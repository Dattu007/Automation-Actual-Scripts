package practice;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	@Test
	public void softAssertions() {
		
		SoftAssert soft = new SoftAssert();
		
		int a=10;
		int b=10;
		
		soft.assertEquals(a, b);
		
		
		Set s = new HashSet<String>();
		s.add("Bharath");
		s.add("Sharath");
		
		Set s1 = new HashSet<String>();
		s1.add("Bharath");
		s1.add("Sharath");
		
		
		soft.fail();
		
		soft.assertEquals(s, s1);
		

		soft.assertAll();
		
	}

}
