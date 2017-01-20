/**
 * 
 */
package com.platform.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

/**
 * @author JX
 * base64加密方式
 */
public class Base64EncryptManner {
	private static final Logger log = Logger.getLogger(Base64EncryptManner.class);
	
	//加密
	public String encode(String tranData) {
		try {
			return URLEncoder.encode(Base64.encode(tranData.getBytes("utf-8")), "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.error("【base64】加密数据出现异常【tranData】" + tranData, e);
			e.printStackTrace();
		}
		return null;
	}

	//解密
	public String decode(String tranData) {
		try {
			return new String(Base64.decode(URLDecoder.decode(tranData, "utf-8")), "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.error("【base64】解密数据出现异常【tranData】" + tranData, e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("【base64】解密数据出现异常【tranData】" + tranData, e);
			e.printStackTrace();
		}
		return null;
	}
	
}
