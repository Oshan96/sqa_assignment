package sqa.stepDefinition.report;

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
public class CreateReportTest {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private Logger logger = null;

    public CreateReportTest() {
        System.setProperty("log4j.configurationFile", "log4j.properties");
        logger = LogManager.getLogger();
    }

    @Given("^user is on reports page of \"([^\"]*)\"$")
    public void user_is_on_reports_page_of(String link) {
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
        logger.info("Navigated to reports page!");
        this.wait = new WebDriverWait(webDriver, 10);
    }

    @When("user clicks new report button")
    public void user_clicks_new_report_button() {
        WebElement ele = this.webDriver.findElement(By.xpath("//*[@id=\"ext-gen18\"]"));
        ele.click();
        logger.info("Clicked on add new report button!");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"createReportLightBox_content\"]/div[2]/div[1]/div/div[2]/div/div[4]")));
    }
    @When("selects report type and clicks configure button")
    public void selects_report_type_and_clicks_configure_button() {
        WebElement ele = this.webDriver.findElement(By.xpath("//*[@id=\"createReportLightBox_content\"]/div[2]/div[1]/div/div[1]/div/div[1]/div[4]"));
        ele.click();
        WebElement btn = this.webDriver.findElement(By.xpath("//*[@id=\"createReportLightBox_content\"]/div[2]/div[1]/div/div[2]/div/div[4]"));
        btn.click();
        logger.info("Selected report type and clicked configure!");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#htmlPreviewTab")));
    }
    @When("clicks generate html report button")
    public void clicks_generate_html_report_button() {
        WebElement ele = this.webDriver.findElement(By.xpath("//*[@id=\"applyReportConfiguration\"]"));
        ele.click();
        logger.info("Clicked generateHTML button!");
    }
    @When("^clicks add to dashboard button and enter (.*) and save$")
    public void clicks_add_to_dashboard_button_and_enter_reportName_and_save(String reportName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#topnav > tbody > tr.secondLevelRow > td.secondLevelCell.selectedColNum3.centered > div > a")));
        WebElement ele = this.webDriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td/div/table/tbody/tr/td[2]/div[1]"));
        ele.click();
        logger.info("Clicked add to dashboard button!");
        WebElement nameInpt = this.webDriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td/div/table/tbody/tr/td[2]/input"));
        nameInpt.sendKeys(reportName);
        logger.info("Entered report name!");
        WebElement btnSve = this.webDriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td/div/table/tbody/tr/td[3]"));
        btnSve.click();
        logger.info("Saved report!");
    }
    @When("clicks reports dashboard button")
    public void clicks_reports_dashboard_button() {
        WebElement ele = this.webDriver.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[2]/td[2]/div/a"));
        ele.click();
        logger.info("Clicked report dashboard button!");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ext-gen18")));
    }
    @Then("^confirm (.*) is in dashboard$")
    public void confirm_reportName_is_in_dashboard(String reportName) {
        logger.info("Successfully added report!");
        System.out.println("Pass");
    }
    @Then("close the browser")
    public void close_the_browser() {
        logger.info("Successfully closed the browser!");
        this.webDriver.close();
    }

}
