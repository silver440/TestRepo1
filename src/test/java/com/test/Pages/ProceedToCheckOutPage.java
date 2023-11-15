package com.test.Pages;

import java.awt.List;
import java.io.FileNotFoundException;
import java.time.Duration;

import javax.print.DocFlavor.STRING;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.jsoup.internal.FieldsAreNonnullByDefault;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.Base.TestBase;

public class ProceedToCheckOutPage extends TestBase{

	public ProceedToCheckOutPage() throws FileNotFoundException {
		super();
		
	}
	@FindBy(xpath = "//*[@id=\"coupon_code\"]")
	WebElement couponBox;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]")
	 WebElement applyCouponButton;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/ul/li")
	   WebElement messageCoupon;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[1]/a")
	WebElement removeItem;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]")
	WebElement undoMessage;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input")
	 WebElement quantityReset;

     @FindBy(xpath = "//*[@name=\"update_cart\"]")
      WebElement updateBasket;
     
     @FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[6]/span")
       WebElement finalItemPrice;
     
     @FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span")
          WebElement subtotalElement;
     
     @FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[2]/td/span")
        WebElement taxAmount;
 
     @FindBy(xpath = "//*[@class=\"wc-proceed-to-checkout\"]/a")
     WebElement checkOut;
 public void getCouponCode() {
	
	 Actions actionProvider = new Actions(driver);
	 Action serAction= actionProvider.moveToElement(couponBox).click().sendKeys("krishnasakinala").build();
       serAction.perform();
      Actions serAction2= actionProvider.moveToElement(applyCouponButton).contextClick(applyCouponButton).click();
   serAction2.perform();
   serAction.perform();
  
    }
 public void itemRemove() {

	 WebDriverWait waitDriver=new WebDriverWait( driver, Duration.ofSeconds(30));
	 waitDriver.until(ExpectedConditions.elementToBeClickable(removeItem));
	 removeItem.click();
 JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
	 jsExecutor.executeAsyncScript("arguments[0].click();", removeItem);
   
	
	 
 }
 public void  getUndoMessage() {
	 if(undoMessage.isDisplayed()) {
		 System.out.println("Message is displayed ");
		 Assert.assertTrue(true);
		 }
	  }
    public void changeQuantitybook() {
    	quantityReset.clear();
    	quantityReset.sendKeys("3");
    }
    public void updateB() {
    	updateBasket.click();
    }
      public String itemPriceOnTheMeneu() throws InterruptedException {
        Thread.sleep(1000);
    	  String string="";
    	  if(finalItemPrice.isDisplayed()) {
    		  String ItemPrice=finalItemPrice.getText();
    	  ItemPrice=ItemPrice.replace("₹", "");
    	  string=ItemPrice;
    	  System.out.println(string );
    			  
    	  }
    	  
		
    	  return string;
      }
      public String   getTotalPrice() throws InterruptedException {
    
    	  Thread.sleep(1000);
          
          String string=(subtotalElement.getText().substring(1));
			System.out.println( string );
			return string;
        }   	
    	public String getTaxPrice() {
    		String string1=(taxAmount.getText().substring(1));
    		System.out.println(string1 );
			return string1;
    	}
    	public void ProceedToCheckOut() {
    		checkOut.click();
    	}
    	
    	
    	
    	
    	
    	 
      }
      

 

