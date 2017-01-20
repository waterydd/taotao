package com.platform.mvc.tradelog;

import java.util.Date;

import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

@Controller(controllerKey = "/jf/platform/tradeLog")
public class TradeLogController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(TradeLogController.class);

	private TradeLogService tradeLogService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				TradeLog.sqlId_splitPageFrom);
		render("/platform/tradelog/list.html");
	}
	
	/**
	 * 查看
	 */
	public void view() {
		String orderid =getPara();// 获取主键
		TradeLog tradeLog = TradeLog.dao.findById(orderid);
		setAttr("tradeLog", tradeLog);// 将TradeLog表中查到的信息 传到界面上去
		render("/platform/tradelog/view.html");// 跳转到view.html界面上显示出来
		
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		TradeLog tradeLog = TradeLog.dao.findById(getPara());//根据ID查询信息
		setAttr("tradeLog", tradeLog);//将查询到的信息给界面
		
		render("/platform/tradelog/update.html");// 返回一个界面修改界面
	}
	
	/**
	 * 确认发货
	 */
	public void update() {
		String msg = "";
		String orderid =getPara("orderid");// 获取主键
		String express =getPara("express");// 获取快递公司
		String expressNumber =getPara("expressNumber");// 获取快递单号
		
		TradeLog tradeLog = TradeLog.dao.findById(orderid);
		tradeLog.getStatus();
		if (tradeLog.getStatus() != 4) {
			msg = "状态不是待发货状态";
		}else {
			
			tradeLog.setStatus(5);
			String me = tradeLog.getSellerid() + "	" + tradeLog.getSeller() + "	" + new Date().getTime() / 1000 + "	" + express+" "+expressNumber;//将取到的快递信息添加到字符串里
			tradeLog.setMessage(me);
			Boolean text = tradeLog.update();
			
			if (text) {
				msg = "确认发货成功";
			}else {
				msg = "确认发货失败！";
			}
			
		}
		

		setAttr("result", msg).render("/platform/tradelog/msg.html");
//		redirect("/jf/platform/tradeLog");// 跳转到当前Controller的index方法上
		
	}
	
	/**
	 * 取消订单
	 */
	public void cancellationOrder() {
		String orderid =getPara();// 获取主键
		String msg = tradeLogService.cancellationOrder(orderid);
		
		setAttr("result", msg).render("/platform/tradelog/msg.html");
		//redirect("/jf/platform/tradeLog");// 跳转到当前Controller的index方法上
	}

	

}
