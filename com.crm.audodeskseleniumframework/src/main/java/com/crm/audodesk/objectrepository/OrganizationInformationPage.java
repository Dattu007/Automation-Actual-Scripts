package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for OrganizationInformation Page
 * @author Bharath Kumar
 *
 */
public class OrganizationInformationPage {
	
	/*Intialization of Web Element*/
	public OrganizationInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of Web Element*/
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationInformationHeader;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement confirmOrganizationNameTextField;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement confirmIndustryTextField;
	
	@FindBy(id="mouseArea_Type")
	private WebElement confirmTypeTextField;
	
	@FindBy(xpath="//td[@class='dvtTabCache']/child::input[@name='Delete']")
	private WebElement deleteButton;
	

	/*Providing getters method*/

	public WebElement getOrganizationInformationHeader() {
		return organizationInformationHeader;
	}

	public WebElement getConfirmOrganizationNameTextField() {
		return confirmOrganizationNameTextField;
	}
	
	public WebElement getConfirmIndustryTextField() {
		return confirmIndustryTextField;
	}

	public WebElement getConfirmTypeTextField() {
		return confirmTypeTextField;
	}
	

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	/*Business Logics*/
	/**
	 * This method returns the text of the OrganizationInformationHeader WebElement
	 * @return
	 */
	public String OrganizationInformationHeaderText() {
		return organizationInformationHeader.getText();
	}
	
	/**
	 * This method will returns the text of confirmIndustryTextField WebElement
	 * @return
	 */
	public String confirmIndustryText() {
		return confirmIndustryTextField.getText();
	}
	
	/**
	 * This method will returns the text of confirmTypeTextField WebElement
	 * @return
	 */
	public String confirmTypeText() {
		return confirmTypeTextField.getText();
	}
	
	/**
	 * This method will click on Delete Button on Organization Information Page
	 * @return
	 */
	public void clickOnDeleteButton(WebDriver driver) {
		deleteButton.click();
		driver.switchTo().alert().accept();
	}
	

}
