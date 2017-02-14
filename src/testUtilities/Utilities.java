package testUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	public Properties setupProperties(String configFileName) {
		File configFile = new File(configFileName);
		Properties properties = new Properties();

		try {
			FileReader reader = new FileReader(configFile);
			properties.load(reader);
		} catch (FileNotFoundException ex) {
			System.out.println("Config properties file not found.");
		} catch (IOException ex) {
			System.out.println("IO Exception.");
		}

		return properties;
	}
	
	public static void errorCapture(WebDriver driver){
		// take a screenshot
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {

					// now copy the screenshot to desired location using copyFile method
					// this will create a different file name each time using the
					// currentTime
					FileUtils.copyFile(srcFile,
							new File(".\\test-output\\ErrorOutput\\" + System.currentTimeMillis() + " testing.png"));

				}

				catch (IOException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(srcFile.getAbsolutePath());

				
				// view the page source and save to a file

				String pagesourcevalue = driver.getPageSource();

				try {
					File f = new File(".\\test-output\\ErrorOutput\\PageSource" + System.currentTimeMillis() + ".txt");
					FileWriter writer = new FileWriter(f);
					writer.write(pagesourcevalue);
					writer.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
		
		
		
	}
	
	
	
}



