package org.ShareandRemember.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

public class PropsReader {

	public static String filePath;
	public static String configFilesPath = "C:/Users/Spritle/git/Share&Remember/src/test/resources/Configuration/";

	public static int timeoutInSeconds;

	// URLs
	public static String Url;
	
	
	// Driver
	public static String driver;

	// Super Admin Credentials
//	public static String superAdminUserName;
//	public static String superAdminPassword;

	// Account User
	public static String accountUserEmail;
	public static String accountUserPassword;
	public static String invalidaccountUserEmail;
	public static String invalidaccountUserPassword;
	public static String wrongaccountUserPassword;
	
	String randomEmail = randomEmail(6);
	
	
	public PropsReader() {

		// Driver
		//PropsReader.driver = readPropertiesFile(configFilesPath + "baseConfig.properties").getProperty("Driver");

		PropsReader.Url = readPropertiesFile(getBaseConfig()).getProperty("URL");
		
		
//		PropsReader.superAdminUserName = readPropertiesFile(getBaseConfig()).getProperty("SuperAdminUserName");
//		PropsReader.superAdminPassword = readPropertiesFile(getBaseConfig()).getProperty("SuperAdminPassword");

		PropsReader.timeoutInSeconds = Integer
				.parseInt(readPropertiesFile(getBaseConfig()).getProperty("TimeoutinSeconds"));

		// Accountuser creds
		PropsReader.accountUserEmail = readPropertiesFile(getBaseConfig()).getProperty("UserEmail");
		PropsReader.accountUserPassword = readPropertiesFile(getBaseConfig()).getProperty("Password");
		
		PropsReader.invalidaccountUserEmail = randomEmail;
		PropsReader.invalidaccountUserPassword = readPropertiesFile(getBaseConfig()).getProperty("Password");
		
		
		PropsReader.wrongaccountUserPassword = readPropertiesFile(getBaseConfig()).getProperty("Password1");
		
	}
	public String randomEmail(int numCount) {
		String name = "LP" +RandomStringUtils.randomNumeric(numCount) + "@Spritle.com";
		return name;
	}
	public static Properties readPropertiesFile(String fileName) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

	public String getBaseConfig() {
		String environment = readPropertiesFile(configFilesPath + "baseConfig.properties").getProperty("Environment");
		Properties props = new Properties();

		try {
			props.load(PropsReader.class.getClassLoader().getResourceAsStream("project.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String mvnEnvironment = props.getProperty("Environment");
		if (environment.equals("${Environment}")) {
			environment = mvnEnvironment;
		}
		try {
			switch (environment.toLowerCase()) {

			case "stage":
				filePath = configFilesPath + "stage.properties";
				break;
			case "prod":
				filePath = configFilesPath + "prod.properties";
				break;
			default:
				throw new Exception("Invalid Environment Selected");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}

}
