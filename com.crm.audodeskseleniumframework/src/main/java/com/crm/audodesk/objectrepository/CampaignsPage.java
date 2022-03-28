package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object repository for Campaigns Page
 * @author Bharath Kumar
 *
 */
public class CampaignsPage {
	
	/*Intialization of Web Element*/
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*declaration of WebElement*/
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement plusIconImage;

	/*Providing getters method*/
	public WebElement getPlusIconImage() {
		return plusIconImage;
	}
	
	/*Business Logics*/
	/**
	 * This Method will click on plus Icon Image of Campaigns page 
	 */
	public void clickOnPlusIconImage() {
		plusIconImage.click();
	}
	
	
}
