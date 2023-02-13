//Verify the tab customization
package com.Jan23.Salesforce;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class salesforceTC35 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginToSalesforce();
		SwitchToHome();
		Thread.sleep(3000);
		switchToTab();
		logout();
		Thread.sleep(3000);
		loginToSalesforce();
		System.out.println("TC_35 home page tab customization pass");
		driver.close();
	}
	
	public static void switchToTab() {
	      
		WebElement switchTousername = driver.findElement(By.xpath("//span[@class ='menuButtonLabel' and text() = 'Joythi SA']"));
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
	
	private static void SwitchToHome() throws InterruptedException {
		//a[text()='Home']
	WebElement homeTab = driver.findElement(By.xpath("//a[text()='Home']"));
	homeTab.click();
	Thread.sleep(3000);
	
	WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
	popupwindow.click();
	Thread.sleep(3000);
			
	
	WebElement allTab = driver.findElement(By.xpath("//li[@id='AllTab_Tab']"));
	allTab.click();
	Thread.sleep(3000);
	
	//input[@name='customize']
	WebElement customize = driver.findElement(By.xpath("//input[@name='customize']"));
	customize.click();
	
	Thread.sleep(4000);
	//option[@value='Chatter']
	WebElement chatter = driver.findElement(By.xpath("//option[@value='Chatter']"));
	chatter.click();
	
	//img[@title='Remove']
	WebElement leftArrow = driver.findElement(By.xpath("//img[@title='Remove']"));
	leftArrow.click();
	Thread.sleep(4000);
	//td[@class='pbButtonb']//input[@name='save']

WebElement save = driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@name='save']"));
save.click();
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
