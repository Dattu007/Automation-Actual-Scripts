package Sample;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganization {

	
	public static void main(String[] args) throws IOException {
		
		Random ran = new Random();
		int number = ran.nextInt(1000);
		
		String orgName = "TMantraa" +"_"+number;
		
		ExcelLibrary lib = new ExcelLibrary();
		
		String usernameData = lib.getData("TC001", 1, 0);
		String passwordData = lib.getData("TC001", 1, 1);		
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
	
		
		driver.findElement(By.name("user_name")).sendKeys(usernameData);
		driver.findElement(By.name("user_password")).sendKeys(passwordData);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actualText = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(actualText.contains(orgName)) {
			System.out.println(orgName +"is verified and PASS");
		}else {
			System.out.println(orgName +"is not verified and PASS");
		}
		
		driver.quit();
		
	}

}
