Feature: Feature to check Google search functionality

  Scenario: Validate the Google Search results for Maven Repo

    Given Open Google Search page
    When Enter details
    And Click on search icon
    Then validate the maven repo url
    And Close the driver instance
