package com.crm.audodesk.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.audodeskgenericutility.WebDriverUtility;
/**
 * Object Repository for OrganizationSearch Page
 * @author Bharath Kumar
 *
 */
public class OrganizationSearchPage extends WebDriverUtility{
	
	/*Initialization of Web Element*/
	public OrganizationSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration of WebElement*/
		
	@FindBy(name="search_text")
	private WebElement organizationSearchTextField;
	
	@FindBy(name="search")
	private WebElement searchNowButton;
	
	/*Providing getters method*/


	public WebElement getOrganizationSearchTextField() {
		return organizationSearchTextField;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	

	/**
	 * This Method will search the created organization and clicks on it
	 * @param driver
	 * @param orgName
	 */
	public void clickOnCreatedOrganization(WebDriver driver, String orgName, String partialTitle) {
		organizationSearchTextField.sendKeys(orgName);
		searchNowButton.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, partialTitle);
	}
	
	
}
