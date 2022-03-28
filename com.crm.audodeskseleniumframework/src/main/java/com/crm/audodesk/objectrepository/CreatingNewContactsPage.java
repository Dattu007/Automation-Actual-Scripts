package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.audodeskgenericutility.WebDriverUtility;
/**
 * Object REpository for CreatingNewContact Page
 * @author Bharath Kumar
 *
 */
public class CreatingNewContactsPage extends WebDriverUtility   {
	
	/*Intialization of Web Element*/
	public CreatingNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration for Web Element*/
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement orgnaizationSelectPlusIconImage;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	
	public WebElement getOrgnaizationSelectPlusIconImage() {
		return orgnaizationSelectPlusIconImage;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*Buiseness Logics*/
	/**
	 * This Method creates contact with passed lastName
	 * @param lastName
	 */
	public void createContact(String lastName) {
		lastNameTextField.sendKeys(lastName);
		saveButton.click();
	}
	
	/**
	 * This method will click on orgnaizationSelectPlusIconImage 
	 */
	public void clickOnOrgSelectPlusIconImage() {
		orgnaizationSelectPlusIconImage.click();
	}
	
	public void enterTextToLastNameTextField(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}
	/**
	 * This Method will click on Save button
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}
	/**
	 * This Method will Create Contact and Switch to Organization Search Page for Organization selection
	 */
	public void createContactWithOrgName(WebDriver driver, String lastName,String partialTitle) {
		lastNameTextField.sendKeys(lastName);
		orgnaizationSelectPlusIconImage.click();
		switchToWindow(driver, partialTitle);
	}
	
}
