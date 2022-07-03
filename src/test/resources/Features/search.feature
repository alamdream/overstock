@other
Feature: Test search functionality

  @search
  Scenario: Check search functionality is working
    Given a user is in the home page
    When user enters "sofa" into the search field
    And click on search button
    Then user is navigated to search result page related to "sofa"

  Scenario Outline: Check search functionality is working for multiple products
    Given a user is in the home page
    When user enters "<product>" into the search field
    And click on search button
    Then user is navigated to search result page related to "<product>"

    Examples:
    | product    |
    | carpet     |
    | trampoline |
    | oven       |