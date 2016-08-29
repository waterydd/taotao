package com.platform.mvc.memberprofile;

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
 * /jf/platform/memberProfile
 * /jf/platform/memberProfile/save
 * /jf/platform/memberProfile/edit
 * /jf/platform/memberProfile/update
 * /jf/platform/memberProfile/view
 * /jf/platform/memberProfile/delete
 * /common/memberProfile/add.html
 * 
 */
@Controller(controllerKey = "/jf/platform/memberProfile")
public class MemberProfileController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MemberProfileController.class);
	
	private MemberProfileService memberProfileService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect, MemberProfile.sqlId_splitPageFrom);
		render("/platform/memberProfile/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(MemberProfileValidator.class)
	public void save() {
		getModel(MemberProfile.class).save();
		render("/platform/memberProfile/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		MemberProfile memberProfile = MemberProfile.dao.findById(getPara());
		setAttr("memberProfile", memberProfile);
		render("/platform/memberProfile/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(MemberProfileValidator.class)
	public void update() {
		getModel(MemberProfile.class).update();
		redirect("/jf/platform/memberProfile");
	}

	/**
	 * 查看
	 */
	public void view() {
		MemberProfile memberProfile = MemberProfile.dao.findById(getPara());
		setAttr("memberProfile", memberProfile);
		render("/platform/memberProfile/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		memberProfileService.delete("pre_common_member_profile", getPara() == null ? ids : getPara());
		redirect("/jf/platform/memberProfile");
	}
	
}
