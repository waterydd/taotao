/**
 * 
 */
package com.platform.util;

import org.apache.log4j.Logger;


/**
 * @author JX
 * 第一版签名加密方式
 */
public class SecondVersionSignEncryptService {
	private static final Logger log = Logger.getLogger(SecondVersionSignEncryptService.class);
	
	/**
	 * 签名
	 * @param appEncrypt
	 * @param tranData
	 * @return
	 * 2016年10月12日 上午10:42:57
	 * @throws Exception 
	 */
	public String sign(String tranData, String randomKey) throws Exception {
	
				HmacHanlder hmacHanlder = new HmacHanlder(randomKey);
				return hmacHanlder.encrypt(tranData);
//		return new HmacHanlder(randomKey).encrypt(tranData)
	
	}

	
	
}
