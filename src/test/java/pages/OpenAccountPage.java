package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinition.Hooks;

public class OpenAccountPage {
	 WebDriver driver ;
	
	public OpenAccountPage() {
		this.driver=Hooks.driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Open New Account')]")
	public WebElement lnkOpenAccount ;
	
	@FindBy(xpath="//*[@id='type']")
	public WebElement dropdAccountType ;
	
	@FindBy(xpath="//*[@id='fromAccountId']")
	public WebElement dropdAccountExisting ;
	
	@FindBy(xpath="//*[@id='rightPanel']//input[@type='submit']")
	public WebElement btnOpenAccount ;
	
	@FindBy(linkText="Account Opened!")
	public WebElement titleForAccount ;
	
	
	public void lnkOpenAccount() throws InterruptedException {
		
		this.lnkOpenAccount.click();
		Thread.sleep(2000);
	}
	
	public void accountType(String accountType) {
		Select accountDropDown = new Select(this.dropdAccountType);		
		accountDropDown.selectByVisibleText(accountType);
	}
	
	public String existingAccount() {
		Select checkinAccountNum = new Select(this.dropdAccountExisting);
		System.out.println(checkinAccountNum.getFirstSelectedOption().getText());
		String accountNum = checkinAccountNum.getFirstSelectedOption().getText();
		return accountNum;
	}
	public void openAccountbtn() throws InterruptedException {
		
		this.btnOpenAccount.click();
		Thread.sleep(3000);
	}
	
	public void accountTitle() {
		if(this.titleForAccount.isEnabled()){
			System.out.println("The Account is opened");
		}
	}
	
		
}
