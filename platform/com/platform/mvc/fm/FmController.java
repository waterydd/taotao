package com.platform.mvc.fm;

import org.apache.log4j.Logger;

import com.jfinal.upload.UploadFile;
import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.platform.util.FileUtil;
import com.platform.util.PropertyUtil;
import com.platform.util.ValidateUtil;
import com.platform.util.oss.OssUploadThread;

@Controller(controllerKey = "/jf/platform/fm")
public class FmController extends BaseController {
	
	private static Logger log = Logger.getLogger(FmController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect,
				Fm.sqlId_splitPageFrom);
		render("/platform/fm/list.html");
	}
	
	/**
	 * 保存
	 */        
	public void save() {
		Fm fm = null;
		boolean saveResult = false;
		try {
			UploadFile uf = getFileByConfigPathByMaxPostSize("image_url", PropertyUtil.getFmImgUploadPath()); 
			String imgpath = uf.getFileName();
			log.info("【imgpath】" + imgpath);
			String totalImgPath = PropertyUtil.getFmImgUploadGetPath() + imgpath;
			log.info("【totalImgPath】" + totalImgPath);
			new Thread(new OssUploadThread(imgpath, totalImgPath, PropertyUtil.getFmImgUploadRemotePath())).start();
			UploadFile record = getFileByConfigPathByMaxPostSize("record_url", PropertyUtil.getFmFileUploadPath()); 
			String recordPath = record.getFileName();
			log.info("【recordPath】" + recordPath);
			String totalFilePath = PropertyUtil.getFmFileUploadGetPath() + recordPath;
			log.info("【totalFilePath】" + totalFilePath);
			new Thread(new OssUploadThread(recordPath,  totalFilePath, PropertyUtil.getFmFileUploadRemotePath())).start();
			fm = getModel(Fm.class);
			FmService fmService = new FmService();
			saveResult = fmService.save(fm, imgpath, recordPath);
		} catch (Exception e) {
			log.error("【保存音频出现异常】异常信息：" + e.getMessage());
			e.printStackTrace();
		}
		if (saveResult) {
			redirect("/jf/platform/fm");
			return;
		}
		else
		{
			setAttr("fm", fm);
			setAttr("result", "保存失败，请稍后重试").render("/platform/fm/add.html");
		}
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Fm fm = Fm.dao.findById(getPara());
		setAttr("fm", fm).render("/platform/fm/update.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		String id = getPara();
		try {
			new FmService().deleteById(id);
		} catch (Exception e) {
			log.error("【删除音频】失败异常信息：" + e.getMessage() + "【id】" + id);
			e.printStackTrace();
		}
		redirect("/jf/platform/fm");
	}
	
	/**
	 * 更新
	 */        
	public void update() {
		Fm fm = null;
		boolean saveResult = false;
		String imgpath = null;
		String recordPath = null;
		try {
			UploadFile uf = getFileByConfigPathByMaxPostSize("image_url", PropertyUtil.getFmImgUploadPath()); 
			fm = getModel(Fm.class);
			if (fm != null)
			{
				if (uf != null)
				{
					imgpath = uf.getFileName();
					log.info("【imgpath】" + imgpath);
					String totalImgPath = PropertyUtil.getFmImgUploadGetPath() + imgpath;
					log.info("【totalImgPath】" + totalImgPath);
					String key = FileUtil.getFileName(fm.getImgUrl());
					new Thread(new OssUploadThread(key, totalImgPath, PropertyUtil.getFmImgUploadRemotePath())).start();
					fm.setImgUrl(PropertyUtil.getFmImgGetRemoteUrl() + key);
				}
				UploadFile record = getFileByConfigPathByMaxPostSize("record_url", PropertyUtil.getFmFileUploadPath()); 
				if (record != null)
				{
					recordPath = record.getFileName();
					log.info("【recordPath】" + recordPath);
					String totalFilePath = PropertyUtil.getFmFileUploadGetPath() + recordPath;
					log.info("【totalFilePath】" + totalFilePath);
					String key = FileUtil.getFileName(fm.getRecordUrl());
					new Thread(new OssUploadThread(key, totalFilePath, PropertyUtil.getFmFileUploadRemotePath())).start();
					fm.setRecordUrl(PropertyUtil.getFmFileGetRemoteUrl() + key);
				}
				String sourceFileName = fm.getSourceFileName();
				if (!ValidateUtil.validateStrNullValue(sourceFileName) && sourceFileName.lastIndexOf('\\') >= 0)
				{
					sourceFileName = sourceFileName.substring(sourceFileName.lastIndexOf('\\') + 1);
					fm.setSourceFileName(sourceFileName);
				}
				saveResult = fm.update();
			}
		} catch (Exception e) {
			log.error("【更新音频出现异常】异常信息：" + e.getMessage());
			e.printStackTrace();
		}
		if (saveResult) {
			redirect("/jf/platform/fm");
			return;
		}
		else
		{
			setAttr("fm", fm);
			setAttr("result", "更新失败，请稍后重试").render("/platform/fm/update.html");
		}
	}
	
	/**
	 * 准备更新
	 */
	public void editContent() {
		Fm fm = Fm.dao.findById(getPara());
		setAttr("fm", fm).render("/platform/fm/editContent.html");
	}
	
	/**
	 * 准备更新
	 */
	public void updateContent() {
		Fm fm = Fm.dao.findById(getPara("fm.id"));
		String content = getPara("fm.content");
		content = content.replaceAll("\"", "'");
		fm.setContent(content);
		fm.update();
		redirect("/jf/platform/fm");
		return;
	}
	
}
