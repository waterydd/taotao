/**
 * 
 */
package com.platform.util;

import java.util.Random;

/**
 * @author Administrator
 *
 */
public class StringUtil {
	/**
	 * 生成随机数字和字母
	 * @param length
	 * @return
	 * 2016年11月2日 下午4:13:39
	 */
	public static int getStringRandom(int length) {
		String val = "";
		Random random = new Random();
		
		for(int i = 0; i < length; i++) 
		{
			val += String.valueOf(random.nextInt(10));
		}
		return Integer.parseInt(val);
	}
	
	public static void main(String[] args) {
		System.out.println(getStringRandom(8));
	}
}
