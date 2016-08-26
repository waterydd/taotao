package com.junit.test.blog;

import java.sql.SQLException;

import org.junit.Test;

import com.junit.TestBase;
import com.platform.mvc.base.BaseService;
import com.platform.plugin.ServicePlugin;

/**
 * 博客单元测试类
 * @author mango  dongcb678@163.com
 */
public class TestBlog extends TestBase {
	
	@Test
    public void delete() throws SQLException{
		BaseService bService = (BaseService) ServicePlugin.getService(BaseService.baseServiceName);
		bService.delete("test_blog", "ids001,ids002");
    }

}
