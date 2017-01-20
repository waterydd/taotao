package com.platform.mvc.goodsattribute;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = GoodsAttribute.table_name,pkName = "id")
public class GoodsAttribute extends BaseModel<GoodsAttribute> {

	private static final long serialVersionUID = 7592248715272224719L;

	private static Logger log = Logger.getLogger(GoodsAttribute.class);
	
	public static final GoodsAttribute dao = new GoodsAttribute();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_eb_goods_attribute";
	
	/**
	 * 字段描述：ID 【不为空 自增长】
	 * 字段类型：int(10)  长度：10
	 */
	public static final String column_id = "id"; 
//********************我是一条分割线***************************
	/**
	 * 字段描述：类型
	 * 字段类型：varchar(2)  长度：2
	 */
	public static final String column_type = "type";  
	
	/**
	 * 字段描述：parent_id
	 * 字段类型：int(10)  长度：10
	 */
	public static final String column_parent_id = "parent_id"; 
	
	/**
	 * 字段描述：名字
	 * 字段类型：varchar(80)  长度：80
	 */
	public static final String column_name = "name"; 
	
	/**
	 * 字段描述：值
	 * 字段类型：text   长度：
	 */
	public static final String column_value = "value"; 
	
	/**
	 * sqlId : platform.goodsattribute.deleteInfo
	 * 描述：根据id删除
	 */
	public static final String sqlId_delete = "platform.goodsattribute.deleteInfo";
	
	/**
	 * sqlId : platform.goodsattribute.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.goodsattribute.splitPageFrom";
	
	
	private Integer id;
	private String type;
	private Integer parent_id;
	private String name;
	private String value;


	public Integer getId() {
		return get(column_id);
	}
	
	public void setId(Integer id) {
		set(column_id, id);
	}

	public String getType() {
		return get(column_type);
	}

	public void setType(String type) {
		set(column_type, type);
	}

	public Integer getParent_id() {
		return get(column_parent_id);
	}

	public void setParent_id(Integer parent_id) {
		set(column_parent_id, parent_id);
	}

	public String getName() {
		return get(column_name);
	}

	public void setName(String name) {
		set(column_name, name);
	}

	public String getValue() {
		return get(column_value);
	}

	public void setValue(String value) {
		set(column_value, value);
	}

	@Override
	public String toString() {
		return "GoodsAttribute [id=" + id + ", type=" + type + ", parent_id="
				+ parent_id + ", name=" + name + ", value=" + value + "]";
	}



}
