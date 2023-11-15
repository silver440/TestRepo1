package com.test.TestCases;


import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.hamcrest.DiagnosingMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.test.Base.TestBase;
import com.test.Pages.BillingInfoPage;
import com.test.Pages.HomePage;
import com.test.Pages.MyAccountPage;
import com.test.Pages.ProceedToCheckOutPage;
import com.test.Pages.ShopPage;
 
  public class AccountPageTestCases extends TestBase {
	  HomePage homepage;
	  ShopPage productPage;
	  ProceedToCheckOutPage procPage;
	  MyAccountPage myAccountPage;
	  BillingInfoPage billpage;

	public AccountPageTestCases() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Parameters("browser")
	@BeforeClass()
	void beforeStart(@Optional("chrome")String browser) {
		initial(browser);
		
	homepage=PageFactory.initElements(driver, HomePage.class);
	productPage=PageFactory.initElements(driver,ShopPage.class);
	procPage=PageFactory.initElements(driver, ProceedToCheckOutPage.class);
	myAccountPage=PageFactory.initElements(driver, MyAccountPage.class);
	billpage=PageFactory.initElements(driver, BillingInfoPage.class);
	
	}
	@AfterClass()
	void afterDone() {
	quitApp();
	}
	 @Test(enabled =false)
	  void TC_1() throws InterruptedException   {
		 homepage.clickOnmyAccount();
		 myAccountPage.getRegEmail();
		 myAccountPage.getRegPassword();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 myAccountPage.clickRegister();
	   WebElement element=driver.findElement(By.xpath("//*[text()=\"Sign out\"]"));
	   if(element.getText().contains("Sign out")) {
		   System.out.println("its working");
		   Assert.assertTrue(element.isDisplayed());
		   myAccountPage.logOout();
	   }
	 
	 }
	 @Test
	 void TC_2() {
		 homepage.clickOnmyAccount();
		 myAccountPage.logInUserName();
		 myAccountPage.loginUserPassword();
		 myAccountPage.logIn();
		 WebElement element=driver.findElement(By.xpath("//*[text()=\"Sign out\"]"));
		 Assert.assertTrue(element.isDisplayed());
		 myAccountPage.logOout();
	 }
	 @Test
	 void TC_3() {
		 homepage.clickOnmyAccount();
		 myAccountPage.logInUserName();
		 myAccountPage.loginWrongPass();
		 myAccountPage.logIn();
		 WebElement  element=driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[4]"));
		 Assert.assertTrue(element.isDisplayed());
		
	 }
 @Test
 void TC_4() {
	 homepage.clickOnmyAccount();
	 myAccountPage.loginWrongEmail();
	 myAccountPage.logIn();
	 WebElement element=driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li"));
	 Assert.assertTrue(element.isDisplayed());
	 
	 
 }
}
