package com.platform.mvc.question;

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
@Table(tableName = Question.table_name, pkName = "id")
public class Question extends BaseModel<Question> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Question.class);
	
	public static final Question dao = new Question();

	/**
	 * 表名称
	 */
	public static final String table_name = "pre_question";
	
	
	/**
	 * sqlId : platform.question.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.question.splitPageFrom";

	public void setId(java.lang.String id) {
		set("id", id);
	}

	public java.lang.String getId() {
		return get("id");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
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

	public void setAmount(java.math.BigDecimal amount) {
		set("amount", amount);
	}

	public java.math.BigDecimal getAmount() {
		return get("amount");
	}

	public void setAmountType(java.lang.String amountType) {
		set("amount_type", amountType);
	}

	public java.lang.String getAmountType() {
		return get("amount_type");
	}

	public void setCreateDatetime(java.lang.String createDatetime) {
		set("create_datetime", createDatetime);
	}

	public java.lang.String getCreateDatetime() {
		return get("create_datetime");
	}

	public void setLimitDatetime(java.lang.String limitDatetime) {
		set("limit_datetime", limitDatetime);
	}

	public java.lang.String getLimitDatetime() {
		return get("limit_datetime");
	}

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
	}

	public void setAcceptAnswerId(java.lang.Integer acceptAnswerId) {
		set("accept_answer_id", acceptAnswerId);
	}

	public java.lang.Integer getAcceptAnswerId() {
		return get("accept_answer_id");
	}

	public void setAcceptAnswerUsername(java.lang.String acceptAnswerUsername) {
		set("accept_answer_username", acceptAnswerUsername);
	}

	public java.lang.String getAcceptAnswerUsername() {
		return get("accept_answer_username");
	}

	public void setUpdateDatetime(java.lang.String updateDatetime) {
		set("update_datetime", updateDatetime);
	}

	public java.lang.String getUpdateDatetime() {
		return get("update_datetime");
	}

	public void setViews(java.lang.Integer views) {
		set("views", views);
	}

	public java.lang.Integer getViews() {
		return get("views");
	}

	public void setReplies(java.lang.Integer replies) {
		set("replies", replies);
	}

	public java.lang.Integer getReplies() {
		return get("replies");
	}

	public void setAnswerCount(java.lang.Integer answerCount) {
		set("answer_count", answerCount);
	}

	public java.lang.Integer getAnswerCount() {
		return get("answer_count");
	}

	public void setPayOrderNo(java.lang.String payOrderNo) {
		set("pay_order_no", payOrderNo);
	}

	public java.lang.String getPayOrderNo() {
		return get("pay_order_no");
	}

	public void setCollectNum(java.lang.Integer collectNum) {
		set("collect_num", collectNum);
	}

	public java.lang.Integer getCollectNum() {
		return get("collect_num");
	}

	public void setSubject(java.lang.String subject) {
		set("subject", subject);
	}

	public java.lang.String getSubject() {
		return get("subject");
	}

}
