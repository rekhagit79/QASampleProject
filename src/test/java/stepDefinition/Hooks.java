package stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.Config;
import utils.SessionVariables;

public class Hooks {
	
	public static WebDriver driver;
	@Before
	public void before(Scenario scenario) {
		System.out.println("Executed before feature" +scenario.getName());
		setWebDriver();
		Config.setProperties();
		SessionVariables.Appurl=Config.getProperties("Appurl");
	}
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Executed b4 all scenarios");

	}
	
	public static void setWebDriver() {
		if(driver==null) {
			  driver = new ChromeDriver();
			
		}
	}
	
	public static void attachScreenshot(Scenario scenario) {
		scenario.log("<br>");
		String screenshot = ((org.openqa.selenium.TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		byte[] bdecode	=(org.apache.commons.codec.binary.Base64.decodeBase64(screenshot.getBytes()));
		scenario.attach(bdecode,"image/png","Reports");
		scenario.log("<br>");		
		
	}
	
	public void after(Scenario scenario) {
		attachScreenshot( scenario);
		
		
	}

}
