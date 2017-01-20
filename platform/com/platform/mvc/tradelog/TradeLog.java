package com.platform.mvc.tradelog;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = TradeLog.table_name,pkName = "orderid")
public class TradeLog extends BaseModel<TradeLog> {

	private static final long serialVersionUID = -8388167199190646732L;

	private static Logger log = Logger.getLogger(TradeLog.class);
	
	public static final TradeLog dao = new TradeLog();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_forum_tradelog";
//********************我是一条分割线*****************************	
	/**
	 * 字段描述：tid
	 * 字段类型：  长度：
	 */
	public static final String column_tid = "tid"; 
	
	/**
	 * 字段描述：pid
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_pid = "pid";  
	
	/**
	 * 字段描述：orderid
	 * 字段类型：varchar(35)  长度：35
	 */
	public static final String column_orderid = "orderid"; 
	
	/**
	 * 字段描述：tradeno
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_tradeno = "tradeno"; 
	
	/**
	 * 字段描述：paytype
	 * 字段类型：varchar(3)  长度：8
	 */
	public static final String column_paytype = "paytype"; 
	
	/**
	 * 字段描述：subject
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_subject = "subject"; 
	
	/**
	 * 字段描述：price
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_price = "price"; 
	
	/**
	 * 字段描述：quality
	 * 字段类型：varchar(6)  长度：6
	 */
	public static final String column_quality = "quality"; 
	
	/**
	 * 字段描述：itemtype
	 * 字段类型：mediumint(35)  长度：35
	 */
	public static final String column_itemtype = "itemtype"; 
	
	/**
	 * 字段描述：number
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_number = "number"; 
	
	/**
	 * 字段描述：tax
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_tax = "tax"; 
	
	/**
	 * 字段描述：locus
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_locus = "locus"; 
	
	/**
	 * 字段描述：sellerid
	 * 字段类型：varchar(64)  长度：64
	 */
	public static final String column_sellerid = "sellerid"; 
	
	/**
	 * 字段描述：seller
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_seller = "seller"; 
	
	/**
	 * 字段描述：selleraccount
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_selleraccount = "selleraccount"; 
	
	/**
	 * 字段描述：tenpayaccount
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_tenpayaccount = "tenpayaccount"; 
	
	/**
	 * 字段描述：buyerid
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_buyerid = "buyerid"; 
	
	/**
	 * 字段描述：buyer
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_buyer = "buyer"; 
	
	/**
	 * 字段描述：buyercontact
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_buyercontact = "buyercontact"; 
	
	/**
	 * 字段描述：buyercredits
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_buyercredits = "buyercredits"; 
	
	/**
	 * 字段描述：buyermsg
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_buyermsg = "buyermsg"; 
	
	/**
	 * 字段描述：status
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_status = "status"; 
	//*************我是一条分割线********************************
	
	/**
	 * 字段描述：lastupdate
	 * 字段类型：varchar(6)  长度：6
	 */
	public static final String column_lastupdate = "lastupdate"; 
	
	/**
	 * 字段描述：offline
	 * 字段类型：mediumint(35)  长度：35
	 */
	public static final String column_offline = "offline"; 
	
	/**
	 * 字段描述：buyername
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_buyername = "buyername"; 
	
	/**
	 * 字段描述：buyerzip
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_buyerzip = "buyerzip"; 
	
	/**
	 * 字段描述：buyerphone
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_buyerphone = "buyerphone"; 
	
	/**
	 * 字段描述：buyermobile
	 * 字段类型：varchar(64)  长度：64
	 */
	public static final String column_buyermobile = "buyermobile"; 
	
	/**
	 * 字段描述：transport
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_transport = "transport"; 
	
	/**
	 * 字段描述：transportfee
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_transportfee = "transportfee"; 
	
	/**
	 * 字段描述：baseprice
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_baseprice = "baseprice"; 
	
	/**
	 * 字段描述：discount
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_discount = "discount"; 
	
	/**
	 * 字段描述：ratestatus
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_ratestatus = "ratestatus"; 
	
	/**
	 * 字段描述：message
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_message = "message"; 
	
	/**
	 * 字段描述：credit
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_credit = "credit"; 
	
	/**
	 * 字段描述：basecredit
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_basecredit = "basecredit"; 
	
	/**
	 * 字段描述：receive_id
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_receive_id = "receive_id"; 
	
	/**
	 * sqlId : platform.tradeLog.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.tradeLog.splitPageFrom";
	
	
	private Integer tid;
	private Long pid;
	private String orderid;
	
	private BigDecimal price;
	
	private String tradeno;
	private Integer paytype;
	
	private String subject;
	private Integer quality;
	private Integer itemtype;
	
	private Integer number;
	private BigDecimal tax;
	private String locus;
	
	private Integer sellerid;
	private String seller;
	private String selleraccount;
	
	private String tenpayaccount;
	private Integer buyerid; 
	private String buyer;
	
	private String buyercontact;
	private Integer buyercredits;
	private String buyermsg;
	
	private Integer status;
	//***********
	private Integer lastupdate;
	private Integer offline;
	private String buyername;
	
	private String buyerzip;
	private String buyerphone;
	private String buyermobile;
	
	private Integer transport;
	private Integer transportfee;
	private BigDecimal baseprice;
	
	private Integer discount;
	private Integer ratestatus; 
	private String message;
	
	private BigDecimal credit;
	private BigDecimal basecredit;
	private Integer receive_id;
	
	
	public Integer getTid() {
		return get(column_tid);
	}
	
	public void setTid(Integer tid) {
		set(column_tid, tid);
	}
	
	public Long getPid() {
		return get(column_pid);
	}
	
	public void setPid(Long pid) {
		set(column_pid, pid);
	}
	
	public String getOrderid() {
		return get(column_orderid);
	}
	
	public void setOrderid(String orderid) {
		set(column_orderid, orderid);
	}
	
	public BigDecimal getPrice() {
		return get(column_price);
	}
	
	public void setPrice(BigDecimal price) {
		set(column_price, price);
	}
	
	public String getTradeno() {
		return get(column_tradeno);
	}
	
	public void setTradeno(String tradeno) {
		set(column_tradeno, tradeno);
	}
	
	public Integer getPaytype() {
		return get(column_paytype);
	}
	
	public void setPaytype(Integer paytype) {
		set(column_paytype, paytype);
	}
	
	public String getSubject() {
		return get(column_subject);
	}
	
	public void setSubject(String subject) {
		set(column_subject, subject);
	}
	
	public Integer getQuality() {
		return get(column_quality);
	}
	
	public void setQuality(Integer quality) {
		set(column_quality, quality);
	}
	
	public Integer getItemtype() {
		return get(column_itemtype);
	}
	
	public void setItemtype(Integer itemtype) {
		set(column_itemtype, itemtype);
	}
	
	public Integer getNumber() {
		return get(column_number);
	}
	
	public void setNumber(Integer number) {
		set(column_number, number);
	}
	
	public BigDecimal getTax() {
		return get(column_tax);
	}
	
	public void setTax(BigDecimal tax) {
		set(column_tax, tax);
	}
	
	public String getLocus() {
		return get(column_locus);
	}
	
	public void setLocus(String locus) {
		set(column_locus, locus);
	}
	
	public Integer getSellerid() {
		return get(column_sellerid);
	}
	
	public void setSellerid(Integer sellerid) {
		set(column_sellerid, sellerid);
	}
	
	public String getSeller() {
		return get(column_seller);
	}
	
	public void setSeller(String seller) {
		set(column_seller, seller);
	}
	
	public String getSelleraccount() {
		return get(column_selleraccount);
	}
	
	public void setSelleraccount(String selleraccount) {
		set(column_selleraccount, selleraccount);
	}
	
	public String getTenpayaccount() {
		return get(column_tenpayaccount);
	}
	
	public void setTenpayaccount(String tenpayaccount) {
		set(column_tenpayaccount, tenpayaccount);
	}
	
	public Integer getBuyerid() {
		return get(column_buyerid);
	}
	
	public void setBuyerid(Integer buyerid) {
		set(column_buyerid, buyerid);
	}
	
	public String getBuyer() {
		return get(column_buyer);
	}
	
	public void setBuyer(String buyer) {
		set(column_buyer, buyer);
	}
	
	public String getBuyercontact() {
		return get(column_buyercontact);
	}
	
	public void setBuyercontact(String buyercontact) {
		set(column_buyercontact, buyercontact);
	}
	
	public Integer getBuyercredits() {
		return get(column_buyercredits);
	}
	
	public void setBuyercredits(Integer buyercredits) {
		set(column_buyercredits, buyercredits);
	}
	
	public String getBuyermsg() {
		return get(column_buyermsg);
	}
	
	public void setBuyermsg(String buyermsg) {
		set(column_buyermsg, buyermsg);
	}
	
	public Integer getStatus() {
		return get(column_status);
	}
	
	public void setStatus(Integer status) {
		set(column_status, status);
	}
	
	public Long getLastupdate() {
		return get(column_lastupdate);
	}
	
	public void setLastupdate(Long lastupdate) {
		set(column_lastupdate, lastupdate);
	}
	
	public Integer getOffline() {
		return get(column_offline);
	}
	
	public void setOffline(Integer offline) {
		set(column_offline, offline);
	}
	
	public String getBuyername() {
		return get(column_buyername);
	}
	
	public void setBuyername(String buyername) {
		set(column_buyername, buyername);
	}
	
	public String getBuyerzip() {
		return get(column_buyerzip);
	}
	
	public void setBuyerzip(String buyerzip) {
		set(column_buyerzip, buyerzip);
	}
	
	public String getBuyerphone() {
		return get(column_buyerphone);
	}
	
	public void setBuyerphone(String buyerphone) {
		set(column_buyerphone, buyerphone);
	}
	
	public String getBuyermobile() {
		return get(column_buyermobile);
	}
	
	public void setBuyermobile(String buyermobile) {
		set(column_buyermobile, buyermobile);
	}
	
	public Integer getTransport() {
		return get(column_transport);
	}
	
	public void setTransport(Integer transport) {
		set(column_transport, transport);
	}
	
	public Integer getTransportfee() {
		return get(column_transportfee);
	}
	
	public void setTransportfee(Integer transportfee) {
		set(column_transportfee, transportfee);
	}
	
	public BigDecimal getBaseprice() {
		return get(column_baseprice);
	}
	
	public void setBaseprice(BigDecimal baseprice) {
		set(column_baseprice, baseprice);
	}
	
	public Integer getDiscount() {
		return get(column_discount);
	}
	
	public void setDiscount(Integer discount) {
		set(column_discount, discount);
	}
	
	public Integer getRatestatus() {
		return get(column_ratestatus);
	}
	
	public void setRatestatus(Integer ratestatus) {
		set(column_ratestatus, ratestatus);
	}
	
	public String getMessage() {
		return get(column_message);
	}
	
	public void setMessage(String message) {
		set(column_message, message);
	}
	
	public BigDecimal getCredit() {
		return get(column_credit);
	}
	
	public void setCredit(BigDecimal credit) {
		set(column_credit, credit);
	}
	
	public BigDecimal getBasecredit() {
		return get(column_basecredit);
	}
	
	public void setBasecredit(BigDecimal basecredit) {
		set(column_basecredit, basecredit);
	}
	
	public Integer getReceive_id() {
		return get(column_receive_id);
	}
	
	public void setReceive_id(Integer receive_id) {
		set(column_receive_id, receive_id);
	}

	@Override
	public String toString() {
		return "TradeLog [tid=" + tid + ", pid=" + pid + ", orderid=" + orderid
				+ ", price=" + price + ", tradeno=" + tradeno + ", paytype="
				+ paytype + ", subject=" + subject + ", quality=" + quality
				+ ", itemtype=" + itemtype + ", number=" + number + ", tax="
				+ tax + ", locus=" + locus + ", sellerid=" + sellerid
				+ ", seller=" + seller + ", selleraccount=" + selleraccount
				+ ", tenpayaccount=" + tenpayaccount + ", buyerid=" + buyerid
				+ ", buyer=" + buyer + ", buyercontact=" + buyercontact
				+ ", buyercredits=" + buyercredits + ", buyermsg=" + buyermsg
				+ ", status=" + status + ", lastupdate=" + lastupdate
				+ ", offline=" + offline + ", buyername=" + buyername
				+ ", buyerzip=" + buyerzip + ", buyerphone=" + buyerphone
				+ ", buyermobile=" + buyermobile + ", transport=" + transport
				+ ", transportfee=" + transportfee + ", baseprice=" + baseprice
				+ ", discount=" + discount + ", ratestatus=" + ratestatus
				+ ", message=" + message + ", credit=" + credit
				+ ", basecredit=" + basecredit + ", receive_id=" + receive_id
				+ "]";
	}



}
