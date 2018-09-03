package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=30;
	public static String SHEET_NAME_PATH="D:\\Workspace-eclipse\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";


	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}


	public static Object[][] readData(String sheetName) throws IOException{
		FileInputStream fis = new FileInputStream(SHEET_NAME_PATH);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}


	public static void takeScreenshot() {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("D:\\Workspace-eclipse\\FreeCRMTest\\Screenshot\\anju.png"));

		driver.quit(); 
	}
}
