package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = {"step_definitions"},
        plugin = {"pretty","summary", "me.jvt.cucumber.report.PrettyReports:target/cucumber-html-reports"},
        tags = "@sunsails"
)
public class TestRunner {

}
