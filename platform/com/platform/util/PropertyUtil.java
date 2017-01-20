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
}