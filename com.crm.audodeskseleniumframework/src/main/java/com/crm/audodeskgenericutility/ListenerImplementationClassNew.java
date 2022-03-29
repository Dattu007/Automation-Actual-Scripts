package com.crm.audodeskgenericutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This Method will contains implementation for the ITestListener Interface of TestNg
 * @author Bharath Kumar
 *
 */
public class ListenerImplementationClassNew implements ITestListener{

	ExtentTest test;
	ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		/* Step3:= Create a Test Method during test Execution */
		test = report.createTest(result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		/* Step4:= Log the Pass method with TestCase Name */
		
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		/*
		 * Step6:= Log fail method, get screen shot, attach screen shot to report and
		 * add Exception log
		 */
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		
		String path= null;
		try {
			path =new WebDriverUtility().screenShotPicture(BaseClass.sDriver, "extentReports");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(path);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		/* Step5:= Log the Skip status with Test Case Name and Exception log */
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		
		/* Step1:= Extent Report Configuration */
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./extentreport"+new JavaUtility().getSystemDateWithTimeZone()+".html");
		htmlReport.config().setReportName("Regression Execution Report");
		htmlReport.config().setDocumentTitle("Audodesk Automation execution Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		/* Step2:= Attach the Physical Report and do the System Configuration */
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS" , System.getProperty("os.name"));
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("URL", "htttp://localhost:8888");
		report.setSystemInfo("Reporter Name", "Bharath Kumar");
		
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
		/* Step7:= Get the reports to our system */
		
		report.flush();
	}
	
	

}
