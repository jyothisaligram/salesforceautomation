//Test forgot password 
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class salesforceTC4A extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		loginToSalesforce();
		
		switchToForgotPassword();
		forgotpasswordPage();
		validateforgotpasswordPage();
		waitforMe(2000);
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
		
	}
	public static void switchToForgotPassword() {
	
  WebElement forgotpassword = driver.findElement(By.linkText("Forgot Your Password?"));
    forgotpassword.click();
	
	}
	
	public static void forgotpasswordPage() {
		
		WebElement forgotPassword = driver.findElement(By.cssSelector("#un"));
		waitforVisibilty(1000,forgotPassword);
		enterText(forgotPassword,"jan23.jyothi@ta.com","usernameelement");
		WebElement continuebutton = driver.findElement(By.xpath("//input[@id='continue']"));
	    continuebutton.click();
	    
	}
	
	
	//h1[@id='header']
	
	public static void validateforgotpasswordPage() {
		
		WebElement headerLine = driver.findElement(By.xpath("//h1[@id='header']"));
		String expectedHeader = "Check Your Email";
		String actualHeader = headerLine.getText();
		if(actualHeader.equalsIgnoreCase(expectedHeader)) {
		System.out.println("Test script for forgot your password PASSED");	
		}
		else {
			System.out.println("Test script for forgot your password Failed");
		}
		
		
	}
	
}
