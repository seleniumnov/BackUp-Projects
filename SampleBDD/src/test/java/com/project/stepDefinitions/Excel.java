package com.project.stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	
	static Map<String, String> data = new HashMap<String, String>();
	static List<Map<String, String>> list  = new ArrayList<Map<String,String>>();
	static String key = null;
	static String value = null;

	public static void main(String[] args) {
		
		try {
			File file = new File("C:\\Users\\suresh.kurry\\Downloads\\TestData.xlsx");
			FileInputStream fin = new FileInputStream(file.getAbsolutePath());
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet sh = wb.getSheet("Sheet1");
			int rows = sh.getPhysicalNumberOfRows();
			int cols = sh.getRow(0).getPhysicalNumberOfCells();
			
			for(int i=1;i<rows;i++) {
				
				for(int j=0;j<cols;j++) {
					
					key = sh.getRow(0).getCell(j).getStringCellValue();
					
					if(sh.getRow(i).getCell(j).getCellType() == CellType.STRING) {
						
						value = sh.getRow(i).getCell(j).getStringCellValue();
						
					}else if(sh.getRow(i).getCell(j).getCellType() == CellType.NUMERIC){
						
						value = String.valueOf(sh.getRow(i).getCell(j).getNumericCellValue());
						
					}else {
						
						value = sh.getRow(i).getCell(j).getRawValue();
					}
					
					data.put(key, value);
				}
				
				list.add(data);
				
			}
			System.out.println(list.size());
			wb.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
