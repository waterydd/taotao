/**
 * 
 */
package com.platform.util.oss;

import java.io.File;
import com.platform.util.PropertyUtil;


/**
 * 【上传图片】线程
 * @author Jx
 */
public class OssUploadThread implements Runnable {

	private String remoteFileName = null;
	private String localFilePath = null;
	private String remoteFilePath = null;
	
	public OssUploadThread(String remoteFileName, String localFilePath,
			String remoteFilePath) {
		super();
		this.remoteFileName = remoteFileName;
		this.localFilePath = localFilePath;
		this.remoteFilePath = remoteFilePath;
	}

	/**
	 * 通过获取临时授权上传文件
	 * @YDD修改
	 */

	@Override
	public void run() {

		OssUtil.uploadFileToOSSClient(PropertyUtil.getDefaultBucketName(), remoteFilePath + remoteFileName,localFilePath);
//		OssUtil.uploadLocalFile(localFilePath, remoteFilePath + remoteFileName);
		//上传远端完成后，删除本地文件
		File file = new File(localFilePath);
		if (file.exists())
			file.delete();
	}
		
}
