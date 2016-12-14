package com.platform.mvc.forum;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.partner.Partner;

@SuppressWarnings("unused")
@Table(tableName = HomeTopPost.table_name, pkName = "tid")
public class HomeTopPost extends BaseModel<HomeTopPost> {

	private static final long serialVersionUID = 6636842343683044173L;

	private static Logger log = Logger.getLogger(HomeTopPost.class);
	
	public static final HomeTopPost dao = new HomeTopPost();
	
	/**
	 * 表名称
	 */
	public static final String table_name = "pre_common_home_top_post";
	
	/**
	 * 字段描述：tid
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_tid = "tid";  
	
	/**
	 * 字段描述：标题 
	 * 字段类型：varchar(80)  长度：80
	 */
	public static final String column_subject = "subject";
	
	/**
	 * 字段描述：内容 
	 * 字段类型：varchar(100)  长度：100
	 */
	public static final String column_content = "content";
	
	/**
	 * 字段描述：图片url 
	 * 字段类型：varchar(120)  长度：120
	 */
	public static final String column_image_url = "image_url";
	
	/**
	 * 字段描述：作者名字
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_author_name = "author_name";
	
	/**
	 * 字段描述：作者ID
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_author_id = "author_id";
	
	/**
	 * 字段描述：
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_replies = "replies";
	
	/**
	 * 字段描述： 
	 * 字段类型：int(10)  长度：10
	 */
	public static final String column_views = "views";
	
	/**
	 * 字段描述：
	 * 字段类型：varchar(80)  长度：80
	 */
	public static final String column_forumName = "forumName";
	
	/**
	 * 字段描述：
	 * 字段类型：int(10)  长度：10
	 */
	public static final String column_dateline = "dateline";
	
	/**
	 * sqlId : platform.forum.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.forum.splitPageFrom";
	
	/**
	 * sqlId : platform.forum.edit
	 * 描述：根据tid更新
	 */
	public static final String sqlId_edit = "platform.forum.edit";
	
	/**
	 * sqlId : platform.forum.save
	 * 描述：增加数据 
	 */
	public static final String sqlId_save = "platform.forum.save";
	
	/**
	 * sqlId : platform.forum.deleteInfo
	 * 描述：根据tid更新
	 */
	public static final String sqlId_delete = "platform.forum.deleteInfo";
	
	/**
	 * sqlId : platform.forum.valiHTPubjectInfo
	 * 描述：查询标题信息是否存在的sql
	 */
	public static final String sqlId_valiHTPubjectInfo = "platform.forum.valiHTPubjectInfo";
	
	private Integer tid;
	private String subject;
	private String content;
	private String image_url;
	private String author_name;
	private Integer author_id;
	private Integer replies;
	private String forumName;
//	private Integer views;
//	private Integer dateline;
	private Long views;
	private Long dateline;
	
	
	public Integer getTid() {
		return get(column_tid);
	}
	public void setTid(Integer tid) {
		set(column_tid, tid);
	}
	public String getSubject() {
		return get(column_subject);
	}
	public void setSubject(String subject) {
		set(column_subject, subject);
	}
	public String getContent() {
		return getStr(column_content);
	}
	public void setContent(String content) {
		set(column_content, content);
	}
	public String getImage_url() {
		return getStr(column_image_url);
	}
	public void setImage_url(String image_url) {
		set(column_image_url, image_url);
	}
	public String getAuthor_name() {
		return getStr(column_author_name);
	}
	public void setAuthor_name(String author_name) {
		set(column_author_name, author_name);
	}
	public Integer getAuthor_id() {
		return get(column_author_id);
	}
	public void setAuthor_id(Integer author_id) {
		set(column_author_id, author_id);
	}
	public Integer getReplies() {
		return get(column_replies);
	}
	public void setReplies(Integer replies) {
		set(column_replies, replies);
	}

	public String getForumName() {
		return get(column_forumName);
	}
	public void setForumName(String forumName) {
		set(column_forumName, forumName);
	}
//	public Integer getDateline() {
//		return get(column_dateline);
//	}
//	public void setDateline(Integer dateline) {
//		set(column_dateline, dateline);
//	}
//	public Integer getViews() {
//		return get(column_views);
//	}
//	public void setViews(Integer views) {
//		set(column_views, views);
//	}
	public Long getViews() {
		return get(column_views);
	}
	public void setViews(Long views) {
		set(column_views, views);
	}
	public Long getDateline() {
		return get(column_dateline);
	}
	public void setDateline(Long dateline) {
		set(column_dateline, dateline);
	}
	
		

}
