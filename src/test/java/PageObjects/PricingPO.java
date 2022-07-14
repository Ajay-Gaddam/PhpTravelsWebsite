package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingPO {
	private WebDriver driver;
	public PricingPO(WebDriver driver){
   	 this.driver=driver;
   	 PageFactory.initElements(this.driver, this);
    }
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	private WebElement Pricing;
	
	@FindBy(xpath="//span[text()='249']")
	private WebElement StartupPrice;
	
	@FindBy(xpath="(//span[text()='499'])[2]")
	private WebElement AgencyPrice;
	
    @FindBy(xpath="(//span[@class='money number'])[5]")
	private WebElement BusinessPrice;
    
    @FindBy(xpath="(//span[@class='money number'])[7]")
   	private WebElement EnterprisePrice;
    
    public WebElement pricingButton() {
 		return Pricing;
 	}
    public WebElement startUpPrice() {
 		return StartupPrice;
 	}
    public WebElement agencyPrice() {
 		return AgencyPrice;
 	}
    public WebElement businessPrice() {
 		return BusinessPrice;
 	} 
    public WebElement enterprisePrice() {
 		return EnterprisePrice;
 	} 
}
