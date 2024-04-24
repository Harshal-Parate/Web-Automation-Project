@parameters
Feature: Test Login Page

  Scenario Outline: Test if the user is able to login or not with valid creds
    Given User navigates to login page
    When User enters valid "<username>" and "<password>" creds
    And User click on login button
    Then Enters inside
    And Quit driver

    Examples:
      | username | password    |
      | student  | Password123 |