package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utilis.TakeScreenShot;

public class BaseTest {
	private WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	public BaseTest(WebDriver driver) {
		this.driver=driver;
	}
    public void reportgen() {
    	report = new ExtentReports(System.getProperty("user.dir")+"/test-output/myReport.html");
    	test = report.startTest("DemoButtonTest");
    }
	public void startReport(String actual,String para,String Step) throws IOException {
		if(actual.equals(para)) {
			 test.log(LogStatus.PASS, Step);
			 TakeScreenShot demo1=new TakeScreenShot();
			 test.log(LogStatus.PASS, test.addScreenCapture(demo1.getScreenshot(driver,"DemoTest"))+ "Test Success");
		}
	    else
		{
		TakeScreenShot demo1=new TakeScreenShot();
		test.log(LogStatus.FAIL, test.addScreenCapture(demo1.getScreenshot(driver,"DemoTest"))+ "Test Failed");
		}
	}
	public void report() {
		report.endTest(test);
		report.flush();
	}
	}

