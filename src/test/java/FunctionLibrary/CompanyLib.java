package FunctionLibrary;

import org.openqa.selenium.WebDriver;

import PageObjects.CompanyPO;

public class CompanyLib {
	private WebDriver driver;
	public CompanyLib(WebDriver driver){
   	 this.driver=driver;
    }
	public String companyAboutUs() {
		CompanyPO company=new CompanyPO(driver);
		company.companyButton().click();
		company.aboutUs().click();
		String innerText=company.aboutUsText().getText();
		return innerText;
	}
}
