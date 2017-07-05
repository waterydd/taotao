package com.platform.mvc.withdraw;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Db;
import com.platform.annotation.Service;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseService;
import com.platform.mvc.goods.Goods;
import com.platform.mvc.partner.PartnerService;

/**
 *@author:YDDs
 *@date:2017年7月5日
 */
@Service(name = WithdrawService.serviceName)
public class WithdrawService extends BaseService{

	private static Logger log = Logger.getLogger(PartnerService.class);
	
	public static final String serviceName = "withdrawService";
	
	/**
	 * 删除信息
	 */
	public void delete(String table, String uid){//表名   参数名
		
		String sqlIn = sqlIn(uid);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("table", table);
		param.put("sqlIn", sqlIn);
		
		String sql = getSqlByBeetl(Withdraw.sqlId_delete, param); //  String sqlId_deleteIn = "platform.baseModel.deleteIn";
		
		Db.use(ConstantInit.db_dataSource_main).update(sql);
	}

	
	
	
}
