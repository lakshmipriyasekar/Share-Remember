package org.ShareandRemember.runner;

//import org.cucumberReport.CucumberReport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.ShareandRemember.steps.AccountUserLoginandLogoutStep;
import org.ShareandRemember.util.BrowserConfig;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue= {"org/ShareandRemember/stepDefinition"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"},
        //tags = "@Smoke",
        monochrome = true,
        publish = true
     //   dryRun=true
)
public class TestRunner1{
	static BrowserConfig browserConfig = new BrowserConfig();
	static AccountUserLoginandLogoutStep beforescenario= new AccountUserLoginandLogoutStep();
	
	@BeforeClass
	public static void setup() {
		//browserConfig.openBrowser();
		beforescenario.loginUser("AccountUser");
		
	}

    @AfterClass
	public static void tearDown() {
    	beforescenario.logoutUser("AccountUser");
		browserConfig.close_browser();
	}


	
	

}
