package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import FunctionLibrary.FeatureDropDownLib;
import Utilis.WebDriverManager;

public class DropDownSelect {
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	
	String PropFile="src/test/java/Properties/SelectDropDown";
    String actual=Utilis.DataProvider.readTestData(PropFile,"actual");
    
    @BeforeClass
  	public void setup() {
  		webDrvMgr = new WebDriverManager();
  		driver = webDrvMgr.launchBrowser("Chrome");
  		driver.get("https://phptravels.com/");
  	}
    
    @Test
	public void featuredropDownSelect() throws InterruptedException {
    	FeatureDropDownLib demo=new FeatureDropDownLib(driver);
    	demo.featureButton();
    	Thread.sleep(5000);
    	demo.dropDownSelect(actual);
    }
    
    @AfterClass
	public void tearDown() {
		driver.quit();
	}
}
