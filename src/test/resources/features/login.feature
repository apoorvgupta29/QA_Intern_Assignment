@login
Feature: Login Functionality

  Scenario Outline: Checking Login Credentials 
    Given User is in Home page and Navigate to login page 
    When User enters user name "<email>" and  password "<password>"
    And Submit the form and check credentials 
    And User performs some actions
    Then User log out successfully

    Examples: 
      | email                 | password       | 
      | neha@intervue.io      | Ps@neha@123    | 
      | apoorvgupta@email.com | apoorvgupta    | 
