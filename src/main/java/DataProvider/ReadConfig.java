/**
 * 
 */
package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author SMuppidi
 *
 */
public class ReadConfig {
	Properties pro;
	public ReadConfig(){
		try {
			File src=new File("./Configuration/frameworkConfig.properties");
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			System.out.println("Config file loaded");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found please check location of config file");
			System.out.println(e.getMessage());
		} catch (IOException e) {
		
			System.out.println("Exception while reading config file");
			System.out.println(e.getMessage());
			
		}
	}
	
	public String getChromePath()
	{
		return pro.getProperty("ChromeDriverPath");
	}
		
	
	public String getIEPath()
	{
		return pro.getProperty("IEDriverPath");
	}
	public String getApplicationUrl()
	{
		return pro.getProperty("ApplicationURL");
	}
	public String getExcelPath()
	{
		return pro.getProperty("ExcelPath");
	}
	public String getHomePageURL()
	{
		return pro.getProperty("HomePageURL");
	}
	
	
	public String RegistartionPageURL()
	{
		
		return pro.getProperty("RegistrationPageURL");
	}
	public String getLoginPageUL()
	{
		return pro.getProperty("LoginPageURL");
	}
	
}

