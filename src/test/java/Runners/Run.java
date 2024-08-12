package Runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "/Users/malik/eclipse-workspace/demo111/src/test/resources/Login.feature",
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class Run extends AbstractTestNGCucumberTests{
}
