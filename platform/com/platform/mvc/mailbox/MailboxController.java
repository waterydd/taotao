package com.platform.mvc.mailbox;

import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.StrKit;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.partner.Partner;
/**
 * 
 * @author Administrator
 * 邮箱信息的导入与邮件发送
 *
 */
@Controller(controllerKey = "/jf/platform/mailbox")
public class MailboxController extends BaseController {
	
	@SuppressWarnings("unused")
	private static  Logger log = Logger.getLogger(MailboxController.class);
	
	public void index() {
 
	paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
			Partner.sqlId_splitPageFrom);// 【BaseModel.sqlId_splitPageSelect = 分页  select *】
	render("/platform/partner/list.html");

	}
	
	/**
	 * 导入excel 文件信息到数据库
	 *
	 * 1 上传文件到服务器目录
	 * 2 客户端传回上传文件名称，调用PoiExt.ReadExcel(上传的文件名,插入SQL语句,读取的列数)
	 * 	 注意上传的文件名为全路径
	 * 3 执行返回一个MAP，返回执行的成功记录数，失败记录数，总记录数
	 * 
	 */
	public void impdata() {
		
		  /*if (StrKit.isBlank(getPara("filename"))) {
		   renderJson(false);
		  } else {
		   String filename = PathKit.getWebRootPath() + "/"+ getPara("filename");
		   filename = filename.replaceAll("\\", "/");
		   Map<String, Object> map = PoiExt.ReadExcel(filename,"insert into pre_mailbox (email) values(?)",1);
		   renderJson(map);
		  }*/
		
			   String filename = "E:\\excelyoujian.xlsx";
			   filename = filename.replaceAll("\\", "/");
			   Map<String, Object> map = PoiExt.ReadExcel(filename,"insert into pre_mailbox (email) values(?)",1);
			   renderJson(map);
			 
		  
	}
	
	

}
