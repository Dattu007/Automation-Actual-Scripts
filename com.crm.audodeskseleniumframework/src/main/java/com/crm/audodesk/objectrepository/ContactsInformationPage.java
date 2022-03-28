package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for ContactInformation Page
 * @author Bharath Kumar
 *
 */
public class ContactsInformationPage {
	
	/*Intialization of Web Element*/
	public ContactsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration of Web Element*/
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactInformationHeader;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']/child::a[contains(@href,'index.php?module=Accounts&action=DetailView&record')]")
	private WebElement confirmOrganizationTextField;

	public WebElement getContactInformationHeader() {
		return contactInformationHeader;
	}
	
	
	public WebElement getConfirmOrganizationTextField() {
		return confirmOrganizationTextField;
	}


	/*Buiseness Logics*/
	/**
	 * This Method is used to get text of contactInformationHeader WebElement
	 * @return
	 */
	public String contactInformationHeaderText() {
		return contactInformationHeader.getText();
	}
	
	/**
	 * This Method will return the confirmOrganizationTextField Web Element
	 * @return
	 */
	
	public String confirmOrganizationTextFieldText() {
		return confirmOrganizationTextField.getText();
	}
	
}
