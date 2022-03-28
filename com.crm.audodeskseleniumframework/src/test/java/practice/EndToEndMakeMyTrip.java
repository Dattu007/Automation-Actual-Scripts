package practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndMakeMyTrip {

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
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.get("https://www.makemytrip.com/flights");
		
		Actions action = new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		
		String fromPlace = "Bengaluru";
		driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys(fromPlace);
		

		
		List<WebElement> listOfFromPlace = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		
		Thread.sleep(2000);
		
		for(WebElement ele:listOfFromPlace) {
			
			if(ele.getText().contains(fromPlace)) {
				ele.click();
				break;
			}
			
		}
		
//		driver.findElement(By.xpath("//input[@id='fromCity' and @type='text' and @value='Bengaluru']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		
		String toPlace = "Mumbai";
		driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys(toPlace);
		

		List<WebElement> listOfToPlace = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		
		Thread.sleep(2000);
		
		for(WebElement ele:listOfToPlace) {
			
			if(ele.getText().contains(toPlace)) {
				ele.click();
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		String path = "//div[text()='"+currentMonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
		
		driver.findElement(By.xpath(path)).click();
		
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		WebElement elemnetForWait = driver.findElement(By.xpath("//p[text()='Flights from ']"));
		
		wait.until(ExpectedConditions.visibilityOf(elemnetForWait));
		
		List<WebElement> listOfFlights = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		
		for(WebElement ele:listOfFlights) {
			
			System.out.println("The Flights Name:" + ele.getText());		
		}
		
		driver.quit();
			
		}
	}


