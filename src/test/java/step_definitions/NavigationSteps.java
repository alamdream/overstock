package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Cart;
import page_objects.NavigationBar;
import page_objects.Notification;
import page_objects.SunSails;

//Feature: Test Navigation functionality
public class NavigationSteps {

    private static Logger LOGGER = LogManager.getLogger(NavigationSteps.class);
    WebDriver driver = Hooks.driver;

    // Scenario: Check if Notifications link is working

    // @Given a user is in the home page
    // In SearchSteps.java

    @When("^user clicks the Notifications link$")
    public void clickNotifications(){
        new NavigationBar(driver).openNotifications();
        LOGGER.info("User clicked the Notifications link");
    }

    @Then("^Notifications sliding window comes up$")
    public void validateNotificationWindow(){
        new Notification(driver).validateUserOnNotificationPage();
        LOGGER.info("Notifications sliding window came up");
    }

    // Scenario: Check if Sunsails link is working

    // @Given a user is in the home page
    // In SearchSteps.java

    @When("^user hovers on Outdoor$")
    public void hoverOnOutdoor(){
        new NavigationBar(driver).mouseHoverToOutdoor();
        LOGGER.info("User hovered on Outdoor");
    }
    @And("^clicks on Sunsails$")
    public void clickOnSunsails(){
        new NavigationBar(driver).navigateToSunSails();
        LOGGER.info("User clicked on Sunsails");
    }

    @Then("^user is navigated to Sunsails page$")
    public void validateSunsailsPage(){
        new SunSails(driver).validateUserOnSunSailsPage();
    }

    // Scenario: Check if Cart link is working
    // @Given a user is in the home page
    // In SearchSteps.java

    @When("^user clicks on the cart link$")
    public void clickCarts() throws InterruptedException {
        new NavigationBar(driver).navigateToCart();
        LOGGER.info("User clicked on the cart link");
    }

    @Then("^user is navigated to Shopping Cart page$")
    public void validateShoppingCart(){
        new Cart(driver).validateUserOnCartPage();
        LOGGER.info("User is navigated to Shopping Cart page");
    }
}
