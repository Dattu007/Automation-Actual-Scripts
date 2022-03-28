package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class DataDrivenFromTestNgXMLTest {
	
	@Test
	public void getCredentialData(XmlTest xml) {
		
	String browserNameData = xml.getParameter("browsername");
	String urlData = xml.getParameter("url");
	String userNameData = xml.getParameter("username");
	String passwordData = xml.getParameter("password");
	
	System.out.println("browserNameData="+browserNameData);
	System.out.println("urlData="+urlData);
	System.out.println("userNameData="+userNameData);
	System.out.println("passwordData="+passwordData);
	
		
	}

}
