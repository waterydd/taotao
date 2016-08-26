package com.platform.tools.code.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.platform.constant.ConstantInit;
import com.platform.tools.ToolSqlXml;
import com.platform.tools.ToolString;
import com.platform.tools.code.run.ColumnDto;

/**
 * 定制PostgreSQL下的代码生成
 * @author mango
 */
public class PostgreSQLHandler extends BaseHandler {

	private static Logger log = Logger.getLogger(PostgreSQLHandler.class);
	
	public PostgreSQLHandler() {
    	String db_type = PropKit.get(ConstantInit.db_type_key);
		log.info("db_type = " + db_type);
		if(!db_type.equals(ConstantInit.db_type_postgresql)){
			throw new RuntimeException("请设置init.properties配置文件db.type = postgresql");
		}
	}

	@Override
	public List<ColumnDto> getColunm(String tableName) {
		// 1.查询表和字段描述信息
		Map<String, String> map = new HashMap<String, String>();
		String ciSql = ToolSqlXml.getSql("platform.postgresql.getColumnsInfo");
		List<Record> listDesc = Db.use(ConstantInit.db_dataSource_main).find(ciSql, tableName);
		for (Record record : listDesc) {
			if(record.getStr("attname") == null){
				map.put("tableName", record.getStr("description"));
			}else{
				map.put(record.getStr("attname"), record.getStr("description"));
			}
		}
		
		// 2.查询表字段信息
		String cSql = ToolSqlXml.getSql("platform.postgresql.getColumns");
		List<Record> listColumn = Db.use(ConstantInit.db_dataSource_main).find(cSql, tableName);

		// 3.查询表字段对应的所有java数据类型
		Map<String, String> columnJavaTypeMap = getJavaType(tableName);
		
		List<ColumnDto> list = new ArrayList<ColumnDto>();
		
		// 4.循环合并表字段详细信息
		for (Record record : listColumn) {
			String column_name = record.getStr("column_name");
			String data_type = record.getStr("data_type");
			String character_maximum_length = String.valueOf(record.getNumber("character_maximum_length"));

			// 需要跳过的字段
			if("xxx".equals(column_name) || "yyy".equals(column_name) || "zzz".equals(column_name)){
				continue;
			}
			
			ColumnDto table = new ColumnDto();
			table.setTable_name(tableName);
			table.setTable_desc(listDesc.get(0).getStr("description"));
			
			table.setColumn_name(column_name);
			table.setColumn_name_upperCaseFirstOne(ToolString.toUpperCaseFirstOne(column_name));
			
			table.setColumn_type(data_type);
			table.setColumn_length(character_maximum_length);
			table.setColumn_desc(map.get(column_name));

			table.setColumn_className(columnJavaTypeMap.get(column_name.toLowerCase()));
			
			list.add(table);
		}
		
		return list;
	}
	
}
