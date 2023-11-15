package com.test.TestCases;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.Base.TestBase;
import com.test.Pages.AccountPage2;
import com.test.Pages.BillingInfoPage;
import com.test.Pages.HomePage;
import com.test.Pages.MyAccountPage;
import com.test.Pages.ProceedToCheckOutPage;
import com.test.Pages.ShopPage;
import com.test.Util.UtilClass;

public class AccountPageCase2 extends TestBase {
	HomePage homepage;
	AccountPage2 accntPage;
	int cnt_reg=1,cnt_login=1;
	UtilClass utilClass=new UtilClass();
	

	public AccountPageCase2() throws FileNotFoundException {
		super();
	
	}
	@Parameters("browser")
	@BeforeClass()
	void beforeStart(@Optional("chrome")String browser) {
		initial(browser);
		
	homepage=PageFactory.initElements(driver, HomePage.class);
	
	accntPage=PageFactory.initElements(driver,AccountPage2.class);
	
	
	}
	@AfterClass()
	void afterDone() {
	quitApp();
	}
    
    	
    	 @Test(dataProvider="AccountData")
//    		Register with valid email and psw
    		void TC_1(String email, String psw) throws InterruptedException {
//    			setLogger("email="+email+", psw="+psw);
    		 homepage.clickOnmyAccount();
    		 accntPage.setRegEmail(email);
    		 accntPage.setRegPsw(psw);
    		 accntPage.clickLoginBtn();
    			
    		   Thread.sleep(1000);
		
    			switch (cnt_reg++) {
    			case 1:
//    				UtilClass.wait.until(ExpectedConditions.visibilityOf(accntPage.logoutBtn));
//    				utility.wait.until(ExpectedConditions.visibilityOf(accntPage.logoutBtn));
    		
    				Assert.assertTrue(accntPage.logoutBtn.isDisplayed());
    				
    			
    				break;
    			case 2:
    				Assert.assertFalse(accntPage.reg_submit.isDisplayed());
    				break;
    			case 3:
//    				Assert.assertTrue(accntPage.isRegisterEnabled());
//    				break;
    			case 4:
    			case 5:
    				Assert.assertTrue(accntPage.getErrTxt().contains("Error"));
    				break;
    			default:
    				break;
    			}
    			
//    			System.out.println(cnt_reg);
    		}
    		
    		
    		//testing Login functions with different values
    		@Test(dataProvider="AccountData")
    		void TC_2(String email, String psw) {
//    			setLogger("email="+email+", psw="+psw);
    			homepage.clickOnmyAccount();
    			
    			accntPage.setLoginUsernm(email);
    		
    			accntPage.setLoginPsw(psw);
    		
    			accntPage.clickLoginBtn();
    			
    			
    			switch (cnt_login++) {
    			case 1:
//    				UtilClass.wait.until(ExpectedConditions.visibilityOf(accntPage.logoutBtn));
//    				utility.wait.until(ExpectedConditions.visibilityOf(accntPage.logoutBtn));
    	
    				Assert.assertTrue(accntPage.logoutBtn.isDisplayed());
    				accntPage.clickLogout();
    				break;
    			case 2:
    				Assert.assertTrue(accntPage.getErrTxt().contains("ERROR"));
    				break;
    			case 3:
//    				Assert.assertTrue(accntPage.isRegisterEnabled());
//    				break;
    			case 4:
    			case 5:
    				Assert.assertTrue(accntPage.getErrTxt().contains("Error"));
    				break;

    			default:
    				break;
    			} 
     }

	@DataProvider(name= "AccountData")
	Object[][] getAccntInfo(Method m){
	String infofilePath=System.getProperty("user.dir")+prop.getProperty("exelPath");
      System.out.println(infofilePath);
//	String[][] result=UtilClass.getAccntFromExcel(infofilePath);
//		
//	if(m.getName().equals("TC_4") || m.getName().equals("TC_5"))
//		return new String[][] {result[0]};
//	else
		return utilClass.getAccntFromExcel(infofilePath);
}
	
}