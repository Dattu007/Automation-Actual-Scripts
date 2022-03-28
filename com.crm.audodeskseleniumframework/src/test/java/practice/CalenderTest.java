package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.audodeskgenericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTest {

	public static void main(String[] args) {
		
		WebDriverUtility wLib = new WebDriverUtility();
		String monthAndDate = "May 2022";
		String day= "7";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		
		driver.get("https://www.makemytrip.com/");
		
		wLib.clickOnWebPageByValue(driver, 10, 10);
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
		
		String path = "//div[text()='"+monthAndDate+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
	
		
		for(;;) {
			
		try {
			driver.findElement(By.xpath(path)).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		}
	}

}
