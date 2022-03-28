package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDataUsingDataProvider {
	
	@Test(dataProvider = "getData")
	public void multipleData(String name, String company, String emailId, String location) {
		
		System.out.println(name);
		System.out.println(company);
		System.out.println(emailId);
		System.out.println(location);
		
		System.out.println("==============================");
		
	}

	@DataProvider
	public Object[][] getData() {
		
		Object[][] objArray = new Object[2][4];
		
		objArray[0][0]= "Bharath";
		objArray[0][1]= "TYSS";
		objArray[0][2]= "Bharath@gmail.com";
		objArray[0][3]= "Bangalore";
		
		objArray[1][0]= "Sharath";
		objArray[1][1]= "TYSS";
		objArray[1][2]= "Sharath@gmail.com";
		objArray[1][3]= "Mumbai";
		
		return objArray;
		
		
  }
}
