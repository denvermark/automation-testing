package dataProviders;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import dataModels.*;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD })
	public @interface DataProviderConfig {
		public String[] value() default {};
	}

	private Config getConfigs(Method method) {
		Config config = new Config();

		// get the array of values passed on the @DataProviderConfig annotation
		// on the test method.
		String[] configs = ((DataProviderConfig) method.getAnnotation(DataProviderConfig.class)).value();
		
		// make sure there are two elements in the array and both are not null
		if (configs.length != 2 || configs[0] == null || configs[1] == null){
			throw new IllegalArgumentException("Wrong number of values were passed to DataProviderConfig.");
		}
		
		// should be in the format {source, className}
		config.source = configs[0];
		config.className = configs[1];

		return config;
	}

	@DataProvider(name = "xlsxDataProvider")
	public Object[][] getData(Method method) throws Exception {
		Config config = getConfigs(method);

		try {
			// get all info from the array
			Object[][] tableArray = ExcelUtils.getTableArray(".\\testData\\" + config.source, "");

			// define the array of objects that we will be returning
			Object[][] returnValue = new Object[tableArray.length - 1][1];

			Field property;
			Object newObject;

			// loop through all the rows starting with the second row (ignoring
			// headers)
			for (int i = 1; i < tableArray.length; i++) {
				newObject = Class.forName(config.className).getConstructor().newInstance();

				// loop through all of the header rows to get the property names
				for (int j = 0; j < tableArray[0].length; j++) {
					// set the property on the object
					// property name = tableArray[0][j]
					// property value = tableArray[i][j]
					try { // make sure the property exists
						property = Class.forName(config.className).getField(tableArray[0][j].toString());
					} catch (NoSuchFieldException e) {
						throw new NoSuchFieldException("Could not find the property " + tableArray[0][j].toString()
								+ " on the class " + config.className);
					}

					// try to set the property now that we know it exists
					property.set(newObject, tableArray[i][j]);

				}

				// add the newly created object to the array
				returnValue[i - 1][0] = newObject;
			}

			return returnValue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}
