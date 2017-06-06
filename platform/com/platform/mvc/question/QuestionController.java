package com.platform.mvc.question;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

/**
 * XXX 管理	
 * 描述：
 * 
 * /jf/platform/question
 * /jf/platform/question/save
 * /jf/platform/question/edit
 * /jf/platform/question/update
 * /jf/platform/question/view
 * /jf/platform/question/delete
 * /common/question/add.html
 * 
 */
@Controller(controllerKey = "/jf/platform/question")
public class QuestionController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(QuestionController.class);
	
	private QuestionService questionService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect, Question.sqlId_splitPageFrom);
		render("/platform/question/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(QuestionValidator.class)
	public void save() {
		getModel(Question.class).save();
		render("/platform/question/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Question question = Question.dao.findById(getPara());
		setAttr("question", question);
		render("/platform/question/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(QuestionValidator.class)
	public void update() {
		getModel(Question.class).update();
		redirect("/jf/platform/question");
	}

	/**
	 * 查看
	 */
	public void view() {
		Question question = Question.dao.findById(getPara());
		setAttr("question", question);
		render("/platform/question/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
//		questionService.delete("pre_question", getPara() == null ? ids : getPara());
		redirect("/jf/platform/question");
	}
	
}
