package com.crm.audodeskgenericutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Generic are used to fetch and write data from excel workbook
 * @author Bharath Kumar
 *
 */
public class ExcelUtility {
	
	/**
	 * Method reads the Test data from excel workbook at given sheetName,row count and cell count, 
	 * returns the data as String 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return String
	 * @throws Throwable 
	 */
	public String getDataExcelWorkbook(String sheetName, int rowNo, int cellNo) throws Throwable {
		
			FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fil);
			String cellValue = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
			return cellValue;
		} 
	

}
