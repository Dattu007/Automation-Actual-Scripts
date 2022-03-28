package practice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.audodesk.objectrepository.CreatingNewOrganizationPage;
import com.crm.audodesk.objectrepository.HomePage;
import com.crm.audodesk.objectrepository.LoginPage;
import com.crm.audodesk.objectrepository.OrganizationInformationPage;
import com.crm.audodesk.objectrepository.OrganizationPage;
import com.crm.audodeskgenericutility.ExcelUtility;
import com.crm.audodeskgenericutility.FileUtility;
import com.crm.audodeskgenericutility.JavaUtility;
import com.crm.audodeskgenericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationPrintAndDelete {

	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		int ranNum = jLib.getRandomNumber();
		
		String orgName = eLib.getDataExcelWorkbook("TC001", 1, 0)+ranNum;
		
//		String orgName = "ddddd";
		
		String urlData = fLib.getDataPropertyFile("url");
		String userNameData = fLib.getDataPropertyFile("username");
		String passwordData = fLib.getDataPropertyFile("password");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		
		driver.get(urlData);
		
		/*Login to Application*/
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(userNameData, passwordData);
		
		/*Organization Creation*/
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickOnplusIconImage();
		
		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.createOrganization(orgName);
		
		/*Verification of Organization Creation*/
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actuaorgName = orgInfoPage.OrganizationInformationHeaderText();
		
		
		if (actuaorgName.contains(orgName)) {
			System.out.println(orgName +   "is verified : PASS");
		}else {
			System.out.println(orgName +   "is not verified : FAIL");
		}
		
		
		//Printing All Organization from Organization list
		
		hp.clickOnOrganizationLinkAfterCreation();
		
		List<WebElement> allOrgList = orgPage.getAllOrganizationsList();
				
		int totalCount = orgPage.totalCountOfPages();
		
		int temp1 =2;
		
		for(int i=1;i<=totalCount;i++) {
		
			for (WebElement element : allOrgList) {
				
				System.out.println(element.getText());
			}
			if(temp1<=totalCount) {
				temp1++;
			orgPage.getForwardButton().click();
			Thread.sleep(5000);
			}
			}
			
//		Selecting Particular Organization and Deleting it permanently
			
		int temp2 =2;
		
		outerloop:
		for(int i=totalCount;i>=1;i--) {
			
			for (WebElement element : allOrgList) {
				if(element.getText().equals(orgName)) {
					orgPage.clickOnParticularOrg(driver, orgName);
					break outerloop;
				}
			}
			if(temp2<=totalCount) {
				temp2++;
			orgPage.getPreviousButton().click();
			Thread.sleep(5000);
			}
			}		
		orgInfoPage.clickOnDeleteButton(driver);
		hp.logout(driver);
		
		
	}

}
