package practice;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
	@Test
	public void createAccount() throws Exception {
		System.out.println("Login");
		System.out.println("create");
		System.out.println("Logout");
//		throw new Exception();
	}
	
	@Test(dependsOnMethods= {"createAccount"})
	public void modifyAccount() throws Exception {
		System.out.println("Login");
		System.out.println("modify");
		System.out.println("Logout");
		
	}
	
	@Test(dependsOnMethods= {"createAccount"})
	public void deleteAccount() {
		System.out.println("Login");
		System.out.println("delete");
		System.out.println("Logout");
	}

}
