package com.test.Pages;

import java.awt.List;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.TestBase;

public class BillingInfoPage  extends TestBase {

	public BillingInfoPage() throws FileNotFoundException {
		super();
		
	}
	@FindBy(id="billing_first_name")
	public   WebElement firstName;
	@FindBy(id="billing_last_name")
       WebElement lastName;
	@FindBy(id="billing_company_field")
	   WebElement companyField;
	
	@FindBy(id="billing_email")
	   WebElement Email;
	@FindBy(id="billing_phone")
    WebElement phone;
	@FindBy(id="s2id_billing_country")
	   WebElement country;
	@FindBy(id="billing_address_1")
	   WebElement streetAddress;
	@FindBy(id="billing_address_2")
	    WebElement appartmentAddress;
	@FindBy(id="billing_city")
	WebElement cityOrTown;
	@FindBy(id="s2id_autogen2_search")
	  WebElement stateField;
	@FindBy(id="billing_postcode")
	    WebElement postCode;
	
	@FindBy(id = "s2id_autogen1_search")
         WebElement countryList;
	@FindBy(id="s2id_autogen1002_search")
	   WebElement searchState;
	
	@FindBy(xpath = "//*[@id=\"place_order\"]")
	 WebElement placeOrder;
	
	public void fillandSendBillinfor(String [] billingInfo) throws InterruptedException {
		firstName.sendKeys(billingInfo[0]);
		lastName.sendKeys(billingInfo[1]);
		Email.sendKeys(billingInfo[2]);
		phone.sendKeys(billingInfo[3]);
		country.click();
		countryList.sendKeys(billingInfo[4]+Keys.ENTER);
		streetAddress.sendKeys(billingInfo[5]);
		appartmentAddress.sendKeys(billingInfo[6]);
		cityOrTown.sendKeys(billingInfo[7]+Keys.ENTER);
	//	stateField.click();
	Thread.sleep(1000);
//		 Actions actionProvider = new Actions(driver);
//		 Action serAction= actionProvider.moveToElement(stateField).click().build();
//	       serAction.perform();
//		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
//		jsExecutor.executeAsyncScript("arguments[0].click;", stateField);
//	searchState.sendKeys(billingInfo[8]+Keys.ENTER);
//		postCode.sendKeys(billingInfo[9]);
		
	    
		

	
	}
	
	public void  clickOnplaceOrder() {
		 WebDriverWait waitDriver=new WebDriverWait( driver, Duration.ofSeconds(30));
		 waitDriver.until(ExpectedConditions.elementToBeClickable(placeOrder));
//		placeOrder.click();
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", placeOrder);
		
		}		
	
		}

