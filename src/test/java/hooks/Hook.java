package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import qa.DriverFactory;
import utilty.PropReader;

import java.io.IOException;

public class Hook {

    WebDriver driver;

    @Before
    public void launchBrowser() throws IOException {

        DriverFactory df = new DriverFactory();

        String browserValue = PropReader.readPropData("browser");
        String commandPromtbrowserName = System.getProperty("cliBrowser");
        if (commandPromtbrowserName != null) {
            browserValue = commandPromtbrowserName;
        }
        driver = df.initBrowser(browserValue);

        driver.manage().window().maximize();

    }

    @After(order = 1)
    public void tearDown() {

        driver.quit();
    }

    @After(order = 2)

    public void failedTestCaseScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failedScreenShot");
        }
    }

}
