package com.platform.mvc.forum;

import org.apache.log4j.Logger;

import com.platform.annotation.Service;
import com.platform.mvc.base.BaseService;
/**
 * 框架已经搭好
 * @author Administrator
 *
 */
@Service(name = ForumThreadService.serviceName)
public class ForumThreadService extends BaseService{

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ForumThreadService.class);
	
	public static final String serviceName = "forumThreadService";
	
	/**
	 * 各种方法 调用 Model的
	 */

}
