package com.platform.mvc.payinfoconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

@Controller(controllerKey = "/jf/platform/payinfoconfig")
public class PayInfoConfigController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PayInfoConfigController.class);
	
	private PayInfoConfigService payInfoConfigService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				PayInfoConfig.sqlId_splitPageFrom);
		render("/platform/payinfoconfig/list.html");
	}
	
	/**
	 * 查看
	 */
	public void view() {
		String id =getPara();// 获取
		PayInfoConfig payInfoConfig = PayInfoConfig.dao.findById(id);
		setAttr("payInfoConfig", payInfoConfig);// 将payInfoConfig表中查到的信息 传到界面上去
		render("/platform/payinfoconfig/view.html");// 跳转到view.html界面上显示出来
		
	}
	
	/**
	 * /jf/platform/payinfoconfig/save
	 * 添加
	 */
	public void save() {
		
		PayInfoConfig payInfoConfig = getModel(PayInfoConfig.class);
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
		//设置保存主键为空
		payInfoConfig.save(pkMap);
		redirect("/jf/platform/payinfoconfig");
	}
	
	
	/**
	 * /jf/platform/payinfoconfig/edit
	 * 准备更新
	 */
	public void edit() {
		PayInfoConfig payInfoConfig = PayInfoConfig.dao.findById(getPara());//根据ID查询信息
		setAttr("payInfoConfig", payInfoConfig);//将查询到的信息给界面
		
		render("/platform/payinfoconfig/update.html");// 返回一个界面修改界面
	}

	/**
	 * /jf/platform/payinfoconfig/update
	 * 更新
	 */
	public void update() {
		PayInfoConfig payInfoConfig = getModel(PayInfoConfig.class);//获取界面穿的参数
		payInfoConfig.update();
		
	    redirect("/jf/platform/payinfoconfig");
	}
	
	/**
	 * /jf/platform/payinfoconfig/delete
	 * 删除
	 */
	public void delete() {
		
		payInfoConfigService.delete("pre_eb_pay_info_config", getPara() == null ? ids : getPara());//调用 的删除方法
		
		redirect("/jf/platform/payinfoconfig");// 跳转到当前Controller的index方法上
		
	}
	
	

	

}
