package com.platform.mvc.indexForum;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = IndexForum.table_name,pkName = "id")
public class IndexForum extends BaseModel<IndexForum> {

	private static final long serialVersionUID = 4433600927099312344L;

	public static final IndexForum dao = new IndexForum();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_index_forum";
	/**
	 * 分页SQL
	 */
	public static final String sqlId_splitPageFrom = "platform.indexForum.splitPageFrom";
	
	
	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setDisplayOrder(java.lang.Integer displayOrder) {
		set("display_order", displayOrder);
	}

	public java.lang.Integer getDisplayOrder() {
		return get("display_order");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setFid(java.lang.Integer fid) {
		set("fid", fid);
	}

	public java.lang.Integer getFid() {
		return get("fid");
	}

	public void setArticleNum(java.lang.Integer articleNum) {
		set("article_num", articleNum);
	}

	public java.lang.Integer getArticleNum() {
		return get("article_num");
	}

	
}
