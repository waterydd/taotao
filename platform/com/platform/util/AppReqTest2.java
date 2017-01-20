/*
 * 
 */
package com.platform.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSONObject;


/**
 * @author JX app接口请求测试
 */
@SuppressWarnings("deprecation")
public class AppReqTest2 {

	public static final String SERVER = "http://jx.jn1535.com/";
	public static final String SERVER_HTTPS = "https://apptest.juxiuclub.com/";
	public static final String LOCAL = "http://localhost:8989/jxsq-app/";
	
	public static void doPost(String url, List<NameValuePair> params) throws Exception {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		String urlTotal = LOCAL + url; // url 地址
		
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
				
			System.out.println(new Base64EncryptManner().decode(str.substring(str.indexOf(rightStr) + 41, str.indexOf("&signature="))));
			instream.close();
			response.close();
			httpclient.close();
		} else
			System.out.println("Error");
	}
	
	/**
	 * 设置固定参数
	 * @param jsonMap
	 * 2016年10月13日 下午4:19:11
	 */
	public static void setFixationParam(HashMap<String, String> jsonMap)
	{
		jsonMap.put("flowNo", "6");
		jsonMap.put("mobileNo", "asdajoidsa");
	}

	/**
	 * 对参数进行二次
	 * @param tranData
	 * @return
	 * @throws Exception
	 */
	public static List<NameValuePair> setTotalParam(String tranData) throws Exception {
		String randomNum = "3fd216"; //随机数
		String appId = "7V03i45dQ9"; //APP ID
		String randomKey = EncDecUtil.enc("nq6Nr2pxiK2S364WL2D1440859yHU44r", randomNum); // 随机 KEY
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("appId", appId));// APP ID
		params.add(new BasicNameValuePair("version", "APP2.0")); // 版本号
		params.add(new BasicNameValuePair("tranData", new Base64EncryptManner().encode(tranData))); // 通过加密后的参数
		// 签名
		params.add(new BasicNameValuePair("signature", new SecondVersionSignEncryptService().sign(tranData, randomNum)));
		params.add(new BasicNameValuePair("ciphertext", randomKey)); // 随机 KEY
		return params;
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static void cancelOrder() throws Exception {
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("uid", "a061abdf48fdffa4e7fbd9617a4dd279");
		jsonMap.put("tradeLogId", "20161110144600027109371220420");
		jsonMap.put("flowNo", "9489489489");
		jsonMap.put("mobileNo", "9489489489");
		setFixationParam(jsonMap);

		doPost("tradeLog/cancelOrder", setTotalParam(JSONObject.toJSONString(jsonMap)));
	}
	
	public static void  name2() throws Exception {
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("uid", "a061abdf48fdffa4e7fbd9617a4dd279"); // 用户 ID
		jsonMap.put("tradeLogId", "20161110144600027109371220420"); //订单 ID
		jsonMap.put("flowNo", "12");// 流水号
		jsonMap.put("mobileNo", "asdajoidsa");//手机序列号 uuid
		jsonMap.put("timestamp", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())); // 时间戳
		
		doPost("tradeLog/cancelOrder", setTotalParam(JSONObject.toJSONString(jsonMap)));
	}

	public static void main(String[] args) throws Exception {
	
//		 cancelOrder();
		name2();

	}
	
	
	
}
