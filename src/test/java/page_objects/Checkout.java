package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends NavigationBar{
    private final By LoginClose = By.xpath("//div[@class='login-layer-container-expanded']");
    private final By CheckoutTitle = By.xpath("//h1[text()='Checkout']");

    public Checkout(WebDriver driver) {
        super(driver);
    }

    public Checkout closeLoginFrame(){
        ActOn.element(driver,LoginClose).click();
        LOGGER.info("Closed Login Frame");
        return this;
    }

    public Checkout validateCheckoutPage(){
        AssertThat.elementAssertions(driver, CheckoutTitle).elementIsDisplayed();
        return this;
    }

}
