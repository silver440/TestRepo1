package com.test.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;




import org.apache.bcel.verifier.statics.DOUBLE_Upper;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.test.Base.TestBase;
import com.test.Pages.BillingInfoPage;
import com.test.Pages.HomePage;
import com.test.Pages.MyAccountPage;
import com.test.Pages.ProceedToCheckOutPage;
import com.test.Pages.ShopPage;




public class ShopPageTestCases extends TestBase	 {
	HomePage homepage;
	  ShopPage shopPage;
	  ProceedToCheckOutPage procPage;
	  MyAccountPage myAccountPage;
	  BillingInfoPage billpage;
	  int books;

	public ShopPageTestCases() throws FileNotFoundException {
		super();
		
	}
	@Parameters("browser")
	@BeforeClass()
	void beforeStart(@Optional("chrome")String browser) {
		initial(browser);
		
	homepage=PageFactory.initElements(driver, HomePage.class);
	shopPage=PageFactory.initElements(driver,ShopPage.class);
	procPage=PageFactory.initElements(driver, ProceedToCheckOutPage.class);
	myAccountPage=PageFactory.initElements(driver, MyAccountPage.class);
	billpage=PageFactory.initElements(driver, BillingInfoPage.class);
	
	
	}
	@AfterClass()
	void afterDone() {
      quitApp();

}
	@Test()
	void TC_1() {
		 homepage.clickShopMenu();

	}
	@Test()
	void TC_2() {
	//	shopPage.getSlider();
	 shopPage.getSlider2();
 shopPage.clickFilter();
	}
	@Test(enabled = false)
	 void TC_3() {
		ArrayList<String> priceArrayList=shopPage.getSliderPrice();
		int min=Integer.parseInt(priceArrayList.get(0));
		int max=Integer.parseInt(priceArrayList.get(1));
		System.out.println("the max"+max+"the min"+min);
	}
	@Test()
	void TC_4() {
		String string ="";
		WebElement element=driver.findElement(By.xpath("(//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[2]/div[1]/span)[1]"));
		String string1=element.getText();
		 string1 =string1.replace("₹","");
		 string=string+string1;
		
			int minNumber=Integer.parseInt(string);
			System.out.println("Minimum Number: "+minNumber);
			
			
			String rest ="";
			WebElement element1=driver.findElement(By.xpath("(//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[2]/div[1]/span)[2]"));
			String string2=element1.getText();
		string2 =string2.replace("₹","");
			 rest=rest+string2;
		
				int maxNumber=Integer.parseInt(rest);
				System.out.println("Maximum number: "	+maxNumber);
		
	
	 	books=shopPage.getBooksListOnthescreen();
		System.out.println("counts of the books on the screen is :"+ books);
		int booksforsale=shopPage.getBooksforsale();
		 System.out.println("books for sale are:"+ booksforsale);
			ArrayList<String > priceArrayList=shopPage.getBooksvalue();
           System.out.println(priceArrayList);
			System.out.println(priceArrayList.toString());
	     for(String elem1:priceArrayList) {
	    Double	 curValue=Double.parseDouble(elem1);
	    if(curValue<minNumber || curValue> maxNumber) {
	    	System.out.println("Books not in range of the filtered price");
	    }
	     else {
	    	 }
			
			}
	     System.out.println("books are in the range of filterd price ");
		}
	
		@Test()
		void TC_5() {
			int bookList=shopPage.getBooksListOnthescreen();
			System.out.println( "Total books listed under product is "+bookList);
			Assert.assertEquals(bookList, books);
//			String s=shopPage.getNameofProduct();
//			System.out.println(s);
			ArrayList<String >booksUnderProductArrayList=shopPage.getNameofProduct();
			System.out.println(booksUnderProductArrayList);
			  
		}
			@Test()
			void TC_6() {
				int i=3;
			int numberofCount=	shopPage.getclickedNumber();
			System.out.println("Total books onthe clicked book list :"+numberofCount);
           int numberofbookonthescreen=shopPage.getBooksListOnthescreen();
           System.out.println("total boosk list according to cliked list"+numberofbookonthescreen);
         Assert.assertEquals(numberofbookonthescreen, numberofCount);
				
			}
		@Test()
		void TC_7() {
			WebElement dROElement=driver.findElement(By.xpath("//*[@name=\"orderby\"]"));
			if(dROElement.isEnabled()&& dROElement.isDisplayed()) {
				System.out.println("Dropdown is enabled and visible");
			}	else {
					System.out.println("Dropdown is not visible");
				}
		     Select select=new Select(dROElement);
		     if(select.isMultiple()) {
		    	 System.out.println("Dropdown list accept multiple choices");
		     }else {
		    	 System.out.println("Dropdown doesnt allow multiple choices");
		     }
		     int size=select.getOptions().size();
		     System.out.println("Size of the dropdown is "+size);
		    String string=     select.getFirstSelectedOption().getText();
		    System.out.println(string);
		    
		      
			}
		@Test()
		void TC_8() {
			shopPage.getSorting();
			System.out.println("Sorting Selected");
		 int b=	shopPage.getScreenMatchingcount();
		    System.out.println("Sorted Item count ont the screen is:"+b);
		    ArrayList<String> sortedPriceArrayList=shopPage.getSortedPriceList();
		    System.out.println(sortedPriceArrayList);

		}
		@Test()
		void TC_9() throws InterruptedException {		 
			shopPage.getBooksToChoooe();
			shopPage.getBookstoBasket();
			homepage.addBooktoBasket();
	      homepage.checkOut();
	      procPage.updateB();
	  	String  num1=	 procPage.getTotalPrice();
		 System.out.println("Total price before tax: "+num1);
		
//		 Float floatValue=Float.valueOf(num1);
//		 System.out.println(floatValue);
//		 float floatV=Float.parseFloat(num1);
//		 System.out.println(floatV);
		 String num2=procPage.getTaxPrice();
		 System.out.println("Total price tax:"+ num2);
		procPage.ProceedToCheckOut();
			
		}
		}
	
		
	
