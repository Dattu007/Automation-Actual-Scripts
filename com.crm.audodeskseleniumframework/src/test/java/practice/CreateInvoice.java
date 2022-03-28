package practice;

import org.testng.annotations.Test;

public class CreateInvoice {
	
	@Test(groups= "smokeTest")
	public void createInvoice() {
		System.out.println("created Inovice SmokeTest");
	}
	
	@Test(groups= "regressionTest")
	public void createInvoiceWithDate() {
		System.out.println("created Inovice regressionTest");
	}
	
	@Test(groups= "systemTest")
	public void createInvoiceWithPlace() {
		System.out.println("created Inovice systemTest");
	}
	
	@Test(groups= "smokeTest")
	public void createInvoiceWithAmount() {
		System.out.println("created Inovice smaokeTest with Amount");
	}
	
	@Test(groups= "regressionTest")
	public void createInvoiceWithCurrentDate() {
		System.out.println("created Inovice regressionTest");
	}
	
	@Test(groups= "systemTest")
	public void createInvoiceWithDelhiveryDate() {
		System.out.println("created Inovice systemTest");
	}

}
