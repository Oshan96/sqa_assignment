package com.app.qa.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.UsersPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.app.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	Logger log = null;
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;

	public HomePageTest() {
		super();
		System.setProperty("log4j.configurationFile", "log4j.properties");
        log = LogManager.getLogger();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Browser launched");
		testUtil = new TestUtil();
		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void verifyUserNameTest(){
		
		Assert.assertTrue(homePage.verifyCorrectUserName());
		log.info("Correct username dispalyed");
	}
	
	@Test(priority=2)
	public void verifyUsersLinkTest(){
		
		usersPage = homePage.clickOnUsersLink();
		log.info("Users link verified");
		
	}
	
	@Test(priority=3)
	public void validateCreateNewTask(){
		homePage.clickOnaddTaskButton();
		homePage.createNewTask("Quality Check", "30000");
		log.info("New task created and vlidated");
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
