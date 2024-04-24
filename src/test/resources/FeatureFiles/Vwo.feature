@VwoLogin
Feature: Check the login functionality for VWO

  Scenario Outline: Verify the response when invalid username and password is passed

    Given User navigates to login page of VWO.
    When User enters invalid "<username>" and "<password>".
    And User click on login button.
    Then User should get error message.
    And Session closed

    Examples:
      | username | password |
      | A        | B        |