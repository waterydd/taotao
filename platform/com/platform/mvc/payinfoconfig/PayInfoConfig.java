package com.platform.mvc.payinfoconfig;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
@Table(tableName = PayInfoConfig.table_name,pkName = "id")
public class PayInfoConfig extends BaseModel<PayInfoConfig> {

	private static final long serialVersionUID = 4781966981122651079L;

	private static Logger log = Logger.getLogger(PayInfoConfig.class);
	
	public static final PayInfoConfig dao = new PayInfoConfig();
	
	/**
	 * 表名
	 */
	public static final String table_name = "pre_eb_pay_info_config";
	
	/**
	 * 字段描述：ID 【不为空 自增长】
	 * 字段类型：mediumint(8)  长度：30
	 */
	public static final String column_id = "id"; 

	/**
	 * 字段描述：名字
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_channel_name = "channel_name";  
	// ***************我是一条分割线***************************
	/**
	 * 字段描述：merchant_id
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_merchant_id = "merchant_id"; 
	
	/**
	 * 字段描述：secret_key
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_secret_key = "secret_key"; 
	
	/**
	 * 字段描述：public_key_path
	 * 字段类型：varchar(200)   长度：200
	 */
	public static final String column_public_key_path = "public_key_path"; 
	
	/**
	 * 字段描述：secret_key_path
	 * 字段类型：varchar(200)   长度：200
	 */
	public static final String column_secret_key_path = "secret_key_path"; 
	
	/**
	 * 字段描述：back_callback_url
	 * 字段类型：varchar(200)   长度：200
	 */
	public static final String column_back_callback_url = "back_callback_url"; 
	
	/**
	 * 字段描述：front_callback_url
	 * 字段类型：varchar(200)   长度：200
	 */
	public static final String column_front_callback_url = "front_callback_url"; 
	
	/**
	 * 字段描述：encrypt_type
	 * 字段类型：char(6)  长度：6
	 */
	public static final String column_encrypt_type = "encrypt_type"; 
	
	/**
	 * 字段描述：status
	 * 字段类型：char(1)  长度：1
	 */
	public static final String column_status = "status"; 
	
	/**
	 * 字段描述：flowno_length
	 * 字段类型：int(3)  长度：3
	 */
	public static final String column_flowno_length = "flowno_length"; 
	
	/**
	 * 字段描述：public_key
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_public_key = "public_key"; 
	
	/**
	 * 字段描述：md5_key
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_md5_key = "md5_key"; 
	
	/**
	 * 字段描述：ios_app_id
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_ios_app_id = "ios_app_id"; 
	
	/**
	 * 字段描述：android_app_id
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_android_app_id = "android_app_id"; 
	
	/**
	 * 字段描述：sign_key
	 * 字段类型：text  长度：65535
	 */
	public static final String column_sign_key = "sign_key"; 
	
	/**
	 * 字段描述：sign_type
	 * 字段类型：varchar(12)  长度：12
	 */
	public static final String column_sign_type = "sign_type"; 
	
	/**
	 * 字段描述：sign_public_key
	 * 字段类型：text  长度：12
	 */
	public static final String column_sign_public_key = "sign_public_key"; 
	
	/**
	 * 字段描述：sign_secret_key
	 * 字段类型：text  长度：12
	 */
	public static final String column_sign_secret_key = "sign_secret_key"; 
	
	/**
	 * 字段描述：sign_md5_key
	 * 字段类型：text  长度：12
	 */
	public static final String column_sign_md5_key = "sign_md5_key"; 
	
	/**
	 * 字段描述：pay_manner_name
	 * 字段类型：varchar(60)  长度：60
	 */
	public static final String column_pay_manner_name = "pay_manner_name"; 
	
	/**
	 * 字段描述：ext_param
	 * 字段类型：text  长度：
	 */
	public static final String column_ext_param = "ext_param"; 
	
	
	/**
	 * sqlId : platform.payInfoConfig.deleteInfo
	 * 描述：根据id删除
	 */
	public static final String sqlId_delete = "platform.payInfoConfig.deleteInfo";
	
	/**
	 * sqlId : platform.payInfoConfig.splitPageFrom
	 * 描述：分页from 【首页显示所有的】
	 */
	public static final String sqlId_splitPageFrom = "platform.payInfoConfig.splitPageFrom";
	
	
	private Integer id;
	private String channel_name;
	private String merchant_id;
	
	private String secret_key;
	private String public_key_path;
	private String secret_key_path;
	
	private String back_callback_url;
	private String front_callback_url;
	private String encrypt_type;
	
	private Integer flowno_length;
	private String status;
	private String public_key;
	
	private String md5_key;
	private String ios_app_id;
	private String android_app_id;
	private String sign_key;
	
	private String sign_type;
	private String sign_public_key;
	private String sign_secret_key;
	private String sign_md5_key;
	private String pay_manner_name;
	private String ext_param;
	
	
	
	
	public String getSign_type() {
		return get(column_sign_type);
	}

	public void setSign_type(String sign_type) {
		set(column_sign_type, sign_type);
	}

	public String getSign_public_key() {
		return get(column_sign_public_key);
	}

	public void setSign_public_key(String sign_public_key) {
		set(column_sign_public_key, sign_public_key);
	}

	public String getSign_secret_key() {
		return get(column_sign_secret_key);
	}

	public void setSign_secret_key(String sign_secret_key) {
		set(column_sign_secret_key, sign_secret_key);
	}

	public String getSign_md5_key() {
		return get(column_sign_md5_key);
	}

	public void setSign_md5_key(String sign_md5_key) {
		set(column_sign_md5_key, sign_md5_key);
	}

	public String getPay_manner_name() {
		return get(column_channel_name);
	}

	public void setPay_manner_name(String pay_manner_name) {
		set(column_channel_name, channel_name);
	}

	public String getExt_param() {
		return get(column_channel_name);
	}

	public void setExt_param(String ext_param) {
		set(column_channel_name, channel_name);
	}

	public String getChannel_name() {
		return get(column_channel_name);
	}

	public void setChannel_name(String channel_name) {
		set(column_channel_name, channel_name);
	}

	public Integer getId() {
		return get(column_id);
	}
	
	public void setId(Integer id) {
		set(column_id, id);
	}

	public String getMerchant_id() {
		return get(column_merchant_id);
	}

	public void setMerchant_id(String merchant_id) {
		set(column_merchant_id, merchant_id);
	}

	public String getSecret_key() {
		return get(column_secret_key);
	}

	public void setSecret_key(String secret_key) {
		set(column_secret_key, secret_key);
	}

	public String getPublic_key_path() {
		return get(column_public_key_path);
	}

	public void setPublic_key_path(String public_key_path) {
		set(column_public_key_path, public_key_path);
	}

	public String getSecret_key_path() {
		return get(column_secret_key_path);
	}

	public void setSecret_key_path(String secret_key_path) {
		set(column_secret_key_path, secret_key_path);
	}

	public String getBack_callback_url() {
		return get(column_back_callback_url);
	}

	public void setBack_callback_url(String back_callback_url) {
		set(column_back_callback_url, back_callback_url);
	}

	public String getFront_callback_url() {
		return get(column_front_callback_url);
	}

	public void setFront_callback_url(String front_callback_url) {
		set(column_front_callback_url, front_callback_url);
	}

	public String getEncrypt_type() {
		return get(column_encrypt_type);
	}

	public void setEncrypt_type(String encrypt_type) {
		set(column_encrypt_type, encrypt_type);
	}

	public Integer getFlowno_length() {
		return get(column_flowno_length);
	}

	public void setFlowno_length(Integer flowno_length) {
		set(column_flowno_length, flowno_length);
	}

	public String getStatus() {
		return get(column_status);
	}

	public void setStatus(String status) {
		set(column_status, status);
	}

	public String getPublic_key() {
		return get(column_public_key);
	}

	public void setPublic_key(String public_key) {
		set(column_public_key, public_key);
	}

	public String getMd5_key() {
		return get(column_md5_key);
	}

	public void setMd5_key(String md5_key) {
		set(column_md5_key, md5_key);
	}

	public String getIos_app_id() {
		return get(column_ios_app_id);
	}

	public void setIos_app_id(String ios_app_id) {
		set(column_ios_app_id, ios_app_id);
	}

	public String getAndroid_app_id() {
		return get(column_android_app_id);
	}

	public void setAndroid_app_id(String android_app_id) {
		set(column_android_app_id, android_app_id);
	}

	public String getSign_key() {
		return get(column_sign_key);
	}

	public void setSign_key(String sign_key) {
		set(column_sign_key, sign_key);
	}

	@Override
	public String toString() {
		return "PayInfoConfig [id=" + id + ", channel_name=" + channel_name
				+ ", merchant_id=" + merchant_id + ", secret_key=" + secret_key
				+ ", public_key_path=" + public_key_path + ", secret_key_path="
				+ secret_key_path + ", back_callback_url=" + back_callback_url
				+ ", front_callback_url=" + front_callback_url
				+ ", encrypt_type=" + encrypt_type + ", flowno_length="
				+ flowno_length + ", status=" + status + ", public_key="
				+ public_key + ", md5_key=" + md5_key + ", ios_app_id="
				+ ios_app_id + ", android_app_id=" + android_app_id
				+ ", sign_key=" + sign_key + ", sign_type=" + sign_type
				+ ", sign_public_key=" + sign_public_key + ", sign_secret_key="
				+ sign_secret_key + ", sign_md5_key=" + sign_md5_key
				+ ", pay_manner_name=" + pay_manner_name + ", ext_param="
				+ ext_param + "]";
	}
	

	

}
