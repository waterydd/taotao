package com.platform.mvc.foundForum;

import org.apache.log4j.Logger;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;

@Controller(controllerKey = "/jf/platform/foundForum")
public class FoundForumController extends BaseController {
	
	private static Logger log = Logger.getLogger(FoundForumController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				FoundForum.sqlId_splitPageFrom);
		render("/platform/foundForum/list.html");
	}
	
	/**
	 * 保存
	 */
	public void save() {
		FoundForum forum = getModel(FoundForum.class);
		FoundForumService FoundForumService = new FoundForumService();
		String validateResult = FoundForumService.validateSave(forum);
		if (!validateResult.equals(""))
		{
			setAttr("foundForum", forum);
			setAttr("result", validateResult).render("/platform/foundForum/add.html");
		}
		else
		{
			validateResult = FoundForumService.save(forum);
			if (validateResult.equals("")) {
				redirect("/jf/platform/foundForum");
				return;
			}
			else
			{
				setAttr("foundForum", forum);
				setAttr("result", validateResult).render("/platform/foundForum/add.html");
			}
		}
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		FoundForum foundForum = FoundForum.dao.findById(getPara());
		setAttr("foundForum", foundForum).
			render("/platform/foundForum/update.html");
	}
	
	/**
	 * 更新
	 */
	public void update() {
		FoundForum forum = getModel(FoundForum.class);
		FoundForumService FoundForumService = new FoundForumService();
		String validateResult = FoundForumService.validateUpdate(forum);
		if (!validateResult.equals(""))
		{
			setAttr("FoundForum", forum);
			setAttr("result", validateResult).render("/platform/foundForum/update.html");
		}
		else
		{
			validateResult = FoundForumService.update(forum);
			if (validateResult.equals("")) {
				redirect("/jf/platform/foundForum");
				return;
			}
			else
			{
				setAttr("FoundForum", forum);
				setAttr("result", validateResult).render("/platform/foundForum/update.html");
			}
		}
	}

	/**
	 * 删除
	 */
	public void delete() {
		String id = getPara();
		FoundForum foundForum = FoundForum.dao.findById(id);
		if (foundForum != null) {
			// 查找大板块下详细内容表是否有数据
			if (foundForum.getArticleNum() == 0)
			{
				boolean deleleResult = foundForum.delete();
				log.info("【删除大板块】执行结果：" + deleleResult + "【forumId】" + foundForum.getId());
				redirect("/jf/platform/foundForum");
			}
			else
				setAttr("result", "板块下有数据，不能删除！").redirect("/jf/platform/foundForum");
		}
	}
	

	

}
