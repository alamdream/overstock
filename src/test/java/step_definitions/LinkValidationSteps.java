package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkValidationSteps {
    private static final By furnitureTitle = By.xpath("//h1[contains(text(),'Furniture')]");
    private static final By furnitureLink = By.linkText("Furniture");
    private static final By closePopUp = By.className("cl-dialog-close");
    private static final By notificationsLink = By.name("Notifications");
    private static final By notifications = By.xpath("//span[@class='notificationCenter_headerTitle_39']");
    private static final By searchInput = By.xpath("//input[@class=\"search_searchBar_de\"]");
    private static final By searchButton = By.xpath("//button[@class=\"search_button_00\"]");
    private static final By searchResult = By.xpath("//h1[text()=\"Sofas & Couches\"]");
    private static final By clickCategory = By.xpath("//a[@href='/Home-Garden/Sofas-Couches/Sofa,/type,/2027/subcat.html']/span[contains(text(),'Sofas')]");
    private static final By sofaType = By.xpath("//h1[contains(text(),'Sofa Sofas & Couches')]");
    private static Logger LOGGER = LogManager.getLogger(LinkValidationSteps.class);
    WebDriver driver;

    //Check if Furniture link is working
    // Precondition
    @Given("^a user is in the home page$")
    public void navigateToHomePage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //delete all cookies
        Thread.sleep(7000);
        ActOn.browser(driver).openBrowser("https://www.overstock.com/");
        Thread.sleep(5000);

        if (driver.findElement(closePopUp).isDisplayed()) {
            LOGGER.info("Closing pop-up window");
            ActOn.element(driver, closePopUp).click();
        }

        LOGGER.info("User is in the Home Page");

    }

    // Main Action
    @When("^user clicks the Furniture link$")
    public void clickFurnitureLink() {
        ActOn.element(driver, furnitureLink).click();
        LOGGER.info("User clicked the Furniture link");

    }

    // Assertion
    @Then("^user is navigated to Furniture page$")
    public void validateUserIsInFurniturePage() {
        AssertThat.elementAssertions(driver, furnitureTitle).elementIsDisplayed();
        LOGGER.info("User is navigated to Furniture page");
        driver.quit();
    }
    //Check if Notifications Link is working

    @When("^user clicks the Notifications link$")
    public void clickNotificationsLink() {
        ActOn.element(driver, notificationsLink).click();
        LOGGER.info("User clicks the Notifications link");
    }

    @Then("^Notifications sliding window comes up$")
    public void validateNotificationsWindow() {
        AssertThat.elementAssertions(driver, notifications).elementIsDisplayed();
        LOGGER.info("Notifications sliding window comes up");
        driver.quit();
    }

    //Check search functionality is working
    @When("^user enters a product name into the search field$")
    public void enterProductNameSearchField() {
        ActOn.element(driver, searchInput).setValue("sofa");
        LOGGER.info("user enters a product name into the search field");

    }

    @And("^click on search button$")
    public void clickSearchButton() {
        ActOn.element(driver, searchButton).click();
        LOGGER.info("Click on search button");
    }

    @Then("^user is navigate to search results related to the product$")
    public void validateSearchResult() {
        AssertThat.elementAssertions(driver, searchResult).elementIsDisplayed();
        LOGGER.info("User is navigate to search results related to the product");

    }
    //Check if Shop by Type option is working
    @Given("^a user is in the search result page$")
    public void searchPage () {
        LOGGER.info("A user is in the search result page");
    }
    @When("^user clicks on a Type category$")
    public void clickCategory() {
        ActOn.element(driver, clickCategory).click();
        LOGGER.info("user clicks on a Type category");
    }
    @Then("^user is navigated to that particular product list page$")
    public void validateClickResult() {
        AssertThat.elementAssertions(driver, sofaType).elementIsDisplayed();
        LOGGER.info("User is navigated to that particular product list page");
        driver.quit();
    }







}