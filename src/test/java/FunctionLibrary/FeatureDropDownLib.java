package FunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import PageObjects.FeaturesPO;

public class FeatureDropDownLib {
private WebDriver driver;
	
	public FeatureDropDownLib(WebDriver driver){
   	this.driver=driver;
    }
	public void featureButton() {
		FeaturesPO demo=new FeaturesPO(driver);
		demo.featuresbutton().click();
	}
	public void dropDownSelect(String Module) {
		Select select=new Select(driver.findElement(By.xpath("(//div[@class='dropdown-content featuresDropdown'])[1]")));
		select.selectByVisibleText(Module);
	}
	
}
