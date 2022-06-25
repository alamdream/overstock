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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class LoginSteps {
    private static final By account = By.name("Account");
    private static final By closePopUp = By.className("cl-dialog-close");
    private static final By signIn = By.xpath("//header/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/a[1]/div[1]");
    private static final By email = By.id("login-email");
    private static final By password = By.id("login-password");
    private static final By signInButton = By.xpath("//body/div[@id='js-login-app']/main[1]/div[1]/div[1]/section[2]/form[1]/button[1]");
    private static final By error = By.xpath("//*[@class='os-alert-cl-wrapper.error.lg.ew']/span");
    private static Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver;

    // Precondition
    @Given("^a user is on the login page$")
    public void navigateToLoginPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        ActOn.browser(driver).openBrowser("https://www.overstock.com/");
        Thread.sleep(5000);
        ActOn.element(driver, closePopUp).click();
        ActOn.element(driver,account).click();
       // ActOn.element(driver,signIn).click();
        LOGGER.info("User is in the Login Page");


    }

    // Main Action
    @When("^user enters valid username and password$")
    public void enterUserCredentials(){
        driver.switchTo().frame("loginIframe");
        ActOn.element(driver,email).setValue("onindita@icloud.com");
        ActOn.element(driver,password).setValue("alam12345");
        LOGGER.info("User has entered valid credentials");
    }

    // Additional Action
    @And("^click on login button$")
    public void clickOnLogin(){
        ActOn.element(driver,signInButton).click();
        LOGGER.info("User clicked on Login Button");
    }

    // Assertion
    @Then("^error is shown as \"There was an error, please try again.\"$")
    public void validateUserIsLoggedInSuccessfully(){
        String errorMsg = driver.findElement(error).getAttribute("innerHTML");
        System.out.println("################# " + errorMsg + " #####################");
        AssertThat.elementAssertions(driver,error).elementIsDisplayed();
        LOGGER.info("Error message shown as \"There was an error, please try again.\"");
    }
}