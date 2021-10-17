package sqa.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author oshan
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/testResources/features/task",
        glue = "sqa/stepDefinition/task",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/createTaskReport.html",
                "json:target/cucumber-reports/json/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class CreateTaskRunner {
}
