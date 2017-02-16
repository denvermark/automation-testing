
package testUtilities;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import pageUtilities.PageBase;

public abstract class TestBase {
	private  String configFileName = "config.properties";
	protected  WebDriver driver;
	protected  Properties properties;
	protected  String driverName = "";
	protected  String driverPath = "";
	protected  Utilities utilities = new Utilities();

	public WebDriver getDriver() {
		return driver;
	}

	public Properties getProperties() {
		return properties;
	}

	@BeforeSuite
	@Parameters({ "browserType" })
	public void beforeSuite(String browserType) {
		// setup our webdriver based on the type of browser
		switch (browserType) {
			case "InternetExplorer":
				// When using IE, turn of Protected Mode for all zones otherwise
				// tests will fail
				driverName = "webdriver.ie.driver";
				driverPath = ".\\resources\\webDrivers\\IEDriverServer.exe";
				System.setProperty(driverName, driverPath);
				break;
			case "Firefox":
				driverName = "webdriver.gecko.driver";
				driverPath = ".\\resources\\webDrivers\\geckoDriver.exe";
				System.setProperty(driverName, driverPath);
				break;
			case "Chrome":
			default:
				// use chrome as the default if none is passed.
				driverName = "webdriver.chrome.driver";
				driverPath = ".\\resources\\webDrivers\\ChromeDriver.exe";
				System.setProperty(driverName, driverPath);
				break;
		}
	}

	@BeforeClass
	@Parameters({ "browserType" })
	public void beforeEveryClass(String browserType) {
		properties = utilities.setupProperties(configFileName);

		switch (browserType) {
			case "InternetExplorer":
				// When using IE, turn of Protected Mode for all zones otherwise
				// tests will fail
				driver = new InternetExplorerDriver();
				break;
			case "Firefox":
				driver = new FirefoxDriver();
				break;
			case "Chrome":
			default:
				// use chrome as the default if none is passed.
				driver = new ChromeDriver();
				break;
		}

		// navigate to the home page. If it doesn't exist in the properties
		// file, use the url below.
		String url = properties.getProperty("baseUrl", "http://automationpractice.com");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterEveryTestMethod() {
		PageBase page = new PageBase(driver);
		page.signOut();
		page.closeWindow();
	}

	@AfterSuite
	public void afterEverySuite() {
		driver.quit();
	}
}
