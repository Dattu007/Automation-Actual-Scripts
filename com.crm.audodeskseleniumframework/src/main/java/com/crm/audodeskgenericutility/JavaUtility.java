package com.crm.audodeskgenericutility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Bharath Kumar
 *
 */

public class JavaUtility {
	
	/**
	 * This method will generate random numbers in the range from 0 to 1000
	 * @return num
	 */

	public int getRandomNumber() {
			
		Random ran = new Random();
		int num = ran.nextInt(1000);
		
		return num;
	}
	
	/**
	 * This method will generate Date with YYYY-MM-DD
	 * @return String
	 */
	public String getSystemDate() {
		
		Date date = new Date();
		String dateWithTime= date.toString();
		String year= dateWithTime.split(" ")[5];
		String Date = dateWithTime.split(" ")[2];
		int month = date.getMonth()+1;
		
		String dateWithFormat = year+ "-" + month + "-" + Date;
		
		return dateWithFormat;
	}
		
		/**
		 * This method will generate Date with YYYY-MM-DD
		 * @return String
		 */
		public String getSystemDateWithTimeZone() {
			
			Date date = new Date();
			String systemDateWithTimeZone= date.toString().replace(":", "-");
			
			return systemDateWithTimeZone;
		
		
	}
	
	/**
	 * This method will return the System Date with YYYYMMDD format
	 * @return date
	 */
	public String getSystemDateYYYYMMDD() {
		
		String ldt = LocalDateTime.now().toString();
		String date = ldt.split("T")[0];
		
		return date;
	}
}
