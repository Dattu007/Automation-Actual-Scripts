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

public class CreateOrg {

	public static void main(String[] args) throws Exception {

		WebDriver driver = null;
		
		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sheet = wb.getSheet("TC001");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int columncount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("row count is"+   rowcount);
		System.out.println("column count is "+   columncount);
		
		for (int i = 0; i <=rowcount-1; i++) {
			for (int j = 0; j <=columncount-1; j++) {
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data + "	");
			}
			System.out.println();
		}
		
		String orgName = sheet.getRow(1).getCell(0).getStringCellValue();
		Random ran = new Random();
		int num = ran.nextInt(1000);
		orgName= orgName + num;
		
		FileInputStream fin = new FileInputStream
				(".\\src\\main\\resources\\commondata\\credentials.properties");
		Properties prop_obj = new Properties();
		prop_obj.load(fin);
		String browserName = prop_obj.getProperty("browser");
		String url = prop_obj.getProperty("url");
		String usernameData = prop_obj.getProperty("username");
		String passwordData = prop_obj.getProperty("password");
		
		System.out.println(browserName);
		System.out.println(url);
		System.out.println(usernameData);
		System.out.println(passwordData);
		
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
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		lo.LogoutToApp(driver);
	}

}
