package Tests;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import FunctionLibrary.DemoButtonLib;
import Utilis.WebDriverManager;

public class DemoButtonTest {
//	static ExtentTest test;
//	static ExtentReports report;
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private SoftAssert sf;
    String propfile="src/test/java/Properties/DemoDetails";
    String Fname=Utilis.DataProvider.readTestData(propfile,"FirstName");
    String Lname=Utilis.DataProvider.readTestData(propfile,"LastName");
    String Bname=Utilis.DataProvider.readTestData(propfile,"BusinessName");
    String Email=Utilis.DataProvider.readTestData(propfile,"Email");
    
    String PropFile="src/test/java/Properties/AssertionDemo";
    String actu=Utilis.DataProvider.readTestData(PropFile, "actual");
    String para=Utilis.DataProvider.readTestData(PropFile, "Para");
    @BeforeSuite
    public void reportgen() {
    	BaseTest test=new BaseTest(driver);
    	test.reportgen();
//    	report = new ExtentReports(System.getProperty("user.dir")+"/test-output/myReport.html");
//    	test = report.startTest("DemoButtonTest");
    }
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
	public void demoButtonTest()  throws IOException, InterruptedException {
		DemoButtonLib demo=new DemoButtonLib(driver);
		BaseTest test=new BaseTest(driver);
		Thread.sleep(2000);
		Reporter.log("Step-1:Navigating to the demoButton Clicking on the DemoButton");
		String buttonStatus=demo.clickDemoButton();
		test.startReport(buttonStatus, "Demo","Navigating to the demoButton Clicking on the DemoButton");
		
//		if(buttonStatus.equals("Demo"))
//			test.log(LogStatus.PASS, "Navigated to the specified Url and performed click operation");
//		else
//			test.log(LogStatus.FAIL, "Test Failed");
		Thread.sleep(1000);
		
		
		Reporter.log("Step-2:-Passing the Details into RequestForm");
		boolean b=demo.demo();
		String str1= new Boolean(b).toString();
		boolean b2=true;
		String str2= new Boolean(b2).toString();
		test.startReport(str1, str2,"Passing the Details into RequestForm");
//		if(b==true)
//			test.log(LogStatus.PASS, "RequestForm Displayed and passing Details");
//		else
//			test.log(LogStatus.FAIL, "Test Failed");
		
		demo.demoInput(Fname, Lname, Bname, Email);
		Thread.sleep(1000);
		
		Reporter.log("Step-3:Clicking on the submit button and Waiting until Thankyou message");
		String button=demo.submitButton();
		test.startReport(button, "Submit","Clicking on the submit button and Waiting until Thankyou message");
//		if(button.equals("Submit"))
//			test.log(LogStatus.PASS, "Details added and Clicked on submit Button");
//		else
//			test.log(LogStatus.FAIL, "Test Failed");
		
		Reporter.log("Step-4:Providing an Wait to load the PopUp ThankYou message and Performing assertion operation");
		Thread.sleep(5000);
		
		String popup=demo.loadMessage();
		test.startReport(popup, "Instant Demo Request Form","ThankYou PopUp is Displayed");
		
//		if(popup.equals("Instant Demo Request Form"))
//			test.log(LogStatus.PASS, "ThankYou Popup is Displayed and performing Assertion Operation");
//		else
//			test.log(LogStatus.FAIL, "Test Failed");
		
		
		
		String paragraph=demo.paraText();
		sf.assertEquals(paragraph, actu);
		test.startReport(paragraph,actu,"Performing Assertion on Paragraph in the PopUp");
		
//		if(paragraph.equals(actu))
//			test.log(LogStatus.PASS, "Assertion got success for the paragraph in popup");
//		else
//		{
//			TakeScreenShot demo1=new TakeScreenShot();
//			test.log(LogStatus.FAIL, test.addScreenCapture(demo1.getScreenshot(driver,"DemoTestButton"))+ "Test Failed");
//		}
		
		Thread.sleep(1000);
		
		
		String actual=demo.thankYouMessage();
		test.startReport(actual, para,"Performing Assertion on ThankYou Text ");
		
//		if(actual.equals(para))
//			 test.log(LogStatus.PASS, "Assertion got success for the ThankYou msg");
//	    else
//		{
//		TakeScreenShot demo1=new TakeScreenShot();
//		test.log(LogStatus.FAIL, test.addScreenCapture(demo1.getScreenshot(driver,"DemoTestButton"))+ "Test Failed");
//		}
		Assert.assertEquals(actual,para);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	@AfterSuite
	public void report() {
		BaseTest test=new BaseTest(driver);
		test.report();
//		report.endTest(test);
//		report.flush();
	}
}
