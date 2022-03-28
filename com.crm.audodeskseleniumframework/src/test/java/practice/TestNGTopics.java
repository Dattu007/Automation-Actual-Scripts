package practice;

import org.testng.annotations.Test;

public class TestNGTopics {
	
	@Test
	public void A(){
		System.out.println("Hi");
	}
	
	@Test(priority=1)
	public void B(){
		System.out.println("Hello");
	}
	
	@Test
	public void C(){
		System.out.println("How r u ");
	}

}
