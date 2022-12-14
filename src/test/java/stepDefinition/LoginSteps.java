package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage;
import utils.SessionVariables;

public class LoginSteps {
	
	//public  static WebDriver driver;
	public LoginPage lp;
	
	
	
	@Given("user has launched the browser")
	public void user_has_launched_the_browser() {
		
		lp = new LoginPage();
	}
	
	@When("user opens the application url {string}")
	public void user_opens_the_application_url(String url) {
		lp.launchAppln(url);
		
	}
	@When("user enters the userid as {string} and password {string}")
	public void user_enters_the_userid_as_and_password(String username, String password) {
		lp.loginToAppln(username, password);  
	}
	@When("user clicks the login button")
	public void user_clicks_the_login_button() throws InterruptedException {
		lp.clickLoginBtn();
		
	}
	@Then("user is successfully logged into application with title {string}")
	public void user_is_successfully_logged_into_application_with_title(String title) {
		lp.titleLogin(title);
	}
	@Then("user is logged out")
	public void user_is_logged_out() throws InterruptedException {
	    lp.logoutAppln();
	}
	@When("user enters the userid and password")
	public void user_enters_the_userid_and_password() {
		
		
	    lp.loginToAppln(SessionVariables.testData.get("UserName"),SessionVariables.testData.get("PassWord"));
	    System.out.println("User and Password loaded");
		
	}
	@Given("user is successfully logged into application with title title")
	public void user_is_successfully_logged_into_application_with_title_title() {
		lp.titleLogin(SessionVariables.testData.get("title"));
	     
	}
	
	@When("user opens the application url")
	public void user_opens_the_application_url() {
	    lp.launchAppln(SessionVariables.Appurl);
	}



}

	

