/**
 * 
 */
package com.platform.util.oss;


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




	@Override
	public void run() {
		OssUtil.uploadLocalFile(localFilePath, remoteFilePath + remoteFileName);
	}
		
}
