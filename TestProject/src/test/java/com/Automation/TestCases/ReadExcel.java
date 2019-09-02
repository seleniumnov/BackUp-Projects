package com.Automation.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {

		File file = new File("C:\\Users\\suresh.kurry\\eclipse-workspace\\TestData.xlsx");
		FileInputStream fin = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int row = sh.getPhysicalNumberOfRows();
		int col = sh.getRow(0).getPhysicalNumberOfCells();
		String key;
		String value;
		HashMap<String, String> map = new HashMap<String, String>();
		List<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {
				
				key = sh.getRow(0).getCell(j).getStringCellValue().trim();
				
				if (sh.getRow(i).getCell(j).getCellType() == CellType.STRING) {

					value = sh.getRow(i).getCell(j).getStringCellValue().trim();
	
				} else {

					value = sh.getRow(i).getCell(j).getRawValue();
				}
				
				map.put(key, value);
			}
			
			data.add(map);
		}
		System.out.println(data);
		wb.close();
		fin.close();
		
	}

}
