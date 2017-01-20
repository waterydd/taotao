package com.platform.mvc.scorelog;

import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

@Controller(controllerKey = "/jf/platform/scoreLog")
public class ScoreLogController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ScoreLogController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				ScoreLog.sqlId_splitPageFrom);
		render("/platform/scorelog/list.html");
	}
	
	/**
	 * 查看
	 */
	public void view() {
		String flow_no =getPara();// 获取主键
		ScoreLog scoreLog = ScoreLog.dao.findById(flow_no);
		setAttr("scoreLog", scoreLog);// 将scoreLog表中查到的信息 传到界面上去
		render("/platform/scorelog/view.html");// 跳转到view.html界面上显示出来
		
	}
	

	

}
