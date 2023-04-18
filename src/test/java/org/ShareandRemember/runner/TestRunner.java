package org.ShareandRemember.runner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.ShareandRemember.util.BrowserConfig;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Login.feature",
        glue= {"org/ShareandRemember/stepDefinition"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"},
        //tags = "@Smoke",
        monochrome = true,
        publish = true
     //   dryRun=true
)
public class TestRunner{
	static BrowserConfig browserConfig = new BrowserConfig();
	
	
	@BeforeClass
	public static void setup() {
		browserConfig.openBrowser();
	
		
	}

    @AfterClass
	public static void tearDown() {
		browserConfig.close_browser();
	}

	
	

}
