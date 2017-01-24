package tests.homePage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BannerPage.BannerPage;
import pageObjects.homePage.LogoSearchCartPage;
import testUtilities.TestBase;



	
	public class ContactUs extends TestBase {
		@Test(description = "Click the Contact Us link")
		public void ClickContactUs() {
			//** 
			//** Arrange
			//**
			BannerPage bannerPage = new BannerPage(this.driver);
			
			//** 
			//** Act
			//**
			bannerPage.contactClick();
			
			//** 
			//** Assert
			//**
			//Assert.assertNotNull(logo, "Logo exists");
			//Assert.assertTrue(logo.getAttribute("src").contains("logo.jpg"), "Logo contains the correct image");
			
			Assert.assertEquals(bannerPage.getContactUrl(), "http://automationpractice.com/index.php?controller=contact");
			
			
		}
	
	
	
	
}
