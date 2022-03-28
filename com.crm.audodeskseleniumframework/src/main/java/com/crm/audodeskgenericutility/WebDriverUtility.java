package com.crm.audodeskgenericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * contains WebDriver generic methods
 * @author Bharath Kumar 
 *
 */
public class WebDriverUtility extends JavaUtility{
	
	/**
	 * This method wait for page to load and element present in DOM 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * This method wait for page to load and element present in DOM for javascript execution
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method wait for the element to become clickable in DOM .
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method wait for the element to become Invisible in DOM .
	 * @param driver
	 * @param element
	 */
	public void waitForElementToInvisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * This method wait for the element to become visible in DOM .
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method wait for the elements to become visible in DOM .
	 * @param driver
	 * @param element
	 */
	public void waitForElementsToBeVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	/**
	 * This method wait for the elements to become visible in DOM .
	 * @param driver
	 * @param element
	 */
	public void waitForElementAtrributeToBe(WebDriver driver, List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	
	
	/**
	 * This method will switch the control to the Passed title window
	 * @param driver
	 * @param partialWindowId
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		
		while(it.hasNext()) {
			 String id = it.next();
			 driver.switchTo().window(id);
			 if(driver.getTitle().contains(partialWindowTitle)) {
				 break;
			 }
		}
	}
	/**
	 * This method will move the mouse cursor to the supplied target element	
	 * @param driver
	 * @param element
	 */
		
	public void mouseCurserMoveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	
	/**
	 * This method will move the mouse cursor to the supplied target element and clicks on it	
	 * @param driver
	 * @param element
	 */
		
	public void mouseCurserMoveToElementAndClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		
	}
	
	/**
	 * This method will Select the supplied visibiletext from the passed Drop List	
	 * @param driver
	 * @param element
	 */
	
	public void select(WebElement element, String visibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This Method will click on any point in WebPage 
	 * @param driver
	 * @param xPixel
	 * @param yPixel
	 */
	public void clickOnWebPageByValue(WebDriver driver,int xPixel, int yPixel) {
		Actions action = new Actions(driver);
		action.moveByOffset(xPixel, yPixel).click().perform();
		
	}
	
	/**
	 * This Method will click on any point in WebPage 
	 * @param driver
	 * @param xPixel
	 * @param yPixel
	 * @return 
	 * @throws IOException 
	 */
	public String screenShotPicture(WebDriver driver, String nameofScreenshot) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		String newPath = "./errorshot/"+getSystemDateWithTimeZone()+nameofScreenshot+".png";
		
		File destination= new File(newPath);
		FileUtils.copyFile(tempfile, destination);
		
		return destination.getAbsolutePath();
	}


}
