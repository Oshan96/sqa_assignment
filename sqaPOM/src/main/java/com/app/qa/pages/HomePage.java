package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.app.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//a[contains(@class,'userProfileLink username')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(@class,'content users')]")
	WebElement usersLink;
	
	@FindBy(id = "addTaskButtonId")
	WebElement addTaskButton;
	

	@FindBy(xpath = "//a[contains(@class,'content report')]")
	WebElement reportsLink;
	
	@FindBy(xpath = "//*[contains(@class,'emptySelection')]")
	WebElement customerBox;

	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public UsersPage clickOnUsersLink(){
		usersLink.click();
		return new UsersPage();
	}
	
	public ReportsPage clickOnReportsLink(){
		reportsLink.click();
		return new ReportsPage();
	}
	
	//public TasksPage clickOnTasksLink(){
		//tasksLink.click();
		//return new TasksPage();
	//}
	
	public void clickOnaddTaskButton(){
		
		addTaskButton.click();
		
	}
	
	public void createNewTask(String taskName, String estimate){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		WebElement custDrop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div")));
        custDrop.click();
        WebElement cust = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[2]/div/div[1]/div/div[3]")));
        cust.click();
        WebElement prjDrop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[3]/td[1]/div/div")));
        prjDrop.click();
        WebElement prj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[3]/td[1]/div/div/div[2]/div/div[1]/div/div[4]")));
        prj.click();
        
        WebElement task = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[1]/input")));
        task.sendKeys(taskName);

        WebElement est = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[3]/input")));
        est.sendKeys(estimate);
		//customerBox.sendKeys(customer);
		//lastName.sendKeys(ltName);
		//Email.sendKeys(email);
		//saveBtn.click();
		
	}
	
	public void clickOnNewTaskLink(){
		Actions action = new Actions(driver);
		action.moveToElement(addTaskButton).build().perform();
		addTaskButton.click();
		
	}

}
