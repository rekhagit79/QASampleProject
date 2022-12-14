package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OpenAccountPage;
import utils.SessionVariables;

public class OpenAccountSteps {
	//public static WebDriver driver  ;
	public OpenAccountPage op;
	
	/*@Given("user opens the application url {string}")
	public void user_opens_the_application_url(String url) {
		driver =new ChromeDriver();	
		op = new OpenAccountPage(driver);
		lp = new LoginPage(driver);	
	//	lp.launchAppln(url);
	}

	@Given("user1 enters the userid as {string} and password {string}")
	public void user1_enters_the_userid_as_and_password(String username, String password) {
	    lp.loginToAppln(username, password);
	}*/
	
		
	@When("the user click the OpenAccount link")
	public void the_user_click_the_open_account_link() throws InterruptedException {
		//driver =new ChromeDriver();
	//	driver = indriver.initialize();	
		op = new OpenAccountPage();
		op.lnkOpenAccount();
	}

	@When("user selects account {string}")
	public void user_selects_account(String accounttype) {
		op.accountType(accounttype);
	    
	}

	@When("select an existing account")
	public void select_an_existing_account() {
	    op.existingAccount();
	}

	@When("user click on Open New Account button")
	public void user_click_on_open_new_account_button() throws InterruptedException {
	    op.openAccountbtn();
	}

	
	@Then("user can view the new account number")
	public void user_can_view_the_new_account_number() {
		op.accountTitle();
	    
	}
	
	
	@When("user selects accout AccountType")
	public void user_selects_accout_account_type() {
		op.accountType(SessionVariables.testData.get("AccountType"));
	}


}