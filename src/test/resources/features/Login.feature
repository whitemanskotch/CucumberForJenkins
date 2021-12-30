@sprint10 #tag for execution whole feature
Feature: Login validation

  @smoke @sprint3
  Scenario: Valid admin login
  #  Given user is navigated to HRMS  -->we don't need this step anymore because we use Hooks class which will open our browser
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in

  @regression @sprint2
  Scenario: Valid ess login
  #  Given user is navigated to HRMS  -->we don't need this step anymore because we use Hooks class which will open our browser
    When user enters valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

    @smoke @regression @sprint1
    Scenario: Valid username and invalid password
  #    Given user is navigated to HRMS  -->we don't need this step anymore because we use Hooks class which will open our browser
      When user enters valid username and invalid password
      And user clicks on login button
      Then user see invalid credentials message on login page