package pageObjects.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObjects.myAccountPage.MyAccountPage;
import pageUtilities.PageBase;

public class LoginPage extends PageBase {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//protected WebDriver driver;

	@FindBy(how = How.ID, using = "email")
	private WebElement username;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;

	@FindBy(how = How.ID, using = "SubmitLogin")
	private WebElement loginButton;

	public MyAccountPage login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginButton.click();

		return new MyAccountPage(driver);
	}
}
