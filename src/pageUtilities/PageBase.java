package pageUtilities;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageBase {
	protected WebDriver driver;
	protected Properties properties;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 15), this);
	}

	// removed page factory's @FindBy because it causes errors when the element
	// doesn't exist.
	// the signout link will not exist if the user is not logged in yet.
	/*
	 * @FindBy(how = How.CSS, using = "a.logout")
	 * protected WebElement signOutLink;
	 */

	private By signOutLink = By.cssSelector("a.logout");

	public WebElement getSignOutLink() {
		return Utilities.getElement(this.driver, signOutLink);
	}

	public void signOut() {
		// click the sign out link if it exists
		WebElement link = this.getSignOutLink();

		if (link != null) {
			link.click();
		}
	}

	public void closeWindow() {
		this.driver.close();
	}
}
