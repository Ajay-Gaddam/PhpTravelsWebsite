package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturesPO {
	private WebDriver driver;
	public FeaturesPO(WebDriver driver){
   	 this.driver=driver;
   	 PageFactory.initElements(this.driver,this);
    }
	@FindBy(xpath="//span[text()='Features']")
	private WebElement Featuresbutton;
	
	@FindBy(xpath="(//div[@class='dropdown-content featuresDropdown'])[1]")
	private List<WebElement> FeatureDropDown;
	
	@FindBy(xpath="//a[text()='Hotels Module']")
	private WebElement Hotelbutton;

	@FindBy(xpath="//h2[text()='Complete Hotels Booking Module']")
	private WebElement Hotelbooking;
	
	@FindBy(xpath="//h2[text()='Full Calendar']")
	private WebElement Hotelcalender;
	
	@FindBy(xpath="//a[text()='Flights Module']")
	private WebElement Flightsbutton;
	
	@FindBy(xpath="//h2[text()='Search filter and reserve flights tickets']")
	private WebElement FlightSearchFilter;
	
	@FindBy(xpath="//h2[text()='Flights booking module']")
	private WebElement FlightBookingModule;
	
	@FindBy(xpath="//h2[text()='Complete flights back-office system']")
	private WebElement FlightBackOffice;
	
	 public WebElement featuresbutton() {
	 		return Featuresbutton;
	 	}
	 public List<WebElement> featureDropDown() {
	 		return FeatureDropDown;
	 	}
	 public WebElement hotelbutton() {
	 		return Hotelbutton;
	 	}
	 public WebElement hotelbooking() {
	 		return Hotelbooking;
	 	} 
	 public WebElement hotelcalender() {
	 		return Hotelcalender;
	 	} 
	 public WebElement flightsbutton() {
	 		return Flightsbutton;
	 	}
	 public WebElement flightSearchFilter() {
	 		return FlightSearchFilter;
	 	}
	 public WebElement flightBookingModule() {
	 		return FlightBookingModule;
	 	}
	 public WebElement flightBackOffice() {
	 		return FlightBackOffice;
	 	} 
}
