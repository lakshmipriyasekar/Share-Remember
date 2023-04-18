package org.ShareandRemember.pagefactory;

import org.ShareandRemember.util.PropsReader;
import org.ShareandRemember.util.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;
	
	public MyProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	@FindBy(xpath="//*[@id=\"infiniteScroll\"]/div/header/div/div/div[1]/div[2]/button[2]")
	private WebElement logoutDropdown;
	@FindBy(xpath="//*[@id=\"basic-menu\"]/div[3]/ul/div/li[1]")  
	private WebElement clickAccountSettings;
	
	public void clickonAccountSettings() {
		
		wait.forElementToBeDisplayed(logoutDropdown);
		logoutDropdown.click();
		wait.forElementToBeDisplayed(clickAccountSettings);
		clickAccountSettings.click();
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/main/div[1]/div/div[3]/div/div/div/form/div[4]/div/input")  
	private WebElement emailid;
    public String profileEmailID() {
		
		wait.forElementToBeDisplayed(emailid);
		return emailid.getAttribute("value");
		
	}
    
   
}
