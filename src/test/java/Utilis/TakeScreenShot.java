package Utilis;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class TakeScreenShot {
	public  String getScreenshot(WebDriver driver,String Screenshot ) throws IOException {
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String destination=System.getProperty("user.dir")+"/Screenshots/"+ Screenshot +date + ".png";
        File finalDestination=new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}