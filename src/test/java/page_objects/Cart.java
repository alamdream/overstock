package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends NavigationBar{
    private final By CartPage =By.xpath("//h1[text()='Shopping Cart']");
    private final By ProductValidation = By.xpath("//div[@data-cy='cart-item-title']/a[text()='17.7\" Wide Cat Bed Soft Plush  Hammock with Dangling Ball - Beige - N/A']");
    private final By QuantityDropdown = By.xpath("//select[@id='qty-select-69561084']");
    private final By CheckoutButton = By.xpath("//a[@data-cy=\"totals-checkout-button-desktop\"]");

    public Cart(WebDriver driver) {
        super(driver);
    }

    public Cart validateUserOnCartPage(){
        AssertThat.elementAssertions(driver, CartPage).elementIsDisplayed();
        return this;
    }

    public Cart validateProductAddedToCart(){
        AssertThat.elementAssertions(driver, ProductValidation).elementIsDisplayed();
        return this;
    }

    public Cart clickOnQuantity(){
        ActOn.element(driver, QuantityDropdown).click();
        return this;
    }

    public Cart chooseQuantity(String quantityValue){
        ActOn.element(driver, QuantityDropdown).selectValue(quantityValue);
        return this;
    }

    public Cart validateSubtotalIsUpdated(String quantityValue){
        String total = String.valueOf(44.99 * Integer.valueOf(quantityValue));
        By SubTotal = By.xpath("//div[@id='scrollingContainer']//span[@data-cy=\"subtotal-totals-line-item\"][text()='$"+ total + "']");
        AssertThat.elementAssertions(driver, SubTotal).elementIsDisplayed();
        LOGGER.info("New subtotal is " + total);
        return this;
    }

    public Cart clickCheckOut(){
        ActOn.element(driver, CheckoutButton).click();
        return this;
    }
}
