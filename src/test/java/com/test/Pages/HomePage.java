package com.test.Pages;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.metadata.IIOInvalidTreeException;

import java.io.FileNotFoundException;

import org.apache.commons.math3.random.Well1024a;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.bouncycastle.asn1.cmc.CMCObjectIdentifiers;
import org.hamcrest.Factory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.test.Base.TestBase;


public class HomePage extends TestBase {

	public HomePage() throws FileNotFoundException {
		super();
	}
    
	@FindBy(xpath = "//div[@class='n2-ss-slider-3']/div")
	List<WebElement> slidersList;

	@FindBy(xpath = "//a[text()='Shop']")
	WebElement shopMenuElement;

	@FindBy(css = "ul[class='products']")
	List<WebElement> arrivalsElements;

	@FindBy(tagName = "h3")
	List<WebElement> bookNames;
	
	@FindBy(xpath = "//a[.=\"Add to basket\"]")
	  List<WebElement>availableToBuy;
//	******************BasketPage*******************************************
	@FindBy(xpath = "//ul[@class=\"tabs wc-tabs\"]/li/a")
	List<WebElement> productDisandRev;
	
	@FindBy(xpath = "(//ul[@class=\"tabs wc-tabs\"]/li/a)[2]")
	WebElement reviewButton;
	
	@FindBy(xpath = "(//ul[@class=\"tabs wc-tabs\"]/li/a)[2]")
	  WebElement discriptionButton;
	
	@FindBy(xpath = "(//span[@class=\"woocommerce-Price-amount amount\"])[1]")
	 WebElement priceofBook;
	
	@FindBy(xpath = "//button[.=\"Add to basket\"]")
	 WebElement addbasketButton;
	
	@FindBy(xpath = "//*[@id=\"product-165\"]/div[2]/form/div/input")
	 WebElement inputNumberofitem;
 
	@FindBy(xpath = "//*[@id=\"product-165\"]/div[2]/p")
	 WebElement stockCnt;
	
	@FindBy(xpath = "//nav[@id=\"main-nav-wrap\"]//child::li[6]")
	WebElement wiewButton;
 
	@FindBy(xpath="//*[@class=\"woocommerce-message\"]/a")
	 WebElement messageBox;
	
	@FindBy(xpath = "//li[@id=\\\"wpmenucartli\\\"]/a/span[2]")
	 WebElement menuItemPrice;
	
	   @FindBy(xpath = "//a[text()=\"My Account\"]")
	    WebElement myAccountMenu;
	
	// Actions
	public int getSliderCnt() {
		return slidersList.size();
	}

	public void clickShopMenu() {
		shopMenuElement.click();
	}

	public int getArrivals() {
		return arrivalsElements.size();

	}


	public List<String> getBookNames() {
		List<String> bk = new ArrayList();
		for (WebElement element : bookNames) {
			System.out.println(element.getText());
			bk.add(element.getText());

		}
		return bk;
	}
      public void navigatingTobasket() {
//    	  for(WebElement element1: availableToBuy) {
//    		  System.out.println(element1.getSize());
//    		  element1.click();
    	  for(WebElement element :bookNames) {
    		  if(element.getText().equalsIgnoreCase("Mastering JavaScript")) {
    			  element.click();
    		//	System.out.println(driver.getCurrentUrl());
    		
    		  }
    	  }
      } 
    
    //*******************************BasketPageMethods**********************		
    public void  getReview() {
                reviewButton.click();
      
    }	   
    	public void getDiscription() {
    		discriptionButton.click();
    	}
    public  void getPriceofBook() {
    	
    	String string=priceofBook.getText();
    	System.out.println("price of itemshowing:" +string);
    	
    	
    }
    public void addBooktoBasket() {
    	addbasketButton.click();
//    	WebElement element=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/text()"));
//    	String text=element.getText();
//    	System.out.println(text);
    }
       public String  addLargeNumber() {
    	   String num="";
    	   if(inputNumberofitem.isDisplayed()) {
    		   String st=stockCnt.getText();
    		   st=st.replace(" in stock", "");
    		   System.out.println("in stock="+st);
    		   num=String.valueOf(Integer.parseInt(st)+1);
    	
    		   inputNumberofitem.sendKeys(num);
    		   System.out.println("number of items ordered : "+num);
    		   }
    	   else {
    		   System.out.println("fail");
    	   }
		return num;
    	   
       }
       public void checkOut() {
    	   wiewButton.click();
       }
       public void pupMessage() {
    	   if(messageBox.isDisplayed()) {
    		   System.out.println("Search box is visislbe.Return "+messageBox.isDisplayed());
    		   
    	   } else {
    		   System.out.println("Search box with message is not visible");
    	   }
       }
       public String  showingMenueItem () {
    	   String num1="";
    	   if(menuItemPrice.isDisplayed()) {
    		   String str=  menuItemPrice.getText();
    		   str=str.replace("₹", "");
    		   System.out.println("Print out the value:"+str);
    		   num1=String.valueOf(Double.parseDouble(str));
    		   
    	   }
		return num1;
    	 
    	 
       }
       public void clickOnmyAccount() {
    	   myAccountMenu.click();
       }
    }
    		  
    	  
    	  
    			
    		
    		
    		
    	  
      

    	  
    	  
      

