package com.platform.mvc.indexArticle;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@Table(tableName = IndexArticle.table_name,pkName = "id")
public class IndexArticle extends BaseModel<IndexArticle> {

	private static final long serialVersionUID = 4433600927099312344L;

	public static final IndexArticle dao = new IndexArticle();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_index_article";
	/**
	 * 分页SQL
	 */
	public static final String sqlId_splitPageFrom = "platform.indexArticle.splitPageFrom";
	
	
	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setFid(java.lang.Integer fid) {
		set("fid", fid);
	}

	public java.lang.Integer getFid() {
		return get("fid");
	}

	public void setForumName(java.lang.String forumName) {
		set("forum_name", forumName);
	}

	public java.lang.String getForumName() {
		return get("forum_name");
	}

	public void setSubject(java.lang.String subject) {
		set("subject", subject);
	}

	public java.lang.String getSubject() {
		return get("subject");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
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

	public void setCreateDatetime(java.lang.String createDatetime) {
		set("create_datetime", createDatetime);
	}

	public java.lang.String getCreateDatetime() {
		return get("create_datetime");
	}

	public void setArticleId(java.lang.String articleId) {
		set("article_id", articleId);
	}

	public java.lang.String getArticleId() {
		return get("article_id");
	}

	public void setRewardAmount(java.math.BigDecimal rewardAmount) {
		set("reward_amount", rewardAmount);
	}

	public java.math.BigDecimal getRewardAmount() {
		return get("reward_amount");
	}

	public void setMiniSubject(java.lang.String miniSubject) {
		set("mini_subject", miniSubject);
	}

	public java.lang.String getMiniSubject() {
		return get("mini_subject");
	}

	public void setImgUrl(java.lang.String imgUrl) {
		set("img_url", imgUrl);
	}

	public java.lang.String getImgUrl() {
		return get("img_url");
	}

	public void setRewardRate(java.lang.String rewardRate) {
		set("reward_rate", rewardRate);
	}

	public java.lang.String getRewardRate() {
		return get("reward_rate");
	}

	public void setExtData(java.lang.String extData) {
		set("ext_data", extData);
	}

	public java.lang.String getExtData() {
		return get("ext_data");
	}

	public void setUpdateDatetime(java.lang.String updateDatetime) {
		set("update_datetime", updateDatetime);
	}

	public java.lang.String getUpdateDatetime() {
		return get("update_datetime");
	}

	public void setDisplayOrder(java.lang.Integer displayOrder) {
		set("display_order", displayOrder);
	}

	public java.lang.Integer getDisplayOrder() {
		return get("display_order");
	}

	public void setRewardCurrency(java.lang.String rewardCurrency) {
		set("reward_currency", rewardCurrency);
	}

	public java.lang.String getRewardCurrency() {
		return get("reward_currency");
	}

	public void setAdUrl(java.lang.String adUrl) {
		set("ad_url", adUrl);
	}

	public java.lang.String getAdUrl() {
		return get("ad_url");
	}

	public void setForumId(java.lang.Integer forumId) {
		set("forum_id", forumId);
	}

	public java.lang.Integer getForumId() {
		return get("forum_id");
	}

	public void setArticleCreateDatetime(java.lang.String articleCreateDatetime) {
		set("article_create_datetime", articleCreateDatetime);
	}

	public java.lang.String getArticleCreateDatetime() {
		return get("article_create_datetime");
	}

	public void setPid(java.lang.String pid) {
		set("pid", pid);
	}

	public java.lang.String getPid() {
		return get("pid");
	}

	public void setFavoriteNum(java.lang.Integer favoriteNum) {
		set("favorite_num", favoriteNum);
	}

	public java.lang.Integer getFavoriteNum() {
		return get("favorite_num");
	}

	public void setFmUrl(java.lang.String fmUrl) {
		set("fm_url", fmUrl);
	}

	public java.lang.String getFmUrl() {
		return get("fm_url");
	}

	public void setQuestionStatus(java.lang.String questionStatus) {
		set("question_status", questionStatus);
	}

	public java.lang.String getQuestionStatus() {
		return get("question_status");
	}
	
}