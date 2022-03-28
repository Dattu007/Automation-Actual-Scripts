package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for CreatingNewProducts Page
 * @author Bharath Kumar
 * 
 * 
 */
public class CreatingNewProductsPage {
	
	/*intialization of Web Element*/
	public CreatingNewProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration of WebElement*/
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	/*Providing getters method*/
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*Business Logics*/
	/**
	 * This Method is used to create Product with passed product name
	 * @param productName
	 */
	public void createProduct(String productName) {
		productNameTextField.sendKeys(productName);
		saveButton.click();
	}
	
	
}
