package com.crm.autodesk.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.audodesk.objectrepository.CampaignInformationPage;
import com.crm.audodesk.objectrepository.CampaignsPage;
import com.crm.audodesk.objectrepository.CreatingNewCampaignPage;
import com.crm.audodesk.objectrepository.CreatingNewProductsPage;
import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodesk.objectrepository.ProductSearchPage;
import com.crm.audodesk.objectrepository.ProductsInformationPage;
import com.crm.audodesk.objectrepository.ProductsPage;
import com.crm.audodeskgenericutility.BaseClass;

public class CreateCampaignWithProductTest extends BaseClass{

	@Test(groups="systemTest")
	public void createCampWithProductTest() throws Throwable {
		
		/* Create objects of Utility classes*/
		/*From Base Class*/
		
		
		/*from Java Utility*/
		int num = jLib.getRandomNumber();
		
		/*Read the Test data from Excel sheet*/
		/*from Excel Utility*/
		String campaignNameData = eLib.getDataExcelWorkbook("TC004", 1, 0)+num;
		String productNameData = eLib.getDataExcelWorkbook("TC004", 1, 1)+num;
		String partialTitleChild = eLib.getDataExcelWorkbook("TC004", 1, 2);
		String partialTitleParent = eLib.getDataExcelWorkbook("TC004", 1, 3);
		
		/*Reading common data from property file*/
		
		/*From File Utility */
		/*From Base Class*/
		
		/*Launching different browser based on property input file, runtime Polymorphism*/
		/*From Base Class*/
		
		/*Step1:= Login to Application*/	

		
		/*using POM Class*/
		/*From Base Class*/
		
		/*Step2:- Create Product with Manadatory Fields*/
		/*using POM Class*/
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnProductsLink();
		
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.clickOnPlusIconImage();
		
		CreatingNewProductsPage createNewProPage = new CreatingNewProductsPage(driver);
		createNewProPage.createProduct(productNameData);
		
		
		/*Step3:= Verification of Product creation*/
		/*using POM Class*/
		
		ProductsInformationPage proInfoPage = new ProductsInformationPage(driver);
		String actualProductName = proInfoPage.confirmProductHeaderText();
		
		Assert.assertEquals(actualProductName.contains(productNameData), true,""+productNameData +"   productName is not verified and not created :: FAIL");
		
//		if(actualProductName.contains(productNameData)) {
//			System.out.println(productNameData +"   productName is verified and created :: PASS");
//		}else {
//			System.out.println(productNameData +"   productName is not verified and not created :: FAIL");
//		}
		
		/*Step4:- Create Campaign with adding products*/
		
		/*using POM Class*/
		
		homePage.clickOnCampaignsLink(driver);	
		
		CampaignsPage campPage = new CampaignsPage(driver);
		campPage.clickOnPlusIconImage();
		
		CreatingNewCampaignPage createNewCampPage = new CreatingNewCampaignPage(driver);
		createNewCampPage.createCampaignName(driver,campaignNameData,partialTitleChild);
						
		/*Step5:- Switch to child window*/
		
		/*using POM Class*/
		ProductSearchPage proSearchPage = new ProductSearchPage(driver);
		proSearchPage.clickOnProductsfromList(driver, productNameData,partialTitleParent);
				
		/*Step5:- Switch to Parent window*/
		/*using POM Class*/
		createNewCampPage.clickOnSaveButton();
		
		/*Step6:= Verification of Campaign creation*/
		/*using POM Class*/
		
		CampaignInformationPage campInfoPage = new CampaignInformationPage(driver);
		String actualCampaignName = campInfoPage.confirmCampaignHeaderText();
		
		Assert.assertEquals(actualCampaignName.contains(campaignNameData), true, ""+campaignNameData+ "   campaignName is not verified");
		
//		if(actualCampaignName.contains(campaignNameData)) {
//			System.out.println(campaignNameData+ "   campaignName is verified");
//		}else {
//			
//			System.out.println(campaignNameData+ "   campaignName is not verified");
//		}

		/*Step7:= Verification of Campaign creation with product */
		/*using POM Class*/
		
		String actualProductNameAdd = campInfoPage.confirmProductTextFieldText();
		
		Assert.assertEquals(actualProductNameAdd, productNameData,""+productNameData+ "    productName  is not verified and not added in Campaign :: FAIL");
			
//		if(actualProductNameAdd.equals(productNameData)) {
//			System.out.println(productNameData+ "    productName is verified and added in Camapaign :: PASS");
//		}else {
//			
//			System.out.println(productNameData+ "    productName  is not verified and not added in Campaign :: FAIL");
//		}
		
		/*Step8:= Logout from the App*/
		
		/*using POM Class*/
		
		/*From Base Class*/
		
	}

}
