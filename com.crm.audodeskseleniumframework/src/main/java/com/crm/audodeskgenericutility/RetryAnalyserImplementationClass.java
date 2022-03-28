package com.crm.audodeskgenericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementationClass implements IRetryAnalyzer {
	
	int count = 0;
	int retry = 5;
	public boolean retry(ITestResult result) {
		while(count<retry) {
			count++;
			return true;
		}
		return false;
	}
	

}
