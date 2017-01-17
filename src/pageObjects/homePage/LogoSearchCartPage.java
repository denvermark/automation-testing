package pageObjects.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObjects.loginPage.LoginPage;
import pageUtilities.PageBase;

public class LogoSearchCartPage extends PageBase {

	public LogoSearchCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CLASS_NAME, using = "login")
	private WebElement signInLink;
	
	@FindBy(how = How.CSS, using = "img.logo.img-responsive")
	private WebElement logo;
	
	@FindBy(how = How.ID, using = "search_query_top")
	private WebElement searchTextBox;

	public WebElement getLogo(){
		return logo;
	}
	
	public WebElement getSearchTextBox(){
		return searchTextBox;
	}
	
	public LoginPage clickLogin() {
		signInLink.click();
		return new LoginPage(driver);
	}
}
