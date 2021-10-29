package com.app.qa.tests;

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
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;

	public HomePageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void verifyUserNameTest(){
		
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=2)
	public void verifyUsersLinkTest(){
		
		usersPage = homePage.clickOnUsersLink();
	}
	
	@Test(priority=3)
	public void validateCreateNewTask(){
		homePage.clickOnaddTaskButton();
		homePage.createNewTask("Quality Check", "30000");
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
