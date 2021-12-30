Feature: Search employee

  @Regression @sprint4
  Scenario: search employee by id
  #  Given user is navigated to HRMS   -->we don't need this step anymore because we use Hooks class which will open our browser
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee id
    And click on search button
    Then user see employee information is displayed

  @Regression @sprint4
  Scenario: search employee by name
  #  Given user is navigated to HRMS   -->we don't need this step anymore because we use Hooks class which will open our browser
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee name
    And click on search button
    Then user see employee information is displayed
