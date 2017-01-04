package pageUtilities;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageBase {
	protected WebDriver driver;
	protected Properties properties;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 15), this);
	}

	@FindBy(how = How.CSS, using = "a.logout")
	protected WebElement signOutLink;

	public void signOut() {
		if (signOutLink != null) {
			signOutLink.click();
		}
	}
	
	public void closeWindow(){
		driver.quit();
	}
}
