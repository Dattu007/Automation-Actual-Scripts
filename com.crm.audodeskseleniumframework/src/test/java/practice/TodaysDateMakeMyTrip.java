package practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TodaysDateMakeMyTrip {

	public static void main(String[] args) throws Throwable {
		
		LocalDateTime date = LocalDateTime.now();
		int day = date.getDayOfMonth();
		String tempMonth = date.getMonth().toString();
		String month= tempMonth.substring(0, 1)+ tempMonth.substring(1).toLowerCase();
		int year = date.getYear();
		String currentMonthAndYear = month+" "+year;

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/flights");
		
		Actions action = new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		
		String path = "//div[text()='"+currentMonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
		
		driver.findElement(By.xpath(path)).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}

}
