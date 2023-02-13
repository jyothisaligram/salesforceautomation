//Check the Save and New button works in New Contact page
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class salesforceTC32 extends SFBaseTest{
	
	public static void main(String[] args) throws InterruptedException{
	
	loginToSalesforce();
	switchTocontacts();
	createnewContact();
	
}
	
public static void createnewContact() throws InterruptedException {
		
WebElement newcontact = driver.findElement(By.xpath("//input[@name='new']"));
newcontact.click();


WebElement lastname = driver.findElement(By.xpath("//input[@id ='name_lastcon2']"));
lastname.sendKeys("Indian");

WebElement accname = driver.findElement(By.xpath("//input[@id ='con4']"));
accname.sendKeys("Global Media");
Thread.sleep(5000);
WebElement saveandNew = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save_new']"));
saveandNew.click();

Thread.sleep(5000);
System.out.println("TC_32 test case save and new  pass");
driver.close();
}


public static void switchTocontacts() throws InterruptedException {
		
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
	