package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailText;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordText;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMeesage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterEmail(String email) {
        emailText.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordText.sendKeys(password);
    }

    public void clickonLoginButton() {
        loginButton.click();

    }

    public String registraionPage() {
        String titleofPage = driver.getTitle();
        return titleofPage;
    }

    public boolean errormessagecheck() {
        boolean displayed = wait.until(ExpectedConditions.visibilityOf(errorMeesage)).isDisplayed();

        return displayed;
    }
}