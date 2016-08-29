package com.platform.mvc.members;

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
 * /jf/platform/members
 * /jf/platform/members/save
 * /jf/platform/members/edit
 * /jf/platform/members/update
 * /jf/platform/members/view
 * /jf/platform/members/delete
 * /common/members/add.html
 * 
 */
@Controller(controllerKey = "/jf/platform/members")
public class MembersController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MembersController.class);
	
	private MembersService membersService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect, Members.sqlId_splitPageFrom);
		render("/platform/members/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(MembersValidator.class)
	public void save() {
		getModel(Members.class).save();
		render("/platform/members/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Members members = Members.dao.findById(getPara());
		setAttr("members", members);
		render("/platform/members/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(MembersValidator.class)
	public void update() {
		getModel(Members.class).update();
		redirect("/jf/platform/members");
	}

	/**
	 * 查看
	 */
	public void view() {
		Members members = Members.dao.findById(getPara());
		setAttr("members", members);
		render("/platform/members/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		membersService.delete("pre_common_member", getPara() == null ? ids : getPara());
		redirect("/jf/platform/members");
	}
	
}
