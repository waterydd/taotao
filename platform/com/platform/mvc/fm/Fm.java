package com.platform.mvc.fm;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

/**
 *  model
 * @author Administrator
 */
@SuppressWarnings("unused")
@Table(tableName = Fm.table_name, pkName = "id")
public class Fm extends BaseModel<Fm> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Fm.class);
	
	public static final Fm dao = new Fm();

	/**
	 * 表名称
	 */
	public static final String table_name = "pre_fm";
	
	
	/**
	 * sqlId : platform.Fm.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.fm.splitPageFrom";

	public void setId(java.lang.String id) {
		set("id", id);
	}

	public java.lang.String getId() {
		return get("id");
	}

	public void setSubject(java.lang.String subject) {
		set("subject", subject);
	}

	public java.lang.String getSubject() {
		return get("subject");
	}

	public void setImgUrl(java.lang.String imgUrl) {
		set("img_url", imgUrl);
	}

	public java.lang.String getImgUrl() {
		return get("img_url");
	}

	public void setViews(java.lang.Integer views) {
		set("views", views);
	}

	public java.lang.Integer getViews() {
		return get("views");
	}

	public void setCollectNum(java.lang.Integer collectNum) {
		set("collect_num", collectNum);
	}

	public java.lang.Integer getCollectNum() {
		return get("collect_num");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
	}

	public void setRecordUrl(java.lang.String recordUrl) {
		set("record_url", recordUrl);
	}

	public java.lang.String getRecordUrl() {
		return get("record_url");
	}

	public void setCreateDatetime(java.lang.String createDatetime) {
		set("create_datetime", createDatetime);
	}

	public java.lang.String getCreateDatetime() {
		return get("create_datetime");
	}

	public void setAuthorId(java.lang.Integer authorId) {
		set("author_id", authorId);
	}

	public java.lang.Integer getAuthorId() {
		return get("author_id");
	}

	public void setAuthorName(java.lang.String authorName) {
		set("author_name", authorName);
	}

	public java.lang.String getAuthorName() {
		return get("author_name");
	}

	public void setRewardNum(java.lang.Integer rewardNum) {
		set("reward_num", rewardNum);
	}

	public java.lang.Integer getRewardNum() {
		return get("reward_num");
	}

	public void setRewardAmount(java.math.BigDecimal rewardAmount) {
		set("reward_amount", rewardAmount);
	}

	public java.math.BigDecimal getRewardAmount() {
		return get("reward_amount");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setPrice(java.math.BigDecimal price) {
		set("price", price);
	}

	public java.math.BigDecimal getPrice() {
		return get("price");
	}

	public void setPayAmountType(java.lang.String payAmountType) {
		set("pay_amount_type", payAmountType);
	}

	public java.lang.String getPayAmountType() {
		return get("pay_amount_type");
	}

	public void setSourceFileName(java.lang.String sourceFileName) {
		set("source_file_name", sourceFileName);
	}

	public java.lang.String getSourceFileName() {
		return get("source_file_name");
	}
	
	
}
