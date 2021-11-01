package sqa.stepDefinition.user;

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
public class CreateUserTest {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private Logger logger = null;

    public CreateUserTest() {
        System.setProperty("log4j.configurationFile", "log4j.properties");
        logger = LogManager.getLogger();
    }

    @Given("^user is on userList page of \"([^\"]*)\"$")
    public void user_is_on_userList_page_of(String link) {
        logger.debug(link);
        this.webDriver = new ChromeDriver();

        this.webDriver.get("https://demo.actitime.com/login.do");
        this.wait = new WebDriverWait(webDriver, 5);

        WebElement username = this.webDriver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement pass = this.webDriver.findElement(By.xpath("//*[@id=\"loginFormContainer\"]/tbody/tr[1]/td/table/tbody/tr[2]/td/input"));
        WebElement submitBtn = this.webDriver.findElement(By.xpath("//*[@id=\"loginButton\"]"));

        username.sendKeys("admin");
        pass.sendKeys("manager");

        submitBtn.click();
        logger.info("Successfully logged!");

        this.webDriver.get(link);
        logger.info("Navigated to userList page!");
        this.wait = new WebDriverWait(webDriver, 10);

    }

    @When("^user clicks new user button$")
    public void user_clicks_new_user_button() {
        WebElement ele = this.webDriver.findElement(By.xpath("//*[@id=\"pageBody\"]/tbody/tr[1]/td[3]/div/div[3]"));
        ele.click();
        logger.info("User clicked add new user button!");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"createUserPanel_firstNameField\"]")));
    }

    @And("^enters (.*), (.*) and (.*)$")
    public void enters_fname_lname_and_email(String fname, String lname, String email) {
        System.out.println(String.format("%s %s %s", fname, lname, email));
        WebElement fNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel_firstNameField\"]")));
        WebElement lNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel_lastNameField\"]")));
        WebElement emailEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel_emailField\"]")));
        System.out.println(fNameEle);
        fNameEle.sendKeys(fname);
        lNameEle.sendKeys(lname);
        emailEle.sendKeys(email);
        logger.info("User details filled!");
    }

    @And("selects department")
    public void selects_department() {
        WebElement deptDrop = this.webDriver.findElement(By.xpath("//*[@id=\"createUserPanel_accountInformationSection\"]/div/div[3]/div[2]/div/div[2]/div/div[1]"));
        deptDrop.click();

        WebElement deptItem = this.webDriver.findElement(By.xpath("//*[@id=\"createUserPanel_accountInformationSection\"]/div/div[3]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[3]"));
        deptItem.click();
        logger.info("Selected department!");
    }

    @Then("clicks save and send invitation button")
    public void clicks_save_and_send_invitation_button() {
        WebElement submitBtn = this.webDriver.findElement(By.xpath("//*[@id=\"createUserPanel\"]/div[3]/div/div[3]/div[1]"));
        submitBtn.click();
        logger.info("Successfully created new user!");
    }

    @Then("close the browser")
    public void close_the_browser() {
        this.webDriver.close();
        logger.info("Successfully closed the browser!");
    }
}
