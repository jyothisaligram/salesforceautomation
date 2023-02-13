package com.Jan23.Salesforce;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class salesforceTC05 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		
		loginToSalesforce();
		waitforMe(5000);
		checkforUsermenu();
		checkusermenudropdown();
		closethebrowser();
		
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
	public static void checkforUsermenu() {
	WebElement switchTousername = driver.findElement(By.xpath("//span[@class ='menuButtonLabel' and text() = 'Jyothi Saligram']"));
		
		waitforVisibilty(100, switchTousername);
		Actions action = new Actions(driver);
		action.moveToElement(switchTousername).build().perform();
		 waitforMe(5000);
		
		
	}
	
	public static void checkusermenudropdown() {
		
WebElement switchTousername = driver.findElement(By.xpath("//span[@class ='menuButtonLabel' and text() = 'Joythi SA']"));
		
		waitforVisibilty(100, switchTousername);
		Actions action = new Actions(driver);
		action.moveToElement(switchTousername).build().perform();
		switchTousername.click();
		 waitforMe(5000);
		
	}
	

}


