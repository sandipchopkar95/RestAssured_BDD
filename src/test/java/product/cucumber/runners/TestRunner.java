package product.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"product.cucumber.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@APIChaining",
        monochrome = true

)
public class TestRunner {
}
