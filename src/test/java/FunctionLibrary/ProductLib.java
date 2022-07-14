package FunctionLibrary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.ProductPO;

public class ProductLib {
	private WebDriver driver;
	public ProductLib(WebDriver driver){
   	 this.driver=driver;
    }
	public void buttonClick() {
		ProductPO productdetails=new ProductPO(driver);
		productdetails.productbutton().click();
	}
	public List<String> ProductDetails(){
		ProductPO productdetails=new ProductPO(driver);
		List<String> prodNames = new ArrayList<String>();
		  List<WebElement> ProductDetails =productdetails.productDetails();
	        for(WebElement oElem: ProductDetails) {
	            String strProdName = oElem.getText().trim();
	            prodNames.add(strProdName);
	        }
		return prodNames;
		
	}
}
