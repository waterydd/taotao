package com.platform.mvc.forum;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.mvc.imgmanage.Validatecode;
import com.platform.util.PropertyUtil;
import com.platform.util.StringUtil;
import com.platform.util.oss.OssUploadThread;

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
	 */
	public void save() {
		try {
			//UploadFile uf = getFile("image_url");// 读取上传的图片文件
			UploadFile uf = getFileByConfigPath("image_url", PropertyUtil.getCarouselImgPath());
			String imgpath = uf.getFileName();
//			new Thread(new OssUploadThread(imgpath, imgTotalPath, PropertyUtil.getAdImgUploadRemotePath())).start();
			
			
			
			HomeTopPost homeTopPost = getModel(HomeTopPost.class);
			
			if (homeTopPost.getContent() == null || "".equals(homeTopPost.getContent())) {
				return;
			}
			HomeTopPost HomeTop = homeTopPostService.saveme(homeTopPost, imgpath);
			Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
			//设置保存主键为空
			HomeTop.save(pkMap);
			
			// 每次变动修改pre_common_validatecode 表validate_code字段的值
			Validatecode validatecode = Validatecode.dao.findById(3);
			validatecode.setValidate_code(System.currentTimeMillis()+validatecode.getType());
			validatecode.update();
		} catch (Exception e) {
			log.error("【保存】homeTopPost，出现异常",e);
			e.printStackTrace();
		}
		
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
		String mark = "";
		if (subjectOld.equals(subjectNew)) {// true 为没改动 //修改
			mark = "ture";
			renderText(mark);
		} else {// 增加
			mark = "false";
		}
		renderText(mark);
	}
	
	/**
	 * 更新
	 */
	public void update() {
		UploadFile uf = getFileByConfigPath("image_url2", PropertyUtil.getCarouselImgPath());
		HomeTopPost homeTopPost2 = getModel(HomeTopPost.class);//获取界面穿的参数
		String tidc = homeTopPost2.getTid().toString();//获取tid
		// 根据tid 获取原始标题 和新标题对比
		HomeTopPost homeTopPostOld = HomeTopPost.dao.findById(tidc);
		String subjectOld= StringUtil.getValue(homeTopPostOld.getSubject());
		String subjectNew= StringUtil.getValue(homeTopPost2.getSubject());
		
		// 判断标题是否改动过
		if (subjectOld.equals(subjectNew)) { // true 为没改动
			// 走 修改信息
			String ForumNameNew = homeTopPost2.getForumName();
			// 如果新板块名为空 或者新版块名与老板块名 不一致，就用新板块名
			homeTopPost2.setForumName(ForumNameNew);
			
			if (uf != null) { //当上传的文件不为空
				String imgpath = uf.getFileName();
				homeTopPost2.setImage_url(imgpath);
			}
			
			homeTopPost2.update();
			// 每次变动修改pre_common_validatecode 表validate_code字段的值
			Validatecode validatecode = Validatecode.dao.findById(3);
			validatecode.setValidate_code(System.currentTimeMillis()+StringUtil.getStringRandom(3)+validatecode.getType());
			validatecode.update();
			redirect("/jf/platform/homeTopPost");
			return;
		}
		else
		{
			String forumname = homeTopPost2.getForumName();//去界面取到的板块名字
			String advertisement = "AD";//广告
			if (advertisement.equals(forumname)) {
				
				//新增时 如果forumName 为AD 则加入那四个的默认值
				homeTopPost2.setAuthor_name("社区小编001");//作者名字
				homeTopPost2.setAuthor_id(22309);// 作者 ID
				homeTopPost2.setReplies(0);
				homeTopPost2.setViews((long) 0);
				
				
			
				homeTopPost2.setForumName(advertisement);
				homeTopPost2.update();
			}else {
				ForumThread forumThread = homeTopPostService.valiSubjectInfo(subjectNew);//调用Service的验证标题是否存在方法
				Integer fid = forumThread.getFid();
				String sql="select name from pre_forum_forum  where  fid =?";// 查询的sql语句   sqlId_splitFind
				log.info("查询的sql:"+sql);// 日志打印查询的sql语句
				ForumForum forum = ForumForum.dao.findFirst(sql,fid);//forumThread.getFid() 取到的fid值
				HomeTopPost oldhomeHomeTopPost = HomeTopPost.dao.findFirst("select * from pre_common_home_top_post where tid = ?", tidc);
				String imgUrl = oldhomeHomeTopPost.getImage_url();
				oldhomeHomeTopPost.delete();
				HomeTopPost newHomeTopPost = new HomeTopPost();
				newHomeTopPost.setForumName(forum.getName());
				newHomeTopPost.setContent(homeTopPost2.getContent());
				newHomeTopPost.setSubject(forumThread.getSubject());
				newHomeTopPost.setTid(forumThread.getTid() + "");
				newHomeTopPost.setAuthor_name(forumThread.getAuthor());
				newHomeTopPost.setAuthor_id(forumThread.getAuthorid());
				newHomeTopPost.setDateline(forumThread.getDateline());
				newHomeTopPost.setViews(forumThread.getViews());
				newHomeTopPost.setReplies(forumThread.getReplies());
				if (uf != null) 
					newHomeTopPost.setImage_url(uf.getFileName());
				else
					newHomeTopPost.setImage_url(imgUrl);
				Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
				newHomeTopPost.save(pkMap);
				
				// 每次变动修改pre_common_validatecode 表validate_code字段的值
				Validatecode validatecode = Validatecode.dao.findById(3);
				validatecode.setValidate_code(System.currentTimeMillis()+StringUtil.getStringRandom(3)+validatecode.getType());
				validatecode.update();
			}
		}
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
		String ids = getPara();
		homeTopPostService.delete("pre_common_home_top_post", getPara() == null ? ids : getPara());//调用homeTopPostService 的删除方法
		Validatecode validatecode = Validatecode.dao.findById(3);
		validatecode.setValidate_code(System.currentTimeMillis()+StringUtil.getStringRandom(3)+validatecode.getType());
		validatecode.update();
		
		redirect("/jf/platform/homeTopPost");// 跳转到当前Controller的index方法上
		
	}
	
	public static void main(String[] args) {
//		System.out.println(System.currentTimeMillis());
		System.out.println(new Date());
	}
	
}
