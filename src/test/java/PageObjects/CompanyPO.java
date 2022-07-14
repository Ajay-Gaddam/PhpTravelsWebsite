package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPO {
	private WebDriver driver;
	public CompanyPO(WebDriver driver){
   	 this.driver=driver;
   	 PageFactory.initElements(this.driver, this);
    }
	@FindBy(xpath="//span[text()='Company']")
	private WebElement Companybutton;
	
	@FindBy(xpath="(//a[text()='About Us'])[1]")
	private WebElement AboutUs;
	
	@FindBy(xpath="//p[@class='cw wow fadeIn sub-title animated animated']")
	private WebElement AboutUsText;
	
	public WebElement companyButton() {
		return Companybutton;
	}
	public WebElement aboutUs() {
		return AboutUs;
	}
	public WebElement aboutUsText() {
		return AboutUsText;
	}
}
