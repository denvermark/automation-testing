package pageObjects.productsPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import pageUtilities.PageBase;

public class WomensPage extends PageBase{
	public WomensPage(WebDriver driver){
		super(driver);
	}
@FindBy(how = How.LINK_TEXT, using = "Dresses")
private WebElement dressesLink;

public DressesPage dressesClick(){
	dressesLink.click();
	return new DressesPage(driver);
}
}
