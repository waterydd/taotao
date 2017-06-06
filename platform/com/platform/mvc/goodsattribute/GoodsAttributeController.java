package com.platform.mvc.goodsattribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

@Controller(controllerKey = "/jf/platform/goodsattribute")
public class GoodsAttributeController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(GoodsAttributeController.class);
	
	private GoodsAttributeService goodsAttributeService;	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				GoodsAttribute.sqlId_splitPageFrom);
		render("/platform/goodsattribute/list.html");
	}
	
	/**
	 * /jf/platform/goodsattribute/view
	 * 查看
	 */
	public void view() {
		String id =getPara();// 获取
		GoodsAttribute goodsAttribute = GoodsAttribute.dao.findById(id);
		setAttr("goodsAttribute", goodsAttribute);// 将goodsAttribute表中查到的信息 传到界面上去
		render("/platform/goodsattribute/view.html");// 跳转到view.html界面上显示出来
		
	}
	
	/**
	 * /jf/platform/goodsattribute/dropdownValue
	 * 下拉框值
	 */
	public void dropdownValue() {
		String sql = "select id from pre_eb_goods_attribute";
	
		ArrayList<GoodsAttribute> goodsAttribute = (ArrayList<GoodsAttribute>) GoodsAttribute.dao.find(sql);
		renderJson(goodsAttribute);
		
	}
	
	/**
	 * /jf/platform/goodsattribute/save
	 * 添加
	 */
	public void save() {
		
		GoodsAttribute goodsAttribute = getModel(GoodsAttribute.class);
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
		//设置保存主键为空
		goodsAttribute.save(pkMap);
		
		redirect("/jf/platform/goodsattribute");
	}

	
	/**
	 * /jf/platform/goodsattribute/edit
	 * 准备更新
	 */
	public void edit() {
		GoodsAttribute goodsAttribute = GoodsAttribute.dao.findById(getPara());//根据ID查询信息
		setAttr("goodsAttribute", goodsAttribute);//将查询到的信息给界面
		
		render("/platform/goodsattribute/update.html");// 返回一个界面修改界面
	}

	/**
	 * /jf/platform/goodsattribute/update
	 * 更新
	 */
	public void update() {
		GoodsAttribute goodsAttribute = getModel(GoodsAttribute.class);//获取界面穿的参数
		goodsAttribute.update();
		
	    redirect("/jf/platform/goodsattribute");
	}
	
	/**
	 * /jf/platform/goodsattribute/delete
	 * 删除
	 */
	public void delete() {
		
		goodsAttributeService.delete("pre_eb_goods_attribute", getPara() == null ? ids : getPara());//调用homeTopPostService 的删除方法
		
		redirect("/jf/platform/goodsattribute");// 跳转到当前Controller的index方法上
		
	}
	

	

}
