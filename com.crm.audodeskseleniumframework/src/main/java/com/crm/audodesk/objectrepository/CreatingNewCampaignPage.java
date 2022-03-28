package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.audodeskgenericutility.WebDriverUtility;
/**
 * Object Repository for CreatingNewCampaign Page
 * @author Bharath Kumar
 *
 */
public class CreatingNewCampaignPage extends WebDriverUtility{
	
	/*Initialization of Web Element*/
	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration of WebElement*/
	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement productAddIconImage;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	/*Providing getters methods*/

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getProductAddIconImage() {
		return productAddIconImage;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*Buiseness Logics*/
	/**
	 * This Method will enter the Campaign name passed
	 * @param campaignName
	 */
	public void createCampaignName(WebDriver driver,String campaignName, String PartialTitle) {
		campaignNameTextField.sendKeys(campaignName);
		productAddIconImage.click();
		switchToWindow(driver,PartialTitle );
	}
	
	/**
	 * This method will click on Save Button
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
	
}
