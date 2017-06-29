/**
 * 
 */
package com.platform.util.oss;

import java.io.File;
import java.util.HashMap;

import com.aliyun.oss.OSSClient;
import com.jfinal.upload.UploadFile;
import com.platform.mvc.oss.UploadOssFileService;
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


	@Override
	public void run() {
//		HashMap<String, String> getToken = new UploadOssFileService().getTemporaryToken();//返回oss/getToken接口查询信息
//		String accessKeyId = getToken.get("accessKeyId");
//		String accessKeySecret = getToken.get("securityToken");
//		String securityToken = getToken.get("securityToken");
//		
//		OSSClient ossClient = new OSSClient(PropertyUtil.getEndPoint(), accessKeyId,accessKeySecret, securityToken);

		OssUtil.uploadFileToOSSClient(PropertyUtil.getDefaultBucketName(), remoteFilePath + remoteFileName,localFilePath);
//		OssUtil.uploadLocalFile(localFilePath, remoteFilePath + remoteFileName);
		//上传远端完成后，删除本地文件
		File file = new File(localFilePath);
		if (file.exists())
			file.delete();
	}
		
}
