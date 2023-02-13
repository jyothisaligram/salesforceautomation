//Select logout from <usermenu> dropdown

package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC09 extends SFBaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     loginToSalesforce();
     logout();
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
	public static void logout() throws InterruptedException {
		
WebElement switchTousername = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
        waitforVisibilty(500, switchTousername);
		switchTousername.click();
			
		WebElement logoutButton =  driver.findElement(By.xpath("//a[text() = 'Logout']"));
		waitforVisibilty(500, logoutButton);
		moveTOElementAction(logoutButton,"logout element");
		Thread.sleep(2000);
		logoutButton.click();
		waitforMe(5000);
		
		
	/*	waitFluentForVisibility(widget,"widget element");
		moveTOElementAction(widget,"widget element");
		driver.close();*/
			
	}


}
