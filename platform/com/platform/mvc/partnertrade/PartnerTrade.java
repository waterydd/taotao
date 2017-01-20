package com.platform.mvc.partnertrade;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = PartnerTrade.table_name,pkName = "id")
public class PartnerTrade extends BaseModel<PartnerTrade> {

	private static final long serialVersionUID = -5611034103171553276L;

	private static Logger log = Logger.getLogger(PartnerTrade.class);
	
	public static final PartnerTrade dao = new PartnerTrade();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_trade";
	
	/**
	 * 字段描述：ID
	 * 字段类型：varchar(32)  长度：32
	 */
	public static final String column_id = "id"; 

	/**
	 * 字段描述：名字
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_name = "name";  
	
	/**
	 * 字段描述：价格
	 * 字段类型：decimal(18,2)  长度：
	 */
	public static final String column_price = "price"; 
	/**************我是一条分割线***************/
	/**
	 * 字段描述：小分类
	 * 字段类型：char(2)  长度：2
	 */
	public static final String column_classify = "classify"; 
	
	/**
	 * 字段描述：商品类型(大分类)
	 * 字段类型：char(2)  长度：2
	 */
	public static final String column_goods_type = "goods_type"; 
	
	/**
	 * 字段描述：是否需要物流
	 * 字段类型：char(1)  长度：1
	 */
	public static final String column_need_logistics = "need_logistics"; 
	
	/**
	 * 字段描述：商品图片地址
	 * 字段类型：varchar(80)  长度：80
	 */
	public static final String column_img_url = "img_url"; 
	
	/**
	 * 字段描述：库存
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_inventory = "inventory"; 
	
	/**
	 * 字段描述：状态
	 * 字段类型：char(2)  长度：2
	 */
	public static final String column_status = "status"; 
	
	/**
	 * 字段描述：显示顺序（小的显示在前面）
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_display_order = "display_order"; 
	
	/**
	 * 字段描述：卖家ID
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_seller_id = "seller_id"; 
	
	/**
	 * 字段描述：卖家名字
	 * 字段类型：varchar(40)  长度：40
	 */
	public static final String column_seller_name = "seller_name"; 
	/***********我是一条分割线*************/
	
	
	/**
	 * sqlId : platform.partnerTrade.deleteInfo
	 * 描述：根据tid删除
	 */
	public static final String sqlId_delete = "platform.partnerTrade.deleteInfo";
	
	/**
	 * sqlId : platform.partnerTrade.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.partnerTrade.splitPageFrom";
	
	
	private String id;
	private String name;
	private BigDecimal price;
	
	private String classify;
	private String goods_type;
	private String need_logistics;
	
	private String img_url;
	private Integer inventory;
	private String status;
	
	private Integer display_order;
	private Integer seller_id;
	private String seller_name;

	/***************/
	
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
	
	public BigDecimal getPrice() {
		return get(column_price);
	}
	
	public void setPrice(BigDecimal price) {
		set(column_price, price);
	}
	
	public String getClassify() {
		return get(column_classify);
	}
	
	public void setClassify(String classify) {
		set(column_classify, classify);
	}
	
	public String getGoods_type() {
		return get(column_goods_type);
	}
	
	public void setGoods_type(String goods_type) {
		set(column_goods_type, goods_type);
	}
	
	public String getNeed_logistics() {
		return get(column_need_logistics);
	}
	
	public void setNeed_logistics(String need_logistics) {
		set(column_need_logistics, need_logistics);
	}
	
	public String getImg_url() {
		return get(column_img_url);
	}
	
	public void setImg_url(String img_url) {
		set(column_img_url, img_url);
	}
	
	public Integer getInventory() {
		return get(column_inventory);
	}
	
	public void setInventory(Integer inventory) {
		set(column_inventory, inventory);
	}
	
	public String getStatus() {
		return get(column_status);
	}
	
	public void setStatus(String status) {
		set(column_status, status);
	}
	
	public Integer getDisplay_order() {
		return get(column_display_order);
	}
	
	public void setDisplay_order(Integer display_order) {
		set(column_display_order, display_order);
	}
	
	public Integer getSeller_id() {
		return get(column_seller_id);
	}
	
	public void setSeller_id(Integer seller_id) {
		set(column_seller_id, seller_id);
	}
	
	public String getSeller_name() {
		return get(column_seller_name);
	}
	
	public void setSeller_name(String seller_name) {
		set(column_seller_name, seller_name);
	}
	

	@Override
	public String toString() {
		return "PartnerTrade [id=" + id + ", name=" + name + ", price=" + price
				+ ", classify=" + classify + ", goods_type=" + goods_type
				+ ", need_logistics=" + need_logistics + ", img_url=" + img_url
				+ ", inventory=" + inventory + ", status=" + status
				+ ", display_order=" + display_order + ", seller_id="
				+ seller_id + ", seller_name=" + seller_name + "]";
	}
	

	
	

	

}
