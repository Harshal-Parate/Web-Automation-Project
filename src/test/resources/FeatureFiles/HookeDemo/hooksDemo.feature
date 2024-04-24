Feature: Check Login Functionality

  @Smoke
  Scenario:
    Given User is on login page
    When User enters valid username and password
    And clicks on login button
    Then Navigate to dashboard page

  Scenario:
    Given User is on login page
    When User enters valid username and password
    And clicks on login button
    Then Navigate to dashboard page
