package tests.Purchases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage.LogoSearchCartPage;
import pageObjects.homePage.ProductsListPage;
import pageObjects.loginPage.LoginPage;
import pageObjects.myAccountPage.MyAccountPage;
import pageObjects.productsPage.CasualDressesPage;
import pageObjects.productsPage.DressesPage;
import pageObjects.productsPage.ShoppingCartSummaryPage;
import pageObjects.productsPage.WomensPage;
import testUtilities.TestBase;

public class BuyCasualDress extends TestBase {

	@Test(description="Test to purchase a casual dress. Stops at shopping cart page.")
	public void PurchaseCasualDress(){
		final int numOfItemsInCart = 1;
		final String priceOfDress = "$26.00";
		
		// Login - needs to be moved to Utilities
		String username = getProperties().getProperty("defaultUserName");
		String password = getProperties().getProperty("defaultPassword");
		
		// open home page
		LogoSearchCartPage homePage = new LogoSearchCartPage(this.getDriver());
		
		// click the login link and get sent to the login page
		LoginPage loginPage = homePage.clickLogin();
		
		// login through the login page
		MyAccountPage myAccountPage = loginPage.login(username,  password);
		
		// Login - complete
		ProductsListPage productsListPage = new ProductsListPage(driver);
		WomensPage womensPage = productsListPage.selectWomenLink();
		DressesPage dressesPage = womensPage.dressesClick();
		CasualDressesPage casualDressesPage = dressesPage.casualDressClick();
		ShoppingCartSummaryPage shoppingCartSummaryPage = casualDressesPage.addToCartClick();
		Assert.assertTrue(shoppingCartSummaryPage.verifyNumItemsInCart(numOfItemsInCart),"Incorrect number of items in cart after purchase.");
		Assert.assertTrue(shoppingCartSummaryPage.verifyPrice(priceOfDress),"Unexpected price in shopping cart after purchase.");
		shoppingCartSummaryPage.deleteItem();
	}
}
