package com.crm.audodesk.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.audodeskgenericutility.WebDriverUtility;
/**
 * Object Repository for Products Page
 * @author Bharath Kumar
 *
 */
public class ProductsPage extends WebDriverUtility {
	
	/*Initialization of WebElement*/
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*Declaration of Web Element*/
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement plusIconImage;
	
	@FindBy(name="search_text")
	private WebElement searchForTextField;
	
	@FindBy(xpath="//div[@id='basicsearchcolumns_real']/child::select[@id='bas_searchfield']")
	private WebElement productSearchFieldDropDown;
	
	@FindBy(name="submit")
	private WebElement searchNowButton;
	
	@FindBy(xpath="//tr[@class='lvtColData']/descendant::a[@title='Products']")
	private WebElement productsCreated;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[3]/td[3]")
	private WebElement tableApprochProductName;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[3]/td[2]")
	private WebElement tableApprochProductNo;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']/child::font")
	private WebElement productNo;

	/*providing getters Method*/
	
	public WebElement getPlusIconImage() {
		return plusIconImage;
	}
	
	public WebElement getSearchForTextField() {
		return searchForTextField;
	}

	public WebElement getProductSearchFieldDropDown() {
		return productSearchFieldDropDown;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

	public WebElement getProductsCreated() {
		return productsCreated;
	}

	public WebElement getTableApprochProductName() {
		return tableApprochProductName;
	}
	
	public WebElement getTableApprochProductNo() {
		return tableApprochProductNo;
	}

	public WebElement getProductNo() {
		return productNo;
	}

	/*Buiseness Logics*/
	/**
	 * This Method will click on Plus Icom Image of Products page
	 */
	public void clickOnPlusIconImage() {
		plusIconImage.click();
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
	 * This Method will search the product in the products list with Product name
	 * @param driver
	 * @return 
	 * @return
	 * @throws Throwable 
	 */
	public String searchForProductName( WebDriver driver, String productName,String visibleText) throws Throwable {
		searchForTextField.sendKeys(productName);
		select(productSearchFieldDropDown, visibleText);
		searchNowButton.click();
		
		String actualText =driver.findElement(By.xpath("//table[@class='lvt small']/tbody/descendant::a[text()='"+productName+"']")).getText();
		
		return actualText;
	}
	
	/**
	 * This Method will search the product in the products list with Product No
	 * @param driver
	 * @return
	 * @throws Throwable 
	 */
	public String searchForProductNo( WebDriver driver,String productNo,String visibleText) throws Throwable {
		searchForTextField.sendKeys(productNo);
		select(productSearchFieldDropDown, visibleText);
		searchNowButton.click();
		
		String actualText =driver.findElement(By.xpath("//table[@class='lvt small']/tbody/descendant::td[text()='"+productNo+" ']")).getText();
		
		return actualText;
		
	}
	
	/**
	 * This Method will wait for the Element to be visible
	 * @param driver
	 * @return
	 */
	public void elementToBeVisible(WebDriver driver, WebElement element) {
		
		waitForElementToBeVisible(driver, element);	
	}
	
	/**
	 * This Method will  searched the product in the products list and returns text of passed element
	 * @param driver
	 * @return
	 */
	
	public String searchedProductByTableTextProductName() {
		
		return tableApprochProductName.getText();
	}
	
	/**
	 * This Method will  searched the product in the products list and returns text of passed element
	 * @param driver
	 * @return
	 */
	
	public String searchedProductByTableTextProductNo() {
		
		return tableApprochProductNo.getText();
	}
	
	/**
	 * This Method will  return the expected Product No 
	 * @param driver
	 * @return
	 */
	
	public String expectedProductNoText() {
		
		String temp =productNo.getText();
		String expectedProductNo= temp.split(" ")[1];
		return expectedProductNo;
	}

}
