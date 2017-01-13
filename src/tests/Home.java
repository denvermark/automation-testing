package tests;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testUtilities.TestBase;

public class Home extends TestBase {
	@Test(description = "Test that the logo exists and contains the correct image")
	public void findLogo() {
		//** 
		//** Arrange
		//**
		HomePage homePage = new HomePage(this.driver);
		
		//** 
		//** Act
		//**
		WebElement logo = homePage.getLogo();
		
		//** 
		//** Assert
		//**
		Assert.assertNotNull("Logo exists", logo);
		Assert.assertTrue("Logo contains the correct image", logo.getAttribute("src").contains("logo.jpg"));
	}
	
	@Test(description = "Test that the search textbox exists")
	public void findSearchTextBox(){
		//** 
		//** Arrange
		//**
		HomePage homePage = new HomePage(this.driver);
		
		//** 
		//** Act
		//**
		WebElement searchTextBox = homePage.getSearchTextBox();
		
		//** 
		//** Assert
		//**
		Assert.assertNotNull("Search textbox exists", searchTextBox);
	}
}
