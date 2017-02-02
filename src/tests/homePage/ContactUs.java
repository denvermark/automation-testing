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
			
			
			BannerPage bannerPage = new BannerPage(this.driver);
			
			
			ContactUsPage contactUsLink = bannerPage.contactClick();
			
			
			
			Assert.assertEquals(contactUsLink.getContactUrl(), "http://automationpractice.com/index.php?controller=contact");
			
			
		}
	
	
	
	
}
