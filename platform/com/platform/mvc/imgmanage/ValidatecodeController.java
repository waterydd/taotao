package com.platform.mvc.imgmanage;

import org.apache.log4j.Logger;

import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.util.PropertyUtil;


@Controller(controllerKey = "/jf/platform/validatecode")
public class ValidatecodeController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ValidatecodeController.class);
	
	/**
	 * /platform/imgmanage/add.html
	 */
	public void index() {
		
		render("/platform/imgmanage/add.html");		
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
		//UploadFile uf = getFile("image_url");
		UploadFile uf = getFileByConfigPath("image_url", PropertyUtil.getStartImgPath());
		String imgpath = uf.getFileName();
	
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
