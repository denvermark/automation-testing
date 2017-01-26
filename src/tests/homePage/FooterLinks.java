package tests.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage.ContactUsPage;
import pageObjects.homePage.FooterPage;
import testUtilities.TestBase;

public class FooterLinks extends TestBase
{
  @Test
  public void FooterLinksTest() {
	  FooterPage footerPage = new FooterPage(this.driver);
	  Assert.assertTrue(footerPage.verifyCategoriesLinks(), "Category links in footer are not as expected.");
	  Assert.assertTrue(footerPage.verifyInformationLinks(),"Information links in footer are not as expected.");
  }
  
  @Test
  public void ContactUsLink(){
	  FooterPage footerPage = new FooterPage(this.driver);
	  ContactUsPage contactUsPage = footerPage.clickOnContactUs();
	  Assert.assertTrue(contactUsPage.ValidateBreadcrumb(), "Error going to Contact Us page.");
  }
}
