package com.platform.mvc.pushinfosettings;

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
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.platform.annotation.Service;
import com.platform.mvc.base.BaseService;
import com.platform.util.Base64EncryptManner;
import com.platform.util.EncDecUtil;
import com.platform.util.HmacHanlder;
import com.platform.util.PropertyUtil;

@Service(name = PushInfoSettingsService.serviceName)
public class PushInfoSettingsService extends BaseService {
	
	private static Logger log = Logger.getLogger(PushInfoSettingsService.class);
	
	public static final String serviceName = "pushInfoSettingsService";
	
	public static final String SERVER = "http://jx.jn1535.com/";
	public static final String SERVER_HTTPS = "https://apptest.juxiuclub.com/";
	public static final String LOCAL = "http://localhost:8989/jxsq-app/";
	
	public static String doPost(String url, List<NameValuePair> params) throws Exception {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		String urlTotal = SERVER + url; // url 地址
		
		HttpPost httpPost = new HttpPost(urlTotal);
		if (params != null) {
			httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		}
		CloseableHttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null) {

			InputStream instream = entity.getContent();
			BufferedReader dr = new BufferedReader(new InputStreamReader(instream));
			StringBuilder str = new StringBuilder();
			String temp = "";
			while ((temp = dr.readLine()) != null) {
				str.append(temp);
			}
			System.out.println("x" + str);
			String rightStr = "appId=7V03i45dQ9&version=APP2.0&tranData=";
			if (str.indexOf(rightStr) >= 0)
				
//			System.out.println(new Base64EncryptManner().decode(str.substring(str.indexOf(rightStr) + 41, str.indexOf("&signature="))));
//			String a = new Base64EncryptManner().decode(str.substring(str.indexOf(rightStr) + 41, str.indexOf("&signature=")));
			instream.close();
			response.close();
			httpclient.close();
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
	 * 推送消息
	 * @throws Exception 
	 */
	public String pushInfo(String title ,String body ,String url ,String operation_type) {

		String rspMsg = "";
			//取参
//			flowNo 请求流水号  = UUID
//			timestamp 时间戳 = 获取当前时间的
//			mobileNo 手机序列号= UUID +后台标示
			
//			title 推送标题 = title
//			body 推送内容 = body
//			url 推送链接 = url
//			operationType 操作类型 = operation_type
		String mobileNo = UUID.randomUUID().toString()+"BACK";// 手机序列号 UUID+BACK
	    String flowNo = UUID.randomUUID().toString();// 流水号 UUID
//*******************我是一条分割线******************************************************
			
			HashMap<String, String> jsonMap = new HashMap<String, String>();
			jsonMap.put("title", title); // 推送标题 title
			jsonMap.put("body", body); //推送内容 body
			jsonMap.put("url", url); //推送链接 url
			jsonMap.put("operationType", operation_type); //操作类型  operation_type
			
			jsonMap.put("flowNo", flowNo);		   // 流水号 UUID
			jsonMap.put("mobileNo", mobileNo); //手机序列号 UUID+BACK
			jsonMap.put("timestamp", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())); // timestamp 时间戳
			
			try {
				String msg = doPost("push/pushAllUser", setTotalParam(JSONObject.toJSONString(jsonMap)));
				
				msg = getResult(msg);
				msg = new Base64EncryptManner().decode(msg);
				JSONObject jsonObject = JSONObject.parseObject(msg);
				
				// JSONObject jsonObject = JSONObject.parseObject(msg);
				String rspCode = (String) jsonObject.get("rspCode"); //是否成功标记数
				rspMsg = (String) jsonObject.get("rspMsg"); // 返回的信息
				String success = "0001"; // 成功为 0001
				if (!success.equals(rspCode)) {//判断是否退款成功 【失败 就return】0001
					log.info("推送不成功 ，非'0001'成功状态！");
					return rspMsg;
				}
			} catch (Exception e) {
				log.error(e);
				e.printStackTrace();
				return "异常 ，推送失败！";
			}
		
		
		return rspMsg;
	}

}
