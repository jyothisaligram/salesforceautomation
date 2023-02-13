//Select "Developers Console" option from user menu for <username> drop down
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class salesforceTC08 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 loginToSalesforce();
		 switchToDeveloperconsole();
		//driver.close();
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
	
	public static void switchToDeveloperconsole() throws InterruptedException {
	WebElement switchTousername = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
    waitforVisibilty(500, switchTousername);
	switchTousername.click();
	String parentwindow = driver.getWindowHandle();	
	//a[contains(text(),'Developer Console')]
	Thread.sleep(5000);
	WebElement developerele = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
	developerele.click();
	
	for(String handle : driver.getWindowHandles()) {
		System.out.println(handle);
		
		if(!handle.equalsIgnoreCase(parentwindow)){
			System.out.println("testing"+handle);
			driver.switchTo().window(handle);
			Thread.sleep(9000);
			driver.close();
	         }	
      }
	
	
	}		
	
	
	
}
