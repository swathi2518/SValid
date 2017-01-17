package SSMModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utility.Library;
import DataProvider.ReadConfig;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SSMPerformanceModel {
	
	private static WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();	
		public SSMPerformanceModel(WebDriver driver){
			this.driver= driver;
			}
		
		
		public void ClickMyPerformance()
		{
			WebElement MyPerformanceLink=driver
					.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkAddAdmin']"));
			Library.highLightElement(driver, MyPerformanceLink).click();
			
		}
		
		public void ValidateNoOfBehindShedule()
		{
			
			WebElement box=driver.findElement(By.xpath("//*[@id='idmainH--leftContainer']/div[2]"));
			List<WebElement> allLinks = box.findElements(By.tagName("a"));
			int LinksCount=allLinks.size();
			System.out.println("Total links-> "+allLinks.size());
			String SheduleNo="2 behind shedule";
			char no=SheduleNo.charAt(0);
			int num=Character.getNumericValue(no);
			Assert.assertEquals(LinksCount, num);
			
				
		}
		
		public void ValidateBehindSheduleStatusMsg()
		{
			
		}
		
}
