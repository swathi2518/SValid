package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Library {
	public static void captureScreenshot(WebDriver ldriver)
	{
		
			TakesScreenshot ts=(TakesScreenshot)ldriver;
			File screen_src=ts.getScreenshotAs(OutputType.FILE);
			String path="./Screenshots/"+System.currentTimeMillis()+".png";
			File destination=new File(path);
			try
			{
			FileUtils.copyFile(screen_src,destination);
			System.out.println("Screenshot Taken");
			}
		catch (Exception e) {
			System.out.println("Exception while taking screen shot"+e.getMessage());
			}
		
	}
	public static void captureScreenshotwithTC(WebDriver ldriver, String tc_name)
	{
		
			TakesScreenshot ts=(TakesScreenshot)ldriver;
			File screen_src=ts.getScreenshotAs(OutputType.FILE);
			String path="./Screenshots/"+tc_name+System.currentTimeMillis()+".png";
			File destination=new File(path);
			try
			{
			FileUtils.copyFile(screen_src,destination);
			System.out.println("Screenshot Taken");
			}
		catch (Exception e) {
			System.out.println("Exception while taking screen shot"+e.getMessage());
			//return e.getMessage();
		}
		}
	public static String captureScreenshotwithpath(WebDriver ldriver)
	{
		
			TakesScreenshot ts=(TakesScreenshot)ldriver;
			File screen_src=ts.getScreenshotAs(OutputType.FILE);
			String path="C:/NursingFaculty/NursingFramework/Screenshots/Nursing"+System.currentTimeMillis()+".png";
			File destination=new File(path);
			try
			{
			FileUtils.copyFile(screen_src,destination);
			System.out.println("Screenshot Taken");
			//return dest;
		}
		catch (Exception e) {
			System.out.println("Exception while taking screen shot"+e.getMessage());
			//return e.getMessage();
		}
			return path;
	}
	public static WebElement highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; boarder:2px solid red;');",element);
		
		try{
			Thread.sleep(500);
		}catch (InterruptedException e){
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style', 'boarder: solid 2px white');", element);
		return element;
	}
		
	public static String getDay(String mydate)
	{
		   Date mydate1;
		try {
			SimpleDateFormat format = new SimpleDateFormat();
			   mydate1 = new Date(mydate);
			   return new SimpleDateFormat("EE").format(mydate1);
		} catch (Exception e) {
			System.out.println("Exception while coverting to day"+e.getMessage());
			return e.getMessage();
		}
}
}
