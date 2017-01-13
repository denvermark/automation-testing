package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageUtilities.PageBase;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getSignOutLink(){
		return super.getSignOutLink();
	}
}
