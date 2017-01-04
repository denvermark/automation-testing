
package testUtilities;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageUtilities.PageBase;

public class TestBase {
	private String configFileName = "config.properties";
	protected WebDriver driver;
	protected Properties properties;
	protected String driverType = "";
	protected String driverName = "";
	protected String driverPath = "";
	protected Utilities utilities = new Utilities();

	public WebDriver getDriver() {
		return driver;
	}

	public Properties getProperties() {
		return properties;
	}

	@BeforeSuite
	@Parameters({ "browserType" })
	public void beforeEverySuite(String browserType) {
		this.driverType = browserType;

		switch (browserType) {
		case "InternetExplorer":
			// When using IE, turn of Protected Mode for all zones otherwise
			// tests will fail
			driverName = "webdriver.ie.driver";
			driverPath = "C:\\Program Files (x86)\\eclipse\\IEDriverServer.exe";
			break;
		case "Firefox":
			// no name or path needed
			break;
		case "Chrome":
		default:
			// use chrome as the default if none is passed.
			driverName = "webdriver.chrome.driver";
			driverPath = "C:\\Program Files (x86)\\eclipse\\ChromeDriver.exe";
			break;
		}

		properties = utilities.setupProperties(configFileName);
	}

	@BeforeTest
	public void beforeEveryTest() {
		// check if we need to set the system property
		if (driverName != "" && driverPath != "") {
			System.setProperty(driverName, driverPath);
		}

		// create a new browser
		switch (driverType) {
		case "InternetExplorer":
			driver = new InternetExplorerDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Chrome":
		default:
			driver = new ChromeDriver();
		}

		// navigate to the home page. If it doesn't exist in the properties
		// file, use the url below.
		String url = properties.getProperty("baseUrl", "http://automationpractice.com");
		driver.get(url);
	}

	@AfterTest
	public void afterEveryTest() {
		PageBase page = new PageBase(driver);
		page.signOut();
		page.closeWindow();
	}
}
