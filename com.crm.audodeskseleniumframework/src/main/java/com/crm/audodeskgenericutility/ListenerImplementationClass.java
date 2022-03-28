package com.crm.audodeskgenericutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This Method will contains implementation for the ITestListener Interface of TestNg
 * @author Bharath Kumar
 *
 */
public class ListenerImplementationClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"==============> Start");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"==============> Execution Sucessful");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"==============> Execution Failed");
		Throwable exceptionName = result.getThrowable();
		System.out.println("ExceptionName =  "+exceptionName);
		
		try {
			new WebDriverUtility().screenShotPicture(BaseClass.sDriver, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"==============> Execution Skipped");
		Throwable exceptionName = result.getThrowable();
		System.out.println("ExceptionName =  "+exceptionName);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("Suiet Execution Starts");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("Suiet Execution Finished");
		
	}
	
	
	

}
