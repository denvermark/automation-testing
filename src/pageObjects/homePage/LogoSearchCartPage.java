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

	public WebElement getSpecificSearchResult(List<WebElement> results, int productId){
		String linkUrl = String.format("http://automationpractice.com/index.php?id_product=%d&controller=product&search_query=faded&results=1", productId);
		List<WebElement> foundElements = new ArrayList<WebElement>();
		
		for (WebElement li: results){
			List<WebElement> links = li.findElements(By.cssSelector("a[href='" + linkUrl + "']"));
			if (links.size() > 0){
				foundElements.add(li);
			}
		}
		
		if (foundElements.size() == 0){
			throw new NotFoundException("Could not find the element requested");
		} else if(foundElements.size() > 1){
			throw new IndexOutOfBoundsException("Too many results were found.");
		} else{
			return foundElements.get(0);
		}

	}

	public LoginPage clickLogin() {
		signInLink.click();
		return new LoginPage(driver);
	}
	
	public CartPage clickCartButton(){
		cartButton.click();
		return new CartPage(driver);
	}
}
