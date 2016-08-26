package com.platform.mvc.partner;

import org.apache.log4j.Logger;

import com.platform.annotation.Service;

import com.platform.mvc.base.BaseService;

@Service(name = PartnerService.serviceName)
public class PartnerService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PartnerService.class);
	
	public static final String serviceName = "partnerService";
	
}
