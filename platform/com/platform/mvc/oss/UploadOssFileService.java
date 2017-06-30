package com.platform.mvc.oss;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.platform.tools.ToolDoPost;
import com.platform.tools.ToolSetTotalParam;
import com.platform.util.Base64EncryptManner;
import com.platform.util.PropertyUtil;

/**
 * 获取临时授权，oss上传文件
 *@author:YDD
 *@date:2017年6月27日
 */

public class UploadOssFileService {

private static Logger log = Logger.getLogger(UploadOssFileService.class);

	private String getResult(String result) {
		String[] fileds = result.split("&");
		return fileds[2].substring(fileds[2].indexOf("=") + 1);
	}
	/**
	*获取临时授权，oss上传文件
	*/
	public HashMap<String, String> getTemporaryToken() {
			String rspMsg = ""; // 接受返回信息

			//调用getToken接口 
			String uid = PropertyUtil.getOssMapUid();// uid 用户ID
			String mobileType = UUID.randomUUID().toString();//手机型号
			String mobileNo = UUID.randomUUID().toString();// 手机序列号
		    String flowNo = UUID.randomUUID().toString()+"BACK";// 流水号 UUID+BACK
	//*******************我是一条分割线******************************************************
			HashMap<String, String> jsonMap = new HashMap<String, String>();
			jsonMap.put("uid",uid ); // 用户 ID 买家id buyerid
			jsonMap.put("flowNo", flowNo);		   // 流水号 UUID+BACK
			jsonMap.put("mobileType", mobileType); //手机型号
			jsonMap.put("mobileNo", mobileNo); //手机序列号 uid
			jsonMap.put("timestamp", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())); // timestamp 时间戳
			
			try {
				String msg = ToolDoPost.doPost("oss/getToken", ToolSetTotalParam.setTotalParam(JSONObject.toJSONString(jsonMap)));
				if(msg != null){
					msg = getResult(msg);
					msg = new Base64EncryptManner().decode(msg);
					JSONObject jsonObject = JSONObject.parseObject(msg);
		
					String rspCode = (String) jsonObject.get("rspCode"); // 是否成功标记数
					rspMsg = (String) jsonObject.get("rspMsg");
					String accessKeyId = (String) jsonObject.get("accessKeyId"); // 返回accessKeyId
					String accessKeySecret = (String) jsonObject.get("accessKeySecret"); // 返回accessKeyId
					String securityToken = (String) jsonObject.get("securityToken"); // 返回accessKeyId
					String success = "0001"; // 成功为 0001
		
					HashMap<String, String> map = new HashMap<>();
		
					if (!success.equals(rspCode)) {// 判断是否退款成功 【失败 就return】0001
						log.info("获取临时授权不成功 ，非'0001'成功状态！");
						map.put("rspMsg", rspMsg);
						return map;
					}
					map.put("accessKeyId", accessKeyId);
					map.put("accessKeySecret", accessKeySecret);
					map.put("securityToken", securityToken);
					return map;
				}else{
					System.out.println("doPost获取msg失败！" );
					return null;
				}
					
			} catch (Exception e) {
				log.error("[xxxchuyic出异常]uid" +uid );
				e.printStackTrace();
				return null;
			}
	}
}
