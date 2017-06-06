/**
 * 
 */
package com.platform.mvc.foundArticle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jx
 * 首页常量
 * 2017年5月15日 下午9:31:07
 */
public class FoundArticleConstant {
	
	//【内容类型】
	/**
	 * 帖子
	 */
	public static final String POST = "post";
	/**
	 * 专辑
	 */
	public static final String ALBUM = "album";
	/**
	 * 投资
	 */
	public static final String INVESTMENT = "investment";
	/**
	 * 音频
	 */
	public static final String FM = "fm";
	/**
	 * 问答
	 */
	public static final String QUESTION = "question";
	/**
	 * 广告
	 */
	public static final String AD = "ad";

	/**
	 * 类型对应汉字说明map
	 */
	public static Map<String, String> typeRemarkMap = new HashMap<String, String>();
	static 
	{
		typeRemarkMap.put(POST, "帖子");
		typeRemarkMap.put(ALBUM, "专辑");
		typeRemarkMap.put(INVESTMENT, "投资");
		typeRemarkMap.put(FM, "音频");
		typeRemarkMap.put(QUESTION, "问答");
		typeRemarkMap.put(AD, "广告");
	}
}
