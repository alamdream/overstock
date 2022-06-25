Feature: Test login functionalities

  Scenario: Check login is successful with valid credentials
    Given a user is on the login page
    When user enters valid username and password
    And click on login button
    Then user is navigated to home page"
#  Scenario: Check login is unsuccessful with invalid credentials
#    Given a user is on the login page
#    When user enters invalid username and password
#    And click on login button
#    Then error is shown as "There was an error, please try again."

#  Scenario: Check if Furniture link is working
#    Given a user is in the home page
#    When user clicks the Furniture link
#    Then user is navigated to Furniture page
#
#  Scenario: Check if Notifications Link is working
#    Given a user is in the home page
#    When user clicks the Notifications link
#    Then Notifications sliding window comes up
#
#  Scenario: Check search functionality is working
#    Given a user is in the home page
#    When user enters a product name into the search field
#    And click on search button
#    Then user is navigate to search results related to the product
#
#  Scenario: Check if Shop by Type option is working
#    Given a user is in the search result page
#    When user clicks on a Type category
#    Then user is navigated to that particular product list page
#
#  Scenario: Filter product by price
#    Given a user is in the search result page
#    When user chooses a price range from price filter list
#    Then user is presented with product within that price range

#  Scenario: Check if product link is working
#    Given a user is in the search result page
#    When user clicks on a product from the list
#    Then user is navigated to that product details page
#
#  Scenario: Check if product is added to cart successfully
#    Given a user is in the product details page
#    When user selects an option
#    And click on Add to Cart button
#    Then the product is added to the cart
#
#  Scenario: Update quantity in the cart
#    Given a user is in the Shopping Cart page
#    When user changes the quantity
#    Then the updated price is shown in the cart total
#
#  Scenario: Remove product from cart
#    Given a user is in the Shopping Cart page
#    When user clicks Remove
#    Then that product will be removed from cart
#
#
#
#
#
