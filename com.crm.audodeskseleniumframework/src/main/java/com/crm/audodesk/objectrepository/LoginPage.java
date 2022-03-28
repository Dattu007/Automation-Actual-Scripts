package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object repository for Login Page
 * @author Bharath Kumar 
 *
 */
public class LoginPage {
	
	
	/*Initialization of Web Elements*/
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Declaration of Web Element*/
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	/*generating only getters method*/
	
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	/*Buisness Logics*/
	/**
	 * This Method will login to Application
	 * @param userNameData
	 * @param passwordData
	 */
	public void loginToApp(String userNameData, String passwordData) {
		userNameTextField.sendKeys(userNameData);
		passwordTextField.sendKeys(passwordData);
		loginButton.click();
	}
	/**
	 * This Method will return the Title of the Current Page
	 * @param driver
	 * @return
	 */
	public String getTitleOfCurrentPage(WebDriver driver) {
		return driver.getTitle();
		
	}
	
}
