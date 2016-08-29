package com.platform.mvc.memberprofile;

import org.apache.log4j.Logger;

import com.platform.annotation.Service;

import com.platform.mvc.base.BaseService;
import com.platform.mvc.partner.Partner;

@Service(name = MemberProfileService.serviceName)
public class MemberProfileService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MemberProfileService.class);
	
	public static final String serviceName = "memberProfileService";
	
	
	/**
	 * 根据手机号查询用户信息
	 * @param phone
	 * @return
	 */
	public MemberProfile queryByPhone(String phone)
	{
		String sql=getSql(MemberProfile.sqlId_queryByPhone);
		MemberProfile memberProfile=MemberProfile.dao.findFirst(sql,phone);
		return memberProfile;
	}
	
}
