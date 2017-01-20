package com.platform.mvc.payflow;


import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

@Controller(controllerKey = "/jf/platform/payFlow")
public class PayFlowController extends BaseController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PayFlowController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				PayFlow.sqlId_splitPageFrom);
		render("/platform/payflow/list.html");
	}
	
	/**
	 * 查看
	 */
	public void view() {
		String pay_flowno =getPara();// 获取支付流水
		PayFlow payFlow = PayFlow.dao.findById(pay_flowno);
		setAttr("payFlow", payFlow);// 将payFlow表中查到的信息 传到界面上去
		render("/platform/payflow/view.html");// 跳转到view.html界面上显示出来
		
	}
	
	/**
	 * /jf/platform/payFlow/getTradeFlowno
	 * 查看支付流水表的订单信息
	 */
	public void getTradeFlowno() {
		//String ay_flowno = getPara("pay_flowno");
		PayFlow payFlow = getModel(PayFlow.class); // 取界面传的参数
		String pay_flowno = payFlow.getPay_flowno().toString(); //取出详细的参数
//		String sql = "select * from pre_eb_pay_flow where pay_flowno = ?";
//		ArrayList<PayFlow> payFlow2 = (ArrayList<PayFlow>) PayFlow.dao.find(sql, pay_flowno);
		
		//PayFlow payFlow2 = PayFlow.dao.findById(pay_flowno); // 根据参数ID 查询是否有这条信息
		String payFlow2 = "youzhi";
		String qwer ="";
//		if (payFlow2 == null || payFlow2.getTrade_flowno()==null) {
		if (payFlow2 == null ) {
			qwer ="1";
		}else{
			//qwer = payFlow2.getTrade_flowno(); // 取出要的交易流水号信息
			qwer = "20161118175500057113951524710";
		}
		renderJson("trade", qwer);
	}


}
