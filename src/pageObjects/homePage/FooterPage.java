package pageObjects.homePage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Reporter;

import pageObjects.ContactUsPage.ContactUsPage;
import pageUtilities.PageBase;

public class FooterPage extends PageBase {


	public FooterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'contact-link')]/a")
	private WebElement contactUsLink;
	
	@FindBy(how=How.XPATH,using = "//div[contains(@class,'category_footer toggle-footer')]/div/ul/li")
	private List<WebElement> categoryList;
	
	@FindBy(how=How.XPATH, using = "//*[@id='block_various_links_footer']/ul/li")
	private List<WebElement> informationList;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@class,'block_content toggle-footer]/ul/li")
	private List<WebElement> myAccountList;
	
	
	public static final List<String> footerCategories =  Arrays.asList("Women");
	public static final List<String> footerInformation = Arrays.asList("Specials","New products","Best sellers","Our stores","Contact us","Terms and conditions of use","About us","Sitemap");
	public static final String breadcrumb = "navigation_page";
	public static final List<String> infoBreadcrumbList = Arrays.asList("Price drop","New products","Best sellers","Our store(s)!","Contact","Terms and conditions of use","About us","Sitemap");
	//public static final String baseUrl = "http://automationpractice.com/index.php?controller=";
	//public static final List<String> footerUrls = Arrays.asList("prices-drop","new-products","best-sales","stores","contact","cms","sitemap");
	
public boolean verifyCategoriesLinks() {
	try{
		driver.findElement(By.xpath("//section/h4[contains(text(),'Categories')]"));
		int numOfItems = driver.findElements(By.xpath("//div[contains(@class,'category_footer')]/div/ul")).size();
		String xpathString = "//div[contains(@class,'category_footer')]/div/ul/li[%1$d]/a";
		return checkFooterLinks(driver, numOfItems, xpathString,footerCategories);
	}
	catch(NoSuchElementException e){
		Reporter.log("Categories section in does not display in footer as expected.");
		return false;
	}
}

public boolean verifyInformationLinks(){
	try{
		driver.findElement(By.xpath("//section/h4[contains(text(),'Information')]"));
		int numOfItems = driver.findElements(By.xpath("//section[contains(@id,'block_various_links_footer')]/ul/li")).size();
		String xpathString = "//section[contains(@id,'block_various_links_footer')]/ul/li[%1$d]/a";
		return checkFooterLinks(driver, numOfItems, xpathString,infoBreadcrumbList);
	}
	catch(NoSuchElementException e){
		Reporter.log("Information section does not display in footer as expected.");
		return false;
	}
}

public static boolean checkFooterLinks(WebDriver driver,int numOfItems,String xpathString, List<String> linkNames) {
	try{
		for(int i=1;i<=numOfItems;i++){
			WebElement categoryLink = driver.findElement(By.xpath(String.format(xpathString,i)));
			categoryLink.click();
			//Helper.WaitForPage();
			if(!linkNames.get(i-1).equals(driver.findElement(By.className(breadcrumb)).getText().trim())){
				return false;
			}
			driver.navigate().back();
			//Helper.WaitForPage();
		}
		return true;
	}
	catch(NoSuchElementException e){
		Reporter.log("Error when selecting link.");
		return false;
	}
}


public ContactUsPage clickOnContactUs(){
	contactUsLink.click();
	//Helper.WaitForPage();
	return new ContactUsPage(driver);
}

public boolean validateFooterInformationList(){
	List<String> listOfLinks = new ArrayList<String>();
	
	for(WebElement e:informationList){
		listOfLinks.add(e.getText().trim());
	}
	return listOfLinks.equals(footerInformation);
}

/*public boolean verifyMyAccountLinks(){
	try {
	driver.findElement(By.xpath("//section/h4/a[contains(text(),'My account')]"));
	int numOfItems = driver.findElements(By.xpath("//section/div[contains(@class,'block_content')]/ul/li")).size();
	String xpathString = "//section/div[contains(@class,'block_content')]/ul/li/a";
	return Helper.checkLinks(driver, numOfItems, xpathString);
	}
	catch(NoSuchElementException e){
		Helper.Log("My Account section does not display in footer as expected.");
		return false;
	}
}*/
}
