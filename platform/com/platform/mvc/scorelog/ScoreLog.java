package com.platform.mvc.scorelog;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = ScoreLog.table_name,pkName = "flow_no")
public class ScoreLog extends BaseModel<ScoreLog> {

	private static final long serialVersionUID = -2657744140158334188L;

	private static Logger log = Logger.getLogger(ScoreLog.class);
	
	public static final ScoreLog dao = new ScoreLog();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_score_log";
//********************我是一条分割线*****************************	
	/**
	 * 字段描述：flow_no
	 * 字段类型：  长度：
	 */
	public static final String column_flow_no = "flow_no"; 
	
	/**
	 * 字段描述：uid
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_uid = "uid";  
	
	/**
	 * 字段描述：score_account_type
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_score_account_type = "score_account_type"; 
	
	/**
	 * 字段描述：operation_type
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_operation_type = "operation_type"; 
	
	/**
	 * 字段描述：req_time
	 * 字段类型：varchar(8)  长度：8
	 */
	public static final String column_req_time = "req_time"; 
	
	/**
	 * 字段描述：order_id
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_order_id = "order_id"; 
	
	/**
	 * 字段描述：changed_amount
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_changed_amount = "changed_amount"; 
	
	/**
	 * 字段描述：balance
	 * 字段类型：varchar(6)  长度：6
	 */
	public static final String column_balance = "balance"; 
	
	/**
	 * 字段描述：status
	 * 字段类型：mediumint(35)  长度：35
	 */
	public static final String column_status = "status"; 
	
	/**
	 * 字段描述：success_time
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_success_time = "success_time"; 
	
	/**
	 * 字段描述：comment
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_comment = "comment"; 
	
	
	/**
	 * sqlId : platform.scoreLog.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.scoreLog.splitPageFrom";
	
	
	private Integer uid;
	private String score_account_type;
	private String operation_type;
	
	private BigDecimal changed_amount;
	private String req_time;
	private String flow_no;
	
	private String order_id;
	private BigDecimal balance;
	private String status;
	
	private String success_time;
	private String comment;
	

//	public BigDecimal getPrice() {
//		return get(column_price);
//	}
//	
//	public void setPrice(BigDecimal price) {
//		set(column_price, price);
//	}
	



	public Integer getUid() {
		return get(column_uid);
	}
	
	public void setUid(Integer uid) {
		set(column_uid, uid);
	}
	
	public String getScore_account_type() {
		return get(column_score_account_type);
	}
	
	public void setScore_account_type(String score_account_type) {
		set(column_score_account_type, score_account_type);
	}
	
	public String getOperation_type() {
		return get(column_operation_type);
	}
	
	public void setOperation_type(String operation_type) {
		set(column_operation_type, operation_type);
	}
	
	public BigDecimal getChanged_amount() {
		return get(column_changed_amount);
	}
	
	public void setChanged_amount(BigDecimal changed_amount) {
		set(column_changed_amount, changed_amount);
	}
	
	public String getReq_time() {
		return get(column_req_time);
	}
	
	public void setReq_time(String req_time) {
		set(column_req_time, req_time);
	}
	
	public String getFlow_no() {
		return get(column_flow_no);
	}
	
	public void setFlow_no(String flow_no) {
		set(column_flow_no, flow_no);
	}
	
	public String getOrder_id() {
		return get(column_order_id);
	}
	
	public void setOrder_id(String order_id) {
		set(column_order_id, order_id);
	}
	
	public BigDecimal getBalance() {
		return get(column_balance);
	}
	
	public void setBalance(BigDecimal balance) {
		set(column_balance, balance);
	}
	
	public String getStatus() {
		return get(column_status);
	}
	
	public void setStatus(String status) {
		set(column_status, status);
	}
	
	public String getSuccess_time() {
		return get(column_success_time);
	}
	
	public void setSuccess_time(String success_time) {
		set(column_success_time, success_time);
	}
	
	public String getComment() {
		return get(column_comment);
	}
	
	public void setComment(String comment) {
		set(column_comment, comment);
	}

	@Override
	public String toString() {
		return "ScoreLog [uid=" + uid + ", score_account_type="
				+ score_account_type + ", operation_type=" + operation_type
				+ ", changed_amount=" + changed_amount + ", req_time="
				+ req_time + ", flow_no=" + flow_no + ", order_id=" + order_id
				+ ", balance=" + balance + ", status=" + status
				+ ", success_time=" + success_time + ", comment=" + comment
				+ "]";
	}
	

	

}
