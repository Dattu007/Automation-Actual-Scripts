package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.Assert.ThrowingRunnable;
import org.testng.annotations.Test;

public class HardAssertion {
	
	@Test
	public void hardAssertions() {
		
		String name1="Bharath";
		String name2="Bharath1";
		
//		Assert.assertEquals(name1,name2);
		
		long l1= 100000;
		long l2= 100000;
		
		Assert.assertEquals(l1,l2);
		
		double d1= 10.5;
		double d2= 10.5;
		
		Assert.assertEquals(d1,d2);
		
		boolean b1=true;
		boolean b2=false;
		boolean b3=false;
		
//		Assert.assertEquals(b1,b2);
		
		List<String> al1 = new ArrayList<String>();
		al1.add("Bharath");
		al1.add("Kumar");
		al1.add("Sharath");
		al1.add("Kumar");
		
		List<String> al2 = new ArrayList<String>();
		al2.add("Bharath");
		al2.add("Kumar");
		al2.add("Sharath");
		al2.add("Kumar");
		
		
		
		Assert.assertEquals(al1,al2);
		
		int[] array1= {10,20,30,40};
		int[] array2= {10,20,30,40};
		
		
		Assert.assertEquals(array1,array2);
		
		Map<String,Integer> map1 = new HashMap<String,Integer>();
		
		
		map1.put("Bharath", 10);
		map1.put("Sharath", 20);
		
	
		Map<String,Integer> map2 = new HashMap<String,Integer>();
		
		map2.put("Bharath", 10);
		map2.put("Sharath", 20);
		
		Assert.assertEquals(map1, map2);
		
		Assert.assertTrue(b1);
		
//		Assert.assertTrue(b2);
		
		Assert.assertFalse(b3, "output is true");
		
		Assert.assertNotEquals(name1, name2);
		
		Object obj = "Bharath";
		
		Assert.assertNotNull(obj, "it is null");
		
		Object obj1="Bharath";
		String obj2= "Bharath";
		
//		Assert.assertNotSame(obj1, obj2, "same");
		
		Assert.assertSame(obj1, obj2);
		
		
		
	}

}
