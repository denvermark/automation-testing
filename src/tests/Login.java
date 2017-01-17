package tests;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testUtilities.TestBase;

public class Login extends TestBase {
	
	@Test(description="Test that logging in as a regular user finds the sign out link on the page.")
	public void login(){
		//** 
		//** Arrange
		//**
		String username = getProperties().getProperty("defaultUserName");
		String password = getProperties().getProperty("defaultPassword");
		
		// open home page
		HomePage homePage = new HomePage(this.getDriver());
		
		// click the login link and get sent to the login page
		LoginPage loginPage = homePage.clickLogin();
		
		//**
		//** Act
		//**
		// login through the login page
		MyAccountPage myAccountPage = loginPage.login(username,  password);
		
		//**
		//**Assert
		//**
		WebElement link = myAccountPage.getSignOutLink();
		Assert.assertNotNull("The sign out link now appears", link);
	}
}
