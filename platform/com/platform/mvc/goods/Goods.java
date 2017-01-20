package com.platform.mvc.goods;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = Goods.table_name,pkName = "id")
public class Goods extends BaseModel<Goods> {

	private static final long serialVersionUID = 4433600927099312344L;

	private static Logger log = Logger.getLogger(Goods.class);
	
	public static final Goods dao = new Goods();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_eb_goods";
	
	/**
	 * 字段描述：ID
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_id = "id"; 

	/**
	 * 字段描述：名字
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_name = "name";  
	
	/**
	 * 字段描述：pic_path
	 * 字段类型：varchar(200)  长度：200
	 */
	public static final String column_pic_path = "pic_path"; 
	
	/**
	 * 字段描述：original_price
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_original_price = "original_price"; 
	
	/**
	 * 字段描述：now_price
	 * 字段类型：decimal(18,2)   长度：
	 */
	public static final String column_now_price = "now_price"; 
	
	/**
	 * 字段描述：inventory
	 * 字段类型：int(10)  长度：10
	 */
	public static final String column_inventory = "inventory"; 
	
	/**
	 * 字段描述：type_id
	 * 字段类型：int(10)  长度：10
	 */
	public static final String column_type_id = "type_id"; 
	
	/**
	 * 字段描述：attribute_id
	 * 字段类型：int(10)  长度：10
	 */
	public static final String column_attribute_id = "attribute_id"; 
	
	/**
	 * 字段描述：thread_url
	 * 字段类型：varchar(200)  长度：200
	 */
	public static final String column_thread_url = "thread_url"; 
	
	/**
	 * 字段描述：publisher_id
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_publisher_id = "publisher_id"; 
	
	/**
	 * 字段描述：publisher_name
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_publisher_name = "publisher_name"; 
	
	/**
	 * 字段描述：publisher_logo
	 * 字段类型：varchar(200)  长度：200
	 */
	public static final String column_publisher_logo = "publisher_logo"; 
	
	/**
	 * 字段描述：need_logistics
	 * 字段类型：char(1)  长度：1
	 */
	public static final String column_need_logistics = "need_logistics"; 
	
	/**
	 * 字段描述：display_order
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_display_order = "display_order"; 
	
	/**
	 * 字段描述： 状态
	 * 字段类型：varchar(3)  长度：3
	 */
	public static final String column_status = "status"; 
	
	/**
	 * 字段描述：卖家ID
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_summary = "summary"; 
	
	
	/**
	 * 字段描述：pay_channel_manner
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_pay_channel_manner = "pay_channel_manner"; 
	
	/**
	 * sqlId : platform.goods.deleteInfo
	 * 描述：根据tid删除
	 */
	public static final String sqlId_delete = "platform.goods.deleteInfo";
	
	/**
	 * sqlId : platform.goods.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.goods.splitPageFrom";
	
	
	private String id;
	private String name;
	private String pic_path;
	
	private BigDecimal original_price;
	private BigDecimal now_price;
	private Integer inventory;
	
	private Integer type_id;
	private Integer attribute_id;
	private String thread_url;
	
	private Integer publisher_id;
	private String publisher_name;
	private String publisher_logo;
	
	private String need_logistics;
	private Integer display_order;
	private String status;
	
	private String summary;
	private String pay_channel_manner;
	
	
	public String getPay_channel_manner() {
		return get(column_pay_channel_manner);
	}

	public void setPay_channel_manner(String pay_channel_manner) {
		set(column_pay_channel_manner, pay_channel_manner);
	}

	public String getId() {
		return get(column_id);
	}
	
	public void setId(String id) {
		set(column_id, id);
	}
	
	public String getName() {
		return get(column_name);
	}
	
	public void setName(String name) {
		set(column_name, name);
	}
	
	public String getPic_path() {
		return get(column_pic_path);
	}
	
	public void setPic_path(String pic_path) {
		set(column_pic_path, pic_path);
	}
	
	public BigDecimal getOriginal_price() {
		return get(column_original_price);
	}
	
	public void setOriginal_price(BigDecimal original_price) {
		set(column_original_price, original_price);
	}
	
	public BigDecimal getNow_price() {
		return get(column_now_price);
	}
	
	public void setNow_price(BigDecimal now_price) {
		set(column_now_price, now_price);
	}
	
	public Integer getInventory() {
		return get(column_inventory);
	}
	
	public void setInventory(Integer inventory) {
		set(column_inventory, inventory);
	}
	
	public Integer getType_id() {
		return get(column_type_id);
	}
	
	public void setType_id(Integer type_id) {
		set(column_type_id, type_id);
	}
	
	public Integer getAttribute_id() {
		return get(column_attribute_id);
	}
	
	public void setAttribute_id(Integer attribute_id) {
		set(column_attribute_id, attribute_id);
	}
	
	public String getThread_url() {
		return get(column_thread_url);
	}
	
	public void setThread_url(String thread_url) {
		set(column_thread_url, thread_url);
	}
	
	public Integer getPublisher_id() {
		return get(column_publisher_id);
	}
	
	public void setPublisher_id(Integer publisher_id) {
		set(column_publisher_id, publisher_id);
	}
	
	public String getPublisher_name() {
		return get(column_publisher_name);
	}
	
	public void setPublisher_name(String publisher_name) {
		set(column_publisher_name, publisher_name);
	}
	
	public String getPublisher_logo() {
		return get(column_publisher_logo);
	}
	
	public void setPublisher_logo(String publisher_logo) {
		set(column_publisher_logo, publisher_logo);
	}
	
	public String getNeed_logistics() {
		return get(column_need_logistics);
	}
	
	public void setNeed_logistics(String need_logistics) {
		set(column_need_logistics, need_logistics);
	}
	
	public Integer getDisplay_order() {
		return get(column_display_order);
	}
	
	public void setDisplay_order(Integer display_order) {
		set(column_display_order, display_order);
	}
	
	public String getStatus() {
		return get(column_status);
	}
	
	public void setStatus(String status) {
		set(column_status, status);
	}
	
	public String getSummary() {
		return get(column_summary);
	}
	
	public void setSummary(String summary) {
		set(column_summary, summary);
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", pic_path=" + pic_path
				+ ", original_price=" + original_price + ", now_price="
				+ now_price + ", inventory=" + inventory + ", type_id="
				+ type_id + ", attribute_id=" + attribute_id + ", thread_url="
				+ thread_url + ", publisher_id=" + publisher_id
				+ ", publisher_name=" + publisher_name + ", publisher_logo="
				+ publisher_logo + ", need_logistics=" + need_logistics
				+ ", display_order=" + display_order + ", status=" + status
				+ ", summary=" + summary + ", pay_channel_manner="
				+ pay_channel_manner + "]";
	}

	
	

}
