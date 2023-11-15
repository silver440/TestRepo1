package com.test.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.TestBase;

public class UtilClass extends TestBase{
	public UtilClass() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public  static void takeScreenShot(String outFileName) throws IOException {
		TakesScreenshot scrShot=(TakesScreenshot) driver;
		 File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		 File dFile=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\test\\ScreenShot"+
				 outFileName+" .png");
		 FileUtils.copyFile(scrFile, dFile);
	}
	public static String[][] getAccntFromExcel(String fpath) {
		String[][] reStrings= null;
		try {
			String string="C:\\Users\\Owner\\Desktop\\home work folder\\IndiaBazarnull";
			System.out.println(fpath);
			FileInputStream fin=new FileInputStream(fpath);
			XSSFWorkbook xwbook=new XSSFWorkbook(fin);
			XSSFSheet xSheet=xwbook.getSheetAt(0);
			int rowCnt=xSheet.getPhysicalNumberOfRows();
			reStrings=new String[rowCnt][2];
			
			for(int i=0;i<rowCnt-1;i++) {
				Row row=xSheet.getRow(i+1);
				if(row.getCell(0) !=null)
					reStrings[i][0]=row.getCell(0).getStringCellValue();
				else
					reStrings[i][0]="";
				
				if(row.getCell(1) !=null)
					reStrings[i][1]=row.getCell(1).getStringCellValue();
				else 
					reStrings[i][1]="";
			}
			
			reStrings[rowCnt-1][0]="";
			reStrings[rowCnt-1][1]="";
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reStrings;
	}

	 
	}
	
	
	
	
	
	

 

