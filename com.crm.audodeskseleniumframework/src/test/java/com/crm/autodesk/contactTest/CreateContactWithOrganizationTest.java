package com.crm.autodesk.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.audodesk.objectrepository.ContactsInformationPage;
import com.crm.audodesk.objectrepository.ContactsPage;
import com.crm.audodesk.objectrepository.CreatingNewContactsPage;
import com.crm.audodesk.objectrepository.CreatingNewOrganizationPage;
import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodesk.objectrepository.OrganizationInformationPage;
import com.crm.audodesk.objectrepository.OrganizationPage;
import com.crm.audodesk.objectrepository.OrganizationSearchPage;
import com.crm.audodeskgenericutility.BaseClass;

public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test(groups="systemTest")
	public void createContWithOrgTest() throws Throwable {
		
		/* Create objects of Utility classes*/
		/*From Base Class*/
		
		/*Read Test Data from Excel File*/
				
		/*From Java Utility*/
				int num = jLib.getRandomNumber();
				
		/*From Excel Utility*/
				String lastNameData = eLib.getDataExcelWorkbook("TC002", 1, 0)+num;
				String orgName = eLib.getDataExcelWorkbook("TC002", 1, 1)+num;
				String partialTitleChild = eLib.getDataExcelWorkbook("TC002", 1, 2);
				String partialTitleParent = eLib.getDataExcelWorkbook("TC002", 1, 3);
				
	   /*Read the common data from Property file*/
				
				/*From File Utility */
				/*From Base Class*/
				
		/*Launching the required browser , run time polymorphism*/
				/*From Base Class*/
				
				/*Step1:- Login to Application*/
				/*From Base Class*/
				
				/*using POM Class*/	
				
				/*Step2:- Create Organization*/
				/*using POM Class*/
				
				HomePage homePage = new HomePage(driver);
				homePage.clickOnOrganizationLink();
				
				OrganizationPage orgPage = new OrganizationPage(driver);
				orgPage.clickOnplusIconImage();
				
				CreatingNewOrganizationPage createNewOrgPage = new CreatingNewOrganizationPage(driver);
				createNewOrgPage.createOrganization(orgName);
				
				/*Verification of Organization Creation*/
				/*using POM Class*/
				
				OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
				String actuaorgName = orgInfoPage.OrganizationInformationHeaderText();
				
				Assert.assertEquals(actuaorgName.contains(orgName), true, ""+orgName +   "   organization Name is not verified : FAIL");
				
//				if (actuaorgName.contains(orgName)) {
//					System.out.println(orgName +   "   organization Name is verified : PASS");
//				}else {
//					System.out.println(orgName +   "   organization Name is not verified : FAIL");
//				}
				
			/*Step3:- Create Contact with Organizations*/
				/*using POM Class*/
				
				
				wLib.waitForElementToBeClickable(driver, homePage.getContactsLink());
				
				homePage.clickOnContactsLink();
				
				ContactsPage contactsPage = new ContactsPage(driver);
				contactsPage.clickOnPlusIconImage();
				
				CreatingNewContactsPage createNewConPage = new CreatingNewContactsPage(driver);
				createNewConPage.createContactWithOrgName(driver, lastNameData, partialTitleChild);
				
				
				/*Step4:= Switch to child window*/
				/*using POM Class*/
				
				OrganizationSearchPage orgSearchPage = new OrganizationSearchPage(driver);
				orgSearchPage.clickOnCreatedOrganization(driver, orgName, partialTitleParent);
				
				/*Step5:= Switch to child Parent*/			
				/*using POM Class*/
				createNewConPage.clickOnSaveButton();
				
							
			/*Step6:= Verify the contacts creation*/
				/*using POM Class*/
				
				ContactsInformationPage contactInfoPage = new ContactsInformationPage(driver);
				
				String actualLastNameData = contactInfoPage.contactInformationHeaderText();
				
				Assert.assertEquals(actualLastNameData.contains(lastNameData), true," "+lastNameData  + "   Last Name is Not verified:: FAIL");
				
//				if(actualLastNameData.contains(lastNameData)) {
//					System.out.println(lastNameData  + "   Last Name is verified :: PASS");
//				}else {
//					System.out.println(lastNameData  + "   Last Name is Not verified:: FAIL");
//				}
				
				
			/*Step7:= Verify the contact with organization selection*/
				/*using POM Class*/
				
				String actualOrgNameAdd = contactInfoPage.confirmOrganizationTextFieldText();
				
				Assert.assertEquals(actualOrgNameAdd, orgName,""+orgName  + "     Organization is Not added to contact and not verified:: FAIL");
				
//				if(actualOrgNameAdd.equals(orgName)) {
//					System.out.println(orgName  + "     Organization is added to contact and verified:: PASS");
//				}else {
//					System.out.println(orgName  + "     Organization is Not added to contact and not verified:: FAIL");
//				}
				
			/*Step7:= Logout from the Application*/
				
				/*using POM Class*/
				/*From Base Class*/
				
	}

}
