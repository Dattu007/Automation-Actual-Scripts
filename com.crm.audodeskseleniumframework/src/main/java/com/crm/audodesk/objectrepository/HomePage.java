package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.audodeskgenericutility.WebDriverUtility;

/**
 * Object repository for Home Page
 * @author Bharath Kumar 
 *
 */
public class HomePage extends WebDriverUtility{
	
	/*Intialization of Web Element*/
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	/*Declaration of Web Element*/
	@FindBy(xpath="//td[@class='tabUnSelected']/child::a[text()='Organizations']")
	private WebElement organizationLink;
	
	@FindBy(xpath="//td[@class='tabSelected']/child::a[text()='Organizations']")
	private WebElement organizationLinkAfterCreation;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(name="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeIconLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement dropDownUserImage;	
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	

	/*Providing getters method to use in test scripts*/
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	
	public WebElement getOrganizationLinkAfterCreation() {
		return organizationLinkAfterCreation;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	

	public WebElement getHomeIconLink() {
		return homeIconLink;
	}

	public WebElement getDropDownUserImage() {
		return dropDownUserImage;
	}
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}


	/**
	 * This Method will click on Organization link
	 */
	public void clickOnOrganizationLink() {
		organizationLink.click();
	}
	
	/**
	 * This Method will click on Organization link
	 * @throws Throwable 
	 */
	public void clickOnOrganizationLinkAfterCreation() throws Throwable {
		organizationLinkAfterCreation.click();
		
	}
	
	/**
	 * This Method will click on Contacts link
	 */
	public void clickOnContactsLink() {
		contactsLink.click();
	}
	
	/**
	 * This Method will click on Products link
	 */
	public void clickOnProductsLink() {
		productsLink.click();
	}
	
	/**
	 * This Method will click on Campaigns link
	 */
	public void clickOnCampaignsLink(WebDriver driver) {
		
		mouseCurserMoveToElement(driver, moreLink);
		mouseCurserMoveToElementAndClick(driver, campaignsLink);
	}
	
	
	/**
	 * This Method logout from the Application
	 * @param driver
	 */
	
	public void logout(WebDriver driver) {
		mouseCurserMoveToElement(driver, dropDownUserImage);
		signOutLink.click();
	}
	
	/**
	 * This Method will return the Title of the Current Page
	 * @param driver
	 * @return
	 */
	public String getTitleOfCurrentPage(WebDriver driver) {
		return driver.getTitle();
		
	}
	
	/**
	 * This Method will click on Home Icon image on Home Page
	 * @param driver
	 * @return
	 */
	public void clickOnHomeIconLink(WebDriver driver) {
		homeIconLink.click();
		
	}
	

}
