package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import FunctionLibrary.PricingLib;
import Utilis.WebDriverManager;

public class PricingButtonTest {
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private SoftAssert sf;
	String PropFile="src/test/java/Properties/PricingDetails";
    String Agency=Utilis.DataProvider.readTestData(PropFile,"Agency");
    String StartUp=Utilis.DataProvider.readTestData(PropFile,"StartUp");
    String Business=Utilis.DataProvider.readTestData(PropFile,"Business");
    String Enterprise=Utilis.DataProvider.readTestData(PropFile,"Enterprise");
  
    @BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("https://phptravels.com/");
	}
    @BeforeMethod
  	public void preReq() {
  		sf = new SoftAssert();
  	}
    @Test
	public void pricingTest() {
    	Reporter.log("Step-1:Navigating to the Pricing button ");
		PricingLib demo=new PricingLib(driver);
		Reporter.log("Step-2:Performing Click action on the Pricing button ");
		demo.pricingButtonclick();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Reporter.log("Step-3:Taking the innerText of the StartUp price and Performing validation on the Price ");
		String actualStartUpPrice=demo.startUpPricing();
		sf.assertEquals(actualStartUpPrice, StartUp);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Reporter.log("Step-4:Taking the innerText and validating the Agency price ");
		String actualAgencyPrice=demo.agencyPricing();
		sf.assertEquals(actualAgencyPrice, Agency);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Reporter.log("Step-5:Taking the innerText and validating the Business price ");
		String actualBusinessPrice=demo.businessPricing();
		sf.assertEquals(actualBusinessPrice,Business);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Reporter.log("Step-6:Taking the innerText and validating the Enterprise price ");
		String actualEnterprisePrice=demo.enterprisePricing();
		sf.assertEquals(actualEnterprisePrice,Enterprise);
	}
    @AfterClass
	public void tearDown() {
		driver.quit();
	}
}
