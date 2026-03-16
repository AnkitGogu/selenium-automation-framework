package com.ankit.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelUtil(String filePath, String sheetName) {

	    try {

	        FileInputStream file = new FileInputStream(filePath);

	        workbook = new XSSFWorkbook(file);

	        sheet = workbook.getSheet(sheetName);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
	
	public int getRowCount() {
	    return sheet.getLastRowNum();
	}
	
	
	public String getCellData(int row, int column) {
	    return sheet.getRow(row).getCell(column).toString();
	}

}