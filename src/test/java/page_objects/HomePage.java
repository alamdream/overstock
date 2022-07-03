package page_objects;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends NavigationBar{
    private final By SearchField = By.xpath("//input[@class='search_searchBar_de']");
    private final By SearchButton = By.xpath("//button[@class=\"search_button_00\"]");
    private String searchTerm;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage enterSearchTerm(String value){
        searchTerm = value;
        ActOn.element(driver, SearchField).setValue(value);
        return this;
    }

    public HomePage clickSearchButton(){
        ActOn.element(driver, SearchButton).click();
        return this;
    }
}
