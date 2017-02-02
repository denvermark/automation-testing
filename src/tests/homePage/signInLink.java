package tests.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BannerPage.BannerPage;
import pageObjects.signInPage.SignInPage;
import testUtilities.TestBase;



	
	public class signInLink extends TestBase {
		@Test(description = "Click the Sign in link")
		
		public void signInLinkClick() {
			//** 
			//** Arrange
			//**
			BannerPage bannerPage = new BannerPage(this.driver);
			
			
			
			
			SignInPage signInLink = bannerPage.signInClick();
			
			
			
			Assert.assertEquals(signInLink.getContactUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");
			
			
		}
	
	
	
	
}
