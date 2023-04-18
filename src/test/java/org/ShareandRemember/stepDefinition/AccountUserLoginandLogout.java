package org.ShareandRemember.stepDefinition;


import org.ShareandRemember.steps.AccountUserLoginandLogoutStep;
//import org.ShareandRemember.util.BeforeAndAfterScenarios;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountUserLoginandLogout {

	
	AccountUserLoginandLogoutStep beforescenario= new AccountUserLoginandLogoutStep();

		@Given("^Logout as (.*)$")
		public void logoutUser(String userType){
			 beforescenario.logoutUser(userType);
			
		}

		@Then("Verify the ProfileEmail in MyProfile matches given Emailid")
		public void verify_the_email_in_my_profile() {
			beforescenario.openMyProfile();
			beforescenario.verifyEmailID();
		}

		@Given("^Login as (.*)$")
		public void loginUser(String userType){
			beforescenario.loginUser(userType);
		}

		@Then("Verify the error message as (.*)$")
		public void verify_errormessage(String message) {
			beforescenario.readErrorMessage(message);
		}

}
