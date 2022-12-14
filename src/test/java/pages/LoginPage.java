 package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import stepDefinition.Hooks;

public class LoginPage {
	WebDriver driver ;
	
	public LoginPage() {
		this.driver=Hooks.driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(name="username")
	public WebElement txtUserName;
	
	@FindBy(name="password")
	public WebElement txtPassWord;
	
	@FindBy(xpath="//input[@class='button']")
	public WebElement btnLogin;
	
	@FindBy(xpath="//*[@id='loginPanel']//a[contains(text(),'Register')]")
	public WebElement lnkRegister;
	
	@FindBy(xpath="//*[@id='loginPanel']//a[contains(text(),'Forgot login info?')]")
	public WebElement lnkForgotogin; 
	
	@FindBy(xpath="//*[@id='rightPanel']/h1[@class='title']")
	public WebElement txtCustomerLookUp; 
	
	@FindBy(xpath="//*[@id='rightPanel']/h1[@class='title']")
	public WebElement txtRegisterTitle;
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Log Out')]")
	public WebElement btnLogOut;
	
	
public void loginToAppln(String username, String password) {
		this.txtUserName.sendKeys(username);
		this.txtPassWord.sendKeys(password);
		
		
	}
public void clickLoginBtn() throws InterruptedException {
	this.btnLogin.click();	
	
	Thread.sleep(2000);
	
}



	public void register_lnk() {
		try {
		this.lnkRegister.click();
		String txtRegisterTitle=this.txtCustomerLookUp.getText().trim();
		
		if(txtRegisterTitle.equals("Signing up is easy!")) {
			System.out.println("Register page loaded");
		}else {
			System.out.println("Register page not loaded");
		}
		}
		catch(Exception e)
		{
			System.out.println("Error in Login page");
			e.printStackTrace();
		}
		
	}
	public void launchAppln(String url) {
		System.out.println("inside launchAppln");
 		driver.get(url);
	//	 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
	}
	
	public void forgotLoginInfo() {
		this.lnkForgotogin.click();
		String lblCustomerLookUp=this.txtCustomerLookUp.getText().trim();
		if(lblCustomerLookUp.equals("Customer Lookup")) {
			System.out.println("Customer Look up page loaded");
		}else {
			System.out.println("Customer Look up page not loaded");
		}
	}
	public void logoutAppln() throws InterruptedException {
		Thread.sleep(2000);
		this.btnLogOut.click();
	}
	
	public void titleLogin(String title) {
		if(driver.getTitle().equalsIgnoreCase(title)){
	    	System.out.println("The user has successfully logged in");
	    }
	}
		
	public void tearDown() {
		this.driver.quit();
		
	}
		
	}
	
	
	

