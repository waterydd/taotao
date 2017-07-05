package com.platform.mvc.withdraw;

import org.apache.log4j.Logger;

import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.goods.Goods;
import com.platform.util.PropertyUtil;

/**
 * 提现申请处理
 *@author:YDD
 *@date:2017年7月5日
 */
@Controller(controllerKey = "/jf/platform/withdraw")
public class WithdrawController extends BaseController{
	
	private static Logger log = Logger.getLogger(WithdrawController.class);
	
	private WithdrawService withdrawService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				Withdraw.sqlId_splitPageFrom);
		render("/platform/withdraw/list.html");
	}
	
	/**
	 * /jf/platform/withdraw/view
	 * 查看
	 */
	public void view() {
		String uid = getPara();// 获取
		Withdraw withdraw = Withdraw.dao.findById(uid);
		setAttr("Withdraw", withdraw);// 将payFlow表中查到的信息 传到界面上去
		render("/platform/Withdraw/view.html");// 跳转到view.html界面上显示出来
	}

	/**
	 * /jf/platform/withdraw/edit
	 * 准备更新
	 */
	public void edit() {
		Withdraw withdraw = Withdraw.dao.findById(getPara());//根据ID查询信息
		setAttr("withdraw", withdraw);//将查询到的信息给界面
		render("/platform/withdraw/update.html");// 返回一个界面修改界面
	}
	
	public void update() {

		//需要更新审核状态和审核备注
		Withdraw withdraw = getModel(Withdraw.class);//获取界面传的参数
			
		withdraw.update();
		
	    redirect("/jf/platform/withdraw");
	}
	
	/**
	 * /jf/platform/withdraw/delete
	 * 删除审核申请
	 */
	public void delete() {
		
		withdrawService.delete("pre_cash_take_money", getPara() == null ? ids : getPara());//调用withdrawService 的删除方法
		
		redirect("/jf/platform/withdraw");// 跳转到当前Controller的index方法上
		
	}
	
	
	
}
