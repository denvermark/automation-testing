package pageObjects.ContactUsPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import pageUtilities.PageBase;

public class ContactUsPage extends PageBase{
	

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	public final static String breadcrumbString = "navigation_page";
	
	@FindBy(how=How.CLASS_NAME, using = breadcrumbString)
	private WebElement breadcrumb;
	
	public boolean ValidateBreadcrumb(){
		// Note: put this in Helper
			return breadcrumb.getText().equals("Contact");
			
	}
	
	
	public String getContactUrl(){
		return driver.getCurrentUrl();
	}
}
