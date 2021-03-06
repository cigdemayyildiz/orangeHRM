Feature: Testing OrangeHrm functionalities

  @login
  Scenario: Happy path OrangeHrm login functionality
    Given I am on OrangeHrm login page
    When I fill up all info for login
    Then I see dashboard page

  @login
  Scenario: Login with invalid credentials
    Given I am on OrangeHrm login page
    When I fill up all info with invalid credentials
    Then I see error message

