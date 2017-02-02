package pageObjects.signInPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObjects.myAccountPage.MyAccountPage;
import pageUtilities.PageBase;

public class SignInPage extends PageBase {
	public SignInPage(WebDriver driver) {
		super(driver);
		
	}
	public String getContactUrl(){
		return driver.getCurrentUrl();
	}
}