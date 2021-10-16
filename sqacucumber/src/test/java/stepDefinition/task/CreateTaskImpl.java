package stepDefinition.task;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author oshan
 */
public class CreateTaskImpl {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @Given("^user is on taskList page of \"([^\"]*)\"$")
    public void user_is_on_taskList_page_of(String link) {
        System.out.println(link);
        this.webDriver = new ChromeDriver();

        this.webDriver.get("https://demo.actitime.com/login.do");
        this.wait = new WebDriverWait(webDriver, 5);

        WebElement username = this.webDriver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement pass = this.webDriver.findElement(By.xpath("//*[@id=\"loginFormContainer\"]/tbody/tr[1]/td/table/tbody/tr[2]/td/input"));
        WebElement submitBtn = this.webDriver.findElement(By.xpath("//*[@id=\"loginButton\"]"));

        username.sendKeys("admin");
        pass.sendKeys("manager");

        submitBtn.click();

        this.webDriver.get(link);
        this.wait = new WebDriverWait(webDriver, 10);
    }

    @When("^user clicks add new button and selects New Task$")
    public void user_clicks_add_new_button() {
        WebElement ele = this.webDriver.findElement(By.xpath("//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[1]/div[1]/div[3]/div"));
        ele.click();
        WebElement opt = this.webDriver.findElement(By.xpath("/html/body/div[19]/div[3]"));
        opt.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div")));
    }

    @And("^selects customer and project from dropdown lists$")
    public void selects_customer_and_project() {
        WebElement custDrop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div")));
        custDrop.click();
        WebElement cust = this.webDriver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[2]/div/div[1]/div/div[3]"));
        cust.click();
        WebElement prjDrop = this.webDriver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[3]/td[1]/div/div"));
        prjDrop.click();
        WebElement prj = this.webDriver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[3]/td[1]/div/div/div[2]/div/div[1]/div/div[4]"));
        prj.click();
    }

    @And("enters (.*) and (.*)$")
    public void enters_taskName_and_est(String taskName, String est) {
        WebElement task = this.webDriver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[1]/input"));
        task.sendKeys(taskName);

        WebElement estTime = this.webDriver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[3]/input"));
        estTime.sendKeys(est);
    }

    @Then("clicks create tasks button")
    public void clicks_create_task_button() {
        WebElement submitBtn = this.webDriver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[2]/div[2]/div[1]/div"));
        submitBtn.click();
    }

    @Then("close the browser")
    public void close_the_browser() {
        this.webDriver.close();
    }
}
