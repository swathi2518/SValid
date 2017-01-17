/**
 * 
 */
package SSMModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import DataProvider.ReadConfig;
import utility.Library;


public class LoginPageModel {
	private static WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();	
		public LoginPageModel(WebDriver driver){
			this.driver= driver;
			}
		
		public void setSSMUserName(String uName){
			WebElement setName = driver.findElement(By.xpath(".//*[@id='username']"));
			Library.highLightElement(driver, setName).sendKeys(uName);
		}
		
		
		public void setSSMPasswd(String pwd){
			WebElement setName = driver.findElement(By.xpath(".//*[@id='password']"));
			Library.highLightElement(driver, setName).sendKeys(pwd);
		}
		
		public void clickLogin(){
			WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='forgotPassword']/button"));
			Library.highLightElement(driver, clickLogIn).click();
			}
		
		public static String GetErrorMsg()
		{
			 String errormessge=driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			 System.out.println(errormessge);
			return errormessge;
		}
		
		public String getSSMHomePageTitle(){
			String SSMgethomeTitle;
			SSMgethomeTitle = driver.getTitle();
		return SSMgethomeTitle;

		}
		
		
		public void waitFor(int sec){
			  try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
	}
