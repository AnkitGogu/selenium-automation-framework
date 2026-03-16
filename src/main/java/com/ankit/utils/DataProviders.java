package com.ankit.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {

	    ExcelUtil excel = new ExcelUtil(
	        "src/test/resources/testdata/loginData.xlsx",
	        "Sheet1"
	    );

	    int rowCount = excel.getRowCount();

	    Object[][] data = new Object[rowCount][4];
	    
	    for (int i = 1; i <= rowCount; i++) {

	        data[i - 1][0] = excel.getCellData(i, 0);
	        data[i - 1][1] = excel.getCellData(i, 1);
	        data[i - 1][2] = excel.getCellData(i, 2);
	        data[i - 1][3] = excel.getCellData(i, 3);

	    }

	    return data;
	}
	
	
	

}