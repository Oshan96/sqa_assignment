package com.app.qa.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.qa.base.TestBase;
import com.app.qa.pages.UsersPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.app.qa.util.TestUtil;

public class UserPageTest extends TestBase {
	
	Logger log = null;
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;
	
	String sheetName = "User";
	
	   
	public UserPageTest(){
			super();
			System.setProperty("log4j.configurationFile", "log4j.properties");
	        log = LogManager.getLogger();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		log.info("Browser launched");
		testUtil = new TestUtil();
		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		
		usersPage = homePage.clickOnUsersLink();
	}
	
	@Test(priority=1)
	public void verifyworkLabel(){
		Assert.assertTrue(usersPage.verifyworkLabel(), "departments label is missing on the page");
		log.info("Work label verfied");
	}
	
	
	
	@DataProvider
	public Object[][] getUserTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getUserTestData")
	public void validateCreateNewUser(String firstName, String lastName, String email){
		usersPage.clickOnNewUserLink();
		usersPage.createNewUser(firstName, lastName, email);
		log.info("New user created and validated");
		
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
