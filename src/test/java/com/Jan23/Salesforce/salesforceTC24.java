//Check "New" button on Leads Home
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class salesforceTC24 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginToSalesforce();	
		switchtoLead();
		switchtonewlead();
		System.out.println("TC_24 create new lead completed");
		Thread.sleep(3000);
		driver.close();
		
	}

	
	
	private static void switchtonewlead() throws InterruptedException {
		//input[@name = 'new']
  WebElement newbutton = driver.findElement(By.xpath("//input[@name = 'new']"));
	newbutton.click();
	//input[@id='name_lastlea2']
 WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
 lastname.sendKeys("ABCD");
 WebElement companyname = driver.findElement(By.xpath("//input[@id='lea3']"));
 companyname.sendKeys("ABCD");
 WebElement save = driver.findElement(By.xpath("//td[@id = 'bottomButtonRow']//input[@name ='save']"));
 save.click();
 Thread.sleep(2000);
	}



	public static void switchtoLead() throws InterruptedException {
		// TODO Auto-generated method stub
		//a[text()='Leads']
WebElement lead = driver.findElement(By.xpath("//a[text()='Leads']"));
lead.click();
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
