package com.crm.audodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object repository for ProductsInformation Page
 * @author Bharath Kumar
 *
 */
public class ProductsInformationPage {
	
	/*Initialization of WebElement*/
	public ProductsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*Declaration of Web Element*/
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement confirmProductHeaderText;
	
	@FindBy(xpath="//td[@class='dvtSelectedCell']")
	private WebElement informationText;

	/*Providing getters method*/
	public WebElement getConfirmProductHeaderText() {
		return confirmProductHeaderText;
	}

	public WebElement getInformationText() {
		return informationText;
	}


	/*Business Logics*/
	/**
	 * This Method is used to get text of confirmProductHeaderText web Element
	 * @return
	 */
	public String confirmProductHeaderText() {
		return confirmProductHeaderText.getText();
	}
	
	/**
	 * This Method is used to get text of informationText web Element
	 * @return
	 */
	public String informationTextVerify() {
		return informationText.getText();
	}
	
}
