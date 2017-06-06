package com.platform.mvc.forum;

/**
 * @author Jx
 * 主题
 */
public class ThreadService {

	public ForumThread findBySubject(String subject)
	{
		String sql = "SELECT tid, t.fid AS fid, author, authorid, SUBJECT, date_format( from_unixtime(t.dateline), '%Y-%m-%d %H:%i:%s' ) d, views, replies, f.`name` AS NAME FROM pre_forum_thread t LEFT JOIN pre_forum_forum f ON t.fid = f.fid WHERE `subject` = ?";
		return ForumThread.dao.findFirst(sql, subject);
	}
	
}
