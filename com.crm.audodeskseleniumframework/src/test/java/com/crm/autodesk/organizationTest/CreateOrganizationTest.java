package com.crm.autodesk.organizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.audodesk.objectrepository.CreatingNewOrganizationPage;
import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodesk.objectrepository.OrganizationInformationPage;
import com.crm.audodesk.objectrepository.OrganizationPage;
import com.crm.audodeskgenericutility.BaseClass;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createOrganizationTest() throws Throwable {
		
		/* Create objects of Utility classes*/
		/*From BaseClass*/
			
		/*Read Test Data from Excel File*/
		
		/*from Java Utility*/
		int num = jLib.getRandomNumber();
		
		/*from Excell Utility*/
		String orgName = eLib.getDataExcelWorkbook("TC001", 1, 0)+num;
		
		
		/*Read the common data from Property file*/
		
		/*From File Utility */
		/*From BaseClass*/
		
		/*Launching the required browser , run time polymorphism*/
		/*From BaseClass*/
		
		/*From WebDriver Utility*/
		/*From BaseClass*/
		
		/*Step1:- Login to Application*/
		/*using POM Class*/
		/*From BaseClass*/
	
		
		/*Step2:- Create Organization*/
		/*using POM Class*/
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganizationLink();
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickOnplusIconImage();
		
		CreatingNewOrganizationPage CreatNewOrgPage = new CreatingNewOrganizationPage(driver);
		CreatNewOrgPage.createOrganization(orgName);
		
		
		/*Step3:- Verification for organization creation*/
		/*using POM Class*/
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actuaorgName = orgInfoPage.OrganizationInformationHeaderText();
		
		/*From TestNg Assertion*/
		
		Assert.assertEquals(actuaorgName.contains(orgName), true, " " +orgName +"is not verified : FAIL");
//		if (actuaorgName.contains(orgName)) {
//			System.out.println(orgName +   "is verified : PASS");
//		}else {
//			System.out.println(orgName +   "is not verified : FAIL");
//		}

		/*Step4 :- Logout from Application*/ 
		/*using POM Class*/
		/*From BaseClass*/
				
	}

}
