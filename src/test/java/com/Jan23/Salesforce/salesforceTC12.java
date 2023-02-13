//TC12 Editview 
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC12 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    
		loginToSalesforce();
		SwitchtoaccountsTab();
		switchtoEditTab();
		closemywindow();
		
	}

	private static void closemywindow() {
		// TODO Auto-generated method stub
		
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
  WebElement accountsTab = driver.findElement(By.xpath("//a[text()='Accounts']"));
  Actions action = new Actions(driver);
  action.build().perform();
  waitforVisibilty(500, accountsTab);
  accountsTab.click();
  Thread.sleep(4000);
  WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
  popupwindow.click();
		
		
     }
	
	public static void switchtoEditTab() throws InterruptedException {
		
		//select[@id='fcf']
	WebElement viewdropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
	viewdropdown.click();
	Select select = new Select(viewdropdown);
	select.selectByIndex(1);
	
	WebElement editTab = driver.findElement(By.xpath("//a[text()='Edit']"));
	editTab.click();
	
	WebElement newfname = driver.findElement(By.xpath("//input[@id='fname']"));
	newfname.clear();
	newfname.sendKeys("MyAccountName");
	System.out.println("Viewname entered in the field");
	
	WebElement firstcolumn = driver.findElement(By.xpath("//select[@id='fcol1']"));
	firstcolumn.click();
		
	WebElement fields = driver.findElement(By.xpath("//select[@id='fcol1']"));
	Select accfield = new Select(driver.findElement(By.xpath("//select[@id='fcol1']")));
	accfield.selectByIndex(1);
		
	WebElement AddfieldsOperator = driver.findElement(By.xpath("//select[@id='fcol1']"));
	Select operator = new Select(driver.findElement(By.xpath("//select[@id='fop1']")));
	operator.selectByIndex(3);
		
	WebElement value = driver.findElement(By.id("fval1"));
	value.clear();
	value.sendKeys("<A>");
	
	
	
	
	
	//input[@name = 'save']
	Thread.sleep(5000);
	WebElement saveTab = driver.findElement(By.xpath("//input[@name = 'save']"));
	saveTab.click();
	Thread.sleep(5000);
	//driver.close();
	System.out.println("TC12Accounts_Edit_view is completed");
		
	}
}
