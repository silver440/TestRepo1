package com.test.Pages;

import java.util.*;

import javax.print.DocFlavor.STRING;
import javax.swing.text.html.HTML;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;

import java.awt.Dimension;
import java.io.FileNotFoundException;


import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.bouncycastle.cms.PasswordRecipientId;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.TestBase;

import io.opentelemetry.api.trace.Span;
import net.bytebuddy.asm.Advice.Return;

import org.openqa.selenium.NoSuchWindowException;
public class ShopPage extends TestBase {

	public ShopPage() throws FileNotFoundException {
		super();

	}

	@FindBy(xpath = "//a[text()=\"Home\"]")
	WebElement homeMenue;

	@FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/div")
	WebElement sliderStick;

	@FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[1]")
	public WebElement sliderElement;

	@FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]")
	public WebElement sliderElement2;

	@FindBy(xpath = "//button[text()=\"Filter\"]")
	WebElement filterButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li")
	List<WebElement> bookafterFiltered;
     
	 @FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[2]/div[1]/span")
//	@FindBy(xpath = "//div[@class=\"price_slider_amount\"]//span")
	List <WebElement> priceRangeOfSlider;
	 
	 @FindBy(xpath = "//*[@class=\"price_slider_wrapper\"]//input[@id=\"min_price\"]")
	    WebElement minPrice;

	
	 
	 @FindBy(xpath = "//*[@id=\"content\"]//span[2]")
	 List<WebElement> saleItem;
	 
	 @FindBy(xpath = "//*[@id=\"content\"]//parent::span[@class=\"price\"]/span")
	 List<WebElement>pricesofBooksontheScreen;
	 
	@FindBy(xpath = "//*[@class=\"product-categories\"]/li")
	List<WebElement> productCategories;
	
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li")
	List<WebElement> screenList;
	
	@FindBy(xpath ="//*[@name=\"orderby\"]")
	    WebElement defaultSorting;
	
//	@FindBy(xpath = "//*[@id=\"content\"]/ul/li/a[1]/span")
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li/a[1]/span/span")
	List<WebElement>sortedPricElements;
	
	@FindBy(xpath = "//*[@id=\"woocommerce_product_categories-2\"]/ul/li[3]/a")
	    WebElement itemstoChoose;
	
	@FindBy(xpath = "//*[@class=\"products masonry-done\"]//a/span")
	   WebElement bookstoAdd;

	public void getSlider() {
		Actions actions = new Actions(driver);
		actions.clickAndHold(sliderStick);
		actions.dragAndDropBy(sliderStick, -26, 300);

		actions.build().perform();

	}

	public void clickOnHomeMenue() {
		homeMenue.click();
	}

	public void getSlider2() {
		Actions actions = new Actions(driver);
		// actions.moveToElement(sliderElement2).clickAndHold();
		actions.clickAndHold(sliderElement2);
		actions.dragAndDropBy(sliderElement2, -26, 300);
		actions.build().perform();

	}

	public void clickFilter() {
		filterButton.click();
	}
    public ArrayList<String> getSliderPrice() {
//    	for(String handle:driver.getWindowHandles()) {
//    		try {
//				driver.switchTo().window(handle);
//			} catch (NoSuchWindowException e) {
//			System.out.println("An exceptional case");
//			}
//    	}
//    	
      WebDriverWait wait=new WebDriverWait(driver, 30);
     wait.until(ExpectedConditions.visibilityOfAllElements(priceRangeOfSlider));
    	ArrayList<String> priceSl=new ArrayList<String>();
    	int i=0;
    	for(WebElement element:priceRangeOfSlider) {
    		priceSl.add(element.getText().substring(1));
    	}
		return getSliderPrice();
    	
    	
    }
    public void getMinPrice() {
    	
}
       public int getBooksListOnthescreen() {
             return bookafterFiltered.size();
         }
		 public int getBooksforsale() {
			 return saleItem.size();
			 
		 }
    	   public ArrayList<String > getBooksvalue(){
    	       ArrayList<String> price=new ArrayList<String>();
    	       for(WebElement elm:pricesofBooksontheScreen) {
    	    	   price.add(elm.getText().substring(1));
    	    	  
    	       }
    	         return price;
    	   }
    	   
    	   public String getMinPrice1() {
    		String string="";
    			
    		  
    		 String string1=minPrice.getText();
    		 string1 =string1.replace("₹","");
    		 string=string+string1;
    		 return string;
//    		 int number=Integer.parseInt(string);
//    		 System.out.println(number);
//    		 return number;
    	   }
    	    public int getCountOfProcudtList() {
    	    return productCategories.size();
				
    	    	
    	    }
        public ArrayList<String > getNameofProduct() {
        	ArrayList<String > booksOntheList=new ArrayList<String >();
        	 for(WebElement element: productCategories) {
        		 booksOntheList.add(element.getText());
        	 }
			return booksOntheList;
			
		}
        public  int getclickedNumber( ) {
        	int i=2;
       System.out.println(productCategories.get(i).getText());
       
        productCategories.get(i).findElement(By.xpath("./a")).click();
String string=         productCategories.get(i).findElement(By.xpath("./span")).getText();
string =string.replace("(", "");
 string=string.replace(")", "");
 System.out.println(string);
	int numbercont=Integer.parseInt(string);
	return numbercont;		
}
        public int getScreenMatchingcount() {
        	return screenList.size();
        }
        
        public void  getSorting() {
        	Select select=new Select(defaultSorting);
        select.selectByVisibleText("Sort by average rating");
        	
        }
        public ArrayList<String> getSortedPriceList(){
        	ArrayList<String > sortedPrice=new ArrayList<String >();
       	 for(WebElement element: sortedPricElements) {
       		sortedPrice.add(element.getText().substring(1));
			
        	
        }
       	 return sortedPrice;
} 
        public void getBooksToChoooe() {
        	itemstoChoose.click();
			
		}
        public void getBookstoBasket() {
        	bookstoAdd.click();
        }
}