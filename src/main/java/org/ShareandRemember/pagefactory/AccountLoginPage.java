package org.ShareandRemember.pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ShareandRemember.util.PropsReader;
import org.ShareandRemember.util.Wait;

public class AccountLoginPage {

		
	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;
	
	public AccountLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	@FindBy(xpath="//*[@id=\":r2:\"]")
	private WebElement accountUserEmail;
	public void enterUserName(String userEmail) {
		wait.forElementToBeDisplayed(accountUserEmail);
		accountUserEmail.clear();
		accountUserEmail.sendKeys(userEmail);
	}
	
	@FindBy(xpath="//*[@id=\":r3:\"]")
	private WebElement accountUserPassword;
	public void enterPassword(String password) {
		wait.forElementToBeDisplayed(accountUserPassword);
		accountUserPassword.clear();
		accountUserPassword.sendKeys(password);
	}
	
	
	@FindBy(xpath="//*[@id=\"root\"]/main/div[2]/div/div/div[2]/form/button")
	private WebElement accountLogin;
	public void clickLoginButton() {
		accountLogin.click();
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]")
	private WebElement errormessage;
	public String checksnackbar() {
		wait.forElementToBeDisplayed(errormessage);
		errormessage.isDisplayed();
		return errormessage.getText();
	}
	
	
}