/**
 * 
 */
package Factory;

import DataProvider.ReadConfig;
import DataProvider.ReadExcelData;

/**
 * @author SMuppidi
 *
 */
public class DataProviderFactory {
	static ReadConfig config;
	static ReadExcelData excelConfig;

	public static ReadConfig getConfig(){
		
		if(config==null){
			
			config=new ReadConfig();
			
		}
	  return config;
			
	}
	
	public static ReadExcelData getExcelConfig(){
		
		if(excelConfig==null){
			
			excelConfig=new ReadExcelData();
		}
		return excelConfig;
		
		}
	
}