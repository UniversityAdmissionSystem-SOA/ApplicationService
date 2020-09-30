Feature: Add Application

  Scenario: Unsuccesful Addition with empty name
    Given user enter home page
    When user enter no name
    Then user will get error message to fill in all fields

  