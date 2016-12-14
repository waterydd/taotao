package com.platform.mvc.forum;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.partner.Partner;
/**
 * model
 * @author Administrator
 *
 */
@SuppressWarnings("unused")
@Table(tableName = ForumThread.table_name, pkName = "tid")
public class ForumThread extends BaseModel<ForumThread> {

	private static final long serialVersionUID = 630238972192175307L;

	private static Logger log = Logger.getLogger(ForumThread.class);
	
	public static final ForumThread dao = new ForumThread();
	//42个字段
	
	/**
	 * 表名称
	 */
	public static final String table_name = "pre_forum_thread";
	
	/**
	 * 字段描述：tid
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_tid = "tid";  
	
	/**
	 * 字段描述：fid
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_fid = "fid"; 
	
	/**
	 * 字段描述： 
	 * 字段类型：  长度：
	 */
	public static final String column_posttableid = "posttableid";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_typeid = "typeid";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_sortid = "sortid";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_readperm = "readperm";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_price = "price";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_author = "author";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_authorid = "authorid";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_subject = "subject";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_dateline = "dateline";
	/*********************/
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_lastpost = "lastpost";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_lastposter = "lastposter";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_views = "views";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_replies = "replies";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_displayorder = "displayorder";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_highlight = "highlight";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_digest = "digest";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_rate = "rate";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_special = "special";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_attachment = "attachment";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_moderated = "moderated";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_closed = "closed";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_stickreply = "stickreply";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_recommends = "recommends";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_recommend_add = "recommend_add";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_recommend_sub = "recommend_sub";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_heats = "heats";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_status = "status";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_isgroup = "isgroup";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_favtimes = "favtimes";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_sharetimes = "sharetimes";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_stamp = "stamp";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_icon = "icon";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_pushedaid = "pushedaid";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_cover = "cover";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_replycredit = "replycredit";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_relatebytag = "relatebytag";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_maxposition = "maxposition";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_bgcolor = "bgcolor";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_comments = "comments";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_hidden = "hidden";
	
	
	/**
	 * sqlId : platform.forumThread.splitFindInfo
	 * 描述：查询标题信息是否存在的sql
	 */
	public static final String sqlId_splitFindInfo = "platform.forumThread.splitFindInfo";
	
	
	private Integer tid;
	private Integer fid;
	private Integer posttableid;
	private Integer typeid;
	private Integer sortid;
	private Integer readperm;
	private Integer price;
	private String author;
	private Integer authorid;
	private String subject;
	private Integer lastpost;
	private String lastposter;
//	private Integer views;
//	private Integer dateline;
	private Long views;
	private Long dateline;
	
	private Integer replies;
	private Integer displayorder;
	private Integer highlight;
	private Integer digest;
	private Integer rate;
	private Integer special;
	private Integer attachment;
	private Integer moderated;
	private Integer closed;
	
	private Integer stickreply;
	private Integer recommends;
	private Integer recommend_add;
	private Integer recommend_sub;
	private Integer heats;
	private Integer status;
	private Integer isgroup;
	private Integer favtimes;
	private Integer sharetimes;
	private Integer stamp;
	private Integer icon;
	private Integer pushedaid;
	private Integer cover;
	private Integer replycredit;
	private String relatebytag;
	private Integer maxposition;
	private String bgcolor;
	private Integer comments;
	private Integer hidden;
	
	
	public Integer getTid() {
		return get(column_tid);
	}
	public void setTid(Integer tid) {
		set(column_tid, tid);
	}
	public Integer getFid() {
		return get(column_fid);
	}
	public void setFid(Integer fid) {
		set(column_fid, fid);
	}
	public Integer getPosttableid() {
		return get(column_posttableid);
	}
	public void setPosttableid(Integer posttableid) {
		set(column_posttableid, posttableid);
	}
	public Integer getTypeid() {
		return get(column_typeid);
	}
	public void setTypeid(Integer typeid) {
		set(column_typeid, typeid);
	}
	public Integer getSortid() {
		return get(column_sortid);
	}
	public void setSortid(Integer sortid) {
		set(column_sortid, sortid);
	}
	public Integer getReadperm() {
		return get(column_readperm);
	}
	public void setReadperm(Integer readperm) {
		set(column_readperm, readperm);
	}
	public Integer getPrice() {
		return get(column_price);
	}
	public void setPrice(Integer price) {
		set(column_price, price);
	}
	public String getAuthor() {
		return get(column_author);
	}
	public void setAuthor(String author) {
		set(column_author, author);
	}
	public Integer getAuthorid() {
		return get(column_authorid);
	}
	public void setAuthorid(Integer authorid) {
		set(column_authorid, authorid);
	}
	public String getSubject() {
		return get(column_subject);
	}
	public void setSubject(String subject) {
		set(column_subject, subject);
	}

	public Integer getLastpost() {
		return get(column_lastpost);
	}
	public void setLastpost(Integer lastpost) {
		set(column_lastpost, lastpost);
	}
	public String getLastposter() {
		return get(column_lastposter);
	}
	public void setLastposter(String lastposter) {
		set(column_lastposter, lastposter);
	}

	public Integer getReplies() {
		return get(column_replies);
	}
	public void setReplies(Integer replies) {
		set(column_replies, replies);
	}
	public Integer getDisplayorder() {
		return get(column_displayorder);
	}
	public void setDisplayorder(Integer displayorder) {
		set(column_displayorder, displayorder);
	}
	public Integer getHighlight() {
		return get(column_highlight);
	}
	public void setHighlight(Integer highlight) {
		set(column_highlight, highlight);
	}
	public Integer getDigest() {
		return get(column_digest);
	}
	public void setDigest(Integer digest) {
		set(column_digest, digest);
	}
	public Integer getRate() {
		return get(column_rate);
	}
	public void setRate(Integer rate) {
		set(column_rate, rate);
	}
	public Integer getSpecial() {
		return get(column_special);
	}
	public void setSpecial(Integer special) {
		set(column_special, special);
	}
	public Integer getAttachment() {
		return get(column_attachment);
	}
	public void setAttachment(Integer attachment) {
		set(column_attachment, attachment);
	}
	public Integer getModerated() {
		return get(column_moderated);
	}
	public void setModerated(Integer moderated) {
		set(column_moderated, moderated);
	}
	public Integer getClosed() {
		return get(column_closed);
	}
	public void setClosed(Integer closed) {
		set(column_closed, closed);
	}
	public Integer getStickreply() {
		return get(column_stickreply);
	}
	public void setStickreply(Integer stickreply) {
		set(column_stickreply, stickreply);
	}
	public Integer getRecommends() {
		return get(column_recommends);
	}
	public void setRecommends(Integer recommends) {
		set(column_recommends, recommends);
	}
	public Integer getRecommend_add() {
		return get(column_recommend_add);
	}
	public void setRecommend_add(Integer recommend_add) {
		set(column_recommend_add, recommend_add);
	}
	public Integer getRecommend_sub() {
		return get(column_recommend_sub);
	}
	public void setRecommend_sub(Integer recommend_sub) {
		set(column_recommend_sub, recommend_sub);
	}
	public Integer getHeats() {
		return get(column_heats);
	}
	public void setHeats(Integer heats) {
		set(column_heats, heats);
	}
	public Integer getStatus() {
		return get(column_status);
	}
	public void setStatus(Integer status) {
		set(column_status, status);
	}
	public Integer getIsgroup() {
		return get(column_isgroup);
	}
	public void setIsgroup(Integer isgroup) {
		set(column_isgroup, isgroup);
	}
	public Integer getFavtimes() {
		return get(column_favtimes);
	}
	public void setFavtimes(Integer favtimes) {
		set(column_favtimes, favtimes);
	}
	public Integer getSharetimes() {
		return get(column_sharetimes);
	}
	public void setSharetimes(Integer sharetimes) {
		set(column_sharetimes, sharetimes);
	}
	public Integer getStamp() {
		return get(column_stamp);
	}
	public void setStamp(Integer stamp) {
		set(column_stamp, stamp);
	}
	public Integer getIcon() {
		return get(column_icon);
	}
	public void setIcon(Integer icon) {
		set(column_icon, icon);
	}
	public Integer getPushedaid() {
		return get(column_pushedaid);
	}
	public void setPushedaid(Integer pushedaid) {
		set(column_pushedaid, pushedaid);
	}
	public Integer getCover() {
		return get(column_cover);
	}
	public void setCover(Integer cover) {
		set(column_cover, cover);
	}
	public Integer getReplycredit() {
		return get(column_replycredit);
	}
	public void setReplycredit(Integer replycredit) {
		set(column_replycredit, replycredit);
	}
	public String getRelatebytag() {
		return get(column_relatebytag);
	}
	public void setRelatebytag(String relatebytag) {
		set(column_relatebytag, relatebytag);
	}
	public Integer getMaxposition() {
		return get(column_maxposition);
	}
	public void setMaxposition(Integer maxposition) {
		set(column_maxposition, maxposition);
	}
	public String getBgcolor() {
		return get(column_bgcolor);
	}
	public void setBgcolor(String bgcolor) {
		set(column_bgcolor, bgcolor);
	}
	public Integer getComments() {
		return get(column_comments);
	}
	public void setComments(Integer comments) {
		set(column_comments, comments);
	}
	public Integer getHidden() {
		return get(column_hidden);
	}
	public void setHidden(Integer hidden) {
		set(column_hidden, hidden);
	}

	
//	public Integer getViews() {
//		return get(column_views);
//	}
//	public void setViews(Integer views) {
//		set(column_views, views);
//	}
//	public Integer getDateline() {
//		return get(column_dateline);
//	}
//	public void setDateline(Integer dateline) {
//		set(column_dateline, dateline);
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
