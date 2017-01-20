package com.platform.mvc.members;

import com.platform.annotation.Table;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModel;


import org.apache.log4j.Logger;

/**
 *  model
 * @author mango  dongcb678@163.com
 */
@SuppressWarnings("unused")
@Table(tableName = Members.table_name, pkName = "uid")
public class Members extends BaseModel<Members> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Members.class);
	
	public static final Members dao = new Members();

	/**
	 * 表名称
	 */
	public static final String table_name = "pre_common_member";
	
	/**
	 * 字段描述： 
	 * 字段类型：mediumint(8) unsigned  长度：null
	 */
	public static final String column_uid = "uid";
	
	/**
	 * 字段描述： 
	 * 字段类型：char(40)  长度：40
	 */
	public static final String column_email = "email";
	
	/**
	 * 字段描述： 
	 * 字段类型：char(50)  长度：50
	 */
	public static final String column_username = "username";
	
	/**
	 * 字段描述： 
	 * 字段类型：char(32)  长度：32
	 */
	public static final String column_password = "password";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_status = "status";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_mobilestatus = "mobilestatus";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_emailstatus = "emailstatus";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_avatarstatus = "avatarstatus";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_videophotostatus = "videophotostatus";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_adminid = "adminid";
	
	/**
	 * 字段描述： 
	 * 字段类型：smallint(6) unsigned  长度：null
	 */
	public static final String column_groupid = "groupid";
	
	/**
	 * 字段描述： 
	 * 字段类型：int(10) unsigned  长度：null
	 */
	public static final String column_groupexpiry = "groupexpiry";
	
	/**
	 * 字段描述： 
	 * 字段类型：char(20)  长度：20
	 */
	public static final String column_extgroupids = "extgroupids";
	
	/**
	 * 字段描述： 
	 * 字段类型：int(10) unsigned  长度：null
	 */
	public static final String column_regdate = "regdate";
	
	/**
	 * 字段描述： 
	 * 字段类型：int(10)  长度：null
	 */
	public static final String column_credits = "credits";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_notifysound = "notifysound";
	
	/**
	 * 字段描述： 
	 * 字段类型：char(4)  长度：4
	 */
	public static final String column_timeoffset = "timeoffset";
	
	/**
	 * 字段描述： 
	 * 字段类型：smallint(6) unsigned  长度：null
	 */
	public static final String column_newpm = "newpm";
	
	/**
	 * 字段描述： 
	 * 字段类型：smallint(6) unsigned  长度：null
	 */
	public static final String column_newprompt = "newprompt";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_accessmasks = "accessmasks";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_allowadmincp = "allowadmincp";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_onlyacceptfriendpm = "onlyacceptfriendpm";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1) unsigned  长度：null
	 */
	public static final String column_conisbind = "conisbind";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_freeze = "freeze";
	
	/**
	 * 字段描述： 
	 * 字段类型：char(32)  长度：32
	 */
	public static final String column_map_uid = "map_uid";
	
	
	/**
	 * sqlId : platform.members.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.members.splitPageFrom";

	private Integer uid;
	private String email;
	private String username;
	private String password;
	private Boolean status;
	private Boolean mobilestatus;
	private Boolean emailstatus;
	private Boolean avatarstatus;
	private Boolean videophotostatus;
	private Boolean adminid;
	private Integer groupid;
	private Long groupexpiry;
	private String extgroupids;
	private Long regdate;
	private Integer credits;
	private Boolean notifysound;
	private String timeoffset;
	private Integer newpm;
	private Integer newprompt;
	private Boolean accessmasks;
	private Boolean allowadmincp;
	private Boolean onlyacceptfriendpm;
	private Boolean conisbind;
	private Boolean freeze;
	private String map_uid;
	
	public void setUid(Integer uid){
		set(column_uid, uid);
	}
	public Integer getUid() {
		return get(column_uid);
	}
	public void setEmail(String email){
		set(column_email, email);
	}
	public String getEmail() {
		return get(column_email);
	}
	public void setUsername(String username){
		set(column_username, username);
	}
	public String getUsername() {
		return get(column_username);
	}
	public void setPassword(String password){
		set(column_password, password);
	}
	public String getPassword() {
		return get(column_password);
	}
	public void setStatus(Boolean status){
		set(column_status, status);
	}
	public Boolean getStatus() {
		return get(column_status);
	}
	public void setMobilestatus(Boolean mobilestatus){
		set(column_mobilestatus, mobilestatus);
	}
	public Boolean getMobilestatus() {
		return get(column_mobilestatus);
	}
	public void setEmailstatus(Boolean emailstatus){
		set(column_emailstatus, emailstatus);
	}
	public Boolean getEmailstatus() {
		return get(column_emailstatus);
	}
	public void setAvatarstatus(Boolean avatarstatus){
		set(column_avatarstatus, avatarstatus);
	}
	public Boolean getAvatarstatus() {
		return get(column_avatarstatus);
	}
	public void setVideophotostatus(Boolean videophotostatus){
		set(column_videophotostatus, videophotostatus);
	}
	public Boolean getVideophotostatus() {
		return get(column_videophotostatus);
	}
	public void setAdminid(Boolean adminid){
		set(column_adminid, adminid);
	}
	public Boolean getAdminid() {
		return get(column_adminid);
	}
	public void setGroupid(Integer groupid){
		set(column_groupid, groupid);
	}
	public Integer getGroupid() {
		return get(column_groupid);
	}
	public void setGroupexpiry(Long groupexpiry){
		set(column_groupexpiry, groupexpiry);
	}
	public Long getGroupexpiry() {
		return get(column_groupexpiry);
	}
	public void setExtgroupids(String extgroupids){
		set(column_extgroupids, extgroupids);
	}
	public String getExtgroupids() {
		return get(column_extgroupids);
	}
	public void setRegdate(Long regdate){
		set(column_regdate, regdate);
	}
	public Long getRegdate() {
		return get(column_regdate);
	}
	public void setCredits(Integer credits){
		set(column_credits, credits);
	}
	public Integer getCredits() {
		return get(column_credits);
	}
	public void setNotifysound(Boolean notifysound){
		set(column_notifysound, notifysound);
	}
	public Boolean getNotifysound() {
		return get(column_notifysound);
	}
	public void setTimeoffset(String timeoffset){
		set(column_timeoffset, timeoffset);
	}
	public String getTimeoffset() {
		return get(column_timeoffset);
	}
	public void setNewpm(Integer newpm){
		set(column_newpm, newpm);
	}
	public Integer getNewpm() {
		return get(column_newpm);
	}
	public void setNewprompt(Integer newprompt){
		set(column_newprompt, newprompt);
	}
	public Integer getNewprompt() {
		return get(column_newprompt);
	}
	public void setAccessmasks(Boolean accessmasks){
		set(column_accessmasks, accessmasks);
	}
	public Boolean getAccessmasks() {
		return get(column_accessmasks);
	}
	public void setAllowadmincp(Boolean allowadmincp){
		set(column_allowadmincp, allowadmincp);
	}
	public Boolean getAllowadmincp() {
		return get(column_allowadmincp);
	}
	public void setOnlyacceptfriendpm(Boolean onlyacceptfriendpm){
		set(column_onlyacceptfriendpm, onlyacceptfriendpm);
	}
	public Boolean getOnlyacceptfriendpm() {
		return get(column_onlyacceptfriendpm);
	}
	public void setConisbind(Boolean conisbind){
		set(column_conisbind, conisbind);
	}
	public Boolean getConisbind() {
		return get(column_conisbind);
	}
	public void setFreeze(Boolean freeze){
		set(column_freeze, freeze);
	}
	public Boolean getFreeze() {
		return get(column_freeze);
	}
	public void setMap_uid(String map_uid){
		set(column_map_uid, map_uid);
	}
	public String getMap_uid() {
		return get(column_map_uid);
	}
	
	@Override
	public String toString() {
		return "Members [uid=" + uid + ", email=" + email + ", username="
				+ username + ", password=" + password + ", status=" + status
				+ ", mobilestatus=" + mobilestatus + ", emailstatus="
				+ emailstatus + ", avatarstatus=" + avatarstatus
				+ ", videophotostatus=" + videophotostatus + ", adminid="
				+ adminid + ", groupid=" + groupid + ", groupexpiry="
				+ groupexpiry + ", extgroupids=" + extgroupids + ", regdate="
				+ regdate + ", credits=" + credits + ", notifysound="
				+ notifysound + ", timeoffset=" + timeoffset + ", newpm="
				+ newpm + ", newprompt=" + newprompt + ", accessmasks="
				+ accessmasks + ", allowadmincp=" + allowadmincp
				+ ", onlyacceptfriendpm=" + onlyacceptfriendpm + ", conisbind="
				+ conisbind + ", freeze=" + freeze + ", map_uid=" + map_uid
				+ "]";
	}
	
	
	
}
