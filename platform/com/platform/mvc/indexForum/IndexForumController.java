package com.platform.mvc.indexForum;

import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

@Controller(controllerKey = "/jf/platform/indexForum")
public class IndexForumController extends BaseController {
	
	private static Logger log = Logger.getLogger(IndexForumController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				IndexForum.sqlId_splitPageFrom);
		render("/platform/indexForum/list.html");
	}
	
	/**
	 * 保存
	 */
	public void save() {
		IndexForum forum = getModel(IndexForum.class);
		IndexForumService indexForumService = new IndexForumService();
		String validateResult = indexForumService.validateSave(forum);
		if (!validateResult.equals(""))
		{
			setAttr("indexForum", forum);
			setAttr("result", validateResult).render("/platform/indexForum/add.html");
		}
		else
		{
			validateResult = indexForumService.save(forum);
			if (validateResult.equals("")) {
				redirect("/jf/platform/indexForum");
				return;
			}
			else
			{
				setAttr("indexForum", forum);
				setAttr("result", validateResult).render("/platform/indexForum/add.html");
			}
		}
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		IndexForum indexForum = IndexForum.dao.findById(getPara());
		setAttr("indexForum", indexForum).
			render("/platform/indexForum/update.html");
	}
	
	/**
	 * 更新
	 */
	public void update() {
		IndexForum forum = getModel(IndexForum.class);
		IndexForumService indexForumService = new IndexForumService();
		String validateResult = indexForumService.validateUpdate(forum);
		if (!validateResult.equals(""))
		{
			setAttr("indexForum", forum);
			setAttr("result", validateResult).render("/platform/indexForum/update.html");
		}
		else
		{
			validateResult = indexForumService.update(forum);
			if (validateResult.equals("")) {
				redirect("/jf/platform/indexForum");
				return;
			}
			else
			{
				setAttr("indexForum", forum);
				setAttr("result", validateResult).render("/platform/indexForum/update.html");
			}
		}
	}

	/**
	 * 删除
	 */
	public void delete() {
		String id = getPara();
		IndexForum indexForum = IndexForum.dao.findById(id);
		if (indexForum != null) {
			// 查找大板块下详细内容表是否有数据
			if (indexForum.getArticleNum() == 0)
			{
				boolean deleleResult = indexForum.delete();
				log.info("【删除大板块】执行结果：" + deleleResult + "【forumId】" + indexForum.getId());
				redirect("/jf/platform/indexForum");
			}
			else
				setAttr("result", "板块下有数据，不能删除！").redirect("/jf/platform/indexForum");
		}
	}
	

	

}
