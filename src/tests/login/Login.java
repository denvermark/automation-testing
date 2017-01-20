package tests.login;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage.LogoSearchCartPage;
import pageObjects.loginPage.LoginPage;
import pageObjects.myAccountPage.MyAccountPage;
import testUtilities.TestBase;

public class Login extends TestBase {
	
	@Test(description="Test that logging in as a regular user finds the sign out link on the page.")
	public void login(){
		String username = getProperties().getProperty("defaultUserName");
		String password = getProperties().getProperty("defaultPassword");
		
		// open home page
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.getDriver());
		
		// click the login link and get sent to the login page
		LoginPage loginPage = homePage.clickLogin();
		
		// login through the login page
		MyAccountPage myAccountPage = loginPage.login(username,  password);
		
		WebElement link = myAccountPage.getSignOutLink();
		Assert.assertNotNull(link, "The sign out link now appears");
	}
}
