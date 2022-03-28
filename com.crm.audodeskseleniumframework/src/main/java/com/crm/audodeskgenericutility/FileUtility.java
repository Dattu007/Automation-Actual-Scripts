package com.crm.audodeskgenericutility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This Generic is used to read common data from Property file 
 * @author Bharath Kumar
 *
 */

public class FileUtility {
	
	/**
	 * This Method reads data from Property file and returns browserName,url,userName and password data in the form of String[].
	 * If data not present or issues while reading returns null with message
	 * @return String[]
	 * @throws Throwable 
	 */
	public String getDataPropertyFile(String key) throws Throwable {
		
		FileInputStream  fin = new FileInputStream(".\\src\\test\\resources\\credentials.properties");
		Properties prop_obj = new Properties();
		prop_obj.load(fin);
		String keyValue = prop_obj.getProperty(key);
			
		return keyValue;
		
		
	}

}
