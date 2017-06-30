package com.platform.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.platform.util.Base64EncryptManner;
import com.platform.util.EncDecUtil;
import com.platform.util.HmacHanlder;
import com.platform.util.PropertyUtil;

/**
 * 传输数据元素
 *@author:YDD
 *@date:2017年6月29日
 */
public class ToolSetTotalParam {

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
		String randomNum = getRandomCharAndNumr(6); //随机 6个随机数
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
}
