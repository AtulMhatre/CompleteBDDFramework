package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import qa.DriverFactory;

public class LoginStepdef {
    LoginPage lp = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }

    @Given("User enter valid Username and Password")
    public void user_enter_valid_username_and_password() {
        lp.enterEmail("tlmhatre@gmail.com");
        lp.enterPassword("Atul@1996");
    }

    @Given("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String Username, String Password) {
        lp.enterEmail(Username);
        lp.enterPassword(Password);
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        lp.clickonLoginButton();
    }


    @Then("User Should be on registarion page")
    public void user_should_be_on_registarion_page() {
        String titleofPage = lp.registraionPage();
        boolean isPresent = titleofPage.contains("My Account");
        //Assert.assertTrue(isPresent);
        Assert.assertTrue(isPresent,
                " Page title mismatch! Expected title to contain 'My Account' but got: " + titleofPage);
    }


    @Then("user should see error msg {string}")
    public void user_should_see_error_msg(String string) {
        boolean errormsgisdisplyed = lp.errormessagecheck();
        Assert.assertEquals(errormsgisdisplyed, true, "error msg is displayed");

    }


}
