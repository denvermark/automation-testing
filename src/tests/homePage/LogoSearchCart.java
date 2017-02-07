package tests.homePage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.cartPage.CartPage;
import pageObjects.homePage.LogoSearchCartPage;
import testUtilities.TestBase;

public class LogoSearchCart extends TestBase {
	@Test(description = "Test that the logo exists and contains the correct image")
	public void findLogo() {
		// open the home page
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.driver);
		// get the logo element
		WebElement logo = homePage.getLogo();

		// ensure the logo element exists
		Assert.assertNotNull(logo, "Logo exists");
		// ensure that the correct image is shown for the logo
		Assert.assertTrue(logo.getAttribute("src").contains("logo.jpg"), "Logo contains the correct image");
	}

	@Test(description = "Test that the search textbox exists")
	public void findSearchTextBox() {
		// open the home page
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.driver);
		// get the search textbox
		WebElement searchTextBox = homePage.getSearchTextBox();

		// ensure that the search textbox exists
		Assert.assertNotNull(searchTextBox, "Search textbox exists");
	}

	@Test(
			dataProviderClass = dataProviders.SearchCriteriaDataProvider.class,
			dataProvider = "searchCriteriaDataProvider",
			description = "Test that performing a search opens the search results page")
	public void executeSearch(String searchCriteria) {
		// open the home page
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.driver);
		// get the search textbox
		WebElement searchTextBox = homePage.getSearchTextBox();
		// enter search criteria
		if (searchTextBox != null) {
			searchTextBox.clear();
			searchTextBox.sendKeys(searchCriteria);
		}
		// get the search button
		WebElement searchButton = homePage.getSearchButton();
		// click the search button to execute the search
		if (searchButton != null) {
			searchButton.click();
		}
		// get the results of the search
		List<WebElement> searchResults = homePage.getSearchResults();
		
		// ensure that there is only one result
		Assert.assertTrue(searchResults.size() == 1, "Search returned only one result");
		// ensure that the correct product (productId=1) was returned
		Assert.assertNotNull(homePage.getSpecificSearchResult(searchResults, searchCriteria), "Search returned the correct results");
	}

	@Test(description = "Test that the shopping cart button exists")
	public void findCartButton() {
		// open the home page
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.driver);
		// get the cart button
		WebElement cartButton = homePage.getCartButton();

		// ensure that the cart button exists
		Assert.assertNotNull(cartButton, "Cart buttton exists");
	}
	
	@Test(description = "Test that clicking the cart button sends us to the cart page")
	public void clickCartButton(){
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.driver);
		CartPage cartPage = homePage.clickCartButton();
		WebElement cartSummarySection = cartPage.getCartSummarySection();
		Assert.assertNotNull(cartSummarySection, "Cart Summary Section exists");
	}
}
