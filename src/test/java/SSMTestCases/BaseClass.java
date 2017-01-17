/**
 * 
 */
package SSMTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import SSMController.LoginPageController;

import utility.Library;

/**
 * @author SMuppidi
 *
 */
public class BaseClass {

	protected static WebDriver driver;
	protected ExtentReports extent;
	protected static ExtentTest test;
	String reportPath;

	@Parameters("browserName")
	@BeforeClass
	public void startbrowser(String browserName) {
		System.out.println("Browser name is " + browserName);
		BrowserFactory factory=new BrowserFactory();
		driver=factory.getBrowser(browserName);

	}

		public LoginPageController SSMLogin()
		{
			driver.get(DataProviderFactory.getConfig().getLoginPageUL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new SSMController.LoginPageController(driver);
		}
		
		
		
		
		/*public RegPageController Regvalid()
		{
			driver.get(DataProviderFactory.getConfig().RegistartionPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new FedController.RegPageController(driver);
		}*/
		
		
		
		@BeforeSuite
		public void reportSetUp() {
			reportPath=System.getProperty("user.dir") +"\\AdvanceReports\\Fed"+System.currentTimeMillis()+".html";
			extent = new ExtentReports(reportPath, false);
		
		}

		@AfterMethod
		public void endTestCase(ITestResult result) {
			if (result.getStatus() == ITestResult.FAILURE)
			{
				try {
					test.log(LogStatus.INFO, test.addScreenCapture(Library.captureScreenshotwithpath(driver)));
					String tc_name = result.getName();
					//System.out.println("The test case name is " + tc_name);
					test.log(LogStatus.FAIL, "Validation Failed Taken Screenshot"+tc_name);
					//test.log(LogStatus.INFO, test.addScreenCapture(Library.captureScreenshotwithpath(driver)));
				} catch (Exception e) {
					System.out.println("Exception while taking screen shot"+e.getMessage());
				}
		
			}
			extent.endTest(test);
		}

		@AfterSuite
		public void tearDown() throws Throwable {
			
		extent.flush();
		driver.get(reportPath);
		Thread.sleep(5000);
		driver.quit();
	     System.out.println("Report is generated >>>> Browser is closed >>>>"+reportPath);
		}
		

}