/**
 * 
 */
package SSMController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import SSMModel.LoginPageModel;
import SSMTestCases.BaseClass;


public class LoginPageController extends BaseClass
{
		WebDriver driver;
			   
		public static LoginPageModel SSMloginPage;

		public LoginPageController(WebDriver driver)
		{
			this.driver = driver;
			SSMloginPage = new SSMModel.LoginPageModel(driver);
		}
		
	
		
		public void SSMWebLogin(String uname, String pwd) throws InterruptedException
		{
			
			SSMloginPage.setSSMUserName(uname);
			test.log(LogStatus.INFO,"  User name entered successfully");
			SSMloginPage.setSSMPasswd(pwd);
			test.log(LogStatus.INFO,"Password entered successfully");
			SSMloginPage.clickLogin();
			test.log(LogStatus.INFO,"Login button is clicked");
			
			System.out.println(SSMloginPage.getSSMHomePageTitle()) ;
			
			Assert.assertEquals(SSMloginPage.getSSMHomePageTitle(),"Home","User is not able to  login to SSM site");
			
			test.log(LogStatus.PASS,"Succesfully logged in to SSM Web Application ");
			
						
			}
		
	}