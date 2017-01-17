package tests.homePage;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage.LogoSearchCartPage;
import testUtilities.TestBase;

public class LogoSearchCart extends TestBase {
	@Test(description = "Test that the logo exists and contains the correct image")
	public void findLogo() {
		//** 
		//** Arrange
		//**
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.driver);
		
		//** 
		//** Act
		//**
		WebElement logo = homePage.getLogo();
		
		//** 
		//** Assert
		//**
		Assert.assertNotNull(logo, "Logo exists");
		Assert.assertTrue(logo.getAttribute("src").contains("logo.jpg"), "Logo contains the correct image");
	}
	
	@Test(description = "Test that the search textbox exists")
	public void findSearchTextBox(){
		//** 
		//** Arrange
		//**
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.driver);
		
		//** 
		//** Act
		//**
		WebElement searchTextBox = homePage.getSearchTextBox();
		
		//** 
		//** Assert
		//**
		Assert.assertNotNull(searchTextBox, "Search textbox exists");
	}
}
