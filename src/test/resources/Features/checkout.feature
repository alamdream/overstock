Feature: Test full process - from search to check out

  Scenario: Check if search functionality is working
    Given a user is in the home page
    When user enters "cat bed" into the search field
    And click on search button
    Then user is navigated to search result page related to "cat bed"

  Scenario: Filter product by price
    Given a user in the Cat Bed search result page
    When user selects "Under 50" under Price filter
    Then search result is filtered with products under 50

  Scenario: Check if product link is working
    Given a user in the Cat Bed search result page
    When user clicks on a product from the list
    Then user is navigated to that product details page

  Scenario: Check if product is added to cart successfully
    Given a user is in the product details page
    When user clicks on Add to Cart button
    Then the product is added to the cart

  Scenario: Update quantity in the cart
    Given a user is in the Shopping Cart page
    When user changes the quantity
    Then the updated price is shown in the cart total

  @other
  Scenario: Check if checkout button is working
    Given a user is in the Shopping Cart page
    When user clicks "Check Out"
    Then user is navigated to Checkout page

