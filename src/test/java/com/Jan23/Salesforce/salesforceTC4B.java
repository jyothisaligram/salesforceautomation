package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class salesforceTC4B extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  loginToSalesforce();
		  
		  WebElement buttonclick = driver.findElement(By.id("Login"));
		  String name = "buttonElement";
		  clickonme(buttonclick,name);
		  validateinvalidUsernameandPassword();
		  closethebrowser();
	}
	
	public static void loginToSalesforce() throws InterruptedException {

		GetDriverInstance("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(5000);
		
		By idLoc = By.id("username");
		WebElement username = driver.findElement(idLoc);
		enterText(username, "123", "usernameEle");
	    Thread.sleep(2000); 
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		enterText(password, "22131", "passwordEle");
		
		
	}
	
	public static void validateinvalidUsernameandPassword(){
	
		WebElement loginerrorMessage = driver.findElement(By.xpath("//div[@id='error']"));
		//div[@id='error']
		
		String expectederrormsg = "Please check your username and password. "
				+ "If you still can't log in, contact"
				+ " your Salesforce administrator.";
		String actualerrormsg = loginerrorMessage.getText();
		if (actualerrormsg.equalsIgnoreCase(expectederrormsg)) {
			System.out.println("Test Script for login error message passed");
			
		}
		else {
			System.out.println("Test Script for login error message Failed");
		}
		
	}

}
