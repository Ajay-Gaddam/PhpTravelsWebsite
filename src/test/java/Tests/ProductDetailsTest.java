package Tests;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import FunctionLibrary.ProductLib;
import Utilis.WebDriverManager;

public class ProductDetailsTest {
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private SoftAssert sf;
	
	String PropFile="src/test/java/Properties/ProductDetails";
    String actual=Utilis.DataProvider.readTestData(PropFile,"actual");
    List<String> act=Arrays.asList(actual.split(","));
    
    @BeforeClass
  	public void setup() {
  		webDrvMgr = new WebDriverManager();
  		driver = webDrvMgr.launchBrowser("Chrome");
  		driver.get("https://phptravels.com/");
  	}
    
      @BeforeMethod
  	public void preReq() {
  		sf = new SoftAssert();
  	}
      
      @Test
  	public void productdetailsTest(){
        Reporter.log("Step-1:Navigating to the Product DropDown And performing click on it");
        ProductLib  demo= new ProductLib(driver);
        demo.buttonClick();
        Reporter.log("Step-2:Taking all the ProductDetails From the Product DropDown and Storing it in List ");
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        List<String> list= demo.ProductDetails();
        Reporter.log("Step-3:PerForming Validation on the List of Product DropDown with the expected List ");
  		for(String expected:list) 
  			for(String actual:act)
  				sf.assertEquals(actual,expected);
  		}
      
      @AfterClass
  	public void tearDown() {
  		driver.quit();
  	}
}
