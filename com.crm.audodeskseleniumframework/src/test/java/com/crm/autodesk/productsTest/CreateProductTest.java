package com.crm.autodesk.productsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.audodesk.objectrepository.CreatingNewProductsPage;
import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodesk.objectrepository.ProductsInformationPage;
import com.crm.audodesk.objectrepository.ProductsPage;
import com.crm.audodeskgenericutility.BaseClass;

public class CreateProductTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createProductTest() throws Throwable {
		
		/* Create objects of Utility classes*/
		/*From Base Class*/
		
		/*from Java Utility*/
		int num = jLib.getRandomNumber();
		
		/* Read Test Data from Excel file*/
		/*From Excel Library*/
		
		String productNameData = eLib.getDataExcelWorkbook("TC003", 1, 0)+num;
		
		/*Read Common Data from Property file*/
		
		/*From File Utility */
		/*From Base Class*/
		
		/*Launching the Required Browser, Run time ployphorsim*/
		/*From Base Class*/
		
		/*Step1:= Login to Application*/
		/*From Base Class*/
		
		/*using POM Class*/
		/*From Base Class*/
		
		
		/*Step2:= Create a Product with mandatory fields*/
		/*using POM Class*/
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnProductsLink();
		
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.clickOnPlusIconImage();
		
		CreatingNewProductsPage createNewProPage = new CreatingNewProductsPage(driver);
		createNewProPage.createProduct(productNameData);
		
		/*Step3:= Verification of Product creation*/
		/*using POM Class*/
		
		ProductsInformationPage ProInfoPage = new ProductsInformationPage(driver);
		String actualProductName = ProInfoPage.confirmProductHeaderText();
		
		Assert.assertEquals(actualProductName.contains(productNameData), true,""+productNameData +"    productName is not verified and not created :: FAIL");
		
//		if(actualProductName.contains(productNameData)) {
//			System.out.println(productNameData +"    productName is verified and created :: PASS");
//		}else {
//			System.out.println(productNameData +"    productName is not verified and not created :: FAIL");
//		}
		
		/*Step4:= Logout from the App*/
		
		/*using POM Class*/
		/*From Base Class*/
	}

}
