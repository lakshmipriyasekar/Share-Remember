Feature: Verify Login Page
  This feature verifies all combinations of Login functionality

  Scenario: 01 Login a non-account user
    Given Login as NonAccountUser
    Then Verify the error message as Invalid Email or Password.

  Scenario: 02 Login a existing account user with wrong password
    Given Login as AccountUserwithwrongpassword
    Then Verify the error message as Wrong password

  Scenario: 03 Login a existing account user
    Given Login as AccountUser
    Then Verify the ProfileEmail in MyProfile matches given Emailid
    Given Logout as AccountUser
