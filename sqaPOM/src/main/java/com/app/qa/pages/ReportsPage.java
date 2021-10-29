package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.qa.base.TestBase;

public class ReportsPage extends TestBase {
	
	

	@FindBy(xpath = "//*[contains(@class,'graphicButton button createNewReportButton')]")
	WebElement NewReportButton;
	
	@FindBy(xpath = "//*[contains(@class,'staffButton reportButton pressed')]")
	WebElement type;
	
	@FindBy(xpath = "//*[contains(@class,'configureButton components_button')]")
	WebElement configure;
	
	@FindBy(xpath = "//*[contains(@class,'innerLabel')]")
	WebElement report;
	
	@FindBy(xpath = "//*[contains(@class,'addToDashboardIcon')]")
	WebElement dashBoardLink;
	
	@FindBy(xpath = "//*[contains(@class,'reportNameEdit inputFieldWithPlaceholder')]")
	WebElement reportName;
	
	
	public ReportsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewReportLink(){
		
		NewReportButton.click();
		
	}
	
	public void createNewReport() {
		type.click();
		configure.click();
		report.click();
		//WebDriverWait wait = new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#topnav > tbody > tr.secondLevelRow > td.secondLevelCell.selectedColNum3.centered > div > a")));
		//WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td/div/table/tbody/tr/td[2]/div[1]")));
        //ele.click();
        //WebElement nameInpt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td/div/table/tbody/tr/td[2]/input")));
        //nameInpt.sendKeys(reportName);
        //WebElement btnSve = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td/div/table/tbody/tr/td[3]")));
        //btnSve.click(); 
		
		//verification
        
        //WebElement dash_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topnav\"]/tbody/tr[2]/td[2]/div/a")));
        //dash_ele.click();
        
        
	}
	
	

}
