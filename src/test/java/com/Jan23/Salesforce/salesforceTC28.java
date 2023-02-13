//Check 'My contacts' vIEw in the Contact Page
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC28 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException{
		loginToSalesforce();
		switchTocontacts();
		viewMycontacts();
		System.out.println("Tc_28 view my contacts test completed");
         driver.close();
	}
	private static void viewMycontacts() throws InterruptedException {
		WebElement mycontact = driver.findElement(By.xpath("//select[@id='fcf']"));
		mycontact.click();
		Select select = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		select.selectByVisibleText("My Contacts");
		Thread.sleep(3000);
	}
	public static void switchTocontacts() throws InterruptedException {
		//a[@title='Contacts Tab']
WebElement contactsTab = driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
contactsTab.click();
Thread.sleep(4000);
WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
popupwindow.click();
Thread.sleep(3000);
		
	}

	public static void loginToSalesforce() throws InterruptedException {
		// TODO Auto-generated method stub
		
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
	
}
