//Create new contact
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class salesforceTC25 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		loginToSalesforce();
		switchTocontacts();
		createnewcontact();
		Thread.sleep(3000);
		System.out.println("TC_25 create new contact complete");
		driver.close();
	}

	public static void createnewcontact() throws InterruptedException {
		//input[@name='new']
WebElement newcontact = driver.findElement(By.xpath("//input[@name='new']"));
newcontact.click();

//input[@id ='name_lastcon2']
WebElement lastname = driver.findElement(By.xpath("//input[@id ='name_lastcon2']"));
lastname.sendKeys("Gandhi");

WebElement accname = driver.findElement(By.xpath("//input[@id ='con4']"));
accname.sendKeys("AAAA");
Thread.sleep(3000);
WebElement save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name ='save']"));
save.click();
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
