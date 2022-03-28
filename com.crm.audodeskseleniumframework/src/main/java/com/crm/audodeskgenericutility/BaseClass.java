package com.crm.audodeskgenericutility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodesk.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver=null;
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public SoftAssert soft = new SoftAssert();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups= {"integrationTest","smokeTest", "systemTest"})
	public void beforeSuite() {
		System.out.println("open the database connection");
	}
	
	@BeforeTest(groups= {"integrationTest","smokeTest", "systemTest"})
	public void beforeTest() {
		System.out.println("execute test scripts in parallel mode");
	}
	
//	@Parameters("browsername")
	@BeforeClass(groups= {"integrationTest","smokeTest", "systemTest"})
	public void beforeClass() throws Throwable {
		
		String browserNameData= fLib.getDataPropertyFile("browser");
		String urlData= fLib.getDataPropertyFile("url");
		
		if(browserNameData.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else if(browserNameData.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else {
			throw new Exception("only two browsers compatible");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(urlData);
		sDriver=driver;
	}
	
	@BeforeMethod(groups= {"integrationTest","smokeTest", "systemTest"})
	public void beforeMethod() throws Throwable {
		
		String userNameData = fLib.getDataPropertyFile("username");
		String passwordData = fLib.getDataPropertyFile("password");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(userNameData, passwordData);
	}
	
	@AfterMethod(groups= {"integrationTest","smokeTest", "systemTest"})
	public void afterMethod() {
		HomePage homePage = new HomePage(driver);
		homePage.logout(driver);
	}
	
	@AfterClass(groups= {"integrationTest","smokeTest", "systemTest"})
	public void afterClass() {
		driver.quit();
	}
	
	@AfterTest(groups= {"integrationTest","smokeTest", "systemTest"})
	public void afterTest() {
		System.out.println("close the Parallel Execution mode");
	}
	
	@AfterSuite(groups= {"integrationTest","smokeTest", "systemTest"})
	public void afterSuite() {
		System.out.println("close the databae connection");
	}

}
