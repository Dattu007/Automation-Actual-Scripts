package practice;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.CrmLib;

public class CreateCampaign {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		
		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sheet = wb.getSheet("TC004");
		
		String campaignNameData = sheet.getRow(1).getCell(0).getStringCellValue();
		Random ran = new Random();
		int num = ran.nextInt(1000);
		campaignNameData = campaignNameData + num;
		
		String expectedProduct = sheet.getRow(1).getCell(1).getStringCellValue();
		
		FileInputStream fin = new FileInputStream
				(".\\src\\main\\resources\\commondata\\credentials.properties");
		Properties prop_obj = new Properties();
		prop_obj.load(fin);
		String browserName = prop_obj.getProperty("browser");
		String url = prop_obj.getProperty("url");
		String usernameData = prop_obj.getProperty("username");
		String passwordData = prop_obj.getProperty("password");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser launched");
		}else if (browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser launched");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		CrmLib lib = new CrmLib();
		lib.loginToApp(driver, usernameData, passwordData);
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("More"))).perform();
		action.moveToElement(driver.findElement(By.name("Campaigns"))).click().perform();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignNameData);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		Set<String> windowId = driver.getWindowHandles();
		List<String> w = new ArrayList<String>(windowId);
		driver.switchTo().window(w.get(1));
		
		List<WebElement> actualProductsList = driver.findElements(By.xpath
											("//a[@href='javascript:window.close();']"));
		
		for (WebElement ele : actualProductsList) {
			if(ele.getText().contains(expectedProduct)) {
				ele.click();
				break;
			}
		}
		
		driver.switchTo().window(w.get(0));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		lib.LogoutToApp(driver);
	}

}
