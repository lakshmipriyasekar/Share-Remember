package org.ShareandRemember.steps;

import static org.junit.Assert.assertEquals;

//import org.openqa.selenium.WebDriver;
import org.ShareandRemember.pagefactory.AccountLoginPage;
import org.ShareandRemember.pagefactory.AccountUserDTO;
import org.ShareandRemember.pagefactory.AcountLogoutPage;
import org.ShareandRemember.pagefactory.MyProfilePage;
import org.ShareandRemember.util.BasePage;
import org.ShareandRemember.util.PropsReader;

public class AccountUserLoginandLogoutStep  extends BasePage{

	
	PropsReader propsReader = new PropsReader();
	AccountLoginPage accountLoginPage = new AccountLoginPage(driver);
	AcountLogoutPage accountLogoutPage = new AcountLogoutPage(driver);
	MyProfilePage accountUserEmailID = new MyProfilePage(driver);
	AccountUserDTO datacreation = new AccountUserDTO();
	AccountUserDTO data = new AccountUserDTO();
	String Email = PropsReader.accountUserEmail;
	String profilemail;
	
	
	public void loginUser(String userType) {
		
		try {
			switch (userType) {
			  
			case "AccountUser":
			
				driver.get(PropsReader.Url);
				accountLoginPage.enterUserName(PropsReader.accountUserEmail);
				accountLoginPage.enterPassword(PropsReader.accountUserPassword);
				accountLoginPage.clickLoginButton();
				datacreation.setEmailID(Email);
                break;
			case "NonAccountUser":
				
				driver.get(PropsReader.Url);
				accountLoginPage.enterUserName(PropsReader.invalidaccountUserEmail);
				accountLoginPage.enterPassword(PropsReader.invalidaccountUserPassword);
				accountLoginPage.clickLoginButton();
				datacreation.setEmailID(Email);
                break;
			case "AccountUserwithwrongpassword":
				
				driver.get(PropsReader.Url);
				accountLoginPage.enterUserName(PropsReader.accountUserEmail);
				accountLoginPage.enterPassword(PropsReader.wrongaccountUserPassword);
				accountLoginPage.clickLoginButton();
				datacreation.setEmailID(Email);
                break;
				
			case "SuperAdmin":
				driver.get(PropsReader.Url);
				accountLoginPage.enterUserName(PropsReader.accountUserEmail);
				accountLoginPage.enterPassword(PropsReader.accountUserPassword);
				accountLoginPage.clickLoginButton();
				datacreation.setEmailID(Email);
                break;
               
			}
		}
	 catch (Exception e) {
			e.printStackTrace();
		}
		
	}

public void openMyProfile() {
	accountUserEmailID.clickonAccountSettings();
	profilemail = accountUserEmailID.profileEmailID();
	data.setProfileEmailID(profilemail);
	
}

public void verifyEmailID() {
	
	assertEquals(datacreation.getEmailID(), data.getProfileEmailID());
	//assertEquals(Email, profilemail);
}

public void readErrorMessage(String message) {
	String actualmessage = accountLoginPage.checksnackbar();
	//System.out.println(actualmessage);
	assertEquals(message, actualmessage );
}
  
 public void logoutUser(String userType) {
  	
   	try {
   		switch (userType) {
		  
		    case "AccountUser":
   			//driver.get(PropsReader.Url);
   			accountLogoutPage.clicklogoutbutton();
   		    break;
			
		    case "SuperAdmin":
			accountLogoutPage.clicklogoutbutton();
		    break;
    		}
   	}
   		
   	catch (Exception e) {
			e.printStackTrace();
		}
   	
    	
    }
}
    

