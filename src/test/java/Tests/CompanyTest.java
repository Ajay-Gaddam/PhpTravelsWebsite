package Tests;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import FunctionLibrary.CompanyLib;
import Utilis.WebDriverManager;

public class CompanyTest {
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private SoftAssert sf;
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
	  	public void companyTest() {
		  CompanyLib demo=new CompanyLib(driver);
		  Reporter.log("Step-1:Navigating to the company and clicking on AboutUs Button");
		  String expected= demo.companyAboutUs();
		  Reporter.log("Step-2:Navigating to AboutUs and Taking its innerText ");
		  Reporter.log("Step-3:Validating innerText with the expected Text ");
		  String actual="A reliable partner and an expert in the area of online travel business applications!";
		  sf.assertEquals(actual, expected);
		  }
	      @AfterClass
	  	public void tearDown() {
	  		driver.quit();
	  	}
}
