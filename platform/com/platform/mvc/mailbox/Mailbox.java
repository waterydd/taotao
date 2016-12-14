package com.platform.mvc.mailbox;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.forum.HomeTopPost;

@SuppressWarnings("unused")
@Table(tableName = HomeTopPost.table_name, pkName = "id")
public class Mailbox extends BaseModel<Mailbox> {

	private static final long serialVersionUID = -6648384439202520119L;
	
	private static Logger log = Logger.getLogger(Mailbox.class);
	
	private static final Mailbox dao = new Mailbox();
	
	/**
	 * 表名称
	 */
	public static final String table_name = "pre_mailbox";
	
	/**
	 * 字段描述：id
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_id = "id";  
	
	/**
	 * 字段描述：邮箱
	 * 字段类型：varchar(40)  长度：40
	 */
	public static final String column_email = "email";
	
	private Integer id;
	private String email;
	
	public Integer getId() {
		return get(column_id);
	}
	public void setId(Integer id) {
		set(column_id, id);
	}
	public String getEmail() {
		return get(column_email);
	}
	public void setEmail(String email) {
		set(column_email, email);
	}
	
	

}
