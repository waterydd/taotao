package com.platform.mvc.partner;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.memberprofile.MemberProfile;
import com.platform.mvc.memberprofile.MemberProfileService;
import com.platform.mvc.members.Members;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;

/**
 * XXX 管理 描述：
 * 
 * /jf/platform/partner /jf/platform/partner/save /jf/platform/partner/edit
 * /jf/platform/partner/update /jf/platform/partner/view
 * /jf/platform/partner/delete /common/partner/add.html
 * 
 * /platform/partner/list.html 界面
 * /platform/partner/update.html 界面
 * /platform/partner/view.html 界面
 * 增加显示内容 金额 Uid 和认证状态
 * 
 */
@Controller(controllerKey = "/jf/platform/partner")
public class PartnerController extends BaseController {

	private static Logger log = Logger.getLogger(PartnerController.class);// log日志

	private PartnerService partnerService;
	private MemberProfileService memberProfileService;


	/**
	 * 列表
	 */
	public void index() { 
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				Partner.sqlId_splitPageFrom);// 【BaseModel.sqlId_splitPageSelect = 分页  select *】
		render("/platform/partner/list.html");

		
	}

	/**
	 * 保存
	 */
	public void save() {
		
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
	     //设置保存主键为空		
	    getModel(Partner.class).save(pkMap);
	    redirect("/jf/platform/partner");

	}

	
	/**
	 * 
	* <p>Description:验证用户信息是否存在 </p>
	* <p>Company:jxsq </p>
	* @author MINGHUA
	* @date 2016年8月26日 下午4:42:43
	 */
	public void valiPartInfo()
	{
		String phone=getPara("partner.phone");//获取手机号
		String realname=getPara("partner.realname");//获取真实姓名
		boolean flag=partnerService.valiPartInfo(realname, phone);//调用Service的验证用户信息是否存在方法
		renderText(String.valueOf(flag));// 给界面传一个是否成功标示
		
	}
	/**
	 * 准备更新
	 */
	public void edit() {
		Partner partner = Partner.dao.findById(getPara());//根据ID查询信息
		setAttr("partner", partner);//将查询到的信息给界面
		render("/platform/partner/update.html");// 返回一个界面修改界面
	}

	/**
	 * 更新
	 */
	@Before(PartnerValidator.class)//后台验证 拦截器
	public void update() {
		getModel(Partner.class).update();// 获取前台的参数进行更新
		redirect("/jf/platform/partner");// 跳转到当前Controller的index方法上
	}

	/**
	 * 查看
	 */
	public void view() {
		String phone =getPara();// 获取手机号
		Partner partner = Partner.dao.findById(phone);//根据手机号查询 Partner 表中的信息【表 1】
		MemberProfile memberProfile=memberProfileService.queryByPhone(phone);//根据手机号查询 memberProfile 表中的信息【表 2】
		if(memberProfile!=null)//判断memberProfile 表中查到的信息是否 不为空
		{
			Members members=Members.dao.findById(memberProfile.getUid());//根据memberProfile表的ID 查询members表中的信息【表 3】
			setAttr("members", members);// 将members表中查到的信息 传到界面上去【表 3】
		}
		setAttr("partner", partner);// 将partner表中查到的信息 传到界面上去【表 1】
		setAttr("memberProfile", memberProfile);// 将memberProfile表中查到的信息 传到界面上去【表 2】
		render("/platform/partner/view.html");// 跳转到view.html界面上显示出来
	}

	/**
	 * 删除 
	 */
	public void delete() {
		int deleteResult = Db.update("delete from pre_jn_partner where phone = ?", getPara());
		log.info("【删除(江南币)商品】影响结果：" + deleteResult);
		//partnerService.delete("pre_jn_partner", getPara() == null ? ids : getPara());//调用partnerService 的删除方法
		redirect("/jf/platform/partner");// 跳转到当前Controller的index方法上
	}
	
	/**
	 * 取消认证
	 */
	public void editAuthstate() {
		Partner partner = Partner.dao.findById(getPara());//根据ID查询信息
		Integer uid = partner.getUid();// 获取uit值
		System.out.println("UID 是多少"+uid);
		if (partner.getUid()>0) {
			//根据uid 去查pre_common_member 的信息
			Members members = Members.dao.findById(uid);
			String men = members.getExtgroupids().replace("21", "").trim();
			members.setExtgroupids(men);
			boolean shi = members.update();
			System.out.println("修改是否成功"+shi);
			
			partner.setAuthstate("0");
			partner.setUid(0-(uid));
			partnerService.update(partner);
		}
		redirect("/jf/platform/partner");// 跳转到当前Controller的index方法上
		

	}
	

}
