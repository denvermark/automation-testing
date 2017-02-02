package tests.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BannerPage.BannerPage;
import testUtilities.TestBase;



	
	public class PhoneNumber extends TestBase {
		@Test(description = "Click the Contact Us link")
		public void ClickContactUs() {
			//** 
			//** Arrange
			//**
			BannerPage bannerPage = new BannerPage(this.driver);
			
			
			//** 
			//** Assert
			//**
			
			
			Assert.assertEquals(bannerPage.getPhoneNumber(), "0123-456-789");
			
			
		}
	
	
	
	
}
