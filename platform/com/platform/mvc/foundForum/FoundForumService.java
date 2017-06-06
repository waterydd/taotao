/**
 * 
 */
package com.platform.mvc.foundForum;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.platform.mvc.forum.ForumService;
import com.platform.mvc.indexArticle.IndexArticleConstant;

/**
 * @author Jx
 * 首页板块
 * 2017年5月17日 下午3:19:05
 */
public class FoundForumService {
	private static Logger log = Logger.getLogger(FoundForumService.class);
	
	/**
	 * 【新增】验证
	 * @param FoundForum
	 * @return
	 * 2017年5月17日 下午3:37:05
	 */
	public String validateSave(FoundForum FoundForum)
	{
		if (existsValidate(FoundForum.getName()))
			return "版块名重复！";
		return fidValidate(FoundForum);
	}
	
	/**
	 * 【更新】验证
	 * @param FoundForum
	 * @return
	 * 2017年5月17日 下午3:37:05
	 */
	public String validateUpdate(FoundForum FoundForum)
	{
		if (existsValidateUpdate(FoundForum))
			return "版块名重复！";
		return fidValidate(FoundForum);
	}

	/**
	 * 【fid】验证
	 * @param FoundForum
	 * @return
	 * 2017年5月17日 下午5:43:35	
	 */
	private String fidValidate(FoundForum FoundForum) {
		Integer fid = FoundForum.getFid();
		if (fid == null)
			return "fid不能为空！";
		else if (fid == -3 && 
				!FoundForum.getType().equals(IndexArticleConstant.QUESTION))
			return "只有问答类型fid才能为-3";
		else if (fid < -3)
			return "fid值错误";
		else if (fid > 0 && (!new ForumService().existsValidate(fid)))
			return "fid不存在！";
		return "";
	}
	
	/**
	 * 板块名存在验证
	 * @param name
	 * @return
	 * 2017年5月17日 下午3:20:46
	 */
	public boolean existsValidate(String name)
	{
		String sql = "select id from pre_index_forum where name = ?";
		return FoundForum.dao.findFirst(sql, name) != null;
	}
	
	/**
	 * 【更新操作】板块名存在验证
	 * @param FoundForum
	 * @return
	 * 2017年5月17日 下午3:20:46
	 */
	public boolean existsValidateUpdate(FoundForum FoundForum)
	{
		String sql = "select id from pre_index_forum where name = ?";
		FoundForum FoundForumDB = FoundForum.dao.findFirst(sql, FoundForum.getName());
		return FoundForumDB != null && FoundForumDB.getId() != FoundForum.getId();
	}
	
	/**
	 * 保存
	 * @param forum
	 * @return
	 * 2017年5月17日 下午3:50:07
	 */
	public String save(FoundForum forum)
	{
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
		Boolean istrue = false;
		try {
			istrue = forum.save(pkMap);
		} catch (Exception e) {
			log.error("【保存forum大板块信息】出现异常【name】" + forum.getName() + "【fid】" + forum.getFid());
			e.printStackTrace();
		}
		if (!istrue) {
			log.error("保存forum大板块信息失败" + forum);
			return "保存失败 ，请稍后重试！";
		}
		return "";
	}
	
	/**
	 * 更新
	 * @param forum
	 * @return
	 * 2017年5月17日 下午3:50:07
	 */
	public String update(FoundForum forum)
	{
		Boolean istrue = false;
		try {
			istrue = forum.update();
		} catch (Exception e) {
			log.error("【更新forum大板块信息】出现异常【name】" + forum.getName() + "【fid】" + forum.getFid());
			e.printStackTrace();
		}
		if (!istrue) {
			log.error("更新forum大板块信息失败" + forum);
			return "更新失败 ，请稍后重试！";
		}
		return "";
	}
}
