package pageObjects.homePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObjects.cartPage.CartPage;
import pageObjects.loginPage.LoginPage;
import pageUtilities.PageBase;

public class LogoSearchCartPage extends PageBase {

	public LogoSearchCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CLASS_NAME, using = "login")
	private WebElement signInLink;

	@FindBy(how = How.CSS, using = "img.logo.img-responsive")
	private WebElement logo;

	@FindBy(how = How.ID, using = "search_query_top")
	private WebElement searchTextBox;

	@FindBy(how = How.CSS, using = "div.shopping_cart>a[href='http://automationpractice.com/index.php?controller=order']")
	private WebElement cartButton;

	@FindBy(how = How.CSS, using = "button[name=submit_search].button-search")
	private WebElement searchButton;

	@FindBy(how = How.CSS, using = "ul.product_list>li")
	private List<WebElement> searchResults;

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getCartButton() {
		return cartButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public List<WebElement> getSearchResults() {
		return searchResults;
	}

	public WebElement getSpecificSearchResult(List<WebElement> results, String searchCriteria) {
		String selector = String.format(
				"//div[@class='product-container']//a[contains(translate(., '%1s', '%2s'), '%3s')]",
				searchCriteria.toUpperCase(), 
				searchCriteria.toLowerCase(), 
				searchCriteria.toLowerCase());

		/*
		 * for (WebElement li : results) {
		 * List<WebElement> products = li.findElements(By.xpath(selector));
		 * if (products.size() > 0) {
		 * foundElements.add(li);
		 * }
		 * }
		 */

		if (results.size() == 0) {
			throw new NotFoundException("Could not find the element requested.");
		} else if (results.size() > 1) {
			throw new IndexOutOfBoundsException("Too many results were found.");
		} else {
			List<WebElement> items = results.get(0).findElements(By.xpath(selector));
			if (items.size() != 1) {
				throw new NotFoundException("The wrong results were returned.");
			} else {
				return items.get(0);
			}
		}
	}

	public LoginPage clickLogin() {
		signInLink.click();
		return new LoginPage(driver);
	}

	public CartPage clickCartButton() {
		cartButton.click();
		return new CartPage(driver);
	}
}
