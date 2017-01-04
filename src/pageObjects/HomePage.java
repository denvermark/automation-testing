package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageUtilities.PageBase;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/*
	 * for using phptravels.net
	 * 
	 * @FindBy(how=How.CSS, using = "a.dropdown-toggle:contains(My Account)")
	 * private WebElement accountLink;
	 * 
	 * @FindBy(how=How.CSS, using = "a[href$=login]:contains(Login)")
	 * private WebElement loginLink;
	 */

	@FindBy(how = How.CLASS_NAME, using = "login")
	private WebElement signInLink;

	public LoginPage clickLogin() {
		signInLink.click();

		/*
		 * for using phptravels.net
		 * 
		 * // get the list of all tabs open.
		 * driver.getWindowHandle();
		 * ArrayList<String> tabHandles = new ArrayList<String>
		 * (driver.getWindowHandles());
		 * // get the 2nd tab (index is 1 because it's 0-based).
		 * String newPageHandle = tabHandles.get(1);
		 * // switch to that tab.
		 * driver.switchTo().window(newPageHandle);
		 */

		return new LoginPage(driver);
	}
}
