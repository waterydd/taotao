package com.platform.mvc.mailbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.tools.ToolMail;
import com.platform.util.PropertyUtil;
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
	
	
	/**
	 * 列表显示
	 * 
	 * /jf/platform/mailbox
	 */
	public void index() {
 
	paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
			Mailbox.sqlId_splitPageFrom);// 【BaseModel.sqlId_splitPageSelect = 分页  select *】
	render("/platform/mailbox/list.html");

	}
	
	/**
	 * 导入excel 文件信息到数据库
	 *
	 * 1 上传文件到服务器目录
	 * 2 客户端传回上传文件名称，调用PoiExt.ReadExcel(上传的文件名,插入SQL语句,读取的列数)
	 * 	 注意上传的文件名为全路径
	 * 3 执行返回一个MAP，返回执行的成功记录数，失败记录数，总记录数
	 * 
	 * /jf/platform/mailbox/impdata
	 * 
	 */
	public void impdata() {
		
		UploadFile uf = getFileByConfigPath("excelfile", PropertyUtil.getStartImgPath());
		String path = uf.getUploadPath() + uf.getFileName();
		
		List<Map<Integer, String>> list = PoiExt.dealDataByPath(path);	// 分析EXCEL数据
		for(Map<Integer,String> map:list) { // 遍历取出的数据，并保存
			
			
			System.out.println(map.get(0).toString());
			String email =  map.get(0).toString();
			System.out.println(email);
			if ( !"".equals(email) && null != email ) {
				Record m = new Record();
				m.set("email",email);
				Boolean trfal = Db.save("pre_mailbox", m);
				System.out.println(trfal);
			}
			
			
		}


		System.out.println("成功！");
		redirect("/jf/platform/mailbox");
			 
		  
	}
	
	
	/**
	 * 发送邮件
	 * /jf/platform/mailbox/sendmail
	 */
	@Before(MailboxValidator.class)
	public void sendmail() {
		String subject1 = getPara("subject");//标题
		System.out.println(subject1);
		String content1 = getPara("content");//邮件内容
		
		if (subject1 != "" && content1 != "" ) {
			
		
		//		String from1 = getPara("from");//邮件发送者地址
		//		String userName1 = getPara("userName");//用户名
		//		String password1 = getPara("password");//密码
				/*********我是配置分割线********/
				
				String from1 = PropertyUtil.getMailfrom(); //邮件发送者地址
				String userName1 = PropertyUtil.getMailuserName(); //用户名
				String password1 = PropertyUtil.getMailpassword();// 密码
				String host = PropertyUtil.getMailhost();//邮件服务器IP
				String port = PropertyUtil.getMailport();// 端口号
				System.out.println(from1+"  "+userName1+"  "+password1+"  "+host+"  "+port+" ");
				
				/*********我是配置分割线********/
		//
		//		String host = "smtp.163.com";		// 发送邮件的服务器的IP
		//		String port = "25";	// 发送邮件的服务器的端口
				
				String from = from1;
		//				"djx1965627260@163.com";		// 邮件发送者的地址
				String userName = userName1;
		//				"djx1965627260@163.com";	// 登陆邮件发送服务器的用户名
				String password = password1;
		//				"djx211406109";	// 登陆邮件发送服务器的密码
		
				
				String sql = "select email from pre_mailbox";
				List<Record> cc =  Db.find(sql);
				List<String> to = new ArrayList<String>();			// 邮件接收者的地址
				for (int i = 0; i < cc.size(); i++) {
					to.add((String) cc.get(i).get("email"));
				}
				
				boolean validate = true;	// 是否需要身份验证
				String subject = subject1;
		//				"标题_左瑞测试";		// 邮件标题
				String content = content1;
				// 附件可加 可不加
				String[] attachFileNames = null;
		//				new String[]{"E:/excelyoujian.xlsx"};	// 邮件附件的文件名
				ToolMail.sendTextMail(host, port, validate, userName, password, from, to, subject, content, attachFileNames);
				
				/***********我是一条分割线*************/
				
				for (int i = 0; ; i++) {
					Integer conten = i * 50;
					String sql2 = "select email from pre_mailbox limit ? ,50";
					
					List<Record> cc2 =  Db.find(sql2 , conten);
					List<String> to2 = new ArrayList<String>();			// 邮件接收者的地址
					for (int j = 0; j < cc2.size(); j++) {
						to2.add((String) cc2.get(j).get("email"));
					}
					
					ToolMail.sendTextMail(host, port, validate, userName, password, from, to2, subject, content, attachFileNames);
					
				}
		}
		redirect("/jf/platform/mailbox");
	
	}
	
public static void main(String[] args) {
	
	for (int i = 0; ; i++) {
		
		
		String sql22 = "select email from pre_mailbox limit ? ,50";
		Integer conten = i * 50 + 1;
		List<Record> cc2 =  Db.find(sql22 , conten);
		List<String> to2 = new ArrayList<String>();			// 邮件接收者的地址
		for (int j = 0; j < cc2.size(); j++) {
			to2.add((String) cc2.get(j).get("email"));
		}
		System.out.println(to2 + "  " + i);
		
	}
	
}
	
	

}
