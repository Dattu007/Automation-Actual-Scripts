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

import io.github.bonigarcia.wdm.WebDriverManager;
import library.CrmLib;

public class AddOrganInContact {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = null;
		
		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sheet = wb.getSheet("TC002");
		
		String lastNameData = sheet.getRow(1).getCell(0).getStringCellValue();
		Random ran = new Random();
		int num = ran.nextInt(1000);
		lastNameData = lastNameData + num;
		
		String expectedOrganization = sheet.getRow(1).getCell(1).getStringCellValue();
		
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
		CrmLib lo = new CrmLib();
		lo.loginToApp(driver, usernameData, passwordData);
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastNameData);
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@title='Select']"))
									.click();
		
						
		Set<String> windowIds = driver.getWindowHandles();
		List<String> w = new ArrayList<String>(windowIds);
		driver.switchTo().window(w.get(1));
				
		List<WebElement> organizationList = driver.findElements(By.xpath("//a[@href='javascript:window.close();']"));
		
		
		for (WebElement ele : organizationList) {
			
			if(ele.getText().contains(expectedOrganization)){
				ele.click();
				break;
			}
		}
		driver.switchTo().window(w.get(0));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(5000);
		
		lo.LogoutToApp(driver);
		
	}

}
