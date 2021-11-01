package sqa.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author oshan
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/testResources/features/login",
        glue = "sqa/stepDefinition/login",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/loginReport.html",
                "json:target/cucumber-reports/json/login.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class LoginRunner {
}
