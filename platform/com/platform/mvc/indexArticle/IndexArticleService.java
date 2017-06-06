/**
 * 
 */
package com.platform.mvc.indexArticle;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.platform.mvc.fm.Fm;
import com.platform.mvc.forum.ForumThread;
import com.platform.mvc.question.Question;
import com.platform.util.DateUtil;
import com.platform.util.StringUtil;

/**
 * @author Jx
 * 首页内容
 * 2017年5月17日 下午7:01:16
 */
public class IndexArticleService {
	private static final Logger log = Logger.getLogger(IndexArticleService.class);
	
	/**
	 * 问题标题截取的长度
	 */
	private static final int QUESTION_CUT_LENGTH = 50;
	
	/**
	 * 【提问】保存
	 * @param question
	 * @param reqIndexArticle
	 * @return
	 * 2017年5月17日 下午7:30:55
	 */
	public boolean saveQuestion(Question question, IndexArticle reqIndexArticle)
	{
		IndexArticle indexArticle = new IndexArticle();
		indexArticle.setSubject(StringUtil.cutContent(question.getContent(), QUESTION_CUT_LENGTH));
		indexArticle.setType(IndexArticleConstant.QUESTION);
		String questionId = question.getId().toString();
		indexArticle.setViews(question.getViews());
		indexArticle.setReplies(question.getReplies());
		indexArticle.setAuthorId(question.getAuthorId());
		indexArticle.setAuthorName(question.getAuthorName());
		String now = DateUtil.getTodayStrUseFormat(DateUtil.TOTAL_DATE_TIME_SSS);
		indexArticle.setCreateDatetime(now);
		indexArticle.setArticleId(questionId);
		indexArticle.setRewardAmount(question.getAmount());
		indexArticle.setRewardCurrency(question.getAmountType());
		indexArticle.setUpdateDatetime(now);
		indexArticle.setDisplayOrder(reqIndexArticle.getDisplayOrder());
		indexArticle.setForumId(reqIndexArticle.getForumId());
		indexArticle.setArticleCreateDatetime(question.getCreateDatetime());
		indexArticle.setQuestionStatus(question.getStatus());
		boolean saveResult = indexArticle.save(new HashMap<String,Object>());
		log.info("【保存问题类型的首页内容】执行结果：" + saveResult + "【问题编号】" + question.getId());
		return saveResult;
	}
	
	/**
	 * 【帖子】保存
	 * @param thread
	 * @param reqIndexArticle
	 * @return
	 * 2017年5月18日 下午7:06:42
	 */
	public boolean savePost(ForumThread thread, IndexArticle reqIndexArticle)
	{
		IndexArticle indexArticle = new IndexArticle();
		indexArticle.setForumName(thread.getStr("NAME"));
		indexArticle.setSubject(thread.getSubject());
		indexArticle.setType(IndexArticleConstant.POST);
		String threadId = thread.getTid().toString();
		indexArticle.setViews(thread.getViews().intValue());
		indexArticle.setReplies(thread.getReplies());
		indexArticle.setAuthorId(thread.getAuthorid());
		indexArticle.setAuthorName(thread.getAuthor());
		String now = DateUtil.getTodayStrUseFormat(DateUtil.TOTAL_DATE_TIME_SSS);
		indexArticle.setCreateDatetime(now);
		indexArticle.setArticleId(threadId);
		indexArticle.setUpdateDatetime(now);
		indexArticle.setDisplayOrder(reqIndexArticle.getDisplayOrder());
		indexArticle.setForumId(reqIndexArticle.getForumId());
		indexArticle.setArticleCreateDatetime(thread.getStr("d"));
		boolean saveResult = indexArticle.save(new HashMap<String,Object>());
		log.info("【保存帖子类型的首页内容】执行结果：" + saveResult + "【tid】" + threadId);
		return saveResult;
	}
	
	/**
	 * 【广告】保存
	 * @param thread
	 * @param reqIndexArticle
	 * @return
	 * 2017年5月18日 下午7:06:42
	 */
	public boolean saveAd(IndexArticle reqIndexArticle, String imgUrl)
	{
		IndexArticle indexArticle = new IndexArticle();
		indexArticle.setAuthorId(2);
		indexArticle.setAuthorName("芒果");
		indexArticle.setSubject(reqIndexArticle.getSubject());
		indexArticle.setType(IndexArticleConstant.AD);
		String now = DateUtil.getTodayStrUseFormat(DateUtil.TOTAL_DATE_TIME_SSS);
		indexArticle.setCreateDatetime(now);
		indexArticle.setImgUrl(imgUrl);
		indexArticle.setUpdateDatetime(now);
		indexArticle.setDisplayOrder(reqIndexArticle.getDisplayOrder());
		indexArticle.setArticleId("-1");//-1标识不存在
		indexArticle.setAdUrl(reqIndexArticle.getAdUrl());
		indexArticle.setForumId(reqIndexArticle.getForumId());
		indexArticle.setArticleCreateDatetime(now);
		boolean saveResult = indexArticle.save(new HashMap<String,Object>());
		log.info("【保存广告类型的首页内容】执行结果：" + saveResult + "【adUrl】" + reqIndexArticle.getAdUrl());
		return saveResult;
	}
	
	/**
	 * 【音频】保存
	 * @param thread
	 * @param reqIndexArticle
	 * @return
	 * 2017年5月18日 下午7:06:42
	 */
	public boolean saveFm(Fm fm, IndexArticle reqIndexArticle)
	{
		IndexArticle indexArticle = new IndexArticle();
		indexArticle.setAuthorId(2);
		indexArticle.setAuthorName("芒果");
		indexArticle.setSubject(fm.getSubject());
		indexArticle.setType(IndexArticleConstant.FM);
		indexArticle.setViews(fm.getViews());
		String now = DateUtil.getTodayStrUseFormat(DateUtil.TOTAL_DATE_TIME_SSS);
		indexArticle.setCreateDatetime(now);
		indexArticle.setImgUrl(fm.getImgUrl());
		indexArticle.setUpdateDatetime(now);
		indexArticle.setDisplayOrder(reqIndexArticle.getDisplayOrder());
		indexArticle.setArticleId(fm.getId());
		indexArticle.setForumId(reqIndexArticle.getForumId());
		indexArticle.setArticleCreateDatetime(fm.getCreateDatetime());
		indexArticle.setFmUrl(fm.getRecordUrl());
		boolean saveResult = indexArticle.save(new HashMap<String,Object>());
		log.info("【保存音频类型的首页内容】执行结果：" + saveResult + "【fmId】" + reqIndexArticle.getArticleId());
		return saveResult;
	}
	
	
	
}
