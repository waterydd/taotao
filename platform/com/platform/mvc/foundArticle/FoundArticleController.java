package com.platform.mvc.foundArticle;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.fm.Fm;
import com.platform.mvc.fm.FmService;
import com.platform.mvc.forum.ForumThread;
import com.platform.mvc.forum.ThreadService;
import com.platform.mvc.foundForum.FoundForum;
import com.platform.mvc.question.Question;
import com.platform.mvc.question.QuestionService;
import com.platform.util.DateFormatUtil;
import com.platform.util.PropertyUtil;
import com.platform.util.oss.OssUploadThread;

@Controller(controllerKey = "/jf/platform/foundArticle")
public class FoundArticleController extends BaseController {
	
	private static Logger log = Logger.getLogger(FoundArticleController.class);
	
	/**
	 * ID列表
	 */
	public void pageById() {
		String id = null;
		FoundForum foundForum = null;
		try {
			id = getPara();
			Long totalRow = Db.queryLong("select count(id) from pre_found_article where forum_id = ?", id);
			splitPage.setTotalRow(totalRow.intValue());
			int pageSize = splitPage.getPageSize();
			int totalPage = (int) (totalRow / pageSize);
			if (totalRow % pageSize != 0) 
				totalPage++;
			splitPage.setTotalPage(totalPage);
			splitPage.setList(transfer2ListVo(FoundArticle.dao.find("SELECT id, forum_id, `subject`, type, article_id, article_create_datetime FROM pre_found_article WHERE forum_id = ? LIMIT ?,?",
					id, (splitPage.getPageNumber() - 1) * splitPage.getPageSize() , 
					splitPage.getPageSize())));
			splitPage.compute();
			foundForum = FoundForum.dao.findById(id);
		} catch (Exception e) {
			log.error("【查询首页内容】出异常【forumId】" + id + "【异常信息】" + e.getMessage());
			e.printStackTrace();
		}
		setAttr("result", id).setAttr("forumName", foundForum.getName())
			.render("/platform/foundArticle/list.html");
	}
	
	private List<FoundArticleVo> transfer2ListVo(List<FoundArticle> articleList)
	{
		List<FoundArticleVo> voList = new ArrayList<FoundArticleVo>();
		for (int i = 0; i < articleList.size(); i++) {
			voList.add(transfer2Vo(articleList.get(i)));
		}
		return voList;
	}
	
	private FoundArticleVo transfer2Vo(FoundArticle FoundArticle)
	{
		FoundArticleVo vo = new FoundArticleVo();
		vo.setId(FoundArticle.getId().toString());
		vo.setSubject(FoundArticle.getSubject());
		vo.setType(FoundArticle.getType());
		vo.setArticleId(FoundArticle.getArticleId());
		vo.setCreateDatetime(DateFormatUtil.dateFormat(FoundArticle.getArticleCreateDatetime()));
		vo.setForumId(FoundArticle.getForumId().toString());
		return vo;
	}
	
	/**
	 * 指定add时跳转页面
	 * /jf/platform/foundArticle/addSkip
	 */
	public void addSkip() {
		String id = getPara();
		
		FoundForum foundForum = FoundForum.dao.findById(id);
		String type = foundForum.getType();
		
		setAttr("info", id);
		if (FoundArticleConstant.POST.equals(type)) { //这里面就是帖子了
			// 指定跳转页面
			render("/platform/foundArticle/postAdd.html");
		}
		if (FoundArticleConstant.ALBUM.equals(type)) { //这里面就是专辑了
			// 指定跳转页面
			render("/platform/foundArticle/albumAdd.html");
		}
		if (FoundArticleConstant.INVESTMENT.equals(type)) { //这里面就是投资了
			// 指定跳转页面
			render("/platform/foundArticle/investmentAdd.html");
		}
		if (FoundArticleConstant.FM.equals(type)) { //这里面就是录音了
			// 指定跳转页面
			render("/platform/foundArticle/fmAdd.html");
		}
		if (FoundArticleConstant.QUESTION.equals(type)) { //这里面就是问答了
			// 指定跳转页面
			render("/platform/foundArticle/questionAdd.html");
		} 
		if (FoundArticleConstant.AD.equals(type)) {  // 这里面就是广告了
			render("/platform/foundArticle/adAdd.html");
			// 指定跳转页面
		}
	}
	
	/**
	 * 保存【问答】
	 */
	public void saveQuestion() {
		FoundArticle foundArticle = getModel(FoundArticle.class);
		FoundArticleService foundArticleService = new FoundArticleService();
		String questionId = foundArticle.getArticleId();
		Question question = new QuestionService().findById(questionId);
		if (question != null)
		{
			if (foundArticleService.saveQuestion(question, foundArticle))
			{
				String path = "/jf/platform/foundArticle/pageById/" + foundArticle.getForumId();
				redirect(path);
				return;
			}
			else
			{
				setAttr("info", foundArticle.getForumId());
				setAttr("FoundArticle", foundArticle);
				setAttr("result", "保存问题失败，请稍后重试！").render("/platform/foundArticle/questionAdd.html");
			}
		}
		else
		{
			setAttr("info", foundArticle.getForumId());
			setAttr("FoundArticle", foundArticle);
			setAttr("result", "问题不存在").render("/platform/foundArticle/questionAdd.html");
		}
	}
	
	/**
	 * 保存【帖子】
	 */
	public void savePost() {
		FoundArticle FoundArticle = getModel(FoundArticle.class);
		FoundArticleService FoundArticleService = new FoundArticleService();
		String subject = FoundArticle.getSubject();
		ForumThread thread = new ThreadService().findBySubject(subject);
		if (thread != null)
		{
			if (FoundArticleService.savePost(thread, FoundArticle))
			{
				String path = "/jf/platform/foundArticle/pageById/" + FoundArticle.getForumId();
				redirect(path);
				return;
			}
			else
			{
				setAttr("info", FoundArticle.getForumId());
				setAttr("FoundArticle", FoundArticle);
				setAttr("result", "保存帖子失败，请稍后重试！").render("/platform/foundArticle/postAdd.html");
			}
		}
		else
		{
			setAttr("info", FoundArticle.getForumId());
			setAttr("FoundArticle", FoundArticle);
			setAttr("result", "帖子不存在").render("/platform/foundArticle/postAdd.html");
		}
	}
	
	/**
	 * 增加 广告
	 * /jf/platform/foundArticle/saveAd
	 */
	public void saveAd() {
		// 获取广告的图片
		String localAdPath = PropertyUtil.getAdImgUploadPath();
		UploadFile uf = getFileByConfigPath("img_url", localAdPath);
		String fileName = uf.getFileName();
		String imgTotalPath = localAdPath + fileName;
		
		FoundArticle FoundArticle = getModel(FoundArticle.class);
		if (new FoundArticleService().saveAd(FoundArticle, fileName))
		{
			new Thread(new OssUploadThread(fileName, imgTotalPath, PropertyUtil.getAdImgUploadRemotePath())).start();
			String path = "/jf/platform/foundArticle/pageById/" + FoundArticle.getForumId();
			redirect(path);
			return;
		}
		else
		{
			setAttr("info", FoundArticle.getForumId());
			setAttr("FoundArticle", FoundArticle);
			setAttr("result", "保存广告失败，请稍后重试！").render("/platform/foundArticle/adAdd.html");
		}
	}
	
	/**
	 * 保存【音频】
	 */
	public void saveFm() {
		FoundArticle FoundArticle = getModel(FoundArticle.class);
		FoundArticleService FoundArticleService = new FoundArticleService();
		String fmId = FoundArticle.getArticleId();
		Fm fm = new FmService().findById(fmId);
		if (fm != null)
		{
			if (FoundArticleService.saveFm(fm, FoundArticle))
			{
				String path = "/jf/platform/foundArticle/pageById/" + FoundArticle.getForumId();
				redirect(path);
				return;
			}
			else
			{
				setAttr("info", FoundArticle.getForumId());
				setAttr("FoundArticle", FoundArticle);
				setAttr("result", "保存音频失败，请稍后重试！").render("/platform/foundArticle/fmAdd.html");
			}
		}
		else
		{
			setAttr("info", FoundArticle.getForumId());
			setAttr("FoundArticle", FoundArticle);
			setAttr("result", "音频不存在").render("/platform/foundArticle/fmAdd.html");
		}
	}
	
}
