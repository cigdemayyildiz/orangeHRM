Feature: Testing OrangeHrm functionalities
  Scenario: Happy path OrangeHrm login functionality
    Given I am on OrangeHrm login page
    When I fill up all info for login
    Then I see dashboard page