package com.platform.mvc.investment;

import com.platform.annotation.Table;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModel;

import java.math.BigDecimal; 

import org.apache.log4j.Logger;

/**
 *  model
 * @author Administrator
 */
@SuppressWarnings("unused")
@Table(tableName = Investment.table_name, pkName = "id")
public class Investment extends BaseModel<Investment> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Investment.class);
	
	public static final Investment dao = new Investment();

	/**
	 * 表名称
	 */
	public static final String table_name = "pre_investment";
	
	/**
	 * 字段描述： 
	 * 字段类型：int(10)  长度：null
	 */
	public static final String column_id = "id";
	
	/**
	 * 字段描述：标题 
	 * 字段类型：varchar(300)  长度：300
	 */
	public static final String column_subject = "subject";
	
	/**
	 * 字段描述：小标题 
	 * 字段类型：varchar(100)  长度：100
	 */
	public static final String column_mini_subject = "mini_subject";
	
	/**
	 * 字段描述：内容 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_content = "content";
	
	/**
	 * 字段描述：回报率 
	 * 字段类型：decimal(6,2)  长度：null
	 */
	public static final String column_reward_rate = "reward_rate";
	
	/**
	 * 字段描述：浏览量 
	 * 字段类型：int(10)  长度：null
	 */
	public static final String column_views = "views";
	
	/**
	 * 字段描述：回复量 
	 * 字段类型：mediumint(8)  长度：null
	 */
	public static final String column_replies = "replies";
	
	/**
	 * 字段描述：作者编号 
	 * 字段类型：mediumint(8)  长度：null
	 */
	public static final String column_author_id = "author_id";
	
	/**
	 * 字段描述：作者名 
	 * 字段类型：varchar(30)  长度：30
	 */
	public static final String column_author_name = "author_name";
	
	/**
	 * 字段描述：创建日期 
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_create_datetime = "create_datetime";
	
	/**
	 * 字段描述：更新日期 
	 * 字段类型：varchar(25)  长度：25
	 */
	public static final String column_update_datetime = "update_datetime";
	
	/**
	 * 字段描述：收藏数 
	 * 字段类型：mediumint(8)  长度：null
	 */
	public static final String column_collect_num = "collect_num";
	
	/**
	 * 字段描述：支持数 
	 * 字段类型：mediumint(8)  长度：null
	 */
	public static final String column_support_num = "support_num";
	
	/**
	 * 字段描述：反对数 
	 * 字段类型：mediumint(8)  长度：null
	 */
	public static final String column_oppose_num = "oppose_num";
	
	/**
	 * 字段描述：投资外网地址 
	 * 字段类型：varchar(800)  长度：800
	 */
	public static final String column_url = "url";
	
	
	/**
	 * sqlId : platform.investment.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.investment.splitPageFrom";

	private Long id;
	private String subject;
	private String mini_subject;
	private String content;
	private BigDecimal reward_rate;
	private Integer views;
	private Integer replies;
	private Integer author_id;
	private String author_name;
	private String create_datetime;
	private String update_datetime;
	private Integer collect_num;
	private Integer support_num;
	private Integer oppose_num;
	private String url;
	
	public void setId(Long id){
		set(column_id, id);
	}
	public Long getId() {
		return get(column_id);
	}
	public void setSubject(String subject){
		set(column_subject, subject);
	}
	public String getSubject() {
		return get(column_subject);
	}
	public void setMini_subject(String mini_subject){
		set(column_mini_subject, mini_subject);
	}
	public String getMini_subject() {
		return get(column_mini_subject);
	}
	public void setContent(String content){
		set(column_content, content);
	}
	public String getContent() {
		return get(column_content);
	}
	public void setReward_rate(BigDecimal reward_rate){
		set(column_reward_rate, reward_rate);
	}
	public BigDecimal getReward_rate() {
		return get(column_reward_rate);
	}
	public void setViews(Integer views){
		set(column_views, views);
	}
	public Integer getViews() {
		return get(column_views);
	}
	public void setReplies(Integer replies){
		set(column_replies, replies);
	}
	public Integer getReplies() {
		return get(column_replies);
	}
	public void setAuthor_id(Integer author_id){
		set(column_author_id, author_id);
	}
	public Integer getAuthor_id() {
		return get(column_author_id);
	}
	public void setAuthor_name(String author_name){
		set(column_author_name, author_name);
	}
	public String getAuthor_name() {
		return get(column_author_name);
	}
	public void setCreate_datetime(String create_datetime){
		set(column_create_datetime, create_datetime);
	}
	public String getCreate_datetime() {
		return get(column_create_datetime);
	}
	public void setUpdate_datetime(String update_datetime){
		set(column_update_datetime, update_datetime);
	}
	public String getUpdate_datetime() {
		return get(column_update_datetime);
	}
	public void setCollect_num(Integer collect_num){
		set(column_collect_num, collect_num);
	}
	public Integer getCollect_num() {
		return get(column_collect_num);
	}
	public void setSupport_num(Integer support_num){
		set(column_support_num, support_num);
	}
	public Integer getSupport_num() {
		return get(column_support_num);
	}
	public void setOppose_num(Integer oppose_num){
		set(column_oppose_num, oppose_num);
	}
	public Integer getOppose_num() {
		return get(column_oppose_num);
	}
	public void setUrl(String url){
		set(column_url, url);
	}
	public String getUrl() {
		return get(column_url);
	}
	
}
