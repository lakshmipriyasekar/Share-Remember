package org.ShareandRemember.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.ShareandRemember.util.BrowserConfig;
import org.ShareandRemember.util.Wait;


public class BasePage {

	protected WebDriver driver;
    protected Wait wait;
	
	public BasePage() {
		PageFactory.initElements(driver, this);
		this.driver = BrowserConfig.driver;
		this.wait = new Wait(this.driver);
	}
}
