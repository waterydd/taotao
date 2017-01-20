package com.platform.mvc.partner;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.platform.annotation.Service;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseService;

@Service(name = PartnerService.serviceName)
public class PartnerService extends BaseService {

	private static Logger log = Logger.getLogger(PartnerService.class);
	
	public static final String serviceName = "partnerService";
	

	
	/**
	 * 
	* <p>Description:验证股东信息是否存在 </p>
	* <p>Company:jxsq </p>
	* @author MINGHUA
	* @date 2016年8月26日 下午4:43:50
	 */
	public boolean valiPartInfo(String realname,String phone) {

		String sql=getSql(Partner.sqlId_splitFindInfo);// 查询的sql语句
		log.info("查询的sql:"+sql);// 日志打印查询的sql语句
		Partner result=Partner.dao.findFirst(sql,phone,realname);
		if(result!=null)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * 删除用户信息
	 */
	@Before(Tx.class) //事物
	public void delete(String table, String phone){//表名   参数名
		String sqlIn = sqlIn(phone);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("table", table);
		param.put("sqlIn", sqlIn);
		
		String sql = getSqlByBeetl(Partner.sqlId_deleteInfo, param); //  String sqlId_deleteIn = "platform.baseModel.deleteIn";
		
		Db.use(ConstantInit.db_dataSource_main).update(sql);
	}

	/**
	 * 更新股东认证信息
	 * @param partner
	 */
	public void update(Partner partner){
		// 更新
		partner.update();
	}
	
	
}
