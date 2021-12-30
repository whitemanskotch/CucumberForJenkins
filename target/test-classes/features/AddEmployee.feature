Feature: Add Employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @1027
  Scenario: first scenario of adding the employee
  #  And user is logged in with valid admin credentials  --> we remove this step we don't need it anymore, because we use Background keyWord
  #  When user clicks on PIM option  --> we remove this step we don't need it anymore, because we use Background keyWord
  #  And user clicks on Add Employee button  --> we remove this step we don't need it anymore, because we use Background keyWord
    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

    @1027
  Scenario: second scenario of adding the employee
  #  And user is logged in with valid admin credentials  --> we remove this step we don't need it anymore, because we use Background keyWord
  #  When user clicks on PIM option  --> we remove this step we don't need it anymore, because we use Background keyWord
  #  And user clicks on Add Employee button  --> we remove this step we don't need it anymore, because we use Background keyWord
    And user enters firstname middlename and lastname
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully

      @1027
  Scenario: third scenario of adding the employee
  #  And user is logged in with valid admin credentials  --> we remove this step we don't need it anymore, because we use Background keyWord
  #  When user clicks on PIM option  --> we remove this step we don't need it anymore, because we use Background keyWord
  #  And user clicks on Add Employee button  --> we remove this step we don't need it anymore, because we use Background keyWord
    And user enters firstname middlename and lastname
    When user selects checkbox
    When user enters username password and confirmpassword
    And user clicks on save button
    Then employee added successfully


        #learning how to use data driven test  -->
  @1028
  Scenario: adding an employee from feature file
    And user enters "Mike12" "lopez" and "Meme"
    And user clicks on save button
    Then employee added successfully

    @examples
    Scenario Outline: adding an employee from feature file
      And user enters "<firstName>" "<middleName>" and "<lastName>" for an employee
      And user clicks on save button
      Then employee added successfully
Examples:
      |firstName|middleName|lastName|
      |Mike123  |lopez     |Meme    |
      |Nallya321|meme      |Reston  |
      |Sule456  |meme      |Joya    |

      @datatable
      Scenario: adding an employee using data table
        When I add multiple employees and verify them that user has been aded successfully
          |firstName|middleName|lastName|
          |Mike123  |lopez     |Meme    |
          |Nallya321|meme      |Reston  |
          |Sule456  |meme      |Joya    |
          |Nallya3321|meme|Rerston|
          |Sule4567  |meme|Jjoya|

      @excel
      Scenario: Adding an employee from excel file
        When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employee

        @db @regression
        Scenario: Adding employee and validating in DataBase
          When user enters "Mike12" "Lopez" and "Meme"
          And captures employee id
          And user clicks on save button
          And employee added successfully
          Then query HRMS database
          And verify employee data is matched in ui and db