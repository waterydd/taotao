package com.platform.mvc.order;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = Order.table_name,pkName = "order_no")
public class Order extends BaseModel<Order> {

	private static final long serialVersionUID = -5063043468471142295L;
	
	private static Logger log = Logger.getLogger(Order.class);
	
	public static final Order dao = new Order();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_eb_order";
	
	/**
	 * 字段描述：订单号
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_order_no = "order_no"; 
	
	/**
	 * 字段描述：uid
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_uid = "uid";  
	
	/**
	 * 字段描述：版本
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_version = "version"; 
	
	/**
	 * 字段描述：CZ
	 * 字段类型：varchar(6)  长度：6
	 */
	public static final String column_trade_type = "trade_type"; 
	
	/**
	 * 字段描述：创建日期时间
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_create_datetime = "create_datetime"; 
	
	/**
	 * 字段描述：请求日期时间
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_req_datetime = "req_datetime"; 
	
	/**
	 * 字段描述：商品 msg
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_goods_msg = "goods_msg"; 
	
	/**
	 * 字段描述：商品ID
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_goods_id = "goods_id"; 
	
	/**
	 * 字段描述：卖方_id
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_seller_id = "seller_id"; 
	
	/**
	 * 字段描述：价格
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_price = "price"; 
	
	/**
	 * 字段描述：num
	 * 字段类型：int(6)  长度：6
	 */
	public static final String column_num = "num"; 
	
	/**
	 * 字段描述：总价
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_total_amount = "total_amount"; 
	
	/**
	 * 字段描述：货币
	 * 字段类型：varchar(8)  长度：8
	 */
	public static final String column_currency = "currency"; 
	
	/**
	 * 字段描述：付费通道【微信\支付宝】
	 * 字段类型：varchar(20)  长度：20
	 */
	public static final String column_pay_channel = "pay_channel"; 
	
	/**
	 * 字段描述：支付银行
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_pay_bank = "pay_bank"; 
	
	/**
	 * 字段描述：front_callback_url
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_front_callback_url = "front_callback_url"; 
	
	/**
	 * 字段描述：front_callback_url
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_back_callback_url = "back_callback_url"; 
	
	/**
	 * 字段描述：状态
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_status = "status"; 
	
	/**
	 * 字段描述：成功日期
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_success_datetime = "success_datetime"; 
	
	/**
	 * 字段描述：注意
	 * 字段类型：text【String】  长度：
	 */
	public static final String column_remark = "remark"; 
	
	/**
	 * 字段描述：请求 ip
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_req_ip = "req_ip"; 
	
	/**
	 * 字段描述：mobileNo
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_mobileNo = "mobileNo"; 
	
	/**
	 * 字段描述：交易流水
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_trade_flowno = "trade_flowno"; 
	
	/**
	 * 字段描述：快递单号
	 * 字段类型：int(10)  长度：10
	 */
	public static final String column_receive_no = "receive_no"; 
	
	/**
	 * 字段描述：后勤 msg
	 * 字段类型：varchar(120)  长度：120
	 */
	public static final String column_logistics_msg = "logistics_msg"; 
	
	/**
	 * 字段描述：支付成功流水
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_success_pay_flowno = "success_pay_flowno"; 
	
	/**
	 * 字段描述：origin_order_no
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_origin_order_no = "origin_order_no"; 
	
	/**
	 * 字段描述：main_order_no
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_main_order_no = "main_order_no"; 
	
	/**
	 * 字段描述：结算状态
	 * 字段类型：varchar(1)  长度：1
	 */
	public static final String column_settle_status = "settle_status"; 
	
	/**
	 * 字段描述：settle_batch
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_settle_batch = "settle_batch"; 
	
	/**
	 * 字段描述：到期日期时间
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_limit_datetime = "limit_datetime"; 
	
	/***********新加字段*************/
	
	/**
	 * 字段描述：到期日期时间
	 * 字段类型：  长度：
	 */
	public static final String column_is_refund = "is_refund"; 
	
	/**
	 * 字段描述：refund_amount
	 * 字段类型：  长度：
	 */
	public static final String column_refund_amount = "refund_amount"; 
	
	/**
	 * 字段描述：refund_times
	 * 字段类型：  长度：
	 */
	public static final String column_refund_times = "refund_times"; 
	
	/**
	 * 字段描述：receive_info
	 * 字段类型：  长度：
	 */
	public static final String column_receive_info = "receive_info"; 
	
	/**
	 * 字段描述：收货人手机
	 * 字段类型：  长度：
	 */
	public static final String column_buyer_mobile = "buyer_mobile"; 
	
	/**
	 * 字段描述：goods_name
	 * 字段类型：  长度：
	 */
	public static final String column_goods_name = "goods_name"; 
	
	/**
	 * 字段描述：收货人电话
	 * 字段类型：  长度：
	 */
	public static final String column_buyer_telephone = "buyer_telephone"; 
	
	/**
	 * 字段描述：收货地址ID
	 * 字段类型：  长度：
	 */
	public static final String column_receive_id = "receive_id"; 
	
	/**
	 * 字段描述：收货人名字
	 * 字段类型：  长度：
	 */
	public static final String column_receive_name = "receive_name"; 
	
	/***********新加字段*************/
	/**
	 * sqlId : platform.order.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.order.splitPageFrom";

	
	
	
	private String order_no;
	private Integer uid;
	private String version;
	
	private String trade_type;
	private String create_datetime;
	private String req_datetime;
	
	private String goods_msg;
	private String goods_id;
	private Integer seller_id;
	
	private BigDecimal price; //价格 decimal(18,2) 这里需要改改
	private Integer num;
	private BigDecimal total_amount; //总价 decimal(18,2) 这里需要改改
	
	private String currency;
	private String pay_channel;
	private String pay_bank;
	
	private String front_callback_url;
	private String back_callback_url;
	private String status;
	
	private String success_datetime;
	private String remark; // 注意 数据库类型为 text
	private String req_ip;
	
	private String mobileNo;
	private String trade_flowno;
	private String receive_no;//[]
	
	private String logistics_msg;
	private String success_pay_flowno;
	private String origin_order_no;
	
	private String main_order_no;
	private String settle_status;
	private String settle_batch;
	
	private Integer limit_datetime;//[]
	/****新加字段*****/
	private String is_refund;
	private BigDecimal refund_amount;
	private Integer refund_times;
	private String receive_info;
	
	private String buyer_mobile;
	private String goods_name;
	private String buyer_telephone;
	
	private Integer receive_id;
	private String receive_name;
	/****新加字段*****/


	/**更成了get set 还未更改**/
	
	


	public Integer getReceive_id() {
		return get(column_receive_id);
	}

	public void setReceive_id(Integer receive_id) {
		set(column_receive_id, receive_id);
	}

	public String getReceive_name() {
		return get(column_receive_name);
	}

	public void setReceive_name(String receive_name) {
		set(column_receive_name, receive_name);
	}
	
	public String getIs_refund() {
		return get(column_is_refund);
	}
	
	public void setIs_refund(String is_refund) {
		set(column_is_refund, is_refund);
	}

	public BigDecimal getRefund_amount() {
		return get(column_refund_amount);
	}

	public void setRefund_amount(BigDecimal refund_amount) {
		set(column_refund_amount, refund_amount);
	}

	public Integer getRefund_times() {
		return get(column_refund_times);
	}

	public void setRefund_times(Integer refund_times) {
		set(column_refund_times, refund_times);
	}

	public String getReceive_info() {
		return get(column_receive_info);
	}

	public void setReceive_info(String receive_info) {
		set(column_receive_info, receive_info);
	}

	public String getBuyer_mobile() {
		return get(column_buyer_mobile);
	}

	public void setBuyer_mobile(String buyer_mobile) {
		set(column_buyer_mobile, buyer_mobile);
	}

	public String getGoods_name() {
		return get(column_goods_name);
	}

	public void setGoods_name(String goods_name) {
		set(column_goods_name, goods_name);
	}

	public String getBuyer_telephone() {
		return get(column_buyer_telephone);
	}

	public void setBuyer_telephone(String buyer_telephone) {
		set(column_buyer_telephone, buyer_telephone);
	}
/**********************************************/
	public String getReceive_no() {
		return get(column_receive_no);
	}
	
	public void setReceive_no(String receive_no) {
		set(column_receive_no, receive_no);
	}

	public String getOrder_no() {
		return get(column_order_no);
	}

	public void setOrder_no(String order_no) {
		set(column_order_no, order_no);
	}

	public Integer getUid() {
		return get(column_uid);
	}

	public void setUid(Integer uid) {
		set(column_uid, uid);
	}

	public String getVersion() {
		return get(column_version);
	}

	public void setVersion(String version) {
		set(column_version, version);
	}

	public String getTrade_type() {
		return get(column_trade_type);
	}

	public void setTrade_type(String trade_type) {
		set(column_trade_type, trade_type);
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

	public String getGoods_msg() {
		return get(column_goods_msg);
	}

	public void setGoods_msg(String goods_msg) {
		set(column_goods_msg, goods_msg);
	}

	public String getGoods_id() {
		return get(column_goods_id);
	}

	public void setGoods_id(String goods_id) {
		set(column_goods_id, goods_id);
	}

	public Integer getSeller_id() {
		return get(column_seller_id);
	}

	public void setSeller_id(Integer seller_id) {
		set(column_seller_id, seller_id);
	}

	public BigDecimal getPrice() {
		return get(column_price);
	}

	public void setPrice(BigDecimal price) {
		set(column_price, price);
	}

	public Integer getNum() {
		return get(column_num);
	}

	public void setNum(Integer num) {
		set(column_num, num);
	}

	public BigDecimal getTotal_amount() {
		return get(column_total_amount);
	}

	public void setTotal_amount(BigDecimal total_amount) {
		set(column_total_amount, total_amount);
	}

	public String getCurrency() {
		return get(column_currency);
	}

	public void setCurrency(String currency) {
		set(column_currency, currency);
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

	public String getStatus() {
		return get(column_status);
	}

	public void setStatus(String status) {
		set(column_status, status);
	}

	public String getSuccess_datetime() {
		return get(column_success_datetime);
	}

	public void setSuccess_datetime(String success_datetime) {
		set(column_success_datetime, success_datetime);
	}

	public String getRemark() {
		return get(column_remark);
	}

	public void setRemark(String remark) {
		set(column_remark, remark);
	}

	public String getReq_ip() {
		return get(column_req_ip);
	}

	public void setReq_ip(String req_ip) {
		set(column_req_ip, req_ip);
	}

	public String getMobileNo() {
		return get(column_mobileNo);
	}

	public void setMobileNo(String mobileNo) {
		set(column_mobileNo, mobileNo);
	}

	public String getTrade_flowno() {
		return get(column_trade_flowno);
	}

	public void setTrade_flowno(String trade_flowno) {
		set(column_trade_flowno, trade_flowno);
	}

	public String getLogistics_msg() {
		return get(column_logistics_msg);
	}

	public void setLogistics_msg(String logistics_msg) {
		set(column_logistics_msg, logistics_msg);
	}

	public String getSuccess_pay_flowno() {
		return get(column_success_pay_flowno);
	}

	public void setSuccess_pay_flowno(String success_pay_flowno) {
		set(column_success_pay_flowno, success_pay_flowno);
	}

	public String getOrigin_order_no() {
		return get(column_origin_order_no);
	}

	public void setOrigin_order_no(String origin_order_no) {
		set(column_origin_order_no, origin_order_no);
	}

	public String getMain_order_no() {
		return get(column_main_order_no);
	}

	public void setMain_order_no(String main_order_no) {
		set(column_main_order_no, main_order_no);
	}

	public String getSettle_status() {
		return get(column_settle_status);
	}

	public void setSettle_status(String settle_status) {
		set(column_settle_status, settle_status);
	}

	public String getSettle_batch() {
		return get(column_settle_batch);
	}

	public void setSettle_batch(String settle_batch) {
		set(column_settle_batch, settle_batch);
	}

	public Integer getLimit_datetime() {
		return get(column_limit_datetime);
	}

	public void setLimit_datetime(Integer limit_datetime) {
		set(column_limit_datetime, limit_datetime);
	}

	@Override
	public String toString() {
		return "Order [order_no=" + order_no + ", uid=" + uid + ", version="
				+ version + ", trade_type=" + trade_type + ", create_datetime="
				+ create_datetime + ", req_datetime=" + req_datetime
				+ ", goods_msg=" + goods_msg + ", goods_id=" + goods_id
				+ ", seller_id=" + seller_id + ", price=" + price + ", num="
				+ num + ", total_amount=" + total_amount + ", currency="
				+ currency + ", pay_channel=" + pay_channel + ", pay_bank="
				+ pay_bank + ", front_callback_url=" + front_callback_url
				+ ", back_callback_url=" + back_callback_url + ", status="
				+ status + ", success_datetime=" + success_datetime
				+ ", remark=" + remark + ", req_ip=" + req_ip + ", mobileNo="
				+ mobileNo + ", trade_flowno=" + trade_flowno + ", receive_no="
				+ receive_no + ", logistics_msg=" + logistics_msg
				+ ", success_pay_flowno=" + success_pay_flowno
				+ ", origin_order_no=" + origin_order_no + ", main_order_no="
				+ main_order_no + ", settle_status=" + settle_status
				+ ", settle_batch=" + settle_batch + ", limit_datetime="
				+ limit_datetime + ", is_refund=" + is_refund
				+ ", refund_amount=" + refund_amount + ", refund_times="
				+ refund_times + ", receive_info=" + receive_info
				+ ", buyer_mobile=" + buyer_mobile + ", goods_name="
				+ goods_name + ", buyer_telephone=" + buyer_telephone + "]";
	}
	
	
	


}
