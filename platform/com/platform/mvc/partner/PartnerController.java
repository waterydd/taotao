package com.platform.mvc.partner;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.memberprofile.MemberProfile;
import com.platform.mvc.memberprofile.MemberProfileService;
import com.platform.mvc.members.Members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;

/**
 * XXX 管理 描述：
 * 
 * /jf/platform/partner /jf/platform/partner/save /jf/platform/partner/edit
 * /jf/platform/partner/update /jf/platform/partner/view
 * /jf/platform/partner/delete /common/partner/add.html
 * 
 */
@Controller(controllerKey = "/jf/platform/partner")
public class PartnerController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PartnerController.class);

	private PartnerService partnerService;
	private MemberProfileService memberProfileService;


	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				Partner.sqlId_splitPageFrom);
		render("/platform/partner/list.html");
	}

	/**
	 * 保存
	 */
	public void save() {
		Map<String,Object> pkMap=new HashMap<String,Object>();
//		Partner p= getAttr("partner");
//		p.getPhone();
//		getAttrForStr("partner");
//		getAttrForStr("partner.phone");
//		getParamMap();
//		getPara("partner.phone");   
	     //设置保存主键为空		
	    getModel(Partner.class).save(pkMap);
//	    setAttr("url", "/jf/platform/partner");
//			render("/platform/partner/add.html");
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
		String phone=getPara("partner.phone");
		String realname=getPara("partner.realname");
		boolean flag=partnerService.valiPartInfo(realname, phone);
		renderText(String.valueOf(flag));
		
	}
	/**
	 * 准备更新
	 */
	public void edit() {
		Partner partner = Partner.dao.findById(getPara());
		setAttr("partner", partner);
		render("/platform/partner/update.html");
	}

	/**
	 * 更新
	 */
	@Before(PartnerValidator.class)
	public void update() {
		getModel(Partner.class).update();
		redirect("/jf/platform/partner");
	}

	/**
	 * 查看
	 */
	public void view() {
		String phone =getPara();
		Partner partner = Partner.dao.findById(phone);
		MemberProfile memberProfile=memberProfileService.queryByPhone(phone);
		if(memberProfile!=null)
		{
			Members members=Members.dao.findById(memberProfile.getUid());
			setAttr("members", members);
		}
		setAttr("partner", partner);
		setAttr("memberProfile", memberProfile);
		render("/platform/partner/view.html");
	}

	/**
	 * 删除
	 */
	public void delete() {
		partnerService.delete("pre_jn_partner", getPara() == null ? ids : getPara());
		redirect("/jf/platform/partner");
	}

}
