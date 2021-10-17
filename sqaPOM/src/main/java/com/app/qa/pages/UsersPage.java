package com.app.qa.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.qa.base.TestBase;

public class UsersPage extends TestBase{
	
	
	
	@FindBy(xpath = "//th[contains(@class,'userName firstLayer')]")
	WebElement workLabel;
	
	@FindBy(xpath = "//*[contains(@class,'components_button withPlusIcon')]")
	WebElement newUserLink;
	
	@FindBy(xpath = "//input[contains(@class,'firstNameField inputFieldWithPlaceholder')]")
	WebElement firstName;
	
	@FindBy(name = "lastName")
	WebElement lastName;
	
	@FindBy(name = "email")
	WebElement Email;
	
	@FindBy(name = "Save & Send Invitation")
	WebElement saveBtn;
	
	@FindBy(xpath = "//*[contains(@class,'title')]")
	WebElement department;
	
	@FindBy(xpath = "//*[contains(@text,'Production')]")
	WebElement prod;
	
	
	// Initializing the Page Objects:
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyworkLabel(){
		return workLabel.isDisplayed();
	}
	
	
	public void clickOnNewUserLink(){
	
		newUserLink.click();
		
	}
	
	
	
	public void createNewUser(String ftName, String ltName, String email){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement fNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel_firstNameField\"]")));
		fNameEle.sendKeys(ftName);
		WebElement lNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel_lastNameField\"]")));
		lNameEle.sendKeys(ltName);
        WebElement emailEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel_emailField\"]")));
        emailEle.sendKeys(email);
        
        WebElement deptDrop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel_accountInformationSection\"]/div/div[3]/div[2]/div/div[2]/div/div[1]")));
        deptDrop.click();
        
        WebElement deptItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel_accountInformationSection\"]/div/div[3]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[3]")));
        deptItem.click();
        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createUserPanel\"]/div[3]/div/div[3]/div[1]")));
        save.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'firstNameField inputFieldWithPlaceholder')]")));
		
		
		//WebDriverWait wait = new WebDriverWait(driver, 50);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'title')]")));
		//driver.findElement(By.xpath("//*[contains(@class,'title')]")).click();
		//department.click();
		//prod.click();
		//saveBtn.click();
		
		
	}
	
	

}
