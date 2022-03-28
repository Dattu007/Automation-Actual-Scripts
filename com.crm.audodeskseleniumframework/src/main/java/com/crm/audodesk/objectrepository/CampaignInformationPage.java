package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for CampaignInformation Page
 * @author Bharath Kumar
 *
 */
public class CampaignInformationPage {
	
	/*Initialization of Web Element*/
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration of WebElement*/
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement confirmCampaignHeader;
	
	@FindBy(xpath="//span[@id='dtlview_Product']/child::a[contains(@href, 'Products&action')]")
	private WebElement confirmProductTextField;
	
	/*Providing Getters methods*/

	public WebElement getConfirmCampaignHeader() {
		return confirmCampaignHeader;
	}

	public WebElement getConfirmProductTextField() {
		return confirmProductTextField;
	}
	
	/*Buiseness logics*/
	/**
	 * This Method will return the text of confirmCampaignHeader Web element
	 * @return
	 */
	public String confirmCampaignHeaderText() {
		return confirmCampaignHeader.getText();
	}
	
	/**
	 * This Method will Return the text of confirmProductTextField WebElement
	 * @return
	 */
	public String confirmProductTextFieldText() {
		return confirmProductTextField.getText();
	}
}
