package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CrmLib {
	
	public void loginToApp(WebDriver driver, String usernameData, String passwordData) {
		
	driver.findElement(By.name("user_name")).sendKeys(usernameData);
	driver.findElement(By.name("user_password")).sendKeys(passwordData);
	driver.findElement(By.id("submitButton")).click();
	}
	
	public void LogoutToApp(WebDriver driver) {
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
