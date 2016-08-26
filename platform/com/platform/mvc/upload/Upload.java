package com.platform.mvc.upload;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModel;

/**
 * 上传文件model
 * @author mango
 */
@SuppressWarnings("unused")
@Table(tableName = "pt_upload")
public class Upload extends BaseModel<Upload> {
	
	private static final long serialVersionUID = 2051998642258015518L;

	private static Logger log = Logger.getLogger(Upload.class);
	
	public static final Upload dao = new Upload();

	/**
	 * 字段描述：主键 
	 * 字段类型：character varying  长度：32
	 */
	public static final String column_ids = "ids";
	
	/**
	 * 字段描述：版本号 
	 * 字段类型：bigint  长度：null
	 */
	public static final String column_version = "version";
	
	/**
	 * 字段描述：参数key 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_parametername = "parametername";
	
	/**
	 * 字段描述：文件名 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_filename = "filename";
	
	/**
	 * 字段描述：contenttype 
	 * 字段类型：character varying  长度：100
	 */
	public static final String column_contenttype = "contenttype";
	
	/**
	 * 字段描述：原文件名 
	 * 字段类型：character varying  长度：500
	 */
	public static final String column_originalfilename = "originalfilename";
	
	/**
	 * 字段描述：存放路径 
	 * 字段类型：character varying  长度：500
	 */
	public static final String column_path = "path";
	
	/**
	 * sqlId : platform.upload.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.upload.splitPageFrom";

	private String ids;
	private Long version;
	private String parametername;
	private String filename;
	private String contenttype;
	private String originalfilename;
	private String path;
	
	public void setIds(String ids){
		set(column_ids, ids);
	}
	public String getIds() {
		return get(column_ids);
	}
	public void setVersion(Long version){
		set(column_version, version);
	}
	public Long getVersion() {
		return get(column_version);
	}
	public void setParametername(String parametername){
		set(column_parametername, parametername);
	}
	public String getParametername() {
		return get(column_parametername);
	}
	public void setFilename(String filename){
		set(column_filename, filename);
	}
	public String getFilename() {
		return get(column_filename);
	}
	public void setContenttype(String contenttype){
		set(column_contenttype, contenttype);
	}
	public String getContenttype() {
		return get(column_contenttype);
	}
	public void setOriginalfilename(String originalfilename){
		set(column_originalfilename, originalfilename);
	}
	public String getOriginalfilename() {
		return get(column_originalfilename);
	}
	public void setPath(String path){
		set(column_path, path);
	}
	public String getPath() {
		return get(column_path);
	}
	
}
