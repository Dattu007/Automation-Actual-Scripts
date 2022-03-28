package com.crm.autodesk.productsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.audodesk.objectrepository.CreatingNewProductsPage;
import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodesk.objectrepository.ProductsInformationPage;
import com.crm.audodesk.objectrepository.ProductsPage;
import com.crm.audodeskgenericutility.BaseClass;

public class SearchProductByProductNoTest extends BaseClass {

	@Test(groups="integrationTest")
	public void searchProductByProductNoTest() throws Throwable {
		
		/*Generic Utility Object Creation*/
		/*From Base Class*/
		
		int num = jLib.getRandomNumber();
	
//		String expectedLoginPageTitle = eLib.getDataExcelWorkbook("TC003", 7, 1);
		String expectedHomePageTitle = eLib.getDataExcelWorkbook("TC003", 7, 2);
		String expectedProductPageTitle = eLib.getDataExcelWorkbook("TC003", 7, 3);
		String productName = eLib.getDataExcelWorkbook("TC003", 7, 4)+num;
		String expectedproInfoText = eLib.getDataExcelWorkbook("TC003", 7, 5);
		String searchVisibleText = eLib.getDataExcelWorkbook("TC003", 7, 6);
		
		
		/*Browser launch : Run Time Polymorphism*/
		/*From Base Class*/
		
		/*LoginPage Displayed Verification*/
		
//		String actualLoginPageTitle = loginPage.getTitleOfCurrentPage(driver);
//		
//		if(actualLoginPageTitle.equals(expectedLoginPageTitle)) {
//			System.out.println("PASS::Login Page is Displayed");
//		}else {
//			System.out.println("FAIL::Login Page is Not Displayed");
//			
//		}
		
		/*Login to Application*/
		/*using POM Class*/
		/*From Base Class*/
		
		/*Verifing Home Page Displayed*/
		
		HomePage homePage = new HomePage(driver);
		
		String actualHomePageTile = homePage.getTitleOfCurrentPage(driver);
		
		soft.assertEquals(actualHomePageTile, expectedHomePageTitle, "FAIL::Home Page is Not Displayed");
				
//		if(actualHomePageTile.equals(expectedHomePageTitle)) {
//			System.out.println("PASS::Home Page is Displayed");
//		}else {
//			System.out.println("FAIL::Home Page is Not Displayed");
//			
//		}
		
		/*Click On Products Link*/
		
		homePage.clickOnProductsLink();
		
		ProductsPage prodPage = new ProductsPage(driver);
		
		prodPage.clickOnPlusIconImage();
		
		
		/*Verification of Product page dispalyed*/
		
		String actualProductPageTile = prodPage.getTitleOfCurrentPage(driver);
		
		soft.assertEquals(actualProductPageTile, expectedProductPageTitle, "FAIL::Product Page is Not Displayed");
						
//		if(actualProductPageTile.equals(expectedProductPageTitle)) {
//			System.out.println("PASS::Product Page is Displayed");
//		}else {
//			System.out.println("FAIL::Product Page is Not Displayed");
//			
//		}
		
		/*Creating Product*/
		
		CreatingNewProductsPage creatNewProPage = new CreatingNewProductsPage(driver);
		creatNewProPage.createProduct(productName);
		
		
		/*Verification of Product Information Page*/
		
		ProductsInformationPage proInfoPage = new ProductsInformationPage(driver);
		String expectedProductNo = prodPage.expectedProductNoText();
		String actualProInfoText = proInfoPage.informationTextVerify();
		
		soft.assertEquals(actualProInfoText, expectedproInfoText, "FAIL::Product Information  is Not Displayed");
		
//		if(actualProInfoText.equals(expectedproInfoText)) {
//			System.out.println("PASS::Product Information Page is Displayed");
//		}else {
//			System.out.println("FAIL::Product Information  Page is Not Displayed");
//			
//		}
		
		/*Search for Product created*/
		
		homePage.clickOnProductsLink();
							
		String actualProductINo = prodPage.searchForProductNo(driver, expectedProductNo, searchVisibleText);
		
		
		/*Verification of product created*/
		
		Assert.assertEquals(actualProductINo, expectedProductNo, "FAIL:: Product not created and not verified using ProductNo");
		
//		if(actualProductINo.equals(expectedProductNo)) {
//			System.out.println("PASS:: Product created and Verified using ProductNo");
//		}else {
//			System.out.println("FAIL:: Product not created and not verified using ProductNo");
//		}
		
		
		/*Logout*/
		/*From Base Class*/
		
//		String actualLoginPageTitleAfterLogout = loginPage.getTitleOfCurrentPage(driver);
//		
//		if(actualLoginPageTitleAfterLogout.equals(expectedLoginPageTitle)) {
//			System.out.println("PASS::Login Page is Displayed after Logout");
//		}else {
//			System.out.println("FAIL::Login Page is Not Displayed after Logout");
//			
//		}
		
		soft.assertAll();
	}
	}

