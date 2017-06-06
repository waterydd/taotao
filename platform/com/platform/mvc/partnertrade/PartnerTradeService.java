package com.platform.mvc.partnertrade;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.upload.UploadFile;
import com.platform.annotation.Service;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseService;
import com.platform.mvc.members.Members;
import com.platform.mvc.randno.Randno;

/**
 * 股东商品信息
 * @author Administrator
 *
 */
@Service(name = PartnerTradeService.serviceName)
public class PartnerTradeService extends BaseService {

	private static Logger log = Logger.getLogger(PartnerTradeService.class);
	public static final String serviceName = "partnerTradeService";
	
	/**
	 * 删除信息
	 */
	public void delete(String table, String id){//表名   参数名
		
		String sqlIn = sqlIn(id);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("table", table);
		param.put("sqlIn", sqlIn);
		
		String sql = getSqlByBeetl(PartnerTrade.sqlId_delete, param); //  String sqlId_deleteIn = "platform.baseModel.deleteIn";
		
		Db.use(ConstantInit.db_dataSource_main).update(sql);
	}
	
	/**
	 * 增加的业务层
	 * @param imgpath
	 * @param partnerTrade
	 * @return
	 */
	public String saveServer(String imgpath , PartnerTrade partnerTrade) {
		
		//取出pt_trade_no 表的rand_num字段的最大值 并且在is_use = 0时 【0代表未用】
		String sql ="select * from pt_trade_no where is_use = 0 ORDER BY rand_num LIMIT 0,1 for update";
		Randno randno = Randno.dao.findFirst(sql);
		randno.setIs_use(true);
		boolean updateResult = randno.update();
		log.info("【更新randNum为不可用】执行结果" + updateResult);
		
		Integer sellerId = partnerTrade.getSeller_id(); // 获取界面的卖家ID
		String sellerName = partnerTrade.getSeller_name(); // 获取界面的卖家名字
		Members members = Members.dao.findById(sellerId);
		if (members == null) {
			
			return "此卖家ID不存在";
		}
		if (!members.getUsername().equals(sellerName)) {
			return "卖家名字不正确";
		}
		
		partnerTrade.setId("-"+randno.getRand_num());
		final String goodBook = "2";
		if (goodBook.equals(partnerTrade.getGoods_type())) {
			partnerTrade.setClassify("");
		}

		partnerTrade.setImg_url(imgpath);//存入商品图片地址
		Map<String,Object> pkMap=new HashMap<String,Object>();
		Boolean isTrue = partnerTrade.save(pkMap);
		if (!isTrue) {
			return "增加失败！";
		}
		return "增加成功！";
	}
	
	public String updateServer(UploadFile uf , PartnerTrade partnerTrade) {
		
		final String goodBook = "2";
		if (goodBook.equals(partnerTrade.getGoods_type())) {
			partnerTrade.setClassify("");
		}
		
		Integer sellerId = partnerTrade.getSeller_id(); // 获取界面的卖家ID
		String sellerName = partnerTrade.getSeller_name(); // 获取界面的卖家名字
		Members members = Members.dao.findById(sellerId);
		if (members == null) {
			return "此卖家ID不存在";
		}
		if (!members.getUsername().equals(sellerName)) {
			return "卖家名字不正确";
		}
		
		if (uf != null) { //当上传的文件不为空
			String imgpath = uf.getFileName();
			partnerTrade.setImg_url(imgpath);
		}
		
		Boolean isTrue = partnerTrade.update();
		if (!isTrue) {
			return "修改失败！";
		}
		return "修改成功！";
	}

}
