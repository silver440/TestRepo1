package com.test.Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.io.FileNotFoundException;

import org.apache.xml.security.stax.impl.processor.input.AbstractDecryptInputProcessor.AbstractDecryptedEventReaderInputProcessor;
import org.bouncycastle.jcajce.provider.asymmetric.elgamal.BCElGamalPublicKey;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.TestBase;

import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;

public class MyAccountPage extends TestBase {

	public MyAccountPage() throws FileNotFoundException {
		super();
		
	}
	@FindBy(id="reg_email")
	WebElement regEmail;
	
	@FindBy(id="reg_password")
	 WebElement regPasswerd;
	
	@FindBy(name="register")
	WebElement register;
	//***************************
	@FindBy( id="username")
      WebElement usrName;
	
	@FindBy(id="password")
	  WebElement userPassword;
	
	@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")
	 WebElement logOut;
	
	@FindBy(name = "login")
	WebElement logIn;
	
	@FindBy(xpath = "//*[@class=\"page-content entry-content\"]//child::li")
	public  WebElement errPasswordNedded;
	
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/ul/li/text()")
  public   WebElement errMessage;

      public void getRegEmail() {
    	  regEmail.clear();
    	  regEmail.sendKeys("ndy7122@gmail.com");
    	 
      }
      public void getRegPassword() throws InterruptedException  {
    	  regPasswerd.clear();
    //	  regPasswerd.sendKeys("B22111@world$$");
   
//    	regPasswerd.sendKeys("Ls444@world$$");
//    	  WebDriverWait wait=new WebDriverWait(driver, 20);
//   	  wait.until(ExpectedConditions.alertIsPresent());
      
    	  JavascriptExecutor jcExecutor=(JavascriptExecutor)driver;
    	   jcExecutor.executeScript("arguments[0].value='e92111@world$$'", regPasswerd);
    	    jcExecutor.executeScript("arguments[0].click()", regPasswerd);
    	
    	 
//    	  WebDriverWait wait=new WebDriverWait(driver, 20);
//    	  wait.until(ExpectedConditions.visibilityOf(regPasswerd));
//    	   
    
      }
      public void clickRegister() {
    	  WebDriverWait wait=new WebDriverWait(driver, 10);
    	  wait.until(ExpectedConditions.visibilityOf(register));
    	  register.click();
    	 // register.click();
      }
	
      public void logOout() {
    	  logOut.click();
      }
      public void logInUserName() {
    	  usrName.sendKeys("bdy7122@gmail.com");
    	
    	
    	  
      }
      public void loginUserPassword() {
    	    userPassword.sendKeys("d92111@world$$");
      }
     public void logIn() {
    	 logIn.click();
     }
     public void loginWrongPass() {
    	 userPassword.sendKeys("");
     }
    public void loginWrongEmail() {
     usrName.sendKeys("");
    }
}

     
	


