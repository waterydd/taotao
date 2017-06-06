package com.platform.mvc.Express;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.platform.annotation.Service;
import com.platform.mvc.base.BaseService;

@Service(name = ExpressService.serviceName)
public class ExpressService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ExpressService.class);
	
	public static final String serviceName = "expressService";
	
	/**
	 * 增加快递 Service
	 * @param express
	 * @return
	 */
	public String saveService(Express express) {
		String code = express.getCode();
		String name = express.getName();
		Integer Display_order = express.getDisplay_order();
		
		// 判断数据是否已存在
		Express newExpress = Express.dao.findById(code);
		// 存在就查找那里重复
		if (newExpress != null) {
			return "快递代码重复 ！";
		}
		
		// 判断快递名 是否已存在
		List<Express> expressNameList = new ArrayList<Express>();
		expressNameList = Express.dao.find("select * from pre_kuaidi where name = ?", name);
		Integer nameSize = expressNameList.size();
		if (nameSize > 0) {
			return "快递名字重复 ！";
		}
		
		// 判断快递名显示顺序 是否已存在
		List<Express> display_orderExpress = new ArrayList<Express>();
		display_orderExpress = Express.dao.find("select * from pre_kuaidi where display_order = ?", Display_order);
		Integer display_orderSize = display_orderExpress.size();
		if (display_orderSize > 0) {
			return "快递名显示顺序重复 ！";
		}
		
		Map<String,Object> pkMap=new HashMap<String,Object>();// 创建一个 HashMap的容器
		// 判断保存是否成功
		Boolean istrue = express.save(pkMap);
		if (!istrue) {
			return "保存失败 ！";
		}
		
		return "增加成功 ！";
	}
	
	/**
	 * 更新Service
	 * @param express
	 * @return
	 */
	public String updateService(Express express) {
		String code = express.getCode();
		String name = express.getName();
		Integer Display_order = express.getDisplay_order();
		
		// 判断主键 是否已存在
		Express newExpress = Express.dao.findById(code);
		if (newExpress == null) {
			return "数据不存在 ！";
		}
		
		// 判断快递名 是否已存在
		List<Express> expressNameList = new ArrayList<Express>();
		expressNameList = Express.dao.find("select * from pre_kuaidi where name = ?", name);
		Integer nameSize = expressNameList.size();
		if (nameSize > 1) {
			return "快递名字重复 ！";
		}
		if (nameSize != 0) {
			
			String codeList = expressNameList.get(0).getCode();
			if (!codeList.equals(code)) {
				
				System.out.println("这不是同一条数据，所以重复");
				return "快递名字重复 ！";
			}
		}
		
		// 判断快递名顺序 是否已存在
		List<Express> display_orderExpress = new ArrayList<Express>();
		display_orderExpress = Express.dao.find("select * from pre_kuaidi where display_order = ?", Display_order);
		Integer display_orderSize = display_orderExpress.size();
		if (display_orderSize > 1) {
			return "快递名显示顺序重复 ！";
		}
		if (display_orderSize != 0) {
			
			String codeListdis = display_orderExpress.get(0).getCode();
			// 把从数据库里取到的和页面传过来的 比较
			if (!codeListdis.equals(code)) {
				return "快递名显示顺序重复 ！";
			}
		}
		
		// 判断修改是否成功
		Boolean istrue = express.update();
		if (!istrue) {
			return "修改失败 ！";
		}
		return "修改成功 ！";
	}
	
	
}
