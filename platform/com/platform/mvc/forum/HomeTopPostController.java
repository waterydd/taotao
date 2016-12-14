package com.platform.mvc.forum;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.imgmanage.Validatecode;

/**
 * 轮播图帖子管理
 * @author Administrator
 * /jf/platform/homeTopPost/delete
 * /jf/platform/homeTopPost/valiHTPubjectInfo
 * /jf/platform/homeTopPost/isalter
 * 
 */							
@Controller(controllerKey = "/jf/platform/homeTopPost")
public class HomeTopPostController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(HomeTopPostController.class);
	
	private HomeTopPostService homeTopPostService;
	
	/**
	 * 列表
	 * OK
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				HomeTopPost.sqlId_splitPageFrom);
		render("/platform/forum/list.html"); 
	}

	/**
	 * 保存
	 * 
	 */
	public void save() {
		
		UploadFile uf = getFile("image_url");// 读取上传的图片文件
		String imgpath = uf.getFileName();
		HomeTopPost homeTopPost = getModel(HomeTopPost.class);
		HomeTopPost HomeTop = homeTopPostService.saveme(homeTopPost, imgpath);
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
		//设置保存主键为空
		HomeTop.save(pkMap);
		
		// 每次变动修改pre_common_validatecode 表validate_code字段的值
		Validatecode validatecode = Validatecode.dao.findById(3);
		validatecode.setValidate_code(System.currentTimeMillis()+HomeTop.getTid()+validatecode.getType());
		validatecode.update();
		
	    redirect("/jf/platform/homeTopPost");

	}

	
	/**
	 * 验证pre_forum_thread表标题是否存在 
	 * 名字已固定
	 */
	public void valiSubjectInfo() {
		String subject=getPara("homeTopPost.subject");//获取标题
		ForumThread forumThread = homeTopPostService.valiSubjectInfo(subject);//调用Service的验证标题是否存在方法
		if (forumThread != null) {
			String mark = "true";
			renderText(mark);
		} else {
			String mark = "false";
			renderText(mark);
		}
		
	}
	
	/**
	 * 验证HomeTopPost表标题是否存在 valiHTPubjectInfo
	 * 名字已固定
	 */
	public void valiHTPubjectInfo() {
		String subject=getPara("homeTopPost.subject");//获取标题
		HomeTopPost homeTopPost = homeTopPostService.valiHTPubjectInfo(subject);//调用Service的验证标题是否存在方法
		if (homeTopPost != null) {
			String mark = "true";
			renderText(mark);
		} else {
			String mark = "false";
			renderText(mark);
		}
		
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		HomeTopPost homeTopPost = HomeTopPost.dao.findById(getPara());//根据ID查询信息
		setAttr("homeTopPost", homeTopPost);//将查询到的信息给界面
		
		render("/platform/forum/update.html");// 返回一个界面修改界面
	}

	/**
	 * 是否更改
	 */
	public void isalter() {
		Integer tid = getParaToInt("homeTopPost.tid");
		HomeTopPost homeTopPostOld = HomeTopPost.dao.findById(tid);//根据ID查询信息
		String subjectOld= homeTopPostOld.getSubject();//获取的原始标题
		String subjectNew= getPara("homeTopPost.subject");// 获取的新标题
		if (subjectOld.equals(subjectNew)) {// true 为没改动
			//修改
			String mark = "ture";
			renderText(mark);
		} else {
			// 增加
			String mark = "false";
			renderText(mark);
		}
	}
	/**
	 * 更新
	 */
	public void update() {
		
		UploadFile uf = getFile("image_url2");
		
		HomeTopPost homeTopPost2 = getModel(HomeTopPost.class);//获取界面穿的参数
		String tidc = homeTopPost2.getTid().toString();//获取tid
		// 根据tid 获取原始标题 和新标题对比
		HomeTopPost homeTopPostOld = HomeTopPost.dao.findById(tidc);
		String subjectOld= homeTopPostOld.getSubject();
		String subjectNew= homeTopPost2.getSubject();
		
		// 判断标题是否改动过
		if (subjectOld.equals(subjectNew)) { // true 为没改动
			// 走 修改信息
			String ForumNameNew = homeTopPost2.getForumName();
			String ForumNameOld = homeTopPostOld.getForumName(); // 获取原始板块名字
			System.out.println(ForumNameNew.equals(ForumNameOld));
			// 如果新板块名为空 或者新版块名与老板块名 不一致，就用新板块名
			if ( ForumNameOld == null || !ForumNameNew.equals(ForumNameOld) ) { 
				homeTopPost2.setForumName("AD");
			} else{
				homeTopPost2.setForumName(ForumNameOld);
			}
			
			if (uf != null) { //当上传的文件不为空
				String imgpath = uf.getFileName();
				homeTopPost2.setImage_url(imgpath);
			}
			
			homeTopPost2.update();
			// 每次变动修改pre_common_validatecode 表validate_code字段的值
			Validatecode validatecode = Validatecode.dao.findById(3);
			validatecode.setValidate_code(System.currentTimeMillis()+homeTopPost2.getTid()+validatecode.getType());
			validatecode.update();
			redirect("/jf/platform/homeTopPost");
			return;
		}
		
//		*****************************
		// 走增加新的信息
		String ForumNameNew = homeTopPost2.getForumName();
		HomeTopPost HomeTop = homeTopPostService.saveme(homeTopPost2, homeTopPost2.getImage_url());
		
		
		String ForumNameOld = HomeTop.getForumName(); // 获取原始板块名字
		// 如果新板块名为空 或者新版块名与老板块名 不一致，就用新板块名
		if ( ForumNameOld == null || !ForumNameNew.equals(ForumNameOld) ) { 
			HomeTop.setForumName(ForumNameNew);
		} 
		
		if (uf != null) { //当上传的文件不为空
			HomeTop.setImage_url(uf.getFileName());
		}
		
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
		//设置保存主键为空
		HomeTop.save(pkMap);
		homeTopPostService.delete("pre_common_home_top_post", tidc);//调用homeTopPostService 的删除方法
	
		// 每次变动修改pre_common_validatecode 表validate_code字段的值
		Validatecode validatecode = Validatecode.dao.findById(3);
		validatecode.setValidate_code(System.currentTimeMillis()+HomeTop.getTid()+validatecode.getType());
		validatecode.update();
		
	    redirect("/jf/platform/homeTopPost");


	}

	/**
	 * 查看
	 * 
	 */
	public void view() {
		String subject =getPara();// 获取标题
		HomeTopPost homeTopPost = HomeTopPost.dao.findById(subject);//根据标题查询 HomeTopPost 表中的信息

		setAttr("homeTopPost", homeTopPost);// 将partner表中查到的信息 传到界面上去【表 1】
		render("/platform/homeTopPost/view.html");// 跳转到view.html界面上显示出来

	}
	
	/**
	 * 删除
	 */
	public void delete() {
		homeTopPostService.delete("pre_common_home_top_post", getPara() == null ? ids : getPara());//调用homeTopPostService 的删除方法
		redirect("/jf/platform/homeTopPost");// 跳转到当前Controller的index方法上
		
	}

}
