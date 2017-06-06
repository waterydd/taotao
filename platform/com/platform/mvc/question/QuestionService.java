package com.platform.mvc.question;

public class QuestionService {
	
	/**
	 * 通过ID验证是否存在
	 * @param questionId
	 * @return true -> 存在
	 * 2017年3月17日 下午3:38:35
	 */
	public boolean validateExistsById(String questionId)
	{
		String sql = "SELECT id FROM pre_question WHERE id = ?";
		return Question.dao.findFirst(sql, questionId) != null;
	}
	
	/**
	 * 通过ID查询
	 * @param questionId
	 * @return
	 * 2017年3月17日 下午3:38:35
	 */
	public Question findById(String questionId)
	{
		String sql = "SELECT id, content, author_id, author_name, amount, amount_type, create_datetime, limit_datetime, STATUS, accept_answer_id, accept_answer_username, update_datetime, views, replies, answer_count, pay_order_no, collect_num, SUBJECT FROM pre_question WHERE id = ?";
		return Question.dao.findFirst(sql, questionId);
	}
}
