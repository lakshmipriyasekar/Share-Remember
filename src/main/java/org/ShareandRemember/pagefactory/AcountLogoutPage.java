package org.ShareandRemember.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ShareandRemember.util.PropsReader;
import org.ShareandRemember.util.Wait;

public class AcountLogoutPage {
	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;
	
	public AcountLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	@FindBy(xpath="//*[@id=\"infiniteScroll\"]/div/header/div/div/div[1]/div[2]/button[2]")
	private WebElement logoutDropdown;
	@FindBy(xpath="//*[@id=\"basic-menu\"]/div[3]/ul/div/li[4]/div[2]/span")  
	private WebElement clickLogout;
	
	public void clicklogoutbutton() {
		
		wait.forElementToBeDisplayed(logoutDropdown);
		logoutDropdown.click();
		wait.forElementToBeDisplayed(clickLogout);
		clickLogout.click();
	}
	

}
