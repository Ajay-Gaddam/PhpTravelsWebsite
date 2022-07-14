package Utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class WebDriverManager {
		private WebDriver driver;
		
		public WebDriver launchBrowser(String BrowserName) {
			
			if(BrowserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "src/test/java/Properties/msedgedriver.exe");
				driver= new EdgeDriver();
			}
			else if(BrowserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver","src/test/java/Properties/chromedriver.exe");
			    driver = new ChromeDriver();
			}
			else
				Assert.fail("Invalid BrowserName");
			driver.manage().window().maximize();
			return driver;	
		}
}
