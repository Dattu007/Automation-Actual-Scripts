package Sample;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToCrm {
	public static void main(String[] args) throws Exception {
		
		try {
			WebDriver driver = null;
			
			FileInputStream fin = new FileInputStream
					(".\\src\\main\\resources\\commondata\\credentials.properties");
			Properties prop_obj = new Properties();
			prop_obj.load(fin);
			String browserName = prop_obj.getProperty("browser");
			String url = prop_obj.getProperty("url");
			String usernameData = prop_obj.getProperty("username");
			String passwordData = prop_obj.getProperty("password");
			
			System.out.println(browserName);
			System.out.println(url);
			System.out.println(usernameData);
			System.out.println(passwordData);
			
			if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("Chrome Browser launched");
			}else if (browserName.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("Firefox Browser launched");
			}
							
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(usernameData);
			driver.findElement(By.name("user_password")).sendKeys(passwordData);
			driver.findElement(By.id("submitButton")).click();
		} catch (Exception e) {
			System.err.println("Only two browser suppoerts");
			System.err.println("Issue in Reading");
		}

	}

}
