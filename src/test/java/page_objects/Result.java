package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class Result extends NavigationBar{
    private final By FilterPrice = By.xpath("//span[text()='Price']");
    private final By PriceOption = By.xpath("//input[@id='price-Under$50']");
    private final By FilterValidation = By.xpath("//span[text()='Under $50']");
    private final By ProductLink = By.xpath("//img[@alt='17.7\" Wide Cat Bed Soft Plush Hammock with Dangling Ball - Beige - N/A']");
    public Result(WebDriver driver){
        super(driver);
    }

    public Result clickOnPriceFilter(){
        ActOn.element(driver, FilterPrice).click();
        return this;
    }

    public Result selectPriceOption(){
        ActOn.element(driver, PriceOption).click();
        return this;
    }

    public Result validateFiltered(){
        AssertThat.elementAssertions(driver, FilterValidation).elementIsDisplayed();
        return this;
    }

    public Result clickOnProduct(){
        ActOn.element(driver, ProductLink).click();
        return this;
    }
}
