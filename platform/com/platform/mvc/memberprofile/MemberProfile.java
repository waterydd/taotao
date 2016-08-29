package com.platform.mvc.memberprofile;

import com.platform.annotation.Table;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModel;


import org.apache.log4j.Logger;

/**
 *  model
 * @author mango  dongcb678@163.com
 */
@SuppressWarnings("unused")
@Table(tableName = MemberProfile.table_name, pkName = "uid")
public class MemberProfile extends BaseModel<MemberProfile> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(MemberProfile.class);
	
	public static final MemberProfile dao = new MemberProfile();

	/**
	 * 表名称
	 */
	public static final String table_name = "pre_common_member_profile";
	
	/**
	 * 字段描述： 
	 * 字段类型：mediumint(8) unsigned  长度：null
	 */
	public static final String column_uid = "uid";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_realname = "realname";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(1)  长度：null
	 */
	public static final String column_gender = "gender";
	
	/**
	 * 字段描述： 
	 * 字段类型：smallint(6) unsigned  长度：null
	 */
	public static final String column_birthyear = "birthyear";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(3) unsigned  长度：null
	 */
	public static final String column_birthmonth = "birthmonth";
	
	/**
	 * 字段描述： 
	 * 字段类型：tinyint(3) unsigned  长度：null
	 */
	public static final String column_birthday = "birthday";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_constellation = "constellation";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_zodiac = "zodiac";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_telephone = "telephone";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_mobile = "mobile";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_idcardtype = "idcardtype";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_idcard = "idcard";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_address = "address";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_zipcode = "zipcode";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_nationality = "nationality";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_birthprovince = "birthprovince";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_birthcity = "birthcity";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(20)  长度：20
	 */
	public static final String column_birthdist = "birthdist";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_birthcommunity = "birthcommunity";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_resideprovince = "resideprovince";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_residecity = "residecity";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(20)  长度：20
	 */
	public static final String column_residedist = "residedist";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_residecommunity = "residecommunity";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_residesuite = "residesuite";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_graduateschool = "graduateschool";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_company = "company";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_education = "education";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_occupation = "occupation";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_position = "position";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_revenue = "revenue";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_affectivestatus = "affectivestatus";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_lookingfor = "lookingfor";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_bloodtype = "bloodtype";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_height = "height";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_weight = "weight";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_alipay = "alipay";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_icq = "icq";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_qq = "qq";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_yahoo = "yahoo";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_msn = "msn";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_taobao = "taobao";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(255)  长度：255
	 */
	public static final String column_site = "site";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_bio = "bio";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_interest = "interest";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_field1 = "field1";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_field2 = "field2";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_field3 = "field3";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_field4 = "field4";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_field5 = "field5";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_field6 = "field6";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_field7 = "field7";
	
	/**
	 * 字段描述： 
	 * 字段类型：text  长度：65535
	 */
	public static final String column_field8 = "field8";
	
	
	/**
	 * sqlId : platform.memberProfile.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.memberProfile.splitPageFrom";
	/**
	 * 通过手机号查询用户信息
	 */
	public static final String sqlId_queryByPhone =  "platform.memberProfile.queryByPhone";

	private Integer uid;
	private String realname;
	private Boolean gender;
	private Integer birthyear;
	private Integer birthmonth;
	private Integer birthday;
	private String constellation;
	private String zodiac;
	private String telephone;
	private String mobile;
	private String idcardtype;
	private String idcard;
	private String address;
	private String zipcode;
	private String nationality;
	private String birthprovince;
	private String birthcity;
	private String birthdist;
	private String birthcommunity;
	private String resideprovince;
	private String residecity;
	private String residedist;
	private String residecommunity;
	private String residesuite;
	private String graduateschool;
	private String company;
	private String education;
	private String occupation;
	private String position;
	private String revenue;
	private String affectivestatus;
	private String lookingfor;
	private String bloodtype;
	private String height;
	private String weight;
	private String alipay;
	private String icq;
	private String qq;
	private String yahoo;
	private String msn;
	private String taobao;
	private String site;
	private String bio;
	private String interest;
	private String field1;
	private String field2;
	private String field3;
	private String field4;
	private String field5;
	private String field6;
	private String field7;
	private String field8;
	
	public void setUid(Integer uid){
		set(column_uid, uid);
	}
	public Integer getUid() {
		return get(column_uid);
	}
	public void setRealname(String realname){
		set(column_realname, realname);
	}
	public String getRealname() {
		return get(column_realname);
	}
	public void setGender(Boolean gender){
		set(column_gender, gender);
	}
	public Boolean getGender() {
		return get(column_gender);
	}
	public void setBirthyear(Integer birthyear){
		set(column_birthyear, birthyear);
	}
	public Integer getBirthyear() {
		return get(column_birthyear);
	}
	public void setBirthmonth(Integer birthmonth){
		set(column_birthmonth, birthmonth);
	}
	public Integer getBirthmonth() {
		return get(column_birthmonth);
	}
	public void setBirthday(Integer birthday){
		set(column_birthday, birthday);
	}
	public Integer getBirthday() {
		return get(column_birthday);
	}
	public void setConstellation(String constellation){
		set(column_constellation, constellation);
	}
	public String getConstellation() {
		return get(column_constellation);
	}
	public void setZodiac(String zodiac){
		set(column_zodiac, zodiac);
	}
	public String getZodiac() {
		return get(column_zodiac);
	}
	public void setTelephone(String telephone){
		set(column_telephone, telephone);
	}
	public String getTelephone() {
		return get(column_telephone);
	}
	public void setMobile(String mobile){
		set(column_mobile, mobile);
	}
	public String getMobile() {
		return get(column_mobile);
	}
	public void setIdcardtype(String idcardtype){
		set(column_idcardtype, idcardtype);
	}
	public String getIdcardtype() {
		return get(column_idcardtype);
	}
	public void setIdcard(String idcard){
		set(column_idcard, idcard);
	}
	public String getIdcard() {
		return get(column_idcard);
	}
	public void setAddress(String address){
		set(column_address, address);
	}
	public String getAddress() {
		return get(column_address);
	}
	public void setZipcode(String zipcode){
		set(column_zipcode, zipcode);
	}
	public String getZipcode() {
		return get(column_zipcode);
	}
	public void setNationality(String nationality){
		set(column_nationality, nationality);
	}
	public String getNationality() {
		return get(column_nationality);
	}
	public void setBirthprovince(String birthprovince){
		set(column_birthprovince, birthprovince);
	}
	public String getBirthprovince() {
		return get(column_birthprovince);
	}
	public void setBirthcity(String birthcity){
		set(column_birthcity, birthcity);
	}
	public String getBirthcity() {
		return get(column_birthcity);
	}
	public void setBirthdist(String birthdist){
		set(column_birthdist, birthdist);
	}
	public String getBirthdist() {
		return get(column_birthdist);
	}
	public void setBirthcommunity(String birthcommunity){
		set(column_birthcommunity, birthcommunity);
	}
	public String getBirthcommunity() {
		return get(column_birthcommunity);
	}
	public void setResideprovince(String resideprovince){
		set(column_resideprovince, resideprovince);
	}
	public String getResideprovince() {
		return get(column_resideprovince);
	}
	public void setResidecity(String residecity){
		set(column_residecity, residecity);
	}
	public String getResidecity() {
		return get(column_residecity);
	}
	public void setResidedist(String residedist){
		set(column_residedist, residedist);
	}
	public String getResidedist() {
		return get(column_residedist);
	}
	public void setResidecommunity(String residecommunity){
		set(column_residecommunity, residecommunity);
	}
	public String getResidecommunity() {
		return get(column_residecommunity);
	}
	public void setResidesuite(String residesuite){
		set(column_residesuite, residesuite);
	}
	public String getResidesuite() {
		return get(column_residesuite);
	}
	public void setGraduateschool(String graduateschool){
		set(column_graduateschool, graduateschool);
	}
	public String getGraduateschool() {
		return get(column_graduateschool);
	}
	public void setCompany(String company){
		set(column_company, company);
	}
	public String getCompany() {
		return get(column_company);
	}
	public void setEducation(String education){
		set(column_education, education);
	}
	public String getEducation() {
		return get(column_education);
	}
	public void setOccupation(String occupation){
		set(column_occupation, occupation);
	}
	public String getOccupation() {
		return get(column_occupation);
	}
	public void setPosition(String position){
		set(column_position, position);
	}
	public String getPosition() {
		return get(column_position);
	}
	public void setRevenue(String revenue){
		set(column_revenue, revenue);
	}
	public String getRevenue() {
		return get(column_revenue);
	}
	public void setAffectivestatus(String affectivestatus){
		set(column_affectivestatus, affectivestatus);
	}
	public String getAffectivestatus() {
		return get(column_affectivestatus);
	}
	public void setLookingfor(String lookingfor){
		set(column_lookingfor, lookingfor);
	}
	public String getLookingfor() {
		return get(column_lookingfor);
	}
	public void setBloodtype(String bloodtype){
		set(column_bloodtype, bloodtype);
	}
	public String getBloodtype() {
		return get(column_bloodtype);
	}
	public void setHeight(String height){
		set(column_height, height);
	}
	public String getHeight() {
		return get(column_height);
	}
	public void setWeight(String weight){
		set(column_weight, weight);
	}
	public String getWeight() {
		return get(column_weight);
	}
	public void setAlipay(String alipay){
		set(column_alipay, alipay);
	}
	public String getAlipay() {
		return get(column_alipay);
	}
	public void setIcq(String icq){
		set(column_icq, icq);
	}
	public String getIcq() {
		return get(column_icq);
	}
	public void setQq(String qq){
		set(column_qq, qq);
	}
	public String getQq() {
		return get(column_qq);
	}
	public void setYahoo(String yahoo){
		set(column_yahoo, yahoo);
	}
	public String getYahoo() {
		return get(column_yahoo);
	}
	public void setMsn(String msn){
		set(column_msn, msn);
	}
	public String getMsn() {
		return get(column_msn);
	}
	public void setTaobao(String taobao){
		set(column_taobao, taobao);
	}
	public String getTaobao() {
		return get(column_taobao);
	}
	public void setSite(String site){
		set(column_site, site);
	}
	public String getSite() {
		return get(column_site);
	}
	public void setBio(String bio){
		set(column_bio, bio);
	}
	public String getBio() {
		return get(column_bio);
	}
	public void setInterest(String interest){
		set(column_interest, interest);
	}
	public String getInterest() {
		return get(column_interest);
	}
	public void setField1(String field1){
		set(column_field1, field1);
	}
	public String getField1() {
		return get(column_field1);
	}
	public void setField2(String field2){
		set(column_field2, field2);
	}
	public String getField2() {
		return get(column_field2);
	}
	public void setField3(String field3){
		set(column_field3, field3);
	}
	public String getField3() {
		return get(column_field3);
	}
	public void setField4(String field4){
		set(column_field4, field4);
	}
	public String getField4() {
		return get(column_field4);
	}
	public void setField5(String field5){
		set(column_field5, field5);
	}
	public String getField5() {
		return get(column_field5);
	}
	public void setField6(String field6){
		set(column_field6, field6);
	}
	public String getField6() {
		return get(column_field6);
	}
	public void setField7(String field7){
		set(column_field7, field7);
	}
	public String getField7() {
		return get(column_field7);
	}
	public void setField8(String field8){
		set(column_field8, field8);
	}
	public String getField8() {
		return get(column_field8);
	}
	
}
