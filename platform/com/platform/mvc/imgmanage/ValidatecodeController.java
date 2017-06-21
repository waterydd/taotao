package com.platform.mvc.imgmanage;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.util.PropertyUtil;
import com.platform.util.oss.OssUploadThread;


@Controller(controllerKey = "/jf/platform/validatecode")
public class ValidatecodeController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ValidatecodeController.class);
	
	/**
	 * /platform/imgmanage/add.html
	 */
	public void index() {
		
		String imgpath = PropertyUtil.getStartImgPathFromOSSClient();//获得oss数据库启动图文件地址（ossClient.properties）

		Validatecode validatecode= Validatecode.dao.findById(0);//获取本地数据库启动图数据
		String comment = validatecode.getComment();// 取到启动图图片comment内容中，“|”后面的字符串
	 	String zi = comment.substring(comment.lastIndexOf('|')+1 ,comment.length());
		
		setAttr("readImg", imgpath+zi).render("/platform/imgmanage/add.html");
		
	}
	/**
	 * 列表显示信息
	 * /jf/platform/validatecode/listInfo
	 */
	public void listInfo() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				Validatecode.sqlId_splitPageFrom);
		render("/platform/imgmanage/list.html"); 
	}
	
	/**
	 * 增加
	 * /jf/platform/validatecode/save
	 */
	public void save() {
		//上传本地启动图片至远端
		//UploadFile uf = getFile("image_url");
		UploadFile uf = getFileByConfigPath("image_url", PropertyUtil.getStartImgPath());
		String imgpath = uf.getFileName();
		
		String totalStartImgPath = PropertyUtil.getStartImgPath() + imgpath;
		new Thread(new OssUploadThread(imgpath, totalStartImgPath, PropertyUtil.getStartImgRemotePath())).start();
		
		
		
		// 每次变动修改pre_common_validatecode 表validate_code字段的值
		Validatecode validatecode = Validatecode.dao.findById(0);
	 	String comment = validatecode.getComment();// 取到的  用来 截取掉 | 后面的字符串
	 	String zi = comment.substring(0,comment.lastIndexOf('|') + 1);
		validatecode.setComment(zi+imgpath);
		validatecode.setValidate_code(System.currentTimeMillis()+validatecode.getType());
		validatecode.update();
	
		render("/platform/imgmanage/succeed.html");	
	}
	


}
