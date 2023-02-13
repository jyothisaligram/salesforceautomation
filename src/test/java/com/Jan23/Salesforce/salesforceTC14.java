//Create account report
package com.Jan23.Salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class salesforceTC14 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		loginToSalesforce();
		SwitchtoaccountsTab();
	}

	public static void loginToSalesforce() throws InterruptedException {

		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(5000);
		
		By idLoc = By.id("username");
		WebElement username = driver.findElement(idLoc);
		enterText(username, "jan23.jyothi@ta.com", "usernameEle");
	    Thread.sleep(2000); 
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		
		password.sendKeys("lavakusha12");
		Thread.sleep(2000);
		
		 WebElement buttonclick = driver.findElement(By.id("Login"));
		 String name = "buttonElement";
		 clickonme(buttonclick,name);
		
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		System.out.println("Page Title = "+actualTitle);
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		System.out.println("User is on home page");
		}
		else {
			System.out.println("home page is not Lunched");
		}	
	
	}

public static void SwitchtoaccountsTab() throws InterruptedException, AWTException {
		//a[text()='Accounts']
  WebElement accountsTab = driver.findElement(By.xpath("//a[text()='Accounts']"));
  Actions action = new Actions(driver);
  action.build().perform();
  waitforVisibilty(500, accountsTab);
  accountsTab.click();
  Thread.sleep(4000);
  WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
  popupwindow.click();
  
    Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ESCAPE);
	r.keyRelease(KeyEvent.VK_ESCAPE);

	WebElement LastActivity = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
    LastActivity.click();
	
	WebElement  dropdown = driver.findElement(By.xpath("//img[@id='ext-gen148']"));
	dropdown.click();
	
	WebElement createddate = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
	createddate.click();
	
	WebElement startdate =  driver.findElement(By.name("startDate"));
	startdate.clear();
	startdate.sendKeys("01/04/2019");
	
	WebElement enddate = driver.findElement(By.name("endDate"));
	enddate.clear();
	enddate.sendKeys("03/04/2019");
	
	WebElement save = driver.findElement(By.xpath("//button[@id='ext-gen49']"));
	save.click();
	WebElement Reportnames =  driver.findElement(By.name("reportName"));
	Reportnames.clear();
	Reportnames.sendKeys("Accountreports");
	
	WebElement ReportUniName =  driver.findElement(By.id("saveReportDlg_DeveloperName"));
	ReportUniName.clear();
	ReportUniName.sendKeys("Accountreports");
	Thread.sleep(4000);
  
	WebElement Saveandrun = driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']"));
	Saveandrun.click();
	//driver.close();
	System.out.println("TC_14_Createaccountreport is completed");
 }

}
	
	
	
	
	
	
	
	
	
	
	

