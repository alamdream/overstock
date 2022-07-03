package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

import java.time.Duration;

public class Hooks {

    private static final By closePopUp = By.xpath("//button[@class='cl-dialog-close']");
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    public static WebDriver driver;

    @Before
    public void initialize(Scenario scenario){
        LOGGER.info("In @Before method");
        LOGGER.info(String.format("---------------Start Scenario: %s ---------------",scenario.getName()));
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterStep
    public void afterStep() throws InterruptedException {
        LOGGER.info("In @AfterStep method");
        Thread.sleep(5000);
        if (driver.findElements(closePopUp).size() > 0) {
            ActOn.element(driver, closePopUp).click();
            LOGGER.info("Closed pop-up window");
        }
    }

    @After("@other")
    public void cleanup(Scenario scenario){
        LOGGER.info("In @After method");
        DriverFactory.getInstance().removeDriver();
        LOGGER.info(String.format("---------------End Scenario: %s ---------------",scenario.getName()));
    }
}
