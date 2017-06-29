package com.platform.mvc.tradelog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.platform.annotation.Service;
import com.platform.mvc.base.BaseService;
import com.platform.mvc.members.Members;
import com.platform.tools.ToolDoPost;
import com.platform.tools.ToolSetTotalParam;
import com.platform.util.Base64EncryptManner;

@Service(name = TradeLogService.serviceName)
public class TradeLogService extends BaseService {
	
	private static Logger log = Logger.getLogger(TradeLogService.class);
	
	public static final String serviceName = "tradeLogService";
		
	
	private String getResult(String result) {
        String[] fileds = result.split("&");
        return fileds[2].substring(fileds[2].indexOf("=") + 1);
    }
	
	/**
	 * 取消订单
	 * @throws Exception 
	 */
	public String cancellationOrder(String orderid) {
		String rspMsg = "取消订单成功！"; // 接受返回信息
		
		TradeLog tradeLog = TradeLog.dao.findById(orderid);
		
		//调用退款接口 
		String mobileNo = UUID.randomUUID().toString();// 手机序列号
	    String flowNo = UUID.randomUUID().toString()+"BACK";// 流水号 UUID+BACK
		String uid = tradeLog.getBuyerid().toString();// uid 用户ID
		Members members = Members.dao.findFirst("Select map_uid from pre_common_member where uid = ?", uid);
		String tradeLogId = tradeLog.getOrderid().toString();// tradeLogId 订单 ID
//*******************我是一条分割线******************************************************
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("uid", members.getMap_uid()); // 用户 ID 买家id buyerid
		jsonMap.put("tradeLogId", tradeLogId); //订单 ID orderid
		jsonMap.put("flowNo", flowNo);		   // 流水号 UUID+BACK
		jsonMap.put("mobileNo", mobileNo); //手机序列号 uuid
		jsonMap.put("timestamp", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())); // timestamp 时间戳
		
		try {
			String msg = ToolDoPost.doPost("tradeLog/cancelOrder", ToolSetTotalParam.setTotalParam(JSONObject.toJSONString(jsonMap)));
			
			msg = getResult(msg);
			msg = new Base64EncryptManner().decode(msg);
			JSONObject jsonObject = JSONObject.parseObject(msg);
			
			String rspCode = (String) jsonObject.get("rspCode"); //是否成功标记数
			rspMsg = (String) jsonObject.get("rspMsg"); // 返回的信息
			String success = "0001"; // 成功为 0001
			if (!success.equals(rspCode)) {//判断是否退款成功 【失败 就return】0001
				log.info("退款不成功 ，非'0001'成功状态！");
				return rspMsg;
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			return "取消订单失败！";
		}
		return rspMsg;
	}
	
}
