package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;
import page_objects.SearchResult;
import utilities.ReadConfigFiles;

import java.util.List;

public class SearchSteps {
    private static Logger LOGGER = LogManager.getLogger(SearchSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^a user is in the home page$")
    public void navigateToMyHomePage() throws InterruptedException {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("OverstockURL"));
        LOGGER.info("User is in the home page");
    }

    @When("^user enters \"(.+?)\" into the search field$")
    public void enterProductNameInSearchField(String value) {
        new HomePage(driver).enterSearchTerm(value);
        LOGGER.info("User entered " + value + " into the search field");
    }

    @And("^click on search button$")
    public void clickSearchButton() {
        new HomePage(driver).clickSearchButton();
        LOGGER.info("User clicked on search button");
    }

    @Then("^user is navigated to search result page related to \"(.+?)\"$")
    public void validateSearchResult(String value) {
        new SearchResult(driver, value).validateSearchResult();
        LOGGER.info("User is navigated to search result page related to " + value);
    }

    @When("^user enters \"<product>\" into the search field$")
    public void enterProductNameInSearchFieldFromList(DataTable dataTable){
        List<String> dataList = dataTable.asList(String.class);
        for(String data : dataList){
            new HomePage(driver).enterSearchTerm(data);
            LOGGER.info("User entered " + data + " into the search field");
        }
    }

    @Then("^user is navigated to search result page related to \"<product>\"$")
    public void validateSearchResult(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        for(String data : dataList){
            new SearchResult(driver, data).validateSearchResult();
            LOGGER.info("User is navigated to search result page related to " + data);
        }
    }
}
