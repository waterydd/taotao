package com.platform.mvc.withdraw;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

/**
 * 
 *@author:YDD
 *@date:2017年7月5日
 */
@SuppressWarnings("unused")
@Table(tableName = Withdraw.table_name, pkName = "uid")
public class Withdraw extends BaseModel<Withdraw>{

	private static final long serialVersionUID = 4433600927099312344L;

	private static Logger log = Logger.getLogger(Withdraw.class);
	
	public static final Withdraw dao = new Withdraw();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_cash_take_money";
	
//********************我是一条分割线*****************************	
	
	/**
	 * 字段描述：ID
	 * 字段类型：int(12)  长度：12
	 */
	public static final String column_id = "id"; 
	
	/**
	 * 字段描述：amount
	 * 字段类型：decimal(18)  长度：18
	 */
	public static final String column_amount = "amount"; 
	
	/**
	 * 字段描述：create_datetime
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_create_datetime = "create_datetime"; 
	
	/**
	 * 字段描述：uid
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_uid= "uid"; 
	
	/**
	 * 字段描述：take_amount_type
	 * 字段类型：varchar(200)  长度：200
	 */
	public static final String column_take_amount_type = "take_amount_type"; 
	
	/**
	 * 字段描述：take_account_no
	 * 字段类型：varchar(200)  长度：200
	 */
	public static final String column_take_account_no = "take_account_no"; 
	
	/**
	 * 字段描述：status
	 * 字段类型：varchar(100)  长度：100
	 */
	public static final String column_status = "status"; 
	
	/**
	 * 字段描述：update_datetime
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_update_datetime = "update_datetime"; 
	
	/**
	 * 字段描述：success_datetime
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_success_datetime = "success_datetime"; 
	
	/**
	 * 字段描述：pay_amount_type
	 * 字段类型：varchar(200)  长度：200
	 */
	public static final String column_pay_amount_type = "pay_amount_type"; 
	
	/**
	 * 字段描述：pay_account_no
	 * 字段类型：varchar(200)  长度：200
	 */
	public static final String column_pay_account_no = "pay_account_no"; 
	
	/**
	 * 字段描述：cash_account_id
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_cash_account_id = "cash_account_id"; 
	
	/**
	 * 字段描述：audit_remark
	 * 字段类型：varchar(500)  长度：500
	 */
	public static final String column_audit_remark = "audit_remark"; 
	
	/**
	 * 字段描述：audit_uid
	 * 字段类型：varchar(32)  长度：32
	 */
	public static final String column_audit_uid = "audit_uid"; 
	
	/**
	 * 字段描述：audit_username
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_audit_username = "audit_username"; 
	
	/**
	 * 字段描述：order_no
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_order_no = "order_no"; 
	
	/**
	 * 字段描述：success_pay_flowno
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_success_pay_flowno = "success_pay_flowno"; 

//********************我是一条分割线*****************************		
	
	/**
	 * sqlId : platform.withdraw.deleteInfo
	 * 描述：根据uid删除
	 */
	public static final String sqlId_delete = "platform.withdraw.deleteInfo";
	
	/**
	 * sqlId : platform.withdraw.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.withdraw.splitPageFrom";
	
	
	private Integer id;
	private BigDecimal amount;
	private String create_datetime;
	
	private Integer uid;
	private String take_amount_type;
	private String take_account_no;
	
	private String status;
	private String update_datetime;
	private String success_datetime;
	
	private String pay_amount_type;
	private String pay_account_no;
	private Integer cash_account_id;
	
	private String audit_remark;
	private String audit_uid;
	private String audit_username;
	
	private String order_no;
	private String success_pay_flowno;
	public static String getColumnId() {
		return column_id;
	}
	public static String getColumnAmount() {
		return column_amount;
	}
	public static String getColumnCreateDatetime() {
		return column_create_datetime;
	}
	public static String getColumnUid() {
		return column_uid;
	}
	public static String getColumnTakeAmountType() {
		return column_take_amount_type;
	}
	public static String getColumnTakeAccountNo() {
		return column_take_account_no;
	}
	public static String getColumnStatus() {
		return column_status;
	}
	public static String getColumnUpdateDatetime() {
		return column_update_datetime;
	}
	public static String getColumnSuccessDatetime() {
		return column_success_datetime;
	}
	public static String getColumnPayAmountType() {
		return column_pay_amount_type;
	}
	public static String getColumnPayAccountNo() {
		return column_pay_account_no;
	}
	public static String getColumnCashAccountId() {
		return column_cash_account_id;
	}
	public static String getColumnAuditRemark() {
		return column_audit_remark;
	}
	public static String getColumnAuditUid() {
		return column_audit_uid;
	}
	public static String getColumnAuditUsername() {
		return column_audit_username;
	}
	public static String getColumnOrderNo() {
		return column_order_no;
	}
	public static String getColumnSuccessPayFlowno() {
		return column_success_pay_flowno;
	}
	
	@Override
	public String toString() {
		return "Withdraw [id=" + id + ", amount=" + amount
				+ ", create_datetime=" + create_datetime + ", uid=" + uid
				+ ", take_amount_type=" + take_amount_type
				+ ", take_account_no=" + take_account_no + ", status=" + status
				+ ", update_datetime=" + update_datetime
				+ ", success_datetime=" + success_datetime
				+ ", pay_amount_type=" + pay_amount_type + ", pay_account_no="
				+ pay_account_no + ", cash_account_id=" + cash_account_id
				+ ", audit_remark=" + audit_remark + ", audit_uid=" + audit_uid
				+ ", audit_username=" + audit_username + ", order_no="
				+ order_no + ", success_pay_flowno=" + success_pay_flowno + "]";
	}
	
	
	
	
	
	
}
