package com.platform.mvc.partner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.platform.annotation.Service;

import com.platform.mvc.base.BaseService;

@Service(name = PartnerService.serviceName)
public class PartnerService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PartnerService.class);
	
	public static final String serviceName = "partnerService";
	

	
	/**
	 * 
	* <p>Description:验证股东信息是否存在 </p>
	* <p>Company:jxsq </p>
	* @author MINGHUA
	* @date 2016年8月26日 下午4:43:50
	 */
	public boolean valiPartInfo(String realname,String phone)
	{

//		List<Partner>sultList=Partner.dao.find(Partner.sqlId_splitFindInfo, param);
		String sql=getSql(Partner.sqlId_splitFindInfo);
		log.info("查询的sql:"+sql);
		Partner result=Partner.dao.findFirst(sql,phone,realname);
		if(result!=null)
		{
			return false;
		}
		return true;
	}
}
