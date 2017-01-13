package testUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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
}
