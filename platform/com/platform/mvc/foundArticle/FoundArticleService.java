/**
 * 
 */
package com.platform.mvc.foundArticle;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.platform.mvc.fm.Fm;
import com.platform.mvc.forum.ForumThread;
import com.platform.mvc.question.Question;
import com.platform.util.DateUtil;
import com.platform.util.PropertyUtil;
import com.platform.util.StringUtil;

/**
 * @author Jx
 * 发现页内容
 * 2017年5月17日 下午7:01:16
 */
public class FoundArticleService {
	private static final Logger log = Logger.getLogger(FoundArticleService.class);
	
	/**
	 * 问题标题截取的长度
	 */
	private static final int QUESTION_CUT_LENGTH = 50;
	
	/**
	 * 【提问】保存
	 * @param question
	 * @param reqFoundArticle
	 * @return
	 * 2017年5月17日 下午7:30:55
	 */
	public boolean saveQuestion(Question question, FoundArticle reqFoundArticle)
	{
		FoundArticle FoundArticle = new FoundArticle();
		FoundArticle.setSubject(StringUtil.cutContent(question.getContent(), QUESTION_CUT_LENGTH));
		FoundArticle.setType(FoundArticleConstant.QUESTION);
		String questionId = question.getId().toString();
		FoundArticle.setViews(question.getViews());
		FoundArticle.setReplies(question.getReplies());
		FoundArticle.setAuthorId(question.getAuthorId());
		FoundArticle.setAuthorName(question.getAuthorName());
		String now = DateUtil.getTodayStrUseFormat(DateUtil.TOTAL_DATE_TIME_SSS);
		FoundArticle.setCreateDatetime(now);
		FoundArticle.setArticleId(questionId);
		FoundArticle.setRewardAmount(question.getAmount());
		FoundArticle.setRewardCurrency(question.getAmountType());
		FoundArticle.setUpdateDatetime(now);
		FoundArticle.setDisplayOrder(reqFoundArticle.getDisplayOrder());
		FoundArticle.setForumId(reqFoundArticle.getForumId());
		FoundArticle.setArticleCreateDatetime(question.getCreateDatetime());
		FoundArticle.setQuestionStatus(question.getStatus());
		boolean saveResult = FoundArticle.save(new HashMap<String,Object>());
		log.info("【保存问题类型的首页内容】执行结果：" + saveResult + "【问题编号】" + question.getId());
		return saveResult;
	}
	
	/**
	 * 【帖子】保存
	 * @param thread
	 * @param reqFoundArticle
	 * @return
	 * 2017年5月18日 下午7:06:42
	 */
	public boolean savePost(ForumThread thread, FoundArticle reqFoundArticle)
	{
		FoundArticle FoundArticle = new FoundArticle();
		FoundArticle.setForumName(thread.getStr("NAME"));
		FoundArticle.setSubject(thread.getSubject());
		FoundArticle.setType(FoundArticleConstant.POST);
		String threadId = thread.getTid().toString();
		FoundArticle.setViews(thread.getViews().intValue());
		FoundArticle.setReplies(thread.getReplies());
		FoundArticle.setAuthorId(thread.getAuthorid());
		FoundArticle.setAuthorName(thread.getAuthor());
		String now = DateUtil.getTodayStrUseFormat(DateUtil.TOTAL_DATE_TIME_SSS);
		FoundArticle.setCreateDatetime(now);
		FoundArticle.setArticleId(threadId);
		FoundArticle.setUpdateDatetime(now);
		FoundArticle.setDisplayOrder(reqFoundArticle.getDisplayOrder());
		FoundArticle.setForumId(reqFoundArticle.getForumId());
		FoundArticle.setArticleCreateDatetime(thread.getStr("d"));
		boolean saveResult = FoundArticle.save(new HashMap<String,Object>());
		log.info("【保存帖子类型的首页内容】执行结果：" + saveResult + "【tid】" + threadId);
		return saveResult;
	}
	
	/**
	 * 【广告】保存
	 * @param thread
	 * @param reqFoundArticle
	 * @return
	 * 2017年5月18日 下午7:06:42
	 */
	public boolean saveAd(FoundArticle reqFoundArticle, String imgUrl)
	{
		FoundArticle FoundArticle = new FoundArticle();
		FoundArticle.setAuthorId(2);
		FoundArticle.setAuthorName("芒果");
		FoundArticle.setSubject(reqFoundArticle.getSubject());
		FoundArticle.setType(FoundArticleConstant.AD);
		String now = DateUtil.getTodayStrUseFormat(DateUtil.TOTAL_DATE_TIME_SSS);
		FoundArticle.setCreateDatetime(now);
		FoundArticle.setImgUrl(imgUrl);
		FoundArticle.setImgUrl(PropertyUtil.getAdImgGetRemoteUrl() + imgUrl);
		FoundArticle.setUpdateDatetime(now);
		FoundArticle.setDisplayOrder(reqFoundArticle.getDisplayOrder());
		FoundArticle.setArticleId("-1");//-1标识不存在
		FoundArticle.setAdUrl(reqFoundArticle.getAdUrl());
		FoundArticle.setForumId(reqFoundArticle.getForumId());
		FoundArticle.setArticleCreateDatetime(now);
		boolean saveResult = FoundArticle.save(new HashMap<String,Object>());
		log.info("【保存广告类型的首页内容】执行结果：" + saveResult + "【adUrl】" + reqFoundArticle.getAdUrl());
		return saveResult;
	}
	
	/**
	 * 【音频】保存
	 * @param thread
	 * @param reqFoundArticle
	 * @return
	 * 2017年5月18日 下午7:06:42
	 */
	public boolean saveFm(Fm fm, FoundArticle reqFoundArticle)
	{
		FoundArticle FoundArticle = new FoundArticle();
		FoundArticle.setAuthorId(2);
		FoundArticle.setAuthorName("芒果");
		FoundArticle.setSubject(fm.getSubject());
		FoundArticle.setType(FoundArticleConstant.FM);
		FoundArticle.setViews(fm.getViews());
		String now = DateUtil.getTodayStrUseFormat(DateUtil.TOTAL_DATE_TIME_SSS);
		FoundArticle.setCreateDatetime(now);
		FoundArticle.setImgUrl(fm.getImgUrl());
		FoundArticle.setUpdateDatetime(now);
		FoundArticle.setDisplayOrder(reqFoundArticle.getDisplayOrder());
		FoundArticle.setArticleId(fm.getId());
		FoundArticle.setForumId(reqFoundArticle.getForumId());
		FoundArticle.setArticleCreateDatetime(fm.getCreateDatetime());
		FoundArticle.setFmUrl(fm.getRecordUrl());
		boolean saveResult = FoundArticle.save(new HashMap<String,Object>());
		log.info("【保存音频类型的首页内容】执行结果：" + saveResult + "【fmId】" + reqFoundArticle.getArticleId());
		return saveResult;
	}
	
	
	
}
