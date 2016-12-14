package com.platform.mvc.forum;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.partner.Partner;

/**
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("unused")
@Table(tableName = ForumForum.table_name, pkName = "fid")
public class ForumForum extends BaseModel<ForumForum> {

	private static final long serialVersionUID = 3351601442175143111L;

	private static Logger log = Logger.getLogger(ForumForum.class);
	
	public static final ForumForum dao = new ForumForum();
	//50个字段
	
	/**
	 * 表名称
	 */
	public static final String table_name = "pre_forum_forum";
	
	/**
	 * 字段描述：fid
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_fid = "fid"; 
	
	/**
	 * 字段描述：tid
	 * 字段类型：mediumint(8)  长度：8
	 */
	public static final String column_fup = "fup"; 
	
	/**
	 * 字段描述： 
	 * 字段类型：  长度：
	 */
	public static final String column_type = "type";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_name = "name";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_status = "status";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_displayorder = "displayorder";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_styleid = "styleid";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_threads = "threads";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_posts = "posts";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_todayposts = "todayposts";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_yesterdayposts = "yesterdayposts";
	/*********************/
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_rank = "rank";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_oldrank = "oldrank";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_lastpost = "lastpost";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_domain = "domain";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowsmilies = "allowsmilies";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowhtml = "allowhtml";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowbbcode = "allowbbcode";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowimgcode = "allowimgcode";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowmediacode = "allowmediacode";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowanonymous = "allowanonymous";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowpostspecial = "allowpostspecial";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowspecialonly = "allowspecialonly";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowappend = "allowappend";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_alloweditrules = "alloweditrules";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowfeed = "allowfeed";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowside = "allowside";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_recyclebin = "recyclebin";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_modnewposts = "modnewposts";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_jammer = "jammer";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_disablewatermark = "disablewatermark";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_inheritedmod = "inheritedmod";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_autoclose = "autoclose";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_forumcolumns = "forumcolumns";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_catforumcolumns = "catforumcolumns";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_threadcaches = "threadcaches";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_alloweditpost = "alloweditpost";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_simple = "simple";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_modworks = "modworks";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_allowglobalstick = "allowglobalstick";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_level = "level";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_commoncredits = "commoncredits";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_archive = "archive";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_recommend = "recommend";
	
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
	public static final String column_disablethumb = "disablethumb";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_disablecollect = "disablecollect";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：
	 */
	public static final String column_mobile_display = "mobile_display";
	
	/**
	 * 字段描述：
	 * 字段类型：  长度：platform.forumforum
	 */
	public static final String column_allow_post = "allow_post";
	
	
	private Integer fid;
	private Integer fup;
	private Enum type;// 【类型问题】
	private String name;
	private Integer status;
	private Integer displayorder;
	private Integer styleid;
	private Integer threads;
	private Integer posts;
	private Integer todayposts;
	private Integer yesterdayposts;
	private Integer rank;
	private Integer oldrank;
	private String lastpost;
	private String domain;
	private Integer allowsmilies;
	private Integer allowhtml;
	private Integer allowbbcode;
	private Integer allowimgcode;
	private Integer allowmediacode;
	private Integer allowanonymous;
	private Integer allowpostspecial;
	private Integer allowspecialonly;
	private Integer allowappend;
	private Integer alloweditrules;
	private Integer allowfeed;
	private Integer allowside;
	private Integer recyclebin;
	private Integer modnewposts;
	private Integer jammer;
	private Integer disablewatermark;
	private Integer inheritedmod;
	private Integer autoclose;
	private Integer forumcolumns;
	private Integer catforumcolumns;
	private Integer threadcaches;
	private Integer alloweditpost;
	private Integer simple;
	private Integer modworks;
	private Integer allowglobalstick;
	private Integer level;
	private Integer commoncredits;
	private Integer archive;
	
	private Integer recommend;
	private Integer favtimes;
	private Integer sharetimes;
	private Integer disablethumb;
	
	private Integer disablecollect;
	private String mobile_display;
	private String allow_post;
	
	
	public Integer getFid() {
		return get(column_fid);
	}
	public void setFid(Integer fid) {
		set(column_fid, fid);
	}
	public Integer getFup() {
		return get(column_fup);
	}
	public void setFup(Integer fup) {
		set(column_fup, fup);
	}
	public Enum getType() {
		return get(column_type);
	}
	public void setType(Enum type) {
		set(column_type, type);
	}
	public String getName() {
		return get(column_name);
	}
	public void setName(String name) {
		set(column_name, name);
	}
	public Integer getStatus() {
		return get(column_status);
	}
	public void setStatus(Integer status) {
		set(column_status, status);
	}
	public Integer getDisplayorder() {
		return get(column_displayorder);
	}
	public void setDisplayorder(Integer displayorder) {
		set(column_displayorder, displayorder);
	}
	public Integer getStyleid() {
		return get(column_styleid);
	}
	public void setStyleid(Integer styleid) {
		set(column_styleid, styleid);
	}
	public Integer getThreads() {
		return get(column_threads);
	}
	public void setThreads(Integer threads) {
		set(column_threads, threads);
	}
	public Integer getPosts() {
		return get(column_posts);
	}
	public void setPosts(Integer posts) {
		set(column_posts, posts);
	}
	public Integer getTodayposts() {
		return get(column_todayposts);
	}
	public void setTodayposts(Integer todayposts) {
		set(column_todayposts, todayposts);
	}
	public Integer getYesterdayposts() {
		return get(column_yesterdayposts);
	}
	public void setYesterdayposts(Integer yesterdayposts) {
		set(column_yesterdayposts, yesterdayposts);
	}
	public Integer getRank() {
		return get(column_rank);
	}
	public void setRank(Integer rank) {
		set(column_rank, rank);
	}
	public Integer getOldrank() {
		return get(column_oldrank);
	}
	public void setOldrank(Integer oldrank) {
		set(column_oldrank, oldrank);
	}
	public String getLastpost() {
		return get(column_lastpost);
	}
	public void setLastpost(String lastpost) {
		set(column_lastpost, lastpost);
	}
	public String getDomain() {
		return get(column_domain);
	}
	public void setDomain(String domain) {
		set(column_domain, domain);
	}
	public Integer getAllowsmilies() {
		return get(column_allowsmilies);
	}
	public void setAllowsmilies(Integer allowsmilies) {
		set(column_allowsmilies, allowsmilies);
	}
	public Integer getAllowhtml() {
		return get(column_allowhtml);
	}
	public void setAllowhtml(Integer allowhtml) {
		set(column_allowhtml, allowhtml);
	}
	public Integer getAllowbbcode() {
		return get(column_allowbbcode);
	}
	public void setAllowbbcode(Integer allowbbcode) {
		set(column_allowbbcode, allowbbcode);
	}
	public Integer getAllowimgcode() {
		return get(column_allowimgcode);
	}
	public void setAllowimgcode(Integer allowimgcode) {
		set(column_allowimgcode, allowimgcode);
	}
	public Integer getAllowmediacode() {
		return get(column_allowmediacode);
	}
	public void setAllowmediacode(Integer allowmediacode) {
		set(column_allowmediacode, allowmediacode);
	}
	public Integer getAllowanonymous() {
		return get(column_allowanonymous);
	}
	public void setAllowanonymous(Integer allowanonymous) {
		set(column_allowanonymous, allowanonymous);
	}
	public Integer getAllowpostspecial() {
		return get(column_allowpostspecial);
	}
	public void setAllowpostspecial(Integer allowpostspecial) {
		set(column_allowpostspecial, allowpostspecial);
	}
	public Integer getAllowspecialonly() {
		return get(column_allowspecialonly);
	}
	public void setAllowspecialonly(Integer allowspecialonly) {
		set(column_allowspecialonly, allowspecialonly);
	}
	public Integer getAllowappend() {
		return get(column_allowappend);
	}
	public void setAllowappend(Integer allowappend) {
		set(column_allowappend, allowappend);
	}
	public Integer getAlloweditrules() {
		return get(column_alloweditrules);
	}
	public void setAlloweditrules(Integer alloweditrules) {
		set(column_alloweditrules, alloweditrules);
	}
	public Integer getAllowfeed() {
		return get(column_allowfeed);
	}
	public void setAllowfeed(Integer allowfeed) {
		set(column_allowfeed, allowfeed);
	}
	public Integer getAllowside() {
		return get(column_allowside);
	}
	public void setAllowside(Integer allowside) {
		set(column_allowside, allowside);
	}
	public Integer getRecyclebin() {
		return get(column_recyclebin);
	}
	public void setRecyclebin(Integer recyclebin) {
		set(column_recyclebin, recyclebin);
	}
	public Integer getModnewposts() {
		return get(column_modnewposts);
	}
	public void setModnewposts(Integer modnewposts) {
		set(column_modnewposts, modnewposts);
	}
	public Integer getJammer() {
		return get(column_jammer);
	}
	public void setJammer(Integer jammer) {
		set(column_jammer, jammer);
	}
	public Integer getDisablewatermark() {
		return get(column_disablewatermark);
	}
	public void setDisablewatermark(Integer disablewatermark) {
		set(column_disablewatermark, disablewatermark);
	}
	public Integer getInheritedmod() {
		return get(column_inheritedmod);
	}
	public void setInheritedmod(Integer inheritedmod) {
		set(column_inheritedmod, inheritedmod);
	}
	public Integer getAutoclose() {
		return get(column_autoclose);
	}
	public void setAutoclose(Integer autoclose) {
		set(column_autoclose, autoclose);
	}
	public Integer getForumcolumns() {
		return get(column_forumcolumns);
	}
	public void setForumcolumns(Integer forumcolumns) {
		set(column_forumcolumns, forumcolumns);
	}
	public Integer getCatforumcolumns() {
		return get(column_catforumcolumns);
	}
	public void setCatforumcolumns(Integer catforumcolumns) {
		set(column_catforumcolumns, catforumcolumns);
	}
	public Integer getThreadcaches() {
		return get(column_threadcaches);
	}
	public void setThreadcaches(Integer threadcaches) {
		set(column_threadcaches, threadcaches);
	}
	public Integer getAlloweditpost() {
		return get(column_alloweditpost);
	}
	public void setAlloweditpost(Integer alloweditpost) {
		set(column_alloweditpost, alloweditpost);
	}
	public Integer getSimple() {
		return get(column_simple);
	}
	public void setSimple(Integer simple) {
		set(column_simple, simple);
	}
	public Integer getModworks() {
		return get(column_modworks);
	}
	public void setModworks(Integer modworks) {
		set(column_modworks, modworks);
	}
	public Integer getAllowglobalstick() {
		return get(column_allowglobalstick);
	}
	public void setAllowglobalstick(Integer allowglobalstick) {
		set(column_allowglobalstick, allowglobalstick);
	}
	public Integer getLevel() {
		return get(column_level);
	}
	public void setLevel(Integer level) {
		set(column_level, level);
	}
	public Integer getCommoncredits() {
		return get(column_commoncredits);
	}
	public void setCommoncredits(Integer commoncredits) {
		set(column_commoncredits, commoncredits);
	}
	public Integer getArchive() {
		return get(column_archive);
	}
	public void setArchive(Integer archive) {
		set(column_archive, archive);
	}
	public Integer getRecommend() {
		return get(column_recommend);
	}
	public void setRecommend(Integer recommend) {
		set(column_recommend, recommend);
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
	public Integer getDisablethumb() {
		return get(column_disablethumb);
	}
	public void setDisablethumb(Integer disablethumb) {
		set(column_disablethumb, disablethumb);
	}
	public Integer getDisablecollect() {
		return get(column_disablecollect);
	}
	public void setDisablecollect(Integer disablecollect) {
		set(column_disablecollect, disablecollect);
	}
	public String getMobile_display() {
		return get(column_mobile_display);
	}
	public void setMobile_display(String mobile_display) {
		set(column_mobile_display, mobile_display);
	}
	public String getAllow_post() {
		return get(column_allow_post);
	}
	public void setAllow_post(String allow_post) {
		set(column_allow_post, allow_post);
	}
	
	


}
