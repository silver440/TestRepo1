package com.test.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import com.google.common.base.StandardSystemProperty;


public class TestBase {
public  static WebDriver driver;
public WebDriver wait;
 public 	Properties prop;
	final int PAGE_LOAD_TIME=10;
	final int IMPLICIT_WAIT=10;
	final int EXPLICIT_WAIT=10;
	 public Logger logger;
	public TestBase() throws FileNotFoundException {
	 prop=new Properties();
	
 logger=LogManager.getLogger(TestBase.class);
	 
	 FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
	 try {
		prop.load(fin);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}
	public void initial(String browsername) {
		driver=getBrowseer(browsername);
	   logger.info("what is upp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(EXPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}
	public void quitApp() {
		driver.close();
		driver.quit();
		
	}
	
	private WebDriver getBrowseer(String browsernm) {
		WebDriver crnDriver=null;
		String prjPath=System.getProperty("user.dir");
		if(browsernm.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",prjPath+"\\src\\test\\java\\Driver\\chromedriver.exe");
			crnDriver=new ChromeDriver();
		} else  if(browsernm.equalsIgnoreCase("Internet Explore")) {
			crnDriver=new InternetExplorerDriver();
		} else if (browsernm.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",prjPath+"c:\\selenium\\msedgedriver.exe");
			crnDriver=new EdgeDriver();
			
		}
			
		
	
		
		return crnDriver;
	}
}
