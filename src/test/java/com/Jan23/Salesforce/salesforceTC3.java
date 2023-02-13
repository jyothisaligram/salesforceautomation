package com.Jan23.Salesforce;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class salesforceTC3 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginToSalesforce();
		 rememberMe();
		 waitforMe(5000);
	 WebElement buttonclick = driver.findElement(By.id("Login"));
	 String name = "buttonElement";
	 clickonme(buttonclick,name);
	 Thread.sleep(5000);
	 switchToTab();
	 logout();
	 
	 Thread.sleep(2000);
	 checkUsername();
	 
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
	
	}
	
	public static void rememberMe() {
		
		WebElement remember = driver.findElement(By.id("rememberUn"));
		waitforVisibilty(50, remember);
		remember.click();
		
	}
	
	
	public static void switchToTab() {
      
		WebElement switchTousername = driver.findElement(By.xpath("//span[@class ='menuButtonLabel' and text() = 'Jyothi Saligram']"));
		
		waitforVisibilty(100, switchTousername);
		Actions action = new Actions(driver);
		action.moveToElement(switchTousername).build().perform();
		switchTousername.click();
		 waitforMe(5000);
			
	}
	
	public static void logout() throws InterruptedException {
		
			
		WebElement logoutButton =  driver.findElement(By.xpath("//a[text() = 'Logout']"));
		waitforVisibilty(500, logoutButton);
		moveTOElementAction(logoutButton,"logout element");
		Thread.sleep(2000);
		logoutButton.click();
		waitforMe(5000);
	
	}
	 public static void checkUsername() {
		 String expectedName = "jan22.jyothi@ta.com";
		// #idcard-identity
		 By idLoc = By.cssSelector("#idcard-identity");
		 WebElement username = driver.findElement(idLoc); 
		 String actualName = username.getText();
		 if(actualName.equalsIgnoreCase(expectedName)) {
			 System.out.println("The script test for rememberme passed");
		 }
		 else {
			 System.out.println("The script test failed");
		 }
		//driver.close();		 
	 }
	 
}
	
	
	
	

