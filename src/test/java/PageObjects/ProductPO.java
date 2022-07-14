package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPO {
	private WebDriver driver;
	public ProductPO(WebDriver driver){
   	 this.driver=driver;
   	 PageFactory.initElements(this.driver, this);
    }
	@FindBy(xpath="//span[text()='Product']")
	private WebElement Productbutton;
	
	@FindBy(xpath="(//div[@class='dropdown-content featuresDropdown'])[2]")
	private List<WebElement> ProductDetails;
	
	public WebElement productbutton() {
 		return Productbutton;
 	}
	public List<WebElement> productDetails() {
 		return ProductDetails;
 	}
}
