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
import FunctionLibrary.FeatureLib;
import Utilis.WebDriverManager;

public class FeatureTest {
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private SoftAssert sf;
	
	String PropFile="src/test/java/Properties/FeatureDetails";
    String actual=Utilis.DataProvider.readTestData(PropFile,"act");
    List<String> act=Arrays.asList(actual.split(","));
    
    String propFile="src/test/java/Properties/HoteLFeatures";
    String actualFeatures=Utilis.DataProvider.readTestData(propFile,"actual");
    List<String> actualHotelFeatures=Arrays.asList(actualFeatures.split(","));
    
    String propfile="src/test/java/Properties/FlightFeatures";
    String actualfeatures=Utilis.DataProvider.readTestData(propfile,"actual");
    List<String> actualFlightFeatures=Arrays.asList(actualfeatures.split(","));
    
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
    	public void featureTest() {
    	  Reporter.log("Step-1:Navigating to the Feature DropDown And performing click on it");
    	  FeatureLib  demo= new FeatureLib(driver);
    	  Reporter.log("Step-2:Taking all the Features From the Feature DropDown and Storing it in List ");
          demo.featureButton();
          Reporter.log("Step-3:PerForming Validation on the List of Features DropDown with the expected List ");
          List<String> list= demo.featureDropDown();
    		for(String expected:list) 
    			for(String actual:act)
    				sf.assertEquals(actual,expected);
    	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    	  Reporter.log("Step-4:Navigating to Feature DropDown and Clicking on the HotelFeatures");
    		demo.hotelButton();
    	  Reporter.log("Step-5:Taking all the Features From the HotelFeatures Tab and Storing it in List ");
    		List<String> hotelfeatures=demo.hotelFeatures();
    	  Reporter.log("Step-6:Performing Validation on the HotelFeatures List with the expected List ");
    		for(String expected:hotelfeatures) 
    			for(String actual:actualHotelFeatures)
    				sf.assertEquals(actual,expected);
    		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    		Reporter.log("Step-7:Navigating to Feature DropDown and Clicking on the FlightFeatures");
    		demo.featureButton();
    		demo.flightButton();
    		 Reporter.log("Step-8:Taking all the Features From the FlightFeatures Tab and Storing it in List ");
    		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    		List<String> flightfeatures=demo.flightFeatures();
    		Reporter.log("Step-9:Performing Validation on the FlightFeatures List with the expected List ");
    		for(String expected:flightfeatures) 
    			for(String actual:actualFlightFeatures)
    				sf.assertEquals(actual,expected);
    		}
        @AfterClass
    	public void tearDown() {
    		driver.quit();
    	}
}
