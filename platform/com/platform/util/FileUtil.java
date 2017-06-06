package com.platform.util;


public class FileUtil {
	
	/**
	 * 获得文件名【只有文件名】
	 * @param totalFileName
	 * @return
	 * 2017年5月24日 上午11:12:59
	 */
	public static String getFileName(String totalFileName)
	{
		if (totalFileName.indexOf('/') >= 0)
			return totalFileName.substring(totalFileName.lastIndexOf('/') + 1);
		return totalFileName;
	}
	
}
