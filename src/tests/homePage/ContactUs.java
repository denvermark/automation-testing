package tests.homePage;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.BannerPage.BannerPage;
import pageObjects.ContactUsPage.ContactUsPage;
import testUtilities.TestBase;
import testUtilities.Utilities;

public class ContactUs extends TestBase {
	@Test(description = "Click the Contact Us link")
	public void ClickContactUs() {

		BannerPage bannerPage = new BannerPage(this.driver);

		ContactUsPage contactUsLink = bannerPage.contactClick();

		try {
			Assert.assertEquals(contactUsLink.getContactUrl(),
					"http://automationpractice.com/index.php?controller=contact");
		} catch (AssertionError e) {
			e.printStackTrace();
			Utilities.errorCapture(driver);
			Reporter.log(e.getMessage());
			throw e;
		}
	}

}
