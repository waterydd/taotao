package com.platform.mvc.investment;

import org.apache.log4j.Logger;

import com.platform.annotation.Service;

import com.platform.mvc.base.BaseService;

@Service(name = InvestmentService.serviceName)
public class InvestmentService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(InvestmentService.class);
	
	public static final String serviceName = "investmentService";
	
}
