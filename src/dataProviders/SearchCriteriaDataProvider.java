package dataProviders;

import org.testng.annotations.DataProvider;

public class SearchCriteriaDataProvider {
	@DataProvider(name = "searchCriteriaDataProvider")
	public Object[][] getData() {
		return new Object[][] { { "faded" }, { "blouse" } };
	}
}
