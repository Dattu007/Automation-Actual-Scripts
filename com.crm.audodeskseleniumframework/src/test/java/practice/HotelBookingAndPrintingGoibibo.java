package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelBookingAndPrintingGoibibo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.get("https://www.goibibo.com/hotels/");
		
		driver.findElement(By.xpath("//h4[text()='India']/preceding-sibling::input[@name='CountryType']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")).sendKeys("Bengaluru");	
		
		driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']/following-sibling::ul[@id='downshift-1-menu']/li/span")).click();
		
//		List<WebElement> listOfCities = driver.findElements(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']/following-sibling::ul[@id='downshift-1-menu']"));
//		
//		for(WebElement ele:listOfCities) {
//			
//			System.out.println(ele.getText());
//			}
//		
		driver.findElement(By.xpath("//div[text()='Check-in']")).click();
		driver.findElement(By.xpath("//span[text()='March 2022']/ancestor::div[contains(@class,'CalenderMonthContainer')]/descendant::span[text()='31']")).click();
		driver.findElement(By.xpath("//div[text()='Check-out']")).click();
		driver.findElement(By.xpath("//span[text()='April 2022']/ancestor::div[contains(@class,'CalenderMonthContainer')]/descendant::span[text()='1']")).click();
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
		driver.findElement(By.xpath("//span[text()='Adults']/ancestor::div[contains(@class,'ContentItemWrapper')]/descendant::span[text()='-']")).click();
		for(int i=1;i<=3;i++) {
		driver.findElement(By.xpath("//span[text()='Children']/ancestor::div[contains(@class,'ContentItemWrapper')]/descendant::span[text()='+']")).click();
		}
		
		driver.findElement(By.xpath("//span[text()='Child ' and text()='1']/following-sibling::div[contains(@class, 'ContentActionWrapper')]")).click();
		driver.findElement(By.xpath("//span[text()='Child ' and text()='1']/following-sibling::div[contains(@class, 'ContentActionWrapper')]/following-sibling::ul[contains(@class,'ChildDropdownWrap')]/li[text()='5']")).click();
		
		driver.findElement(By.xpath("//span[text()='Child ' and text()='2']/following-sibling::div[contains(@class, 'ContentActionWrapper')]")).click();
		driver.findElement(By.xpath("//span[text()='Child ' and text()='2']/following-sibling::div[contains(@class, 'ContentActionWrapper')]/following-sibling::ul[contains(@class,'ChildDropdownWrap')]/li[text()='8']")).click();
		
		driver.findElement(By.xpath("//span[text()='Child ' and text()='3']/following-sibling::div[contains(@class, 'ContentActionWrapper')]")).click();
		driver.findElement(By.xpath("//span[text()='Child ' and text()='3']/following-sibling::div[contains(@class, 'ContentActionWrapper')]/following-sibling::ul[contains(@class,'ChildDropdownWrap')]/li[text()='10']")).click();
		
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Search Hotels']"))));
//		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		
//		WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search Hotels']"));
//		
//		jse.executeScript("arguments[0].click()", searchButton);
		
		driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
		
		List<WebElement> listOfHotels = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		
		for(WebElement ele :listOfHotels) 
		{
			System.out.println("Hotel Name    :" + ele.getText());
		}
		
		
	}

}
