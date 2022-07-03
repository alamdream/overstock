package page_objects;

import command_providers.AssertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResult extends NavigationBar{

    private String searchTerm;

    public SearchResult(WebDriver driver,String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    public SearchResult validateSearchResult(){
        By searchResultTitle = By.xpath("//h1[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+ searchTerm +"')]");
        AssertThat.elementAssertions(driver, searchResultTitle).elementIsDisplayed();
        return this;
    }



}
