package com.crm.audodesk.objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.audodeskgenericutility.WebDriverUtility;
/**
 * Object Repository for OrganizationPage
 * @author Bharath Kumar
 *
 */
public class OrganizationPage extends WebDriverUtility {
	
	/*Initialization of Web Element*/
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration of Web Element*/
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement plusIconImage;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[3]")
	private List<WebElement> allOrganizationsList;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']/descendant::a[@title='Next']")
	private WebElement forwardButton;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']/descendant::a[@title='Previous']")
	private WebElement previousButton;
	
	//table[@class='layerPopupTransport']/descendant::a[@title='Previous']
	@FindBy(xpath="//table[@class='layerPopupTransport']/descendant::input[@name='pagenum']")
	private WebElement pageNumberTextBox;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']/descendant::span[@name='Accounts_listViewCountContainerName']")
	private WebElement totalPageNumberTextBox;
	
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(xpath="//div[@id='basicsearchcolumns_real']/child::select[@id='bas_searchfield']")
	private WebElement typeOfSearchDorpDown;
	

	@FindBy(name="submit")
	private WebElement searchNowButton;
	
	/*providing getters method */
	public WebElement getPlusIconImage() {
		return plusIconImage;
	}
	
	
	public List<WebElement> getAllOrganizationsList() {
		return allOrganizationsList;
	}

	public WebElement getForwardButton() {
		return forwardButton;
	}

	public WebElement getPreviousButton() {
		return previousButton;
	}


	public WebElement getPageNumberTextBox() {
		return pageNumberTextBox;
	}

	public WebElement getTotalPageNumberTextBox() {
		return totalPageNumberTextBox;
	}


	public WebElement getSearchTextField() {
		return searchTextField;
	}


	public WebElement getTypeOfSearchDorpDown() {
		return typeOfSearchDorpDown;
	}


	public WebElement getSearchNowButton() {
		return searchNowButton;
	}


	/*Buiseness Logics*/
	/**
	 * This method will click on plus Icon Image in Organization page
	 */
	public void clickOnplusIconImage() {
		plusIconImage.click();
	}
	
	/**
	 * This method will search for organization in Organization page
	 */
	public void searchForOrganizations(String orgName,String visibleText) {
		searchTextField.sendKeys(orgName);
		select(typeOfSearchDorpDown, visibleText);
		searchNowButton.click();
		
	}
	
	/**
	 * This method will click on the particular organization from list
	 */
	public void clickOnParticularOrg(WebDriver driver,String orgName) {
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td/a[text()='"+orgName+"']")).click();
		
	}
	
	/**
	 * This method will return total count of pages in organization list page
	 */
	public int totalCountOfPages() {
		
		String totalPageNumText = totalPageNumberTextBox.getText();
		
		String temp = totalPageNumText.split(" ")[1];
		
		return Integer.parseInt(temp);
		
	}
	
	
	
	
}
