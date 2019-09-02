package com.Automation.SmokeTests;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public HashMap<String, String> map = new HashMap<String, String>();

	public static List<HashMap<String, String>> data = new ArrayList<>();

	public static void main(String[] args) {

		new ReadExcel().readExcel();
		
		System.out.println(data.get(1).get("Name"));
		
		
	}

	public static List<HashMap<String, String>> readExcel() {
		
		try {
			
			File file = new File("C:\\Users\\suresh.kurry\\Downloads\\TestData.xlsx");
			FileInputStream fin = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet sh = wb.getSheet("Sheet1");
			
			//Get 0 Header Elements
			Row row = sh.getRow(0);
			
			for(int i =1; i<sh.getPhysicalNumberOfRows(); i++) {
				
				Row rowdata = sh.getRow(i);
				
				HashMap<String, String> currentRowMap = new HashMap<String, String>();
				
				for(int j=0; j<rowdata.getPhysicalNumberOfCells(); j++) {
					
					Cell currentCell = rowdata.getCell(j);
					
					if(currentCell.getCellType() == CellType.STRING) {
						
						//System.out.println(currentCell.getStringCellValue() + "\t");
						currentRowMap.put(row.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						
					}else if(currentCell.getCellType() == CellType.NUMERIC){
						
						//System.out.println((int)(currentCell.getNumericCellValue()) + "\t");
						
						int d = (int)(currentCell.getNumericCellValue());
						
						currentRowMap.put(row.getCell(j).getStringCellValue(), 
								String.valueOf(d));
					}				
				}
				data.add(currentRowMap);
			}
			
			wb.close();
			fin.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return data;
	}

}
