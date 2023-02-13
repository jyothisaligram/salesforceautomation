//Verify if the firstname and lastname of the loggedin user is displayed
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class salesforceTC33 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		loginToSalesforce();
		SwitchToHome();
	
		}
	
	
	private static void SwitchToHome() throws InterruptedException {
		//a[text()='Home']
	WebElement homeTab = driver.findElement(By.xpath("//a[text()='Home']"));
	homeTab.click();
	Thread.sleep(3000);
	
	WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
	popupwindow.click();
	Thread.sleep(3000);
			
	
	//a[text()='Joythi SA']
	WebElement namelink = driver.findElement(By.xpath("//a[text()='Joythi SA']"));
	String nameonHomepage = namelink.getText();
	namelink.click();
	Thread.sleep(3000);
		
	//span[text()='Joythi SA']
	WebElement profileName = driver.findElement(By.xpath("//span[text()='Joythi SA']"));
	String myUsername = profileName.getText();
	System.out.println("Profile name is " + myUsername);
	
	if(nameonHomepage.equals(myUsername)) {
		System.out.println("Username on Home page is same as username in my Profile page");
	}
	else {
		System.out.println("Username on home page is different from Profile page");
	}
	
	
	System.out.println("TC_33 verify home page and firstname lastname pass");
	driver.close();
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
