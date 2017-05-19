package pageObjects.productsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageUtilities.PageBase;

public class ShoppingCartSummaryPage extends PageBase{
	//private final int numItems = 1;
	//private final String expectedPrice = "26.00";
	
	public ShoppingCartSummaryPage(WebDriver driver){
	super(driver);
	}
	
	@FindBy(how = How.ID, using = "summary_products_quantity")
	private WebElement numOfProductsInCart;
	
	@FindBy(how = How.XPATH, using = "//*[@id='product_price_3_13_6979']/span")
	private WebElement productPrice;

	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Delete')]")
	private WebElement deleteLink;
	
	public boolean verifyNumItemsInCart(int expectedItems){
		String[] numberOfProducts = numOfProductsInCart.getText().split(" ");
		return (Integer.parseInt(numberOfProducts[0]) == expectedItems);
	}
	public boolean verifyPrice(String expectedPrice){
		return productPrice.getText().equals(expectedPrice);
	}
	
	public void deleteItem(){
		deleteLink.click();
	}

}
