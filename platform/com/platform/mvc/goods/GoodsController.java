package com.platform.mvc.goods;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.util.PropertyUtil;

@Controller(controllerKey = "/jf/platform/goods")
public class GoodsController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(GoodsController.class);
	
	private GoodsService goodsService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				Goods.sqlId_splitPageFrom);
		render("/platform/goods/list.html");
	}
	
	/**
	 * 查看
	 */
	public void view() {
		String id =getPara();// 获取
		Goods goods = Goods.dao.findById(id);
		setAttr("goods", goods);// 将payFlow表中查到的信息 传到界面上去
		render("/platform/goods/view.html");// 跳转到view.html界面上显示出来
		
	}
	
	/**
	 * /jf/platform/goods/dropdownValue
	 * 下拉框值
	 */
/*	public void dropdownValue() {
		String type = getPara("name");
		String sql = "select * from pre_eb_goods_attribute where type = '"
				+ "0"
				+ "'";
	
		String sql = "select * from pre_eb_goods_attribute where type = ?";
		ArrayList<GoodsAttribute> goodsAttribute = (ArrayList<GoodsAttribute>) GoodsAttribute.dao.find(sql ,type);
		renderJson(goodsAttribute);
		
	}*/
	
	
	/**
	 *  /jf/platform/goods/save
	 *  添加
	 */
	public void save() {
		//UploadFile uf = getFile("image_url");
		UploadFile uf = getFileByConfigPath("image_url", PropertyUtil.getGoodsImgPath()); // 读取上传的图片文件
		String imgpath = uf.getFileName();
		Goods goods = getModel(Goods.class);
		if(goods.getThread_url() == null || goods.getThread_url().length()<=0 ){//如果帖子url为空的话 默认将id的值赋给它
			goods.setThread_url(goods.getId());
		}
		if (goods.getPublisher_logo() == null || goods.getPublisher_logo().length()<=0) {
			goods.setPublisher_logo("0");
		}
		goods.setPic_path(imgpath);
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
		//设置保存主键为空
		goods.save(pkMap);
		 redirect("/jf/platform/goods");
	}
	
	
	/**
	 * /jf/platform/goods/edit
	 * 准备更新
	 */
	public void edit() {
		Goods goods = Goods.dao.findById(getPara());//根据ID查询信息
		setAttr("goods", goods);//将查询到的信息给界面
		
		render("/platform/goods/update.html");// 返回一个界面修改界面
	}

	/**
	 * /jf/platform/goods/update
	 * 更新
	 */
	public void update() {
		//UploadFile uf = getFile("image_url2");
		UploadFile uf = getFileByConfigPath("image_url2", PropertyUtil.getGoodsImgPath()); // 读取上传的图片文件
		Goods goods = getModel(Goods.class);//获取界面穿的参数
		if(goods.getThread_url() == null || goods.getThread_url().length()<=0 ){//如果帖子url为空的话 默认将id的值赋给它
			goods.setThread_url(goods.getId());
		}
		if (goods.getPublisher_logo() == null || goods.getPublisher_logo().length()<=0) {
			goods.setPublisher_logo("0");
		}
		if (uf != null) { //当上传的文件不为空
			String imgpath = uf.getFileName();
			goods.setPic_path(imgpath);
		}
		
		goods.update();
		
	    redirect("/jf/platform/goods");
	}
	
	/**
	 * /jf/platform/goods/delete
	 * 删除
	 */
	public void delete() {
		
		goodsService.delete("pre_eb_goods", getPara() == null ? ids : getPara());//调用homeTopPostService 的删除方法
		
		redirect("/jf/platform/goods");// 跳转到当前Controller的index方法上
		
	}
	
	/**
	 * /jf/platform/goods/valiId
	 * 验证ID是否存在 
	 */
	public void valiId() {
		String  flag ;
		
		String id=getPara("goods.id");//获取手机号
		Goods goods = Goods.dao.findById(id);
		if (goods != null) { // 1 存在 ： 0 不存在
			flag = "1";
		} else {
			flag = "0";
		}
		renderText(flag);// 给界面传一个是否成功标示
		
	}

	

	

}
