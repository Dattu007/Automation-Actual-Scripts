package practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.audodeskgenericutility.BaseClass;

@Listeners(com.crm.audodeskgenericutility.ListenerImplementationClassNew.class)
public class ExtentReportPractice extends BaseClass {
	
	@Test
	public void createOrg() {
		System.out.println("Passed");
	}
	
	@Test
	public void createOrgWithDate() {
		System.out.println("Fail");
		Assert.fail();
	}
	
	@Test
	public void createOrgWithMandatory() {
		
		throw new SkipException("Skipped");
	}
	
	

}
