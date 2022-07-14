package FunctionLibrary;

import org.openqa.selenium.WebDriver;

import PageObjects.PricingPO;


public class PricingLib {
	private WebDriver driver;
	public PricingLib(WebDriver driver){
   	 this.driver=driver;
    }
	public void pricingButtonclick() {
		PricingPO price=new PricingPO(driver);
		price.pricingButton().click();
	}
	public String startUpPricing() {
		PricingPO price=new PricingPO(driver);
	    String actual=price.startUpPrice().getText();
		return actual;
	}
	public String agencyPricing() {
		PricingPO price=new PricingPO(driver);
		String actual=price.agencyPrice().getText();
		return actual;
	}
	public String businessPricing() {
		PricingPO price=new PricingPO(driver);
		String actual=price.businessPrice().getText();
		return actual;
	}
	public String enterprisePricing() {
		PricingPO price=new PricingPO(driver);
		String actual=price.enterprisePrice().getText();
		return actual;
	}
}
