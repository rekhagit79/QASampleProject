package stepDefinition;

import io.cucumber.java.en.Given;
import utils.ConnectionWithExcel;
import utils.SessionVariables;
public class ExcelData {
	
	@Given("data is loaded for scenario {string}")
	public void data_is_loaded_for_scenario(String scenarioName) {
	    
		SessionVariables.scenario=scenarioName;
		ConnectionWithExcel data = new ConnectionWithExcel();
		
		SessionVariables.testData =data.loadTestData(scenarioName);
		System.out.println("loaded the test data");
	}


}
