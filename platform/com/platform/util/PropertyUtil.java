/**
 * 
 */
package com.platform.util;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * @author JX
 * 资源文件工具
 * 上传图片类型的文件工具地址
 */
public class PropertyUtil {
	/**
	 * 文件上传通用配置
	 */
	private static Prop propFileUpload = PropKit.use("fileUpload.properties");
	
	/**
	 * APP配置
	 */
	private static Prop propApp = PropKit.use("app.properties");
	/**
	 * 系统配置
	 */
	private static Prop propSys = PropKit.use("sys.properties");
	
	/**
	 * 邮件发送配置
	 */
	private static Prop mailbox = PropKit.use("mailBox.properties");
	
	/**
	 * oss配置
	 */
	private static Prop oss = PropKit.use("ossClient.properties");
	
	
	/**
	 * 邮箱服务器地址
	 * @return
	 * 
	 */
	public static String getMailhost() {
		return mailbox.get("config.mail.host");
	}
	
	/**
	 * 端口号
	 * @return
	 * 
	 */
	public static String getMailport() {
		return mailbox.get("config.mail.port");
	}
	
	
	/**
	 * from
	 * @return
	 * 
	 */
	public static String getMailfrom() {
		return mailbox.get("config.mail.from");
	}
	
	
	/**
	 * 邮箱用户名
	 * @return
	 * 
	 */
	public static String getMailuserName() {
		return mailbox.get("config.mail.userName");
	}
	
	
	/**
	 * 用户密码
	 * @return
	 * 
	 */
	public static String getMailpassword() {
		return mailbox.get("config.mail.password");
	}
	
	
	/************邮箱服务器配置**************/
	
	
	/**
	 * 轮播图地址
	 * @return
	 * 
	 */
	public static String getCarouselImgPath()
	{
		return propFileUpload.get("homeTopFloat.upload.path");
	}
	
	/**
	 * 启动图地址
	 * @return
	 */
	public static String getStartImgPath()
	{
		return propFileUpload.get("startImg.upload.path");
	}
	
	/**
	 * 商品图地址
	 * @return
	 */
	public static String getGoodsImgPath()
	{
		return propFileUpload.get("goodsImg.upload.path");
	}
	
	/**
	 * appId
	 * @return
	 */
	public static String getAppId()
	{
		return propApp.get("appId");
	}
	
	/**
	 * 签名秘钥KEY
	 * @return
	 */
	public static String getDesKey()
	{
		return propApp.get("desKey");
	}
	
	/**
	 * 【后台】接口的HTTPS地址
	 * @return
	 */
	public static String getReqHttpsUrl()
	{
		return propSys.get("https.url");
	}
	
	/**
	 * 获得【广告图上传地址】
	 * @return
	 */
	public static String getAdImgUploadPath()
	{
		return propFileUpload.get("adImg.upload.path");
	}
	
	/**
	 * 获得【广告图上传远程地址】
	 * @return
	 */
	public static String getAdImgUploadRemotePath()
	{
		return propFileUpload.get("adImg.upload.remote.path");
	}
	
	/**
	 * 获得节点
	 * @return
	 * 2017年2月23日 下午3:13:05
	 */
	public static String getEndPoint()
	{
		return oss.get("endPoint");
	}
	
	/**
	 * 获得默认的bucketName
	 * @return
	 * 2017年2月24日 上午11:45:20
	 */
	public static String getDefaultBucketName()
	{
		return oss.get("bucket.name.default");
	}
	
	/**
	 * 获得访问ID
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getAccessId()
	{
		return oss.get("access.id");
	}
	
	/**
	 * 获得密码
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getSecretKey()
	{
		return oss.get("secret.key");
	}
	
	/**
	 * 音频图片获取远程地址
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getFmImgGetRemoteUrl()
	{
		return oss.get("fm.img.get.remoteUrl");
	}
	
	/**
	 * 音频文件获取远程地址
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getFmFileGetRemoteUrl()
	{
		return oss.get("fm.file.get.remoteUrl");
	}
	
	/**
	 * 音频图片本地路径
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getFmImgUploadPath()
	{
		return propFileUpload.get("fmImg.upload.path");
	}
	
	/**
	 * 音频图片远程路径
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getFmImgUploadRemotePath()
	{
		return propFileUpload.get("fmImg.upload.remote.path");
	}
	
	/**
	 * 音频文件本地路径
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getFmFileUploadPath()
	{
		return propFileUpload.get("fmFile.upload.path");
	}
	
	/**
	 * 音频文件远程路径
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getFmFileUploadRemotePath()
	{
		return propFileUpload.get("fmFile.upload.remote.path");
	}
	
	/**
	 * 音频本地文件获取路径
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getFmImgUploadGetPath()
	{
		return propFileUpload.get("fmImg.upload.get.path");
	}
	
	/**
	 * 音频本地文件获取路径
	 * @return
	 * 2017年2月23日 下午3:12:02
	 */
	public static String getFmFileUploadGetPath()
	{
		return propFileUpload.get("fmFile.upload.get.path");
	}
}