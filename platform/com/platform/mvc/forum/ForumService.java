package com.platform.mvc.forum;

/**
 * @author Jx
 *
 */
public class ForumService {

	/**
	 * fid存在验证
	 * @param fid
	 * @return
	 * 2017年5月17日 下午3:32:39
	 */
	public boolean existsValidate(int fid)
	{
		String sql = "select fid from pre_forum_forum where fid = ?";
		return ForumForum.dao.findFirst(sql, fid) != null;
	}
	
}
