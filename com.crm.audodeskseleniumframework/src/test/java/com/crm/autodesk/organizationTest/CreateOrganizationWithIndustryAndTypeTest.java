package com.crm.autodesk.organizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.audodesk.objectrepository.CreatingNewOrganizationPage;
import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodesk.objectrepository.OrganizationInformationPage;
import com.crm.audodesk.objectrepository.OrganizationPage;
import com.crm.audodeskgenericutility.BaseClass;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {

	@Test(groups="systemTest")
	public void createOrgWithIndusAndTypeTest() throws Throwable {
		
		/* Create objects of Utility classes*/
		/*From BaseClass*/
		
		/*Read Test Data from Excel File*/
		
		/*from Java Utility*/
		
		int num = jLib.getRandomNumber();
		
		/*from Excell Utility*/
		
		String orgName = eLib.getDataExcelWorkbook("TC001", 1, 0)+num;
		String indutryType = eLib.getDataExcelWorkbook("TC001", 1, 3); 
		String type = eLib.getDataExcelWorkbook("TC001", 1, 4);
		
		
		/*Read the common data from Property file*/
		
		/*From File Utility */
		/*From BaseClass*/
		
		/*Launching the required browser , run time polymorphism*/
		/*From BaseClass*/
		
		/*Step1:- Login to Application*/
		/*Using POM class*/
		/*From BaseClass*/
		
		/*Step2:- Create Organization with Industry and Type*/
		/*Using POM class*/
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganizationLink();
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickOnplusIconImage();
		
		CreatingNewOrganizationPage createNewOrgPage = new CreatingNewOrganizationPage(driver);
		createNewOrgPage.createOrganizationWithIndustryAndType(orgName, indutryType, type);
	
		
		/*Step3:- Verification for organization creation*/
		/*Using POM class*/
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		
		String actuaorgName = orgInfoPage.OrganizationInformationHeaderText();
		
		Assert.assertEquals(actuaorgName.contains(orgName), true,""+orgName +"   is not verified : FAIL");
		
//		if (actuaorgName.contains(orgName)) {
//			System.out.println(orgName +"   is verified : PASS");
//		}else {
//			System.out.println(orgName +"   is not verified : FAIL");
//		}
		
		/*Step4:- Verification for industry type*/
		/*Using POM class*/
		
		String actualIndustryType = orgInfoPage.confirmIndustryText();
		
		Assert.assertEquals(actualIndustryType, indutryType,""+indutryType +"   is not verified : FAIL");
			
//		if (actualIndustryType.equals(indutryType)) {
//			System.out.println(indutryType +"   is verified : PASS");
//		}else {
//			System.out.println(indutryType +"   is not verified : FAIL");
//		}
		
		/*Step5:- Verification for  type*/
		/*Using POM class*/
		
		String actualType = orgInfoPage.confirmTypeText();
		
		Assert.assertEquals(actualType, type, ""+type +"   is not verified : FAIL");
				
//		if (actualType.equals(type)) {
//			System.out.println(type +"   is verified : PASS");
//		}else {
//			System.out.println(type +"   is not verified : FAIL");
//		}

		/*Step6 :- Logout from Application */
		/*Using POM class*/
		/*From BaseClass*/

	}

}
