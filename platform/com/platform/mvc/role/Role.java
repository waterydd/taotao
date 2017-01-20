package com.platform.mvc.role;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModelCache;
import com.platform.mvc.station.Station;
import com.platform.plugin.ParamInitPlugin;
import com.platform.tools.ToolCache;

/**
 * 角色model
 * @author mango
 */
@SuppressWarnings("unused")
@Table(tableName = "pt_role")
public class Role extends BaseModelCache<Role> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Role.class);
	
	public static final Role dao = new Role();

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
	 * 字段描述：描述 
	 * 字段类型：character varying  长度：2000
	 */
	public static final String column_description = "description";
	
	/**
	 * 字段描述：名称 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_names = "names";
	
	/**
	 * 字段描述：拥有的功能ids 
	 * 字段类型：text  长度：null
	 */
	public static final String column_operatorids = "operatorids";
	
	/**
	 * 字段描述：拥有的功能模块ids 
	 * 字段类型：text  长度：null
	 */
	public static final String column_moduleids = "moduleids";
	
	/**
	 * 字段描述：编号 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_numbers = "numbers";
	
	/**
	 * sqlId : platform.role.paging
	 * 描述：查询所有角色
	 */
	public static final String sqlId_paging = "platform.role.paging";

	/**
	 * sqlId : platform.role.noCheckedFilter
	 * 描述：
	 */
	public static final String sqlId_noCheckedFilter = "platform.role.noCheckedFilter";

	/**
	 * sqlId : platform.role.checkedFilter
	 * 描述：
	 */
	public static final String sqlId_checkedFilter = "platform.role.checkedFilter";

	/**
	 * sqlId : platform.role.noChecked
	 * 描述：
	 */
	public static final String sqlId_noChecked = "platform.role.noChecked";

	/**
	 * sqlId : platform.role.splitPageSelect
	 * 描述：分页Select
	 */
	public static final String sqlId_splitPage_select = "platform.role.splitPageSelect";

	/**
	 * sqlId : platform.role.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.role.splitPageFrom";

	private String ids;
	private Long version;
	private String description;
	private String names;
	private String operatorids;
	private String moduleids;
	private String numbers;
	
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
	public void setDescription(String description){
		set(column_description, description);
	}
	public String getDescription() {
		return get(column_description);
	}
	public void setNames(String names){
		set(column_names, names);
	}
	public String getNames() {
		return get(column_names);
	}
	public void setOperatorids(String operatorids){
		set(column_operatorids, operatorids);
	}
	public String getOperatorids() {
		return get(column_operatorids);
	}
	public void setModuleids(String moduleids){
		set(column_moduleids, moduleids);
	}
	public String getModuleids() {
		return get(column_moduleids);
	}
	public void setNumbers(String numbers){
		set(column_numbers, numbers);
	}
	public String getNumbers() {
		return get(column_numbers);
	}
	
	/**
	 * 添加或者更新缓存
	 */
	public void cacheAdd(String ids){
		ToolCache.set(ParamInitPlugin.cacheStart_role + ids, Role.dao.findById(ids));
	}

	/**
	 * 删除缓存
	 */
	public void cacheRemove(String ids){
		ToolCache.remove(ParamInitPlugin.cacheStart_role + ids);
	}

	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	public Role cacheGet(String key){
		Role role = ToolCache.get(ParamInitPlugin.cacheStart_role + key);
		if(role == null){
			role = Role.dao.findById(ids);
			cacheAdd(ids);
		}
		return role;
	}
	
	@Override
	public String toString() {
		return "Role [ids=" + ids + ", version=" + version + ", description="
				+ description + ", names=" + names + ", operatorids="
				+ operatorids + ", moduleids=" + moduleids + ", numbers="
				+ numbers + "]";
	}
	
	
	
}
