package practice;

import org.testng.annotations.Test;

public class CreatePurchaseOrder {
	
	@Test(groups= "systemTest")
	public void createPO() {
		System.out.println("create PO systemTest");
	}
	
	@Test(groups= "systemTest")
	public void createPOWithDate() {
		System.out.println("create PO systemTest");
	}
	
	@Test(groups= "regressionTest")
	public void createPOWithPlace() {
		System.out.println("create PO regressionTest");
	}
	
	@Test(groups= "smokeTest")
	public void createPOWithAmount() {
		System.out.println("create PO smokeTest");
	}
	
	@Test(groups= "smokeTest")
	public void createPOWithDeliveryDate() {
		System.out.println("create PO smokeTest");
	}
	
	@Test(groups= "smokeTest")
	public void createPOWithConditions() {
		System.out.println("create PO smokeTest");
	}

}
