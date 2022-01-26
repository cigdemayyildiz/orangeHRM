Feature: Testing OrangeHrm functionalities

  Scenario: Happy path add a new user
    Given I am on OrangeHrm home page
    When I click the Admin button
    When I should see System Users header
    Then I can add a new user

