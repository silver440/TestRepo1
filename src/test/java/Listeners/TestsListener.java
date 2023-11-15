package Listeners;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.Base.TestBase;
import com.test.Util.UtilClass;

public class TestsListener  extends TestBase implements ITestListener{

	public TestsListener() throws FileNotFoundException {
		super();
		
//		UtilClass utilClass=new UtilClass();
	}

	@Override
  public	void onTestFailure(ITestResult result) {
		System.out.println("***********Error "+result.getName()+" test has failed*********");
		String methodName=result.getName().toString().trim();
		//ITestContext context=result.getTestContext();
		 try {
			UtilClass.takeScreenShot(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		 try {
//			takeScreenShot(methodName);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	

}
