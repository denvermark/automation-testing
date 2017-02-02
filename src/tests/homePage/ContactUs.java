package tests.homePage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BannerPage.BannerPage;
import pageObjects.ContactUsPage.ContactUsPage;
import pageObjects.homePage.LogoSearchCartPage;
import pageObjects.signInPage.SignInPage;
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
			ContactUsPage contactUsLink = bannerPage.contactClick();
			
			//** 
			//** Assert
			//**
			//Assert.assertNotNull(logo, "Logo exists");
			//Assert.assertTrue(logo.getAttribute("src").contains("logo.jpg"), "Logo contains the correct image");
			
			Assert.assertEquals(contactUsLink.getContactUrl(), "http://automationpractice.com/index.php?controller=contact");
			
			
		}
	
	
	
	
}
