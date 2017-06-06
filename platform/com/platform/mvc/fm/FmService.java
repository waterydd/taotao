package com.platform.mvc.fm;

import com.jfinal.plugin.activerecord.Db;
import com.platform.util.DateUtil;
import com.platform.util.PropertyUtil;
import com.platform.util.ValidateUtil;


public class FmService {
	
	/**
	 * 通过ID查询
	 * @param fmId
	 * @return
	 * 2017年5月19日 下午5:39:23
	 */
	public Fm findById(String fmId)
	{
		String sql = "SELECT id, `subject`, img_url, views, author_id, author_name, create_datetime, record_url FROM pre_fm WHERE id = ?";
		return Fm.dao.findFirst(sql, fmId);
	}
	
	public boolean save(Fm reqFm, String imgPath, String recordPath)
	{
		Fm fm = new Fm();
		fm.setSubject(reqFm.getSubject());
		fm.setImgUrl(PropertyUtil.getFmImgGetRemoteUrl() + imgPath);
		fm.setContent("");
		fm.setRecordUrl(PropertyUtil.getFmFileGetRemoteUrl() + recordPath);
		fm.setCreateDatetime(DateUtil.getNowDateStrByFormatStr(DateUtil.TOTAL_DATE_TIME_SSS));
		fm.setAuthorId(2);
		fm.setAuthorName("江南1535");
		fm.setType(reqFm.getType());
		fm.setPayAmountType("11");
		String sourceFileName = reqFm.getSourceFileName();
		if (!ValidateUtil.validateStrNullValue(sourceFileName) && sourceFileName.lastIndexOf('\\') >= 0)
		{
			sourceFileName = sourceFileName.substring(sourceFileName.lastIndexOf('\\') + 1);
		}
		fm.setSourceFileName(sourceFileName);
		return fm.save();
	}
	
	
	public boolean deleteById(String id)
	{
		String sql = "delete from pre_fm where id = ?";
		Integer deleteRow = Db.update(sql, id);
		return deleteRow != null && deleteRow > 0;
	}
}
