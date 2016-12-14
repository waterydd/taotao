package com.platform.mvc.forum;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.platform.annotation.Service;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseService;
import com.platform.mvc.partner.Partner;
import com.platform.mvc.partner.PartnerService;

/**
 * 论坛帖子管理 HomeTopPostService 
 * @author Administrator
 *
 */
@Service(name = HomeTopPostService.serviceName)
public class HomeTopPostService extends BaseService {

	private static Logger log = Logger.getLogger(PartnerService.class);
	
	public static final String serviceName = "homeTopPostService";
	
	

	/**
	 * 验证ForumThread表的标题是否存在
	 * @param subject
	 * @return
	 */
	public ForumThread valiSubjectInfo(String subject) {

		String sql=getSql(ForumThread.sqlId_splitFindInfo);// 查询的sql语句
		log.info("查询的sql:"+sql);// 日志打印查询的sql语句
		ForumThread result = ForumThread.dao.findFirst(sql, subject);
		return result;
	}
	
	/**
	 * 验证HomeTopPost表的标题是否存在
	 * @param subject
	 * @return
	 */
	public HomeTopPost valiHTPubjectInfo(String subject) {

		String sql=getSql(HomeTopPost.sqlId_valiHTPubjectInfo);// 查询的sql语句
		log.info("查询的sql:"+sql);// 日志打印查询的sql语句
		HomeTopPost result = HomeTopPost.dao.findFirst(sql, subject);
		return result;
	}
	
    
	/**
	 * 
	 * @param homeTopPost 界面取到的值
	 * @param imgpath 图片地址
	 * @return
	 */
	public HomeTopPost saveme(HomeTopPost homeTopPost,String imgpath) {
		
		ForumThread forumThread = valiSubjectInfo(homeTopPost.getSubject());//调用Service的验证标题是否存在方法

		homeTopPost.setTid(forumThread.getTid());// 取tid 并存到homeTopPost里
		homeTopPost.setAuthor_name(forumThread.getAuthor()); // 作者 并存到homeTopPost里
		homeTopPost.setAuthor_id(forumThread.getAuthorid()); //作者 id 并存到homeTopPost里
		homeTopPost.setDateline(forumThread.getDateline()); //发稿日期 并存到homeTopPost里
		homeTopPost.setViews(forumThread.getViews()); //查看数 并存到homeTopPost里
		homeTopPost.setReplies(forumThread.getReplies()); //回复数 并存到homeTopPost里
		homeTopPost.setImage_url(imgpath);//添加图片地址
		
		
		String sql="select name from pre_forum_forum  where  fid =?";// 查询的sql语句   sqlId_splitFind
		log.info("查询的sql:"+sql);// 日志打印查询的sql语句
		Integer fid = forumThread.getFid();
		System.out.println("找到的fid是： "+fid);
		ForumForum name = ForumForum.dao.findFirst(sql,fid );//forumThread.getFid() 取到的fid值
		homeTopPost.setForumName(name.getName());
		return homeTopPost;
	}
	
	
	/**
	 * 删除用户信息
	 */
	@Before(Tx.class) //事物
	public void delete(String table, String tid){//表名   参数名
		
		String sqlIn = sqlIn(tid);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("table", table);
		param.put("sqlIn", sqlIn);
		
		String sql = getSqlByBeetl(HomeTopPost.sqlId_delete, param); //  String sqlId_deleteIn = "platform.baseModel.deleteIn";
		
		Db.use(ConstantInit.db_dataSource_main).update(sql);
	}

}
