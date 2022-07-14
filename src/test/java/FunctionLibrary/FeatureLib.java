package FunctionLibrary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.FeaturesPO;

public class FeatureLib {
	private WebDriver driver;
	
	public FeatureLib(WebDriver driver){
   	this.driver=driver;
    }
	
	public void featureButton() {
		FeaturesPO demo=new FeaturesPO(driver);
		demo.featuresbutton().click();
	}
	public List<String> featureDropDown(){
		FeaturesPO FeatureList=new FeaturesPO(driver);
		List<String> prodNames = new ArrayList<String>();
		  List<WebElement> FeatureDetails =FeatureList.featureDropDown();
	        for(WebElement oElem: FeatureDetails) {
	            String strProdName = oElem.getText().trim();
	            prodNames.add(strProdName);
	        }
		return prodNames;
	}
	public void hotelButton() {
		FeaturesPO demo=new FeaturesPO(driver);
		demo.hotelbutton().click();
	}
	public List<String> hotelFeatures(){
		FeaturesPO FeatureList=new FeaturesPO(driver);
		List<String> prodNames = new ArrayList<String>();
		String actual=FeatureList.hotelbooking().getText();
		String actual1=FeatureList.hotelcalender().getText();
		prodNames.add(actual);
		prodNames.add(actual1);
		return prodNames;
	}
	public void flightButton() {
		FeaturesPO demo=new FeaturesPO(driver);
		demo.flightsbutton().click();
	}
	public List<String> flightFeatures(){
		FeaturesPO FeatureList=new FeaturesPO(driver);
		List<String> prodNames = new ArrayList<String>();
		String actual=FeatureList.flightBookingModule().getText();
		String actual1=FeatureList.flightSearchFilter().getText();
		String actual2=FeatureList.flightBackOffice().getText();
		prodNames.add(actual);
		prodNames.add(actual1);
		prodNames.add(actual2);
		return prodNames;
	}
}
