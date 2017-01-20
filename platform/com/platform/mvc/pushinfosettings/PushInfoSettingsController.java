package com.platform.mvc.pushinfosettings;
import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.forum.ForumThread;

@Controller(controllerKey = "/jf/platform/pushInfoSettings")
public class PushInfoSettingsController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PushInfoSettingsController.class);
	
	private PushInfoSettingsService pushInfoSettingsService;
	
	
	/**
	 * /jf/platform/pushInfoSettings
	 * 准备发送推送信息
	 */
	public void index() {
		
		render("/platform/pushinfosettings/add.html");		
		
	}
	
	/**
	 * /jf/platform/pushInfoSettings/pushInfo
	 * 发送推送信息
	 */
	public void pushInfo() {
		String title = getPara("title"); //标题
		String body = getPara("body"); // 内容
		String url = getPara("url"); //链接
		String operation_type = getPara("operation_type");// 类型
		
		//调用接口 【七个字段】
		String result = pushInfoSettingsService.pushInfo(title, body, url, operation_type);
		setAttr("result", result).render("/platform/pushinfosettings/add.html");		
	}
	
	/**
	 * /jf/platform/pushInfoSettings/valiTidInfo
	 * 验证pre_forum_thread表tid是否存在 
	 * 名字已固定
	 */
	public void valiTidInfo() {
		Integer tid=getParaToInt("homeTopPost.subject");//获取Tid
		String sql=getSql(ForumThread.sqlId_findTidInfo);// 查询的sql语句
		ForumThread forumThread = ForumThread.dao.findFirst(sql, tid);
		String mark = "";
		if (forumThread != null) {
			mark = "true";
		} else {
			mark = "false";
			
		}
		renderText(mark);
	}
	

}
