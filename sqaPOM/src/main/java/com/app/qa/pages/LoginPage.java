package com.app.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.TestBase;


public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="pwd")
	WebElement password;
	
	@FindBy(id="loginButton")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[contains(@class,'errormsg')]")
	WebElement errorMessage;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		    	
		    	
		return new HomePage();
	}
	
	public boolean invalidLogin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return errorMessage.isDisplayed();
		
	}
	
	

}
