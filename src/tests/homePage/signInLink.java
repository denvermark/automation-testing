package tests.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BannerPage.BannerPage;
import testUtilities.TestBase;



	
	public class signInLink extends TestBase {
		@Test(description = "Click the Sign in link")
		
		public void signInLinkClick() {
			//** 
			//** Arrange
			//**
			BannerPage bannerPage = new BannerPage(this.driver);
			
			
			
			
			bannerPage.signInClick();
			
			//** 
			//** Assert
			//**
			//Assert.assertNotNull(logo, "Logo exists");
			//Assert.assertTrue(logo.getAttribute("src").contains("logo.jpg"), "Logo contains the correct image");
			
			Assert.assertEquals(bannerPage.getContactUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");
			
			
		}
	
	
	
	
}
