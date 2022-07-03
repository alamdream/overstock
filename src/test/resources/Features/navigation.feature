@other
Feature: Test Navigation functionality

  Scenario: Check if Notifications link is working
    Given a user is in the home page
    When user clicks the Notifications link
    Then Notifications sliding window comes up

  @sunsails
  Scenario: Check if Sunsails link is working
    Given a user is in the home page
    When user hovers on Outdoor
    And clicks on Sunsails
    Then user is navigated to Sunsails page


  Scenario: Check if Cart link is working
    Given a user is in the home page
    When user clicks on the cart link
    Then user is navigated to Shopping Cart page