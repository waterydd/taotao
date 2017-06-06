package com.platform.mvc.Express;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;

/**
 * 快递 管理	
 * 描述：
 * 
 * /jf/platform/express
 * /jf/platform/express/save
 * /jf/platform/express/edit
 * /jf/platform/express/update
 * /jf/platform/express/view // 未添加
 * /jf/platform/express/delete
 * /platform/express/add.html
 * 
 */
@Controller(controllerKey = "/jf/platform/express")
public class ExpressController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ExpressController.class);
	
	private ExpressService expressService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect, Express.sqlId_splitPageFrom);
		render("/platform/express/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(ExpressValidator.class)
	public void save() {
		final String IS_TRUE = "增加成功 ！";
		Express express = getModel(Express.class);
		String info = expressService.saveService(express);
		
		if (IS_TRUE.equals(info)) {
			redirect("/jf/platform/express");
			return;
		}
		setAttr("express", express);
		setAttr("result", info).render("/platform/express/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Express express = Express.dao.findById(getPara());
		setAttr("express", express);
		render("/platform/express/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(ExpressValidator.class)
	public void update() {
		final String IS_TRUE = "修改成功 ！";
		Express express = getModel(Express.class);
		String info = expressService.updateService(express);
		
		// 返回信息是否成功
		if (IS_TRUE.equals(info)) {
			redirect("/jf/platform/express");
			return;
		}
		setAttr("express", express);
		setAttr("result", info).render("/platform/express/update.html");
	}

	/**
	 * 查看
	 */
	public void view() {
		Express express = Express.dao.findById(getPara());
		setAttr("express", express);
		render("/platform/express/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		String code = getPara();
		Express express = Express.dao.findById(code);
		if (express != null) {
			 Db.update("delete from pre_kuaidi where code = ?", code);
		}
		redirect("/jf/platform/express");
	}
	
}
