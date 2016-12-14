package com.platform.mvc.imgmanage;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.forum.ForumThread;

@SuppressWarnings("unused")
@Table(tableName = Validatecode.table_name, pkName = "type")
public class Validatecode extends BaseModel<Validatecode> {

	private static final long serialVersionUID = 7134853145038534255L;

	private static Logger log = Logger.getLogger(Validatecode.class);
	
	public static final Validatecode dao = new Validatecode();
	
	/**
	 * 表名称
	 */
	public static final String table_name = "pre_common_validatecode";
	
	/**
	 * 字段描述：type
	 * 字段类型：char(2)  长度：2 DEFAULT ''
	 */
	public static final String column_type = "type";  
	
	/**
	 * 字段描述：validate_code
	 * 字段类型：varchar(20)  长度：20
	 */
	public static final String column_validate_code = "validate_code"; 
	
	/**
	 * 字段描述： comment
	 * 字段类型： varchar(200)  长度：200
	 */
	public static final String column_comment = "comment";
	
	/**
	 * 字段描述：reserved1
	 * 字段类型：varchar(256)  长度：256
	 */
	public static final String column_reserved1 = "reserved1";


	private String type;
	private String validate_code;
	private String comment;
	private String reserved1;
	
	public String getType() {
		return get(column_type);
	}
	public void setType(String type) {
		set(column_type, type);
	}
	public String getValidate_code() {
		return get(column_validate_code);
	}
	public void setValidate_code(String validate_code) {
		set(column_validate_code, validate_code);
	}
	public String getComment() {
		return get(column_comment);
	}
	public void setComment(String comment) {
		set(column_comment, comment);
	}
	public String getReserved1() {
		return get(column_reserved1);
	}
	public void setReserved1(String reserved1) {
		set(column_reserved1, reserved1);
	}
	
	
	
}
