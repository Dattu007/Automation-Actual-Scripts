package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.audodeskgenericutility.WebDriverUtility;

/**
 * Object Repository for CreatingNewOrganization Page
 * @author Bharath Kumar
 *
 */

public class CreatingNewOrganizationPage extends WebDriverUtility {
	
	/*Intialization of WebElement*/
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*Declaration of WebElement*/
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="industry")
	private WebElement industryDropDownList;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDownList;


	/*Providing getters methods*/
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getIndustryDropDownList() {
		return industryDropDownList;
	}
	
	public WebElement getTypeDropDownList() {
		return typeDropDownList;
	}

	/*Business Logics*/
	/**
	 * This method Cretes organization with organization name passed
	 * @param orgName
	 */
	
	public void createOrganization(String orgName) {
		organizationNameTextField.sendKeys(orgName);
		saveButton.click();
	}
	
	/**
	 * This method creates organization with Industry and Type
	 * @param orgName
	 * @param industryValue
	 * @param typeValue
	 */
	
	public void createOrganizationWithIndustryAndType(String orgName, String industryValue, String typeValue){
		organizationNameTextField.sendKeys(orgName);
		select(industryDropDownList, industryValue);
		select(typeDropDownList, typeValue);
		saveButton.click();
		
	}
	

}
