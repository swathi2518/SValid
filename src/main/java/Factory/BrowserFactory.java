/**
 * 
 */
package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import SSMTestCases.BaseClass;

/**
 * @author SMuppidi
 *
 */
	public class BrowserFactory extends SSMTestCases.BaseClass {
		//static WebDriver driver;
			
			public WebDriver getBrowser(String browserName){
				
				if(driver==null){
					if(browserName.equalsIgnoreCase("firefox")){
						ProfilesIni init=new ProfilesIni();
						FirefoxProfile profile=init.getProfile("default");
						
						driver=new FirefoxDriver(profile);
						
						driver.manage().timeouts().implicitlyWait(90, TimeUnit.MILLISECONDS);
					}
					if(browserName.equalsIgnoreCase("chrome")){
						System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
						driver=new ChromeDriver();
						driver.manage().timeouts().implicitlyWait(90, TimeUnit.MILLISECONDS);
					}
					if(browserName.equalsIgnoreCase("IE")){
						DesiredCapabilities cap=new DesiredCapabilities();
						cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
						cap.setJavascriptEnabled(true);
						System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
						driver=new InternetExplorerDriver(cap);
						driver.manage().timeouts().implicitlyWait(90, TimeUnit.MILLISECONDS);
					}
				}
				return driver;
			}
	
	/*public static void closeBrowser()
	{
		driver.quit();
	}*/
}

