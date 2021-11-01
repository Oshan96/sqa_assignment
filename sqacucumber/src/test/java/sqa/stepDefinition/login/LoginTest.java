package sqa.stepDefinition.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author oshan
 */
public class LoginTest {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private Logger logger = null;

    public LoginTest() {
        System.setProperty("log4j.configurationFile", "log4j.properties");
        logger = LogManager.getLogger();
    }

    @Given("^user is on login page of \"([^\"]*)\"$")
    public void user_is_on_login_page_of(String link) {
        logger.debug(link);
        this.webDriver = new ChromeDriver();

        this.webDriver.get("https://demo.actitime.com/login.do");
        logger.info("Navigated to login page!");
        this.wait = new WebDriverWait(webDriver, 5);
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        WebElement userEle = this.webDriver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement pass = this.webDriver.findElement(By.xpath("//*[@id=\"loginFormContainer\"]/tbody/tr[1]/td/table/tbody/tr[2]/td/input"));

        userEle.sendKeys(username);
        pass.sendKeys(password);
        logger.info("Filled login details!");
    }

    @And("clicks login button")
    public void clicks_login_button() {
        WebElement submitBtn = this.webDriver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
        submitBtn.click();
        logger.info("Clicked login button!");
    }

    @Then("close the browser")
    public void close_the_browser() {
        logger.info("Successfully logged!");
        logger.info("Successfully closed the browser!");
        this.webDriver.close();
    }
}
