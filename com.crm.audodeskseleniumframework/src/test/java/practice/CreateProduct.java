package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.CrmLib;

public class CreateProduct {

	public static void main(String[] args) throws Exception {

		WebDriver driver = null;
		
		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sheet = wb.getSheet("TC003");
		
		String productNameData = sheet.getRow(1).getCell(0).getStringCellValue();
		Random ran = new Random();
		int num = ran.nextInt(1000);
		productNameData = productNameData + num;
		
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
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productNameData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(5000);
		
		lib.LogoutToApp(driver);
	}

}
