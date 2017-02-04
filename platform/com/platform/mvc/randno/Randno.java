package com.platform.mvc.randno;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = Randno.table_name,pkName = "id")
public class Randno extends BaseModel<Randno> {

	private static final long serialVersionUID = 144288752621126319L;

	private static Logger log = Logger.getLogger(Randno.class);
	
	public static final Randno dao = new Randno();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pt_trade_no";
	
	/**
	 * 字段描述：ID
	 * 字段类型：  长度：
	 */
	public static final String column_id = "id"; 

	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_rand_num = "rand_num";  

	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_member_id = "member_id";  
	
	/**
	 * 字段描述：ID
	 * 字段类型：  长度：
	 */
	public static final String column_is_use = "is_use"; 

	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_num_length = "num_length";  
	
	/**
	 * sqlId : platform.partnerTrade.deleteInfo
	 * 描述：根据tid删除
	 */
//	public static final String sqlId_delete = "platform.partnerTrade.deleteInfo";
	
	/**
	 * sqlId : platform.partnerTrade.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
//	public static final String sqlId_splitPageFrom = "platform.partnerTrade.splitPageFrom";
	
	
	private Long id;
	private Integer rand_num;
	private Boolean is_use;
	private Integer num_length;
	private Long member_id;
	
	
	public Long getId() {
		return get(column_id);
	}
	
	public void setId(Long id) {
		set(column_id, id);
	}
	
	public Integer getRand_num() {
		return get(column_rand_num);
	}
	
	public void setRand_num(Integer rand_num) {
		set(column_rand_num, rand_num);
	}
	
	public Boolean getIs_use() {
		return get(column_is_use);
	}
	
	public void setIs_use(Boolean is_use) {
		set(column_is_use, is_use);
	}
	
	public Integer getNum_length() {
		return get(column_num_length);
	}
	
	public void setNum_length(Integer num_length) {
		set(column_num_length, num_length);
	}
	
	public Long getMember_id() {
		return get(column_member_id);
	}
	
	public void setMember_id(Long member_id) {
		set(column_member_id, member_id);
	}


	

}
