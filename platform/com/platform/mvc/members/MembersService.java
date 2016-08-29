package com.platform.mvc.members;

import org.apache.log4j.Logger;

import com.platform.annotation.Service;

import com.platform.mvc.base.BaseService;

@Service(name = MembersService.serviceName)
public class MembersService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MembersService.class);
	
	public static final String serviceName = "membersService";
	
}
