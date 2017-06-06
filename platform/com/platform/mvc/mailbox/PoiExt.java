package com.platform.mvc.mailbox;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PoiExt {
	
	
	/**
	 * 分析excel的内容
	 * @param path
	 * @return
	 */
	@SuppressWarnings("resource")
	public static List<Map<Integer, String>> dealDataByPath(String path) {
		List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
		// 工作簿
		HSSFWorkbook hwb = null;
		XSSFWorkbook xwb = null;
		String hssf = "xls"; //2003版本
		String xssf = "xlsx"; // 2007版本
		try {
			//取后缀
			String postfix = path.substring(path.lastIndexOf('.') + 1);
			System.out.println(postfix);
			
			if (hssf.equals(postfix)) {
				System.out.println("走了2003版");
				hwb = new HSSFWorkbook(new FileInputStream(new File(path)));
				
				HSSFSheet sheet = hwb.getSheetAt(0);	// 获取到第一个sheet中数据
				
				for(int i = 0;i<sheet.getLastRowNum() + 1; i++) {// 第二行开始取值，第一行为标题行
					HSSFRow row = sheet.getRow(i);		// 获取到第i列的行数据(表格行)
					
					if (row != null) {
						Map<Integer, String> map = new HashMap<Integer, String>();

						for(int j=0;j<row.getLastCellNum(); j++) {
							
							HSSFCell cell = row.getCell(j);	// 获取到第j行的数据(单元格)
							if (cell == null) {
								break;
							}

							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							
							map.put(j, cell.getStringCellValue());
						}
						
						list.add(map);
						
					}
					
					
				}
				
			} else if (xssf.equals(postfix)) {
				System.out.println("走了2007版");
				xwb = new XSSFWorkbook(new FileInputStream(new File(path)));
				
				XSSFSheet sheet = xwb.getSheetAt(0);	// 获取到第一个sheet中的数据
				
				for(int i = 0;i<sheet.getLastRowNum() + 1; i++) {// 第二行开始取值，第一行为标题行
					XSSFRow row = sheet.getRow(i);		// 获取到第i列的行数据(表格行)
					if (row != null) {
						Map<Integer, String> map = new HashMap<Integer, String>();
	
						for(int j=0;j<row.getLastCellNum(); j++) {
							XSSFCell cell = row.getCell(j);	// 获取到第j行的数据(单元格)
							System.out.println(cell);
							if (cell == null) {
								break;
							}
							cell.setCellType(XSSFCell.CELL_TYPE_STRING);
							map.put(j, cell.getStringCellValue());
						}
						
						list.add(map);
					}
				}
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public static List<Map<Integer, String>> ReadExcel(String filename, String sql,int ColCount) {
		List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>(); //新加
		Map<String, Object> map = null;
		try {
			@SuppressWarnings("resource")
			HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(filename));
			//读取第一个工作薄
			HSSFSheet sheet = wookbook.getSheet("Sheet1");
			//读取工作薄里共有多少行
			int rows = sheet.getPhysicalNumberOfRows(); //获取不为空的行个数
			//创建一个二维数组  rows 行  ColCount 数
			Object[][] paras = new Object[rows][ColCount];
			//循环读每行的数据
			for (int i = 1; i < rows; i++) {
				//取这一行的值
				HSSFRow row = sheet.getRow(i);
				//判断取到的是否为空值
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();  //获取不为空的列个数
					
					Map<Integer, String> map1 = new HashMap<Integer, String>(); // 后加的
					
					// 循环读取不为空的列的 数据
					for (int j = 0; j < cells; j++) {
						// 取这一列的数据
						HSSFCell cell = row.getCell(j);
						// 判断这一列是否为空
						if (cell != null) {
							
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							
							map1.put(j, cell.getStringCellValue());
							System.out.println(map1);
							// 获取值的类型 
//							switch (cell.getCellType()) {
//							case HSSFCell.CELL_TYPE_FORMULA: //公式型 2
//								break;
//								
//							case HSSFCell.CELL_TYPE_NUMERIC: //数值型 0
//								paras[i][j] = cell.getNumericCellValue(); //读取为数值类型的单元格内容 
//								break;
//								
//							case HSSFCell.CELL_TYPE_STRING: //字符串型 1
//								paras[i][j] = cell.getStringCellValue(); //读取为字符串类型的单元格内容 
//								break;
//								
//							default: 
//								paras[i][j] = null;
//								break;
//							}
							
						}// if的结束点
					}// jfor循环的结束点
					
					list.add(map1);
				}
			}
			
			
//			System.out.println(paras);
//			int[] ret = Db.batch(sql, paras, 10);
//			int s = 0, l = 0;
//			for (int i = 0; i < ret.length; i++)
//				if (ret[i] == 1)
//					s++;
//				else
//					l++;
//			map = new HashMap<String, Object>();
//			map.put("success", s);
//			map.put("lost", l);
//			map.put("count", ret.length);
//			wookbook = null;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * @param args
	 * 测试
	 * 
	 */
	public static void main(String[] args) {

		List<Map<Integer, String>> list = dealDataByPath("e:\\student_info.xls");	// 分析EXCEL数据
		
		for(Map<Integer,String> map:list) { // 遍历取出的数据，并保存
			
			
			System.out.println(map.get(0).toString());
			String email =  map.get(0).toString();
			System.out.println(email);
			
			Mailbox m = new Mailbox();
			m.setEmail(email);
			m.save();
			System.out.println(m);
			
		}


		System.out.println("成功！");
	
	}

}