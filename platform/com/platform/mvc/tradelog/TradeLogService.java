package com.platform.mvc.tradelog;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.platform.annotation.Service;
import com.platform.mvc.base.BaseService;
import com.platform.mvc.members.Members;
import com.platform.util.Base64EncryptManner;
import com.platform.util.EncDecUtil;
import com.platform.util.HmacHanlder;
import com.platform.util.HttpClientUtil;
import com.platform.util.PropertyUtil;

@Service(name = TradeLogService.serviceName)
public class TradeLogService extends BaseService {
	
	private static Logger log = Logger.getLogger(TradeLogService.class);
	
	public static final String serviceName = "tradeLogService";
	
	public static String doPost(String url, List<NameValuePair> params) throws Exception {
		
		HttpClient httpclient = HttpClientUtil.getHttpClient();
		
		String urlTotal = PropertyUtil.getReqHttpsUrl() + url; // url 地址
		
		HttpPost httpPost = new HttpPost(urlTotal);
		if (params != null) {
			httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		}
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null) {

			InputStream instream = entity.getContent();
			BufferedReader dr = new BufferedReader(new InputStreamReader(instream));
			StringBuilder str = new StringBuilder();
			String temp = "";
			while ((temp = dr.readLine()) != null) {
				str.append(temp);
			}
			/*System.out.println("x" + str);*/
			instream.close();
			if (response != null)
				EntityUtils.consume(response.getEntity());
			if (httpPost != null)
				httpPost.abort();
			return str.toString();
		} else
			System.out.println("Error");
		return urlTotal;
	}
	
	/**
	 * 产生随机数
	 * @param length
	 * @return
	 */
	public static String getRandomCharAndNumr(Integer length) {  
	    String str = "";  
	    Random random = new Random();  
	    for (int i = 0; i < length; i++) {  
	        boolean b = random.nextBoolean();  
	        if (b) { // 字符串  
	            // int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母  
	            str += (char) (65 + random.nextInt(26));// 取得大写字母  
	        } else { // 数字  
	            str += String.valueOf(random.nextInt(10));  
	        }  
	    }  
	    return str;  
	} 
	
	/**
	 * 
	 * @param tranData
	 * @return
	 * @throws Exception
	 */
	public static List<NameValuePair> setTotalParam(String tranData) throws Exception {
		String randomNum = getRandomCharAndNumr(6); //随机数 6个随机数
		String appId = PropertyUtil.getAppId(); //APP ID 【？】
		String randomKey = EncDecUtil.enc(PropertyUtil.getDesKey(), randomNum); // 随机 KEY
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("appId", appId));// APP ID
		params.add(new BasicNameValuePair("version", "APP2.0")); // 版本号
		params.add(new BasicNameValuePair("tranData", new Base64EncryptManner().encode(tranData))); // 通过加密后的参数
		params.add(new BasicNameValuePair("signature", new HmacHanlder(randomNum).encrypt(tranData)));// 签名
		params.add(new BasicNameValuePair("ciphertext", randomKey)); // 随机 KEY
		return params;
	}
	
	private String getResult(String result) {
        String[] fileds = result.split("&");
        return fileds[2].substring(fileds[2].indexOf("=") + 1);
    }
	
	/**
	 * 取消订单
	 * @throws Exception 
	 */
	public String cancellationOrder(String orderid) {
		String rspMsg = "取消订单成功！"; // 接受返回信息
		
		TradeLog tradeLog = TradeLog.dao.findById(orderid);
		
		//调用退款接口 
		String mobileNo = UUID.randomUUID().toString();// 手机序列号
	    String flowNo = UUID.randomUUID().toString()+"BACK";// 流水号 UUID+BACK
		String uid = tradeLog.getBuyerid().toString();// uid 用户ID
		Members members = Members.dao.findFirst("Select map_uid from pre_common_member where uid = ?", uid);
		
		String tradeLogId = tradeLog.getOrderid().toString();// tradeLogId 订单 ID
//*******************我是一条分割线******************************************************
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("uid", members.getMap_uid()); // 用户 ID 买家id buyerid
		jsonMap.put("tradeLogId", tradeLogId); //订单 ID orderid
		jsonMap.put("flowNo", flowNo);		   // 流水号 UUID+BACK
		jsonMap.put("mobileNo", mobileNo); //手机序列号 uuid
		jsonMap.put("timestamp", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())); // timestamp 时间戳
		
		try {
			String msg = doPost("tradeLog/cancelOrder", setTotalParam(JSONObject.toJSONString(jsonMap)));
			
			msg = getResult(msg);
			msg = new Base64EncryptManner().decode(msg);
			JSONObject jsonObject = JSONObject.parseObject(msg);
			
			String rspCode = (String) jsonObject.get("rspCode"); //是否成功标记数
			rspMsg = (String) jsonObject.get("rspMsg"); // 返回的信息
			String success = "0001"; // 成功为 0001
			if (!success.equals(rspCode)) {//判断是否退款成功 【失败 就return】0001
				log.info("退款不成功 ，非'0001'成功状态！");
				return rspMsg;
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			return "取消订单失败！";
		}
		return rspMsg;
	}

}
