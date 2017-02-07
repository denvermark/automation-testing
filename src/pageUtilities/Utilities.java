package pageUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static WebElement getElement(WebDriver driver, By locator) {
		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, 2);
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element;
		} catch (TimeoutException ex) {
			return null;
		}
	}
}
