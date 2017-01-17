/**
 * 
 */
package SSMTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Factory.DataProviderFactory;
import SSMController.LoginPageController;
import SSMModel.LoginPageModel;

/**
 * @author SMuppidi
 *
 */
public class LoginValidation extends BaseClass{
	
		@Test
		
		public void SSMloginwithvalidusernameandpassword() throws InterruptedException
		{
			test = extent.startTest("Checking the login functionality");
			System.out.println("Testing with valid data");
			test = extent.startTest("Verify Login with valid username and password ");
			SSMLogin().SSMWebLogin(DataProviderFactory.getExcelConfig().getStringData("LoginData", 1, 0), DataProviderFactory.getExcelConfig().getStringData("LoginData", 1, 1));
			
			
			
			
		
		}
		
		/*@Test
		public void Fedloginwithinvalidusernameandpassword() throws InterruptedException
		{
			System.out.println("Testing with Invalid data");
			test = extent.startTest("Verify Login with invalid username and password" );
			SSMLogin().SSMWebLogin(DataProviderFactory.getExcelConfig().getStringData("LoginData", 2, 0), DataProviderFactory.getExcelConfig().getStringData("LoginData", 2, 1));
			
			String Loginerror=LoginPageModel.GetErrorMsg();
			
			Assert.assertEquals(Loginerror, "Login failed!");
		}
	}*/
}