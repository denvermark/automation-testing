package tests.login;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataModels.User;
import dataProviders.ExcelDataProvider;
import dataProviders.ExcelDataProvider.DataProviderConfig;
import pageObjects.homePage.LogoSearchCartPage;
import pageObjects.loginPage.LoginPage;
import pageObjects.myAccountPage.MyAccountPage;
import testUtilities.TestBase;

public class Login extends TestBase {
	
	@Test(
			dataProvider="xlsxDataProvider", 
			dataProviderClass=ExcelDataProvider.class,
			description="Test that logging in as a regular user finds the sign out link on the page.")
	@DataProviderConfig({"Users.xlsx", "dataModels.User"})
	public void login(User user){
		String username = user.UserName;
		String password = user.Password;
		
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
