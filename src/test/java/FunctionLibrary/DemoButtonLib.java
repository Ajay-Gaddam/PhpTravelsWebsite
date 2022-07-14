package FunctionLibrary;
import org.openqa.selenium.WebDriver;

import PageObjects.DemoButtonPO;

public class DemoButtonLib {
	private WebDriver driver;
	
	public DemoButtonLib(WebDriver driver){
   	 this.driver=driver;
    }
	public String clickDemoButton() {
		DemoButtonPO demo=new DemoButtonPO(driver);
		String name=demo.demoButton().getText();
		demo.demoButton().click();
		return name;
	}
	public boolean demo() {
		DemoButtonPO demo=new DemoButtonPO(driver);
		boolean b=demo.demoform().isDisplayed();
		return b;
	}
	public void demoInput(String firstName,String lastName,String businessName,String email) {
		DemoButtonPO demo=new DemoButtonPO(driver);
		demo.firstName().sendKeys(firstName);
		demo.lastName().sendKeys(lastName);
		demo.businessName().sendKeys(businessName);
		demo.email().sendKeys(email);
		
	}
	public String submitButton() {
		DemoButtonPO demo=new DemoButtonPO(driver);
		String name=demo.submitButton().getText();
		demo.submitButton().click();
		return name;
	}
	public String loadMessage() {
		DemoButtonPO demo=new DemoButtonPO(driver);
		demo.load().click();
		String name=demo.requestForm().getText();
		return name;
	}
	public String thankYouMessage() {
		DemoButtonPO demo=new DemoButtonPO(driver);
		String actual=demo.thankYouMsg().getText();
		return actual;
	}
	public String paraText() {
		DemoButtonPO demo=new DemoButtonPO(driver);
		String para=demo.innerTextPara().getText();
		return para;
	}
}
