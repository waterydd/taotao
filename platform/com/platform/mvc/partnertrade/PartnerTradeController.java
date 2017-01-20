package com.platform.mvc.partnertrade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.randno.Randno;
import com.platform.util.PropertyUtil;

@Controller(controllerKey = "/jf/platform/partnerTrade")
public class PartnerTradeController extends BaseController {
	
	@SuppressWarnings("unused")
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
		//取出member_rand_no 表的rand_num字段的最大值 并且在is_use = 0时 【0代表未用】
		String sql ="select * from member_rand_no where is_use = 0 ORDER BY rand_num LIMIT 0,1 for update";
		Randno randno = Randno.dao.findFirst(sql);
		randno.setIs_use(true);
		boolean updateResult = randno.update();
		log.info("【更新randNum为不可用】执行结果" + updateResult);
		PartnerTrade partnerTrade = getModel(PartnerTrade.class);

		partnerTrade.setId("-"+randno.getRand_num());
		if ("2".equals(partnerTrade.getGoods_type())) {
			partnerTrade.setClassify("");
		}

		partnerTrade.setImg_url(imgpath);//存入商品图片地址
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
		
		partnerTrade.save(pkMap);//设置保存主键为空
		redirect("/jf/platform/partnerTrade");
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
		if ("2".equals(partnerTrade.getGoods_type())) {
			partnerTrade.setClassify("");
		}
		if (uf != null) { //当上传的文件不为空
			String imgpath = uf.getFileName();
			partnerTrade.setImg_url(imgpath);
		}
		
		partnerTrade.update();
		
	    redirect("/jf/platform/partnerTrade");
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
