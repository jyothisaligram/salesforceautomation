//Create an Account

package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC10 extends SFBaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		loginToSalesforce();
		SwitchtoaccountsTab();
		createNewAccount();
		driver.close();	
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
public static void SwitchtoaccountsTab() throws InterruptedException {
		//a[text()='Accounts']
		//Opening Accounts page
WebElement accountsTab = driver.findElement(By.xpath("//a[text()='Accounts']"));
 // Actions action = new Actions(driver);
 // action.build().perform();
 // waitforVisibilty(500, accountsTab);
  accountsTab.click();
  System.out.println("Clicked on Accounts Ta..");
  Thread.sleep(4000);
  WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
  popupwindow.click();
  
		
}
	
	public static void createNewAccount() throws InterruptedException {
	//input[@name='new']
	//Creating New Account	
		
	//Thread.sleep(3000);	
	
	WebElement newTab = driver.findElement(By.xpath("//*[@id=\'hotlist\']/table/tbody/tr/td[2]/input"));
	newTab.click();
	System.out.println("Clicked on New tab..");	
	
		//input[@id = 'acc2']
	WebElement accountname = driver.findElement(By.id("acc2"));
	accountname.clear();
	accountname.sendKeys("Jyothi");
	
	WebElement accounttype = driver.findElement(By.xpath("//select[@id ='acc6' ]"));
	Select acctypeselect = new Select(accounttype);
	acctypeselect.selectByVisibleText("Technology Partner");
	
	//select[@id='00NDn00000BSTTv']
//	Thread.sleep(4000);
	WebElement prioritytype = driver.findElement(By.xpath("//select[@id='00NDn00000Ujo0E']"));
	Select priorityselect = new Select(prioritytype);
	priorityselect.selectByVisibleText("High");
	
		//select[@id ='acc6' ]
	WebElement savebutton = driver.findElement(By.name("save"));
	savebutton.click();
	System.out.println("Clicked on Save button..");
	System.out.println("Tc_10_create account is completed");
	}	
		
}
