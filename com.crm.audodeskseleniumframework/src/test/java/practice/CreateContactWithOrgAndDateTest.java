package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.crm.audodeskgenericutility.ExcelUtility;
import com.crm.audodeskgenericutility.FileUtility;
import com.crm.audodeskgenericutility.JavaUtility;
import com.crm.audodeskgenericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgAndDateTest {

	public static void main(String[] args) throws Throwable {
		
		/* Create objects of Utility classes*/
		
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		
		/*Read Test Data from Excel File*/
				WebDriver driver = null;
				
		/*From Java Utility*/
				int num = jLib.getRandomNumber();
				
		/*From Excel Utility*/
				String lastNameData = eLib.getDataExcelWorkbook("TC002", 1, 0)+num;
				String orgName = eLib.getDataExcelWorkbook("TC002", 1, 1)+num;
				
	    /*Read the common data from Property file*/
				
				/*From File Utility */
				String browserData = fLib.getDataPropertyFile("browser");
				String urlData = fLib.getDataPropertyFile("url");
				String userNameData = fLib.getDataPropertyFile("username");
				String passwordData = fLib.getDataPropertyFile("password");
				
		/*Launching the required browser , run time polymorphism*/
				
				if(browserData.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println("Chrome Browser launched");
				}else if (browserData.equalsIgnoreCase("firefox")){
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					System.out.println("Firefox Browser launched");
				}else if(browserData.equalsIgnoreCase("ie")){
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					System.out.println("Firefox Browser launched");
				}else{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println("Default Chrome Browser launched");
				}
				
			/*Step1:- Login to Application*/
				
				driver.manage().window().maximize();
				wLib.waitForPageToLoad(driver);
				driver.get(urlData);
				driver.findElement(By.name("user_name")).sendKeys(userNameData);
				driver.findElement(By.name("user_password")).sendKeys(passwordData);
				driver.findElement(By.id("submitButton")).click();
				
			/*Step2:- Create Organization*/
				
				driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String actuaorgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if (actuaorgName.contains(orgName)) {
					System.out.println(orgName +   "is verified : PASS");
				}else {
					System.out.println(orgName +   "is not verified : FAIL");
				}
				
			/*Step3:- Create Contact with Organizations*/
				
				wLib.waitForElementToBeClickable(driver, driver.findElement(By.linkText("Contacts")));
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(lastNameData);
				driver.findElement(By.xpath
				("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
				
			/*Step4:= Switch to child window*/
				
				wLib.switchToWindow(driver, "Accounts");
				
				driver.findElement(By.id("search_txt")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				
			/*Step5:= Switch to child Parent*/
				
				wLib.switchToWindow(driver, "Contacts");
				
				String systemDate = jLib.getSystemDateYYYYMMDD();
				
				driver.findElement(By.xpath("//input[@name='support_start_date']")).clear();
				
				driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(systemDate);
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String actualLastNameData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
			/*Step6:= Verify the contacts creation*/
				
				if(actualLastNameData.contains(lastNameData)) {
					System.out.println(lastNameData  + "= is verified :: PASS");
				}else {
					System.out.println(lastNameData  + "= is Not verified:: FAIL");
				}
			/*Step7:= Verify the contact with organization selection*/
				
				String actualOrgNameAdd = driver.findElement(By.xpath
						("//td[@id='mouseArea_Organization Name']/a")).getText();
				
				if(actualOrgNameAdd.equals(orgName)) {
					System.out.println(orgName  + "= is added to contact and verified:: PASS");
				}else {
					System.out.println(orgName  + "= is Not added to contact and not verified:: FAIL");
				}
				
			/*Step8:= Verification the contact with Date also*/
				
				String actualDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				
				if(actualDate.equals(systemDate)) {
					System.out.println(systemDate  + "= is added to contact and verified:: PASS");
				}else {
					System.out.println(systemDate  + "= is Not added to contact and not verified:: FAIL");
				}
				
			/*Step9:= Logout from the Application*/
				
				/*From WebDriver Utility*/
				wLib.mouseCurserMoveToElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
				driver.findElement(By.linkText("Sign Out")).click();
				
				driver.quit();

	}

}
