package com.platform.mvc.payflow;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = PayFlow.table_name,pkName = "pay_flowno")
public class PayFlow extends BaseModel<PayFlow> {

	private static final long serialVersionUID = 7117204659498726199L;

	private static Logger log = Logger.getLogger(PayFlow.class);
	
	public static final PayFlow dao = new PayFlow();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_eb_pay_flow";
	
	/**
	 * 字段描述：支付流水
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_pay_flowno = "pay_flowno"; 
	
	/**
	 * 字段描述：交易流水
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_trade_flowno = "trade_flowno";  
	
	/**
	 * 字段描述：combined_flowno
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_combined_flowno = "combined_flowno"; 
	
	/**
	 * 字段描述：总数
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_amount = "amount"; 
	
	/**
	 * 字段描述：货币
	 * 字段类型：varchar(8)  长度：8
	 */
	public static final String column_currency = "currency"; 
	
	/**
	 * 字段描述：创建时间
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_create_datetime = "create_datetime"; 
	
	/**
	 * 字段描述：请求时间
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_req_datetime = "req_datetime"; 
	
	/**
	 * 字段描述：支付通道
	 * 字段类型：varchar(6)  长度：6
	 */
	public static final String column_pay_channel = "pay_channel"; 
	
	/**
	 * 字段描述：支付方式
	 * 字段类型：mediumint(35)  长度：35
	 */
	public static final String column_pay_bank = "pay_bank"; 
	
	/**
	 * 字段描述：状态描述串
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_status = "status"; 
	
	/**
	 * 字段描述：bank_ret_flowno
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_bank_ret_flowno = "bank_ret_flowno"; 
	
	/**
	 * 字段描述：bank_ret_msg
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_bank_ret_msg = "bank_ret_msg"; 
	
	/**
	 * 字段描述：bank_ret_code
	 * 字段类型：varchar(64)  长度：64
	 */
	public static final String column_bank_ret_code = "bank_ret_code"; 
	
	/**
	 * 字段描述：bank_ret_success_time
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_bank_ret_success_time = "bank_ret_success_time"; 
	
	/**
	 * 字段描述： 成功时间
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_success_time = "success_time"; 
	
	/**
	 * 字段描述：卖家ID
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_buyerid = "buyerid"; 
	
	/**
	 * 字段描述：卖家ID
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_sellerid = "sellerid"; 
	
	/**
	 * 字段描述：真实支付数量
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_real_pay_amount = "real_pay_amount"; 
	
	/**
	 * 字段描述：寄 送 银行流水号
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_send_bank_flowno = "send_bank_flowno"; 
	
	/**
	 * 字段描述：银行退款流水
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_bank_refund_flowno = "bank_refund_flowno"; 
	
	/**
	 * 字段描述：接口返回的支付银行
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_ret_pay_bank = "ret_pay_bank"; 
	
	/**
	 * 字段描述：到期日期时间
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_limit_datetime = "limit_datetime"; 
	
	/**
	 * 字段描述：is_refund
	 * 字段类型：char(1)  长度：1
	 */
	public static final String column_is_refund = "is_refund"; 
	
	/**
	 * 字段描述：front_callback_url
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_front_callback_url = "front_callback_url"; 
	
	/**
	 * 字段描述：back_callback_url
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_back_callback_url = "back_callback_url"; 
	
	
	/**
	 * sqlId : platform.payFlow.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.payFlow.splitPageFrom";
	
	
	private String pay_flowno;
	private String trade_flowno;
	private String combined_flowno;
	
	private BigDecimal amount;
	private String currency;
	private String create_datetime;
	
	private String req_datetime;
	private String pay_channel;
	private String pay_bank;
	
	private String status;
	private String bank_ret_flowno;
	private String bank_ret_msg;
	
	private String bank_ret_code;
	private String bank_ret_success_time;
	private String success_time;
	
	private Integer buyerid;
	private Integer sellerid; 
	private BigDecimal real_pay_amount;
	
	private String send_bank_flowno;
	private String bank_refund_flowno;
	private String ret_pay_bank;
	
	private Integer limit_datetime;
	/****新增字段*****/
	private String is_refund;
	private String front_callback_url;
	private String back_callback_url;
	/****新增字段*****/

	

	public String getIs_refund() {
		return get(column_is_refund);
	}

	public void setIs_refund(String is_refund) {
		set(column_is_refund, is_refund);
	}

	public String getFront_callback_url() {
		return get(column_front_callback_url);
	}

	public void setFront_callback_url(String front_callback_url) {
		set(column_front_callback_url, front_callback_url);
	}

	public String getBack_callback_url() {
		return get(column_back_callback_url);
	}

	public void setBack_callback_url(String back_callback_url) {
		set(column_back_callback_url, back_callback_url);
	}

	public String getPay_flowno() {
		return get(column_pay_flowno);
	}

	public void setPay_flowno(String pay_flowno) {
		set(column_pay_flowno, pay_flowno);
	}

	public String getTrade_flowno() {
		return get(column_trade_flowno);
	}

	public void setTrade_flowno(String trade_flowno) {
		set(column_trade_flowno, trade_flowno);
	}

	public String getCombined_flowno() {
		return get(column_combined_flowno);
	}

	public void setCombined_flowno(String combined_flowno) {
		set(column_combined_flowno, combined_flowno);
	}

	public BigDecimal getAmount() {
		return get(column_amount);
	}

	public void setAmount(BigDecimal amount) {
		set(column_amount, amount);
	}

	public String getCurrency() {
		return get(column_currency);
	}

	public void setCurrency(String currency) {
		set(column_currency, currency);
	}

	public String getCreate_datetime() {
		return get(column_create_datetime);
	}

	public void setCreate_datetime(String create_datetime) {
		set(column_create_datetime, create_datetime);
	}

	public String getReq_datetime() {
		return get(column_req_datetime);
	}

	public void setReq_datetime(String req_datetime) {
		set(column_req_datetime, req_datetime);
	}

	public String getPay_channel() {
		return get(column_pay_channel);
	}

	public void setPay_channel(String pay_channel) {
		set(column_pay_channel, pay_channel);
	}

	public String getPay_bank() {
		return get(column_pay_bank);
	}

	public void setPay_bank(String pay_bank) {
		set(column_pay_bank, pay_bank);
	}

	public String getStatus() {
		return get(column_status);
	}

	public void setStatus(String status) {
		set(column_status, status);
	}

	public String getBank_ret_flowno() {
		return get(column_bank_ret_flowno);
	}

	public void setBank_ret_flowno(String bank_ret_flowno) {
		set(column_bank_ret_flowno, bank_ret_flowno);
	}

	public String getBank_ret_msg() {
		return get(column_bank_ret_msg);
	}

	public void setBank_ret_msg(String bank_ret_msg) {
		set(column_bank_ret_msg, bank_ret_msg);
	}

	public String getBank_ret_code() {
		return get(column_bank_ret_code);
	}

	public void setBank_ret_code(String bank_ret_code) {
		set(column_bank_ret_code, bank_ret_code);
	}

	public String getBank_ret_success_time() {
		return get(column_bank_ret_success_time);
	}

	public void setBank_ret_success_time(String bank_ret_success_time) {
		set(column_bank_ret_success_time, bank_ret_success_time);
	}

	public String getSuccess_time() {
		return get(column_success_time);
	}

	public void setSuccess_time(String success_time) {
		set(column_success_time, success_time);
	}

	public Integer getBuyerid() {
		return get(column_buyerid);
	}

	public void setBuyerid(Integer buyerid) {
		set(column_buyerid, buyerid);
	}

	public Integer getSellerid() {
		return get(column_sellerid);
	}

	public void setSellerid(Integer sellerid) {
		set(column_sellerid, sellerid);
	}

	public BigDecimal getReal_pay_amount() {
		return get(column_real_pay_amount);
	}

	public void setReal_pay_amount(BigDecimal real_pay_amount) {
		set(column_real_pay_amount, real_pay_amount);
	}

	public String getSend_bank_flowno() {
		return get(column_send_bank_flowno);
	}

	public void setSend_bank_flowno(String send_bank_flowno) {
		set(column_send_bank_flowno, send_bank_flowno);
	}

	public String getBank_refund_flowno() {
		return get(column_bank_refund_flowno);
	}

	public void setBank_refund_flowno(String bank_refund_flowno) {
		set(column_bank_refund_flowno, bank_refund_flowno);
	}

	public String getRet_pay_bank() {
		return get(column_ret_pay_bank);
	}

	public void setRet_pay_bank(String ret_pay_bank) {
		set(column_ret_pay_bank, ret_pay_bank);
	}

	public Integer getLimit_datetime() {
		return get(column_limit_datetime);
	}

	public void setLimit_datetime(Integer limit_datetime) {
		set(column_limit_datetime, limit_datetime);
	}

	@Override
	public String toString() {
		return "PayFlow [pay_flowno=" + pay_flowno + ", trade_flowno="
				+ trade_flowno + ", combined_flowno=" + combined_flowno
				+ ", amount=" + amount + ", currency=" + currency
				+ ", create_datetime=" + create_datetime + ", req_datetime="
				+ req_datetime + ", pay_channel=" + pay_channel + ", pay_bank="
				+ pay_bank + ", status=" + status + ", bank_ret_flowno="
				+ bank_ret_flowno + ", bank_ret_msg=" + bank_ret_msg
				+ ", bank_ret_code=" + bank_ret_code
				+ ", bank_ret_success_time=" + bank_ret_success_time
				+ ", success_time=" + success_time + ", buyerid=" + buyerid
				+ ", sellerid=" + sellerid + ", real_pay_amount="
				+ real_pay_amount + ", send_bank_flowno=" + send_bank_flowno
				+ ", bank_refund_flowno=" + bank_refund_flowno
				+ ", ret_pay_bank=" + ret_pay_bank + ", limit_datetime="
				+ limit_datetime + ", is_refund=" + is_refund
				+ ", front_callback_url=" + front_callback_url
				+ ", back_callback_url=" + back_callback_url + "]";
	}
	
	

}
