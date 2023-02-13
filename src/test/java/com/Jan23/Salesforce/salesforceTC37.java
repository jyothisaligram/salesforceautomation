//Blocking an event in the calender with weekly recurrance

package com.Jan23.Salesforce;

import java.util.Date;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class salesforceTC37 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		
		loginToSalesforce();
		SwitchToHome();
		
	}
	private static void SwitchToHome() throws InterruptedException {
		//a[text()='Home']
	WebElement homeTab = driver.findElement(By.xpath("//a[text()='Home']"));
	homeTab.click();
	Thread.sleep(5000);
	
	WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
	popupwindow.click();
	Thread.sleep(3000);
	
	WebElement todayDate = driver.findElement(By.xpath("//a[text()='Thursday February 9, 2023']"));
	todayDate.click();
	Thread.sleep(4000);
	
	
	WebElement Time = driver.findElement(By.xpath("//a[contains(text(), '4:00 PM')]"));
	Time.click();
	Thread.sleep(4000);
	
	
	String parentHandle = driver.getWindowHandle();
	System.out.println("currenthandle="+parentHandle);
	
	driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']")).click();
	Thread.sleep(4000);
	
	Set<String> windowHandles = driver.getWindowHandles();
	String currentHandle = driver.getWindowHandle();
	windowHandles.remove(currentHandle);
	String newHandle = windowHandles.iterator().next();
	driver.switchTo().window(newHandle);
	
	
	
WebElement subjectLookup = driver.findElement(By.xpath("//a[@href ='javascript:pickValue(4);']"));
subjectLookup.click();

driver.switchTo().window(parentHandle);

	Thread.sleep(5000);
	
	WebElement endTime = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
	endTime.click();
	Thread.sleep(4000);
	WebElement recurrance = driver.findElement(By.xpath("//label[contains(text(),'Create Recurring Series of Events')]"));
	recurrance.click();
	
	WebElement weekly = driver.findElement(By.xpath("//label[text() = 'Weekly']"));
	weekly.click();
	
	WebElement recur = driver.findElement(By.xpath("//input[@id='wi']"));
	recur.clear();
	recur.sendKeys("1");
	Thread.sleep(5000);
	
	Date d1 = new Date();
	System.out.println("Today's date"+d1);
	
	WebElement day = driver.findElement(By.xpath("//input[@id='16']"));
	day.click();
	//input[@id='RecurrenceEndDateOnly']
	WebElement recurranceendDate = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
	recurranceendDate.sendKeys("2/23/2023");
	
	
	WebElement save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
	save.click();
	
	System.out.println("TC37_BlockingAnEvent_Calendar_WeeklyRecurring is done");
		
	//driver.close();
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
