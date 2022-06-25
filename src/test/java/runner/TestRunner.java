package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/login.feature",
        glue = {"step_definitions"},
        plugin = {"pretty","summary", "html:target/CucumberReports/reports.html"}
)
public class TestRunner {

}