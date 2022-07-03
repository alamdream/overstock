package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Cart;
import page_objects.Checkout;
import page_objects.ProductDetail;
import page_objects.Result;
import page_objects.*;

// Feature: Test full process - from search to check out
public class CheckoutSteps {

    private static Logger LOGGER = LogManager.getLogger(CheckoutSteps.class);
    WebDriver driver = Hooks.driver;

    // Scenario: Check if search functionality is working
    // Given a user is in the home page
    // When user enters "cat bed" into the search field
    // And click on search button
    // Then user is navigated to search result page related to "cat bed"
    // In SearchSteps.java

    // Scenario: Filter product by price

    @Given("^a user in the Cat Bed search result page$")
    public void staysInSearchResultPage(){
        LOGGER.info("User is in the Cat Bed search result page");
    }

    @When("^user selects \"Under 50\" under Price filter$")
    public void filterByPrice() throws InterruptedException {
       // new HomePage(driver).closePopUp();
        new Result(driver).clickOnPriceFilter();
        LOGGER.info("User selected 'Under $50' under Price filter");
    }

    @Then("^search result is filtered with products under 50")
    public void validateSearchResultIsFiltered(){
        new Result(driver).validateFiltered();
        LOGGER.info("Search result is filtered with products under $50");
    }

    // Scenario: Check if product link is working

    @When("^user clicks on a product from the list$")
    public void clickOnAProduct(){
        new Result(driver).clickOnProduct();
        LOGGER.info("User clicked on a product from the list");
    }

    @Then("^user is navigated to that product details page$")
    public void validateProductPage(){
        new ProductDetail(driver).validateUserOnProductPage();
        LOGGER.info("User is navigated to that product details page");
    }

    // Scenario: Check if product is added to cart successfully

    @Given("^a user is in the product details page$")
    public void stayInProductPage(){
        LOGGER.info("User is in the product details page");
    }

    @When("^user clicks on Add to Cart button$")
    public void clickAddToCart(){
        new ProductDetail(driver).addProductToCart();
        LOGGER.info("User clicked on Add to Cart button");
    }

    @Then("^the product is added to the cart$")
    public void validateProductIsAddedToCart(){
        new Cart(driver).validateProductAddedToCart();
        LOGGER.info("The product is added to the cart");
    }

    // Scenario: Update quantity in the cart
    @Given("^a user is in the Shopping Cart page$")
    public void stayInShoppingCartPage(){
        LOGGER.info("User is in the Shopping Cart page");
    }

    @When("^user changes the quantity$")
    public void updateQuantityInCart(){
        String newQuantity = "3";
        new Cart(driver)
                .clickOnQuantity()
                .chooseQuantity(newQuantity);
        LOGGER.info("User changed the quantity to " + newQuantity);
    }

    @Then("^the updated price is shown in the cart total$")
    public void validateCartPriceIsUpdated(){
        new Cart(driver).validateSubtotalIsUpdated("3");
        LOGGER.info("The updated price is shown in the cart total");
    }

    // Scenario: Check if checkout button is working

    @When("^user clicks \"Check Out\"$")
    public void clickOnCheckOut(){
        new Cart(driver).clickCheckOut();
        LOGGER.info("User clicked Check Out");
    }

    @Then("^user is navigated to Checkout page$")
    public void validateUserOnCheckoutPage(){
        new Checkout(driver)
                .closeLoginFrame()
                .validateCheckoutPage();
        LOGGER.info("User is navigated to Checkout page");
    }

}
