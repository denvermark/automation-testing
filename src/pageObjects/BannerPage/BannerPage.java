package pageObjects.BannerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import pageUtilities.PageBase;

public class BannerPage extends PageBase {

	public BannerPage(WebDriver driver) {
		super(driver);
	}
		
		
		
		// banner link
		@FindBy(how = How.CLASS_NAME, using ="img-responsive")
		WebElement bannerLink;
		
		
		// Contact Us link
		
		@FindBy(how = How.XPATH, using ="//*[@id='contact-link']/a")
		WebElement ContactUsLink;
		
		
		// Sign In link
		
		@FindBy (how = How.CLASS_NAME, using ="login")
				WebElement loginLink;
		
		public WebElement getContactUs(){
			return bannerLink;
		}

		public void contactClick() {
			ContactUsLink.click();
			
		}
		
		public String getContactUrl(){
			return driver.getCurrentUrl();
		}
		
		public void signInClick(){
			
			loginLink.click();
			
		}
		
		
		
		
	}
