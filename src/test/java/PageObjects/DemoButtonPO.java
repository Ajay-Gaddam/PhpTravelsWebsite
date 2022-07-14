package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoButtonPO {
	private WebDriver driver;
     public DemoButtonPO(WebDriver driver){
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
     }
     @FindBy(xpath="//a[text()='Demo']")
     private WebElement demo;
     
     @FindBy(xpath="//div[@class='form']")
     private WebElement demoForm;
     
     @FindBy(xpath="//input[@name='first_name']")
     private WebElement FirstName;
   
     @FindBy(xpath="//input[@name='last_name']")
     private WebElement LastName; 
   
     @FindBy(xpath="//input[@name='business_name']")
     private WebElement BusinessName; 
   
     @FindBy(xpath="//input[@class='email input form-control form-group']")
     private WebElement Email;
     
     @FindBy(id="demo")
     private WebElement Submit;
     
     @FindBy(xpath="//h3[@class='text-center']")
     private WebElement RequestForm;
     
     @FindBy(xpath="//div[@class='col-md-12']")
     private WebElement load;
     
     @FindBy(xpath="//h1[@class='text-center']")
     private WebElement thankyou;
     
     @FindBy(xpath="//p[@class='text-center']")
     private WebElement paragraph;
  
     public WebElement demoButton() {
 		return demo;
 	}
     public WebElement demoform() {
   		return demoForm;
   	}
     public WebElement firstName() {
  		return FirstName;
  	}
     public WebElement lastName() {
   		return LastName;
   	}
     public WebElement businessName() {
    		return BusinessName;
    	}
     public WebElement email() {
    		return Email;
    	}
     public WebElement submitButton() {
 		return Submit;
 	}
     public WebElement requestForm() {
  		return RequestForm;
  	}
     public WebElement load() {
  		return load;
  	}
     public WebElement thankYouMsg() {
  		return thankyou;
  	}
     public WebElement innerTextPara() {
  		return paragraph;
  	}
}
