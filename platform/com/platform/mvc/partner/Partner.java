package com.platform.mvc.partner;

import com.platform.annotation.Table;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModel;

import java.sql.Timestamp; 

import org.apache.log4j.Logger;

/**
 *  model
 * @author mango  dongcb678@163.com
 */
@SuppressWarnings("unused")
@Table(tableName = Partner.table_name, pkName = "phone")
public class Partner extends BaseModel<Partner> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Partner.class);
	
	public static final Partner dao = new Partner();

	/**
	 * 表名称
	 */
	public static final String table_name = "pre_jn_partner";
	
	/**
	 * 字段描述：手机号 
	 * 字段类型：varchar(20)  长度：20
	 */
	public static final String column_phone = "phone";
	
	/**
	 * 字段描述：姓名 
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_realname = "realname";
	
	/**
	 * 字段描述：住址 
	 * 字段类型：varchar(100)  长度：100
	 */
	public static final String column_receiptinfo = "receiptinfo";
	
	/**
	 * 字段描述：短信发送次数 
	 * 字段类型：int(2)  长度：null
	 */
	public static final String column_msgcount = "msgcount";
	
	/**
	 * 字段描述：0 未认证 1已完成认证 
	 * 字段类型：varchar(1)  长度：1
	 */
	public static final String column_authstate = "authstate";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(8)  长度：8
	 */
	public static final String column_checkcode = "checkcode";
	
	/**
	 * 字段描述： 
	 * 字段类型：timestamp  长度：null
	 */
	public static final String column_inserttime = "inserttime";
	
	/**
	 * 字段描述：江南币余额 
	 * 字段类型：varchar(10)  长度：10
	 */
	public static final String column_jnb_balance = "jnb_balance";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(20)  长度：20
	 */
	public static final String column_rechargegold = "rechargegold";
	
	/**
	 * 字段描述： 
	 * 字段类型：timestamp  长度：null
	 */
	public static final String column_approve_time = "approve_time";
	
	
	/**
	 * sqlId : platform.partner.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.partner.splitPageFrom";
	
	/**
	 * sqlId : platform.partner.splitFindInfo
	 * 描述：查询用户信息的sql
	 */
	public static final String sqlId_splitFindInfo = "platform.partner.splitFindInfo";

	private String phone;
	private String realname;
	private String receiptinfo;
	private Integer msgcount;
	private String authstate;
	private String checkcode;
	private Timestamp inserttime;
	private String jnb_balance;
	private String rechargegold;
	private Timestamp approve_time;
	
	public void setPhone(String phone){
		set(column_phone, phone);
	}
	public String getPhone() {
		return get(column_phone);
	}
	public void setRealname(String realname){
		set(column_realname, realname);
	}
	public String getRealname() {
		return get(column_realname);
	}
	public void setReceiptinfo(String receiptinfo){
		set(column_receiptinfo, receiptinfo);
	}
	public String getReceiptinfo() {
		return get(column_receiptinfo);
	}
	public void setMsgcount(Integer msgcount){
		set(column_msgcount, msgcount);
	}
	public Integer getMsgcount() {
		return get(column_msgcount);
	}
	public void setAuthstate(String authstate){
		set(column_authstate, authstate);
	}
	public String getAuthstate() {
		return get(column_authstate);
	}
	public void setCheckcode(String checkcode){
		set(column_checkcode, checkcode);
	}
	public String getCheckcode() {
		return get(column_checkcode);
	}
	public void setInserttime(Timestamp inserttime){
		set(column_inserttime, inserttime);
	}
	public Timestamp getInserttime() {
		return get(column_inserttime);
	}
	public void setJnb_balance(String jnb_balance){
		set(column_jnb_balance, jnb_balance);
	}
	public String getJnb_balance() {
		return get(column_jnb_balance);
	}
	public void setRechargegold(String rechargegold){
		set(column_rechargegold, rechargegold);
	}
	public String getRechargegold() {
		return get(column_rechargegold);
	}
	public void setApprove_time(Timestamp approve_time){
		set(column_approve_time, approve_time);
	}
	public Timestamp getApprove_time() {
		return get(column_approve_time);
	}
	
}
