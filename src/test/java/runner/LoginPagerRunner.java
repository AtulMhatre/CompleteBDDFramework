package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs", "hooks"},

        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber-reports.json"},
        tags = "@Sanity",
        monochrome = true,
        publish = true,
        dryRun = false

)
public class LoginPagerRunner extends AbstractTestNGCucumberTests {


}
