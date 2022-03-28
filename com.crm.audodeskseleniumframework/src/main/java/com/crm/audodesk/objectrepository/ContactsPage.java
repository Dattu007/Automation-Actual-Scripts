package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object Repository for Contacts Page
 * @author Bharath Kumar
 *
 */
public class ContactsPage {
	
	/*Initialization of Web Element*/
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration of Web Element*/
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement plusIconImage;

	
	/*providing getters method*/
	
	public WebElement getPlusIconImage() {
		return plusIconImage;
	}
	
	/*	Buiseness Logics*/
	
	/**
	 * This method will click on plusIconImage
	 */
	public void clickOnPlusIconImage() {
		plusIconImage.click();
	}
	
}
