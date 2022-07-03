package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetail extends NavigationBar{
    private final By ProductTitle = By.xpath("//h1[text()='17.7\" Wide Cat Bed Soft Plush Hammock with Dangling Ball - Beige - N/A']");
    private final By AddToCartButton = By.xpath("//button[@data-testid='add-to-cart-button']");

    public ProductDetail(WebDriver driver){
        super(driver);
    }

    public ProductDetail validateUserOnProductPage(){
        for(String newWindow: driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        AssertThat.elementAssertions(driver, ProductTitle).elementIsDisplayed();
        return this;
    }

    public ProductDetail addProductToCart(){
        ActOn.element(driver, AddToCartButton).click();
        return this;
    }
}
