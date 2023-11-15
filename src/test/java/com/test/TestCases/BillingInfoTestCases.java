package com.test.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.test.Pages.ProceedToCheckOutPage;

public class BillingInfoTestCases extends TestBase{
	HomePage homePage;
	BillingInfoPage billingInfoPage;
	ProceedToCheckOutPage prcheckPage;
	
	

	public BillingInfoTestCases() throws FileNotFoundException {
		super();
		
		
	}
	 @Parameters("browser")
	 @BeforeClass
	 void beforeStart(@Optional("chrome")String browser) {
		 initial(browser);
		 
		 homePage=PageFactory.initElements(driver,HomePage.class);
		 prcheckPage=PageFactory.initElements(driver, ProceedToCheckOutPage.class);
		 billingInfoPage=PageFactory.initElements(driver, BillingInfoPage.class);
		 
	 }
	 @AfterClass
	 void afterDone() {
	 quitApp();
	 }
	 @Test
	  void TC_1() throws InterruptedException {
		 homePage.navigatingTobasket();
		 homePage.addBooktoBasket();
		 homePage.checkOut();
		 prcheckPage.changeQuantitybook();
		 Thread.sleep(1000);
		 prcheckPage.updateB();
		 String  num1=prcheckPage.getTotalPrice();
		 System.out.println("Total price before tax: "+num1);
		 String num2=prcheckPage.getTaxPrice();
		 System.out.println("Tax price alone:"+num2);
		Assert.assertNotSame(num1, num2);
		 prcheckPage.ProceedToCheckOut();
		
	 }
	 @Test
	 public void TC_2() throws InterruptedException {
		 WebDriverWait wait=new WebDriverWait(driver, 30);
	       wait.until(ExpectedConditions.visibilityOf(billingInfoPage.firstName));
	       Assert.assertTrue(billingInfoPage.firstName.isDisplayed());
	       System.out.println("BillingPage is displayed");
	    String[] billingStrings= {"Layla","Lima","idn4230@gmail.com","2348793432","UnitedStates","2301 Westport","Altun","Joplin","Missouri","64804"};
        billingInfoPage.fillandSendBillinfor(billingStrings);
      billingInfoPage.clickOnplaceOrder();
	 }
	 

}
