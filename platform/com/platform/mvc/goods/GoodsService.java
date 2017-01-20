package com.platform.mvc.goods;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Db;
import com.platform.annotation.Service;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseService;

/**
 * 论坛帖子管理 HomeTopPostService 
 * @author Administrator
 *
 */
@Service(name = GoodsService.serviceName)
public class GoodsService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(GoodsService.class);
	
	public static final String serviceName = "goodsService";
	
	
	
	
	/**
	 * 删除信息
	 */
	public void delete(String table, String id){//表名   参数名
		
		String sqlIn = sqlIn(id);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("table", table);
		param.put("sqlIn", sqlIn);
		
		String sql = getSqlByBeetl(Goods.sqlId_delete, param); //  String sqlId_deleteIn = "platform.baseModel.deleteIn";
		
		Db.use(ConstantInit.db_dataSource_main).update(sql);
	}

}
