package pageObjects.cartPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageUtilities.PageBase;

public class CartPage extends PageBase{
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.CSS, using="h1.cart_title")
	private WebElement cartSummarySection;
	
	public WebElement getCartSummarySection(){
		return cartSummarySection;
	}
}
