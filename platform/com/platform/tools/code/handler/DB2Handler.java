package com.platform.tools.code.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.platform.constant.ConstantInit;
import com.platform.tools.ToolDataBase;
import com.platform.tools.ToolSqlXml;
import com.platform.tools.ToolString;
import com.platform.tools.code.run.ColumnDto;

/**
 * 定制Oracle下的代码生成
 * @author mango
 */
public class DB2Handler extends BaseHandler {

	private static Logger log = Logger.getLogger(DB2Handler.class);
	
	public DB2Handler() {
		String db_type = PropKit.get(ConstantInit.db_type_key);
		log.info("db_type = " + db_type);
		if(!db_type.equals(ConstantInit.db_type_db2)){
			throw new RuntimeException("请设置init.properties配置文件db.type = db2");
		}
	}

	@Override
	public List<ColumnDto> getColunm(String tableName) {
		String dbUser = ToolDataBase.getDbInfo().getUserName();

		// 1.查询表和字段描述信息
		String tcSql = ToolSqlXml.getSql("platform.db2.getTableComments");
		String tableDesc = Db.use(ConstantInit.db_dataSource_main).findFirst(tcSql, dbUser, tableName).getStr("REMARKS");

		// 2.查询表字段信息
		String ccSql = ToolSqlXml.getSql("platform.db2.getColumnComments");
		List<Record> listColumnComments = Db.use(ConstantInit.db_dataSource_main).find(ccSql, dbUser, tableName);

		// 3.查询表字段对应的所有java数据类型
		Map<String, String> columnJavaTypeMap = getJavaType(tableName);

		List<ColumnDto> list = new ArrayList<ColumnDto>();
		
		// 4.循环合并表字段详细信息
		for (Record record : listColumnComments) {
			String column_name = record.getStr("COLNAME");
			String column_type = record.getStr("TYPENAME");
			String column_length = String.valueOf(record.getNumber("LENGTH"));
			String comments = record.getStr("REMARKS");
			
			// 需要跳过的字段
			if("xxx".equals(column_name) || "yyy".equals(column_name) || "zzz".equals(column_name)){
				continue;
			}
			
			ColumnDto table = new ColumnDto();
			table.setTable_name(tableName);
			table.setTable_desc(tableDesc);
			
			table.setColumn_name(column_name);
			table.setColumn_name_upperCaseFirstOne(ToolString.toUpperCaseFirstOne(column_name));
			
			table.setColumn_type(column_type);
			table.setColumn_length(column_length);
			table.setColumn_desc(comments);

			table.setColumn_className(columnJavaTypeMap.get(column_name.toLowerCase()));
			
			list.add(table);
		}
		
		return list;
	}
	
	

}
