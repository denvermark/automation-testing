package pageObjects.homePage;


import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import pageObjects.productsPage.WomensPage;
import pageUtilities.PageBase;

public class ProductsListPage extends PageBase{
	public ProductsListPage(WebDriver driver){
		super(driver);
	}
	@FindBy(how = How.XPATH, using = "//ul/li/a[contains(@title,'Women')]")
	private WebElement womenLink;
	
	public WomensPage selectWomenLink(){
		womenLink.click();
		return new WomensPage(driver);
	}
}
