package com.app.qa.tests;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	Logger log = null;
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super(); 
		System.setProperty("log4j.configurationFile", "log4j.properties");
        log = LogManager.getLogger();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization(); // defined in TestBase
		loginPage = new LoginPage();
		log.info("Browser launched");
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "actiTIME - Login");
		log.info("Title verified");
	}
	
	
	
	@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));  //defined inside config properties
		log.info("successful login tested");
	}
	
	@Test(priority=3)
	public void invalidUsernameTest(){
		loginPage.invalidLogin("abc",prop.getProperty("password"));  // invalid username valid password
		log.info("invalid login type 1 tested");
	}
	
	@Test(priority=4)
	public void invalidPasswordTest(){
		loginPage.invalidLogin(prop.getProperty("username"),"admin");  // invalid password valid password
		log.info("invalid login type 2 tested");
	}
	
	@Test(priority=5)
	public void invalidLoginTest(){
		loginPage.invalidLogin("abc","xyz");  // invalid username and invalid password
		log.info("invalid login type 3 tested");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
