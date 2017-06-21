/**
 * 
 */
package com.platform.util.createModel;

import javax.sql.DataSource;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * @author JX
 * 通过数据库创建所有Model
 */
public class CreateModel {
	public static DataSource getDataSource() {
		//使用数据库配置文件
		PropKit.use("com/platform/util/init.properties");
		//jfinal使用C3p0Plugin连接远程数据源
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("mysql.jdbcUrl"), PropKit.get("mysql.userName"),
				PropKit.get("mysql.passWord"));
		//加载JDBC驱动
		c3p0Plugin.setDriverClass("com.mysql.jdbc.Driver");
		c3p0Plugin.start();
		return c3p0Plugin.getDataSource();
	}

	public static void main(String[] args) {
		// base model 所使用的包名
		String baseModelPackageName = "com2";
		// base model 文件保存路径
		String baseModelOutputDir = "d:/TT1";

		// model 所使用的包名 (MappingKit 默认使用的包名)
		String modelPackageName = "com2";
		// model 文件保存路径 (MappingKit 与 DataDictionary 文件默认保存路径)
		String modelOutputDir = baseModelOutputDir;

		// 创建生成器
		Generator gernerator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir,
				modelPackageName, modelOutputDir);
		// 添加不需要生成的表名
//		gernerator.addExcludedTable("blog");
		// 设置是否在 Model 中生成 dao 对象
		gernerator.setGenerateDaoInModel(true);
		// 设置是否生成字典文件
		gernerator.setGenerateDataDictionary(false);
		// 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为
		// "User"而非 OscUser
		gernerator.setRemovedTableNamePrefixes("pre_");
		// 生成
		gernerator.generate();
	}
	
}
