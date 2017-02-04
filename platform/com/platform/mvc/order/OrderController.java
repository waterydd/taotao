package com.platform.mvc.order;


import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.goods.Goods;
import com.platform.mvc.members.Members;

@Controller(controllerKey = "/jf/platform/order")
public class OrderController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(OrderController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				Order.sqlId_splitPageFrom);
		render("/platform/order/list.html");
	}
	
	/**
	 * 查看
	 */
	public void view() {
		String order_no =getPara();// 获取订单号
		Order order = Order.dao.findById(order_no);
		//order.getUid(); //获取卖家ID
		Members members = Members.dao.findById(order.getUid());
		Members members2 = Members.dao.findById(order.getSeller_id());
		
		String goodsid = order.getGoods_id(); //获取商品编号
		Goods goods = Goods.dao.findById(goodsid);
		setAttr("members2", members2);// 将Members表中查到的信息 传到界面上去
		setAttr("members", members);// 将Members表中查到的信息 传到界面上去
		setAttr("goods", goods);// 将Goods表中查到的信息 传到界面上去
		setAttr("order", order);// 将order表中查到的信息 传到界面上去
		render("/platform/order/view.html");// 跳转到view.html界面上显示出来
		
	}
	
	/**
	 * /jf/platform/order/edit
	 * 准备更新
	 */
	public void edit() {
		Order order = Order.dao.findById(getPara());//根据主键订单号查询信息
		setAttr("order", order);//将查询到的信息给界面
		
		render("/platform/order/update.html");// 返回一个界面修改界面
	}
	
	/**
	 * /jf/platform/order/update
	 * 【电商】发货
	 */
	public void update() {
		String msg = "";
		String order_no =getPara("order_no");// 获取主键【主键为订单号】
		String logistics_msg =getPara("logistics_msg");// 获取快递公司
		String receive_no =getPara("receive_no");// 获取快递单号
		Order order = Order.dao.findById(order_no);
		
		if (!"PENDING_SEND".equals(order.getStatus())) {
			msg = "状态不是待发货状态！";
		}else {
			
			String SELLER_SENT = "SELLER_SENT"; //此为已发货状态
			order.setStatus(SELLER_SENT);
			order.setLogistics_msg(logistics_msg);
			order.setReceive_no(receive_no);
			Boolean text = order.update();
			
			if (text) {
				msg = "发货成功";
			}else {
				msg = "发货失败！";
			}
		}

		setAttr("result", msg).render("/platform/order/msg.html");
		
	}

}
