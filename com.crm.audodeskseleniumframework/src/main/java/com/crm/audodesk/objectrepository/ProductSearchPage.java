package com.crm.audodesk.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.audodeskgenericutility.WebDriverUtility;

public class ProductSearchPage extends WebDriverUtility {
	
	/*Initialization of Web Element*/
	public ProductSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	/*Declaration of Web Element*/
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchNowButton;

	/*Providing getters method*/
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	/*Buiseness Logics*/
	
	public void clickOnProductsfromList(WebDriver driver, String productName,String PartialTitle) {
		searchTextField.sendKeys(productName);
		searchNowButton.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		switchToWindow(driver, PartialTitle);
		
	}
	
	
}
