package page_objects;

import command_providers.AssertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SunSails extends NavigationBar{

    private final By SunSailsTitle = By.xpath("//h1[text()='Sunsails']");

    public SunSails(WebDriver driver){
        super(driver);
    }

    public SunSails validateUserOnSunSailsPage(){
        AssertThat.elementAssertions(driver, SunSailsTitle).elementIsDisplayed();
        return this;
    }
}
