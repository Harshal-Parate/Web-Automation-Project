Feature: Check Home page Functionality

  Background: User is logged in
    Given User is on a login page
    When enter username and a password
    And clicks on a login button
    Then user is navigated to a home page

  Scenario: Check logout link
    When User click on a welcome link
    Then Logout is displayed.

  Scenario: Verify the quick launch tool bar is present
    When User click on a dashboard link
    Then Quick launch a tool is displayed