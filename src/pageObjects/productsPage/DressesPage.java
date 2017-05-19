package pageObjects.productsPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import pageUtilities.PageBase;

public class DressesPage extends PageBase{
	public DressesPage(WebDriver driver){
		super(driver);
	}
	@FindBy(how = How.LINK_TEXT, using = ("Casual Dresses"))
	private WebElement casualDressesLink;
	
	public CasualDressesPage casualDressClick(){
		casualDressesLink.click();
		return new CasualDressesPage(driver);
	}
}
