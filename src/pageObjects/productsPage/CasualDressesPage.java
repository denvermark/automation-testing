package pageObjects.productsPage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

import pageUtilities.PageBase;

public class CasualDressesPage extends PageBase{
	public CasualDressesPage(WebDriver driver){
		super(driver);
	}
	@FindBy(how = How.XPATH, using = "//*[@id='add_to_cart']/button/span")
	private WebElement addToCartButton;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@title,'Proceed to checkout')]")
	private WebElement proceedButton;
	

	
	public ShoppingCartSummaryPage addToCartClick(){
		WebElement picture = driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]"));
		picture.click();
		WebElement iFrame = driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]"));
		driver.switchTo().frame(iFrame);
		addToCartButton.click();
		proceedButton.click();
		return new ShoppingCartSummaryPage(driver);

	}
}
