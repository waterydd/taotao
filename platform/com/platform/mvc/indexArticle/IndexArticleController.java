package com.platform.mvc.indexArticle;

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
import com.platform.mvc.indexForum.IndexForum;
import com.platform.mvc.question.Question;
import com.platform.mvc.question.QuestionService;
import com.platform.util.DateFormatUtil;
import com.platform.util.PropertyUtil;
import com.platform.util.oss.OssUploadThread;

@Controller(controllerKey = "/jf/platform/indexArticle")
public class IndexArticleController extends BaseController {
	
	private static Logger log = Logger.getLogger(IndexArticleController.class);
	
	/**
	 * ID列表
	 */
	public void pageById() {
		String id = null;
		IndexForum indexForum = null;
		try {
			id = getPara();
			Long totalRow = Db.queryLong("select count(id) from pre_index_article where forum_id = ?", id);
			splitPage.setTotalRow(totalRow.intValue());
			int pageSize = splitPage.getPageSize();
			int totalPage = (int) (totalRow / pageSize);
			if (totalRow % pageSize != 0) 
				totalPage++;
			splitPage.setTotalPage(totalPage);
			splitPage.setList(transfer2ListVo(IndexArticle.dao.find("SELECT id, forum_id, `subject`, type, article_id, article_create_datetime FROM pre_index_article WHERE forum_id = ? LIMIT ?,?", id, splitPage.getPageNumber(), splitPage.getPageSize())));
			splitPage.compute();
			indexForum = IndexForum.dao.findById(id);
		} catch (Exception e) {
			log.error("【查询首页内容】出异常【forumId】" + id);
			e.printStackTrace();
		}
		setAttr("result", id).setAttr("forumName", indexForum.getName())
			.render("/platform/indexArticle/list.html");
	}
	
	private List<IndexArticleVo> transfer2ListVo(List<IndexArticle> articleList)
	{
		List<IndexArticleVo> voList = new ArrayList<IndexArticleVo>();
		for (int i = 0; i < articleList.size(); i++) {
			voList.add(transfer2Vo(articleList.get(i)));
		}
		return voList;
	}
	
	private IndexArticleVo transfer2Vo(IndexArticle indexArticle)
	{
		IndexArticleVo vo = new IndexArticleVo();
		vo.setId(indexArticle.getId().toString());
		vo.setSubject(indexArticle.getSubject());
		vo.setType(indexArticle.getType());
		vo.setArticleId(indexArticle.getArticleId());
		vo.setCreateDatetime(DateFormatUtil.dateFormat(indexArticle.getArticleCreateDatetime()));
		vo.setForumId(indexArticle.getForumId().toString());
		return vo;
	}
	
	/**
	 * 指定add时跳转页面
	 * /jf/platform/indexArticle/addSkip
	 */
	public void addSkip() {
		String id = getPara();
		IndexForum indexForum = IndexForum.dao.findById(id);
		String type = indexForum.getType();
		
		setAttr("info", id);
		if (IndexArticleConstant.POST.equals(type)) { //这里面就是帖子了
			// 指定跳转页面
			render("/platform/indexArticle/postAdd.html");
		}
		if (IndexArticleConstant.ALBUM.equals(type)) { //这里面就是专辑了
			// 指定跳转页面
			render("/platform/indexArticle/albumAdd.html");
		}
		if (IndexArticleConstant.INVESTMENT.equals(type)) { //这里面就是投资了
			// 指定跳转页面
			render("/platform/indexArticle/investmentAdd.html");
		}
		if (IndexArticleConstant.FM.equals(type)) { //这里面就是录音了
			// 指定跳转页面
			render("/platform/indexArticle/fmAdd.html");
		}
		if (IndexArticleConstant.QUESTION.equals(type)) { //这里面就是问答了
			// 指定跳转页面
			render("/platform/indexArticle/questionAdd.html");
		} 
		if (IndexArticleConstant.AD.equals(type)) {  // 这里面就是广告了
			render("/platform/indexArticle/adAdd.html");
			// 指定跳转页面
		}
	}
	
	/**
	 * 保存【问答】
	 */
	public void saveQuestion() {
		IndexArticle indexArticle = getModel(IndexArticle.class);
		IndexArticleService indexArticleService = new IndexArticleService();
		String questionId = indexArticle.getArticleId();
		Question question = new QuestionService().findById(questionId);
		if (question != null)
		{
			if (indexArticleService.saveQuestion(question, indexArticle))
			{
				String path = "/jf/platform/indexArticle/pageById/" + indexArticle.getForumId();
				redirect(path);
				return;
			}
			else
			{
				setAttr("info", indexArticle.getForumId());
				setAttr("indexArticle", indexArticle);
				setAttr("result", "保存问题失败，请稍后重试！").render("/platform/indexArticle/questionAdd.html");
			}
		}
		else
		{
			setAttr("info", indexArticle.getForumId());
			setAttr("indexArticle", indexArticle);
			setAttr("result", "问题不存在").render("/platform/indexArticle/questionAdd.html");
		}
	}
	
	/**
	 * 保存【帖子】
	 */
	public void savePost() {
		IndexArticle indexArticle = getModel(IndexArticle.class);
		IndexArticleService indexArticleService = new IndexArticleService();
		String subject = indexArticle.getSubject();
		ForumThread thread = new ThreadService().findBySubject(subject);
		if (thread != null)
		{
			if (indexArticleService.savePost(thread, indexArticle))
			{
				String path = "/jf/platform/indexArticle/pageById/" + indexArticle.getForumId();
				redirect(path);
				return;
			}
			else
			{
				setAttr("info", indexArticle.getForumId());
				setAttr("indexArticle", indexArticle);
				setAttr("result", "保存帖子失败，请稍后重试！").render("/platform/indexArticle/postAdd.html");
			}
		}
		else
		{
			setAttr("info", indexArticle.getForumId());
			setAttr("indexArticle", indexArticle);
			setAttr("result", "帖子不存在").render("/platform/indexArticle/postAdd.html");
		}
	}
	
	/**
	 * 增加 广告
	 * /jf/platform/indexArticle/saveAd
	 */
	public void saveAd() {
		// 获取广告的图片
		String localAdPath = PropertyUtil.getAdImgUploadPath();
		UploadFile uf = getFileByConfigPath("img_url", localAdPath);
		String fileName = uf.getFileName();
		String imgTotalPath = localAdPath + fileName;
		
		IndexArticle indexArticle = getModel(IndexArticle.class);
		if (new IndexArticleService().saveAd(indexArticle, fileName))
		{
			new Thread(new OssUploadThread(fileName, imgTotalPath, PropertyUtil.getAdImgUploadRemotePath())).start();
			String path = "/jf/platform/indexArticle/pageById/" + indexArticle.getForumId();
			redirect(path);
			return;
		}
		else
		{
			setAttr("info", indexArticle.getForumId());
			setAttr("indexArticle", indexArticle);
			setAttr("result", "保存广告失败，请稍后重试！").render("/platform/indexArticle/adAdd.html");
		}
	}
	
	/**
	 * 保存【音频】
	 */
	public void saveFm() {
		IndexArticle indexArticle = getModel(IndexArticle.class);
		IndexArticleService indexArticleService = new IndexArticleService();
		String fmId = indexArticle.getArticleId();
		Fm fm = new FmService().findById(fmId);
		if (fm != null)
		{
			if (indexArticleService.saveFm(fm, indexArticle))
			{
				String path = "/jf/platform/indexArticle/pageById/" + indexArticle.getForumId();
				redirect(path);
				return;
			}
			else
			{
				setAttr("info", indexArticle.getForumId());
				setAttr("indexArticle", indexArticle);
				setAttr("result", "保存音频失败，请稍后重试！").render("/platform/indexArticle/fmAdd.html");
			}
		}
		else
		{
			setAttr("info", indexArticle.getForumId());
			setAttr("indexArticle", indexArticle);
			setAttr("result", "音频不存在").render("/platform/indexArticle/fmAdd.html");
		}
	}
	
//	/**
//	 * 更新 帖子信息
//	 * /jf/platform/indexArticle/update
//	 */
//	@Before(IndexArticleValidator.class)
//	public void update() {
//		
//		final String IS_TRUE = "修改成功 ！";
//		IndexArticle indexArticle = getModel(IndexArticle.class);
//		Integer forum_id = indexArticle.getForum_id();
//		String info = indexArticleService.updateService(indexArticle);
//		
//		if (IS_TRUE.equals(info)) {
//			String path = "/jf/platform/indexArticle/" + forum_id;
//			redirect(path);
//			return;
//		}
//		setAttr("info", forum_id);
//		setAttr("indexArticle", indexArticle);
//		setAttr("result", info).render("/platform/indexarticle/postupdate.html");
//	}
//	
//	/**
//	 * 修改 广告
//	 * /jf/platform/indexArticle/updateAd
//	 * 
//	 */
//	public void updateAd() {
//		UploadFile uf = getFileByConfigPath("img_url2", PropertyUtil.getCarouselImgPath());
//		
//		final String IS_TRUE = "修改成功 ！";
//		IndexArticle indexArticle = getModel(IndexArticle.class);
//		
//		if (uf != null) { //当上传的文件不为空
//			String imgpath = uf.getFileName();
//			indexArticle.setImg_url(imgpath);
//		}
//		
//		Integer forum_id = indexArticle.getForum_id();
//		String info = indexArticleService.updateAdService(indexArticle);
//		
//		if (IS_TRUE.equals(info)) {
//			String path = "/jf/platform/indexArticle/" + forum_id;
//			redirect(path);
//			return;
//		}
//		setAttr("info", forum_id);
//		setAttr("indexArticle", indexArticle);
//		setAttr("result", info).render("/platform/indexarticle/adupdate.html");
//	}
//
//	/**
//	 * 查看
//	 * /jf/platform/indexArticle/view
//	 * 
//	 */
//	public void view() {
//		String id = getPara();
//		IndexArticle indexArticle = IndexArticle.dao.findById(id);
//		Integer forumId = indexArticle.getForum_id(); // 大板块ID
//		setAttr("info", forumId);
//		setAttr("indexArticle", indexArticle);
//		render("/platform/indexarticle/view.html");
//	}
	
	/**
	 * 删除
	 */
	@Before(Tx.class)
	public void delete() {
		
		String forumId = getPara(0); // 第一个板块名
		String deleteId = getPara(1); // 第二个要删除的id
		Integer istrue = Db.update("delete from pre_index_article where id = ?", deleteId);
		if (istrue == 1) 
			 Db.update("UPDATE pre_index_forum SET article_num = article_num - 1 WHERE id = ?", forumId);
		String path = "/jf/platform/indexArticle/pageById/" + forumId;
		redirect(path);
	}
	
//	
//	/**
//	 * 
//	 * 增加投资板块信息
//	 * /jf/platform/indexArticle/saveInvestment
//	 */
//	public void saveInvestment() {
//		final String IS_TRUE = "增加成功 ！";
//		
//		IndexArticle indexArticle = getModel(IndexArticle.class);
//		Integer forum_id = indexArticle.getForum_id();
//		String info = indexArticleService.saveInvestmentService(indexArticle);
//		
//		if (IS_TRUE.equals(info)) {
//			String path = "/jf/platform/indexArticle/" + forum_id;
//			redirect(path);
//			return;
//		}
//		setAttr("info", forum_id);
//		setAttr("indexArticle", indexArticle);
//		setAttr("result", info).render("/platform/indexarticle/investmentadd.html");
//	}
//	
//	/**
//	 * 修改投资板块信息
//	 * /jf/platform/indexArticle/updateInvestment
//	 */
//	public void updateInvestment() {
//		
//		final String IS_TRUE = "修改成功 ！";
//		IndexArticle indexArticle = getModel(IndexArticle.class);
//		
//		Integer forum_id = indexArticle.getForum_id();
//		String info = indexArticleService.updateInvestmentService(indexArticle);
//		
//		if (IS_TRUE.equals(info)) {
//			String path = "/jf/platform/indexArticle/" + forum_id;
//			redirect(path);
//			return;
//		}
//		setAttr("info", forum_id);
//		setAttr("indexArticle", indexArticle);
//		setAttr("result", info).render("/platform/indexarticle/investmentupdate.html");
//		
//	}
//	
//	/**
//	 * 增加问答
//	 * /jf/platform/indexArticle/saveQuestion
//	 */
//	public void saveQuestion() {
//		final String IS_TRUE = "增加成功 ！";
//		
//		IndexArticle indexArticle = getModel(IndexArticle.class);
//		Integer forum_id = indexArticle.getForum_id();
//		String info = indexArticleService.saveQuestionService(indexArticle);
//		
//		if (IS_TRUE.equals(info)) {
//			String path = "/jf/platform/indexArticle/" + forum_id;
//			redirect(path);
//			return;
//		}
//		setAttr("info", forum_id);
//		setAttr("indexArticle", indexArticle);
//		setAttr("result", info).render("/platform/indexarticle/questionadd.html");
//	}
//	
//	/**
//	 * 修改问答
//	 * /jf/platform/indexArticle/updateQuestion
//	 */
//	public void updateQuestion() {
//		
//		final String IS_TRUE = "修改成功 ！";
//		IndexArticle indexArticle = getModel(IndexArticle.class);
//		
//		Integer forum_id = indexArticle.getForum_id();
//		String info = indexArticleService.updateQuestionService(indexArticle);
//		
//		if (IS_TRUE.equals(info)) {
//			String path = "/jf/platform/indexArticle/" + forum_id;
//			redirect(path);
//			return;
//		}
//		setAttr("info", forum_id);
//		setAttr("indexArticle", indexArticle);
//		setAttr("result", info).render("/platform/indexarticle/questionupdate.html");
//	}
	
}
