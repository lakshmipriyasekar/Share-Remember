package org.cucumberReport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReport {
	public static void cucumberReport(String json) {
		File filepath = new File("Share&Remember/target");
		Configuration config = new Configuration(filepath, "Selenium_Template");
		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Version", "103");
		config.addClassifications("OS", "Windows 11");
		config.addClassifications("Resource", "gopi");
		List<String> li = new ArrayList<String>();
		li.add(json);
		
		ReportBuilder build = new ReportBuilder(li, config);
		build.generateReports();
	}

}
