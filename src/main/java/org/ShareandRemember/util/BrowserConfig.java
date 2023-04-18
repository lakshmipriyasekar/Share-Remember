/**
 * 
 */
/**
 * @author Spritle
 *
 */
package org.ShareandRemember.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class BrowserConfig {
	static WebDriver driver;
	PropsReader propsReader = new PropsReader();
	
//    public BrowserConfig() {
//    	BrowserConfig.driver = openBrowser();
//    }
    
	public WebDriver openBrowser() {
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");	
			System.setProperty("webdriver.chrome.driver", "C:/Users/Spritle/git/Share&Remember/src/test/resources/Configuration/lib/chromedriver.exe");
		
			driver = new ChromeDriver(ops);
			driver.manage().window().maximize();
			
		return driver;
	}

	public void close_browser() {
		driver.quit();
	}
}





