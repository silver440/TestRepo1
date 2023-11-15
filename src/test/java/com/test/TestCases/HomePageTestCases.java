package com.test.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.Base.TestBase;
import com.test.Pages.HomePage;
import com.test.Pages.ProceedToCheckOutPage;
import com.test.Pages.ShopPage;



public class HomePageTestCases  extends TestBase{
	HomePage homePage;
    ShopPage shopPage;
    ProceedToCheckOutPage prCheckOutPage;

	public HomePageTestCases() throws FileNotFoundException {
		super();
		}
	@Parameters("browser")
	@BeforeClass
	void beforeStart(@Optional("Chrome") String browser) {
	
		initial(browser);
		homePage=PageFactory.initElements(driver, HomePage.class);
		shopPage=PageFactory.initElements(driver, ShopPage.class);
		prCheckOutPage=PageFactory.initElements(driver, ProceedToCheckOutPage.class);
	}
	@AfterClass
	void afterFinish() {
		quitApp();
		}
	@Test(enabled = false)
	void TC_1() {
		homePage.clickShopMenu();
	    shopPage.clickOnHomeMenue();
		int slidersCnt=homePage.getSliderCnt();
		assertEquals(slidersCnt, 3);
	}
	@Test(enabled=false)//retryAnalyzer = Listeners.RetryAnalyzer.class)
	void TC_2() {
		homePage.clickShopMenu();
	     shopPage.clickOnHomeMenue();
		int newArrivalscnt=homePage.getArrivals();
		assertEquals(newArrivalscnt, 3);
		
	}
	@Test(enabled=false)
	void TC_3() {
		homePage.clickShopMenu();
		shopPage.clickOnHomeMenue();
		int newArrivalscnt=homePage.getArrivals();
		assertEquals(newArrivalscnt, 3);
	List<String> books=homePage.getBookNames();
	    System.out.println(books.size());
		homePage.navigatingTobasket();
	   logger.info("addedTobasket");
	   
	}
	@Test(enabled=false)
	void TC_4() {
		homePage.clickShopMenu();
		shopPage.clickOnHomeMenue();
		int newArrivalscnt=homePage.getArrivals();
		assertEquals(newArrivalscnt, 3);
		homePage.navigatingTobasket();
		homePage.getDiscription();
		  boolean res= driver.getPageSource().contains("It would seem that ");
		  	
	        if(res==true) {
	        	Assert.assertTrue(true);
	        }
	        else {
	        	Assert.assertTrue(false);
	        }
	     
	        String num=homePage.showingMenueItem();
            assertEquals(num, num);
	}
	@Test(enabled = false)
	void TC_5() {
		homePage.navigatingTobasket();
		homePage.getReview();
		boolean res= driver.getPageSource().contains("There are no reviews yet.");
			  	
		        if(res==true) {
		        	Assert.assertTrue(true);
		        }
		        else {
		        	Assert.assertTrue(false);
		        }
		        homePage.getPriceofBook();
		       homePage.addBooktoBasket();
		      String numString= homePage.addLargeNumber();
		     WebElement resElement=driver.findElement(By.xpath("//div[@class=\"woocommerce-message\"]"));
		    
	         String resText=   resElement.getText();
	            Assert.assertFalse(resText.contains(numString));
        	 homePage.addBooktoBasket();
             Assert.assertTrue( resElement.isDisplayed());
             String num=homePage.showingMenueItem();
             assertEquals(num, num);
	} 
	@Test()
	void TC_6() throws IOException {
		homePage.clickShopMenu();
		shopPage.clickOnHomeMenue();
		int newArrivalscnt=homePage.getArrivals();
		assertEquals(newArrivalscnt, 3);
		homePage.navigatingTobasket();
		homePage.addBooktoBasket();
		homePage.pupMessage();
		
	WebElement messagElement=	driver.findElement(By.xpath("//*[@class=\"woocommerce-message\"]/a"));
		assertEquals(true,messagElement.isDisplayed());
		
		homePage.checkOut();
//		 String num=homePage.showingMenueItem();
//		  System.out.println("price of the book"+ num);
//         assertEquals(num, num);
		
		
	}
	@Test(enabled = false)
	void TC_7() throws InterruptedException {
        prCheckOutPage.getCouponCode();
		prCheckOutPage.itemRemove();
//		prCheckOutPage.getUndoMessage();
	 //   Thread.sleep(1000);
//	String num=homePage.showingMenueItem();
//        assertEquals(num, num);
		
}
	@Test(dependsOnMethods = {"TC_6"})
	void TC_8() throws InterruptedException {
		prCheckOutPage.changeQuantitybook();
		prCheckOutPage.updateB();
		String num=prCheckOutPage.itemPriceOnTheMeneu();
		System.out.println("item price changes after the update:"+ num);
         assertEquals(num, num);
		
			}
	@Test(dependsOnMethods = {"TC_8"})
	void TC_9() throws InterruptedException {
	String  num1=	 prCheckOutPage.getTotalPrice();
	 System.out.println("Total price before tax: "+num1);
	
//	 Float floatValue=Float.valueOf(num1).floatValue();
//	 System.out.println(floatValue);
//	 float floatV=Float.parseFloat(num1);
//	 System.out.println(floatV);
	 String num2=prCheckOutPage.getTaxPrice();
	 System.out.println("Total price tax:"+ num2);
	prCheckOutPage.ProceedToCheckOut();
	}
		

		

}