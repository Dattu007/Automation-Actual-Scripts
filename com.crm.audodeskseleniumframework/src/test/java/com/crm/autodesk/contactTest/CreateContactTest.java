package com.crm.autodesk.contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.audodesk.objectrepository.ContactsInformationPage;
import com.crm.audodesk.objectrepository.ContactsPage;
import com.crm.audodesk.objectrepository.CreatingNewContactsPage;
import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodeskgenericutility.BaseClass;

//@Listeners(com.crm.audodeskgenericutility.ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass {

//	(groups="smokeTest", retryAnalyzer=com.crm.audodeskgenericutility.RetryAnalyserImplementationClass.class)
	@Test
	public  void createContactTest() throws Throwable {
		
		/* Create objects of Utility classes*/
		/*From Base Class*/
		
		/*from Java Utility*/
		
		int num = jLib.getRandomNumber();
		
		/*Read lastNamedata from excel sheet for test data*/
		/*from Excel Utility*/
		String lastNameData = eLib.getDataExcelWorkbook("TC002", 1, 0)+num;
		
		/*Read data from property file for common data*/
		
		/*From File Utility */
		/*From Base Class*/
		
		/*Browser specific launch , run time polymorphism*/
		/*From Base Class*/
		
			
		/*Step 1 :- Login to Application*/
		
		/*using POM Class*/
		/*From Base Class*/
		
		/*Step 2 :- Create Contact with Mandatory field*/
		/*using POM Class*/
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();
		
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.clickOnPlusIconImage();
		
		CreatingNewContactsPage createConPage = new CreatingNewContactsPage(driver);
		createConPage.createContact(lastNameData);
		
		/*Step3:- Verify the Contacts creation*/
		/*using POM Class*/
		
		ContactsInformationPage contactsInfoPage = new ContactsInformationPage(driver);
		String actuaLastName = contactsInfoPage.contactInformationHeaderText();
//		Assert.fail();
		
		/*From TestNg Assertions*/
		Assert.assertEquals(actuaLastName.contains(lastNameData), true, ""+lastNameData +"   is not verified : FAIL");
				
//		if (actuaLastName.contains(lastNameData)) {
//			System.out.println(lastNameData +"   is verified : PASS");
//		}else {
//			System.out.println(lastNameData +"   is not verified : FAIL");
//		}
		
		/*Step4 :- Logout from Application */
		/*using POM Class*/
		/*From Base Class*/
	}

}
