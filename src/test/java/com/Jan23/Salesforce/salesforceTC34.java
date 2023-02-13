//Verify the edited lastname is updated at various places
package com.Jan23.Salesforce;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class salesforceTC34 extends SFBaseTest{

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
			
	//span[@class ='mruText']
	WebElement nameTab = driver.findElement(By.xpath("//span[@class ='mruText']"));
	nameTab.click();
	
	String parentframe = driver.getWindowHandle();
	Thread.sleep(3000);
	//img[@src='/img/func_icons/util/pencil12.gif']
	WebElement editIcon = driver.findElement(By.xpath("//img[@src='/img/func_icons/util/pencil12.gif']"));
	editIcon.click();
	
	//li[@id='aboutTab']
	
	 Thread.sleep(3000);
	driver.switchTo().frame("contactInfoContentId");
	WebElement about = driver.findElement(By.xpath("//li[@id='aboutTab']"));
	about.click();
	Thread.sleep(3000);
	//input[@id='firstName']
	
	WebElement lname = driver.findElement(By.xpath("//input[@id='lastName']"));
	lname.click();
	
//	lname.clear();
//	lname.sendKeys("Abcd");
	Thread.sleep(3000);
	
	//input[@value='Save All']
	WebElement saveAll = driver.findElement(By.xpath("//input[@value='Save All']"));
	saveAll.click();
	
	
	System.out.println("TC_34 verify home page and firstname lastname pass");
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
