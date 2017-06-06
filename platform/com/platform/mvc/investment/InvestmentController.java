package com.platform.mvc.investment;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;

/**
 * XXX 管理	
 * 描述：
 * 
 * /jf/platform/investment
 * /jf/platform/investment/save
 * /jf/platform/investment/edit
 * /jf/platform/investment/update
 * /jf/platform/investment/view
 * /jf/platform/investment/delete
 * /common/investment/add.html
 * 
 */
@Controller(controllerKey = "/jf/platform/investment")
public class InvestmentController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(InvestmentController.class);
	
	private InvestmentService investmentService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect, Investment.sqlId_splitPageFrom);
		render("/platform/investment/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(InvestmentValidator.class)
	public void save() {
		getModel(Investment.class).save();
		render("/platform/investment/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Investment investment = Investment.dao.findById(getPara());
		setAttr("investment", investment);
		render("/platform/investment/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(InvestmentValidator.class)
	public void update() {
		getModel(Investment.class).update();
		redirect("/jf/platform/investment");
	}

	/**
	 * 查看
	 */
	public void view() {
		Investment investment = Investment.dao.findById(getPara());
		setAttr("investment", investment);
		render("/platform/investment/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		investmentService.delete("pre_investment", getPara() == null ? ids : getPara());
		redirect("/jf/platform/investment");
	}
	
}
