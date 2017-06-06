package com.platform.mvc.partnertrade;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.util.PropertyUtil;

@Controller(controllerKey = "/jf/platform/partnerTrade")
public class PartnerTradeController extends BaseController {
	
	private static Logger log = Logger.getLogger(PartnerTradeController.class);
	private PartnerTradeService partnerTradeService;
	
	/**
	 * /jf/platform/partnerTrade
	 * 列表 [首页 ok]
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				PartnerTrade.sqlId_splitPageFrom);
		render("/platform/partnertrade/list.html");
	}
	
	/**
	 * /jf/platform/partnerTrade/view
	 * 查看
	 */
	public void view() {
		String id =getPara();// 获取
		PartnerTrade partnerTrade = PartnerTrade.dao.findById(id);
		setAttr("partnerTrade", partnerTrade);// 将partnerTrade表中查到的信息 传到界面上去
		render("/platform/partnertrade/view.html");// 跳转到view.html界面上显示出来
		
	}
	
	/**
	 *  /jf/platform/partnerTrade/save
	 *  添加
	 */
	@Before(Tx.class)
	public void save() {
		UploadFile uf = getFileByConfigPath("image_url", PropertyUtil.getGoodsImgPath()); // 读取上传的图片文件
		String imgpath = uf.getFileName();
		final String IS_TRUE = "增加成功！";
		
		PartnerTrade partnerTrade = getModel(PartnerTrade.class);
		String info = partnerTradeService.saveServer(imgpath, partnerTrade);
		
		if (IS_TRUE.equals(info)) { //成功就跳转
			redirect("/jf/platform/partnerTrade");
			return;
		}
		setAttr("partnerTrade", partnerTrade);
		setAttr("result", info).render("/platform/partnertrade/add.html");
		
	}
	
	
	/**
	 * /jf/platform/partnerTrade/edit
	 * 准备更新
	 */
	public void edit() {
		PartnerTrade partnerTrade = PartnerTrade.dao.findById(getPara());//根据ID查询信息
		setAttr("partnerTrade", partnerTrade);//将查询到的信息给界面
		
		render("/platform/partnertrade/update.html");// 返回一个界面修改界面
	}

	/**
	 * /jf/platform/partnerTrade/update
	 * 更新
	 */
	public void update() {
		UploadFile uf = getFileByConfigPath("image_url2", PropertyUtil.getGoodsImgPath()); // 读取上传的图片文件
		PartnerTrade partnerTrade = getModel(PartnerTrade.class);//获取界面穿的参数
		
		final String IS_TRUE = "修改成功！";
		String info = partnerTradeService.updateServer(uf, partnerTrade);
		
		if (IS_TRUE.equals(info)) { //成功就跳转
			redirect("/jf/platform/partnerTrade");
			return;
		}
		setAttr("partnerTrade", partnerTrade);
		setAttr("result", info).render("/platform/partnertrade/update.html");
	}
	
	/**
	 * /jf/platform/partnerTrade/delete
	 * 删除
	 */
	public void delete() {
		int deleteResult = Db.update("delete from pre_trade where id = ?", getPara());
		log.info("【删除(江南币)商品】影响结果：" + deleteResult);
		
		redirect("/jf/platform/partnerTrade");// 跳转到当前Controller的index方法上
		
	}
	
	/**
	 * /jf/platform/partnerTrade/valiId
	 * 验证ID是否存在 
	 */
	public void valiId() {
		String  flag ;
		
		String id=getPara("partnerTrade.id");//获取ID主键
		PartnerTrade partnerTrade = PartnerTrade.dao.findById(id);
		if (partnerTrade != null && partnerTrade.getName() != null) { // 1 存在 ： 0 不存在
			flag = "1";
		} else {
			flag = "0";
		}
		renderText(flag);// 给界面传一个是否成功标示
		
	}

	

	

}
