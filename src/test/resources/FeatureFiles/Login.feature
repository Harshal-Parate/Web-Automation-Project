@SmokeFeature
Feature: Scenario for Login

  @SmokeTest
  Scenario: Valid Creds Login
    Given User on login page
    When User enters valid creds
    And Click on login button
    Then Moves to dashboard page