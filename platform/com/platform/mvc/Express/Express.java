package com.platform.mvc.Express;

import com.platform.annotation.Table;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModel;


import org.apache.log4j.Logger;

/**
 *  model
 * @author Administrator
 */
@SuppressWarnings("unused")
@Table(tableName = Express.table_name, pkName = "code")
public class Express extends BaseModel<Express> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Express.class);
	
	public static final Express dao = new Express();

	/**
	 * 表名称
	 */
	public static final String table_name = "pre_kuaidi";
	
	/**
	 * 字段描述：  代码
	 * 字段类型：varchar(80)  长度：80
	 */
	public static final String column_code = "code";
	
	/**
	 * 字段描述：快递名字
	 * 字段类型：varchar(100)  长度：100
	 */
	public static final String column_name = "name";
	
	/**
	 * 字段描述： 顺序
	 * 字段类型：int(8)  长度：null
	 */
	public static final String column_display_order = "display_order";
	
	
	/**
	 * sqlId : platform.express.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.express.splitPageFrom";

	private String code;
	private String name;
	private Integer display_order;
	
	public void setCode(String code){
		set(column_code, code);
	}
	
	public String getCode() {
		return get(column_code);
	}
	
	public void setName(String name){
		set(column_name, name);
	}
	
	public String getName() {
		return get(column_name);
	}
	
	public void setDisplay_order(Integer display_order){
		set(column_display_order, display_order);
	}
	
	public Integer getDisplay_order() {
		return get(column_display_order);
	}
	
}
