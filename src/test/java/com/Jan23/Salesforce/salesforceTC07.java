//Select Mysettings
package com.Jan23.Salesforce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC07 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		loginToSalesforce();
		waitforMe(5000);
		checkforUsermenu();
	     switchTomysettings();
	    Thread.sleep(3000);
		
		
		
		
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
		WebElement switchTousername = driver.findElement(By.xpath("//span[@class ='menuButtonLabel' and text() = 'Jyothi Tata']"));
			
			waitforVisibilty(100, switchTousername);
			Actions action = new Actions(driver);
			action.moveToElement(switchTousername).build().perform();
			switchTousername.click();
			// waitforMe(5000);
			
			
		}
	
	public static void switchTomysettings() throws InterruptedException{
		WebElement MySettings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		waitforVisibilty(100, MySettings);
	   	Actions action = new Actions(driver);
	   	action.moveToElement(MySettings).build().perform();
	    Thread.sleep(5000);
	    
	    MySettings.click();
	    
		
	  //span[@id='PersonalInfo_font']
	    WebElement personalTab = driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
	    action.moveToElement(personalTab).build().perform();
	    personalTab.click();
		
	  //span[@id='LoginHistory_font']
	    WebElement loginHistoryTab = driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
	    action.moveToElement(loginHistoryTab).build().perform();
	    loginHistoryTab.click();  
	    
	  //downloading .csv file
		WebElement LoginHistory6Months= driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a"));
		LoginHistory6Months.click();
	    
		//Display and layout link
		//span[@id='DisplayAndLayout_font']
		WebElement displayandLayoutTab = driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
	    action.moveToElement(displayandLayoutTab).build().perform();
	    displayandLayoutTab.click();  
	    
		
	    WebElement customizeTab = driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
	    action.moveToElement(customizeTab).build().perform();
	    customizeTab.click();  
	    
	    WebElement dropdown = driver.findElement(By.id("p4"));
		Select dropdownOptions = new Select(dropdown); 
		dropdownOptions.selectByVisibleText("Salesforce Chatter");
		
		Thread.sleep(5000);
	    		
		//Available Tabs dropdown
		dropdown = driver.findElement(By.id("duel_select_0"));
		dropdownOptions = new Select(dropdown); 
		dropdownOptions.selectByVisibleText("Reports");
		WebElement Add_Arrow = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img"));
		Add_Arrow.click();
	    
		//checking if the selected element is in Selected Tabs dropdown
		dropdown= driver.findElement(By.id("duel_select_1"));
		dropdownOptions = new Select(dropdown); 
		List<WebElement> elements = dropdownOptions.getOptions();
		for(int i=0; i<elements.size(); i++) {
			if(elements.get(i).getText().equals("Reports")) {
				System.out.println("Reports Tab is added");	
			}
			else {
				System.out.println("Reports Tab is  not added");
			}
		}
		//Email Tab
		WebElement Email = driver.findElement(By.id("EmailSetup"));
		Email.click();
		WebElement MyEmailSettings = driver.findElement(By.id("EmailSettings_font"));
		MyEmailSettings.click();

		WebElement Email_Name = driver.findElement(By.id("sender_name"));
		Email_Name.clear();
		Email_Name.sendKeys("jyothisa");
		WebElement Email_Address = driver.findElement(By.id("sender_name"));
		Email_Address.clear();
		Email_Address.sendKeys("jyothisa@ta.com");
		WebElement Bcc_radioButton = driver.findElement(By.id("auto_bcc1"));
		Bcc_radioButton.click();
		WebElement Save_button = driver.findElement(By.name("save"));
		Save_button.click();		
		
		//Calender & Remainders
		WebElement Calender_and_Reminders = driver.findElement(By.id("CalendarAndReminders"));
		Calender_and_Reminders.click();
		Thread.sleep(5000);
		WebElement ActivityReminders = driver.findElement(By.xpath("//*[@id=\"Reminders_font\"]"));
		ActivityReminders.click();
		Thread.sleep(5000);
		WebElement Test_Reminder = driver.findElement(By.className("btn"));
		Test_Reminder.click();
		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		for(String handle : driver.getWindowHandles()) { 
			if(handle != parentWindow) {
				driver.switchTo().window(handle);
			String	expectedUrl1 = driver.getCurrentUrl();
			String	actualUrl1 = "https://ap8.salesforce.com/ui/core/activity/ReminderSettingsPage?setupid=Reminders&retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DCalendarAndReminders";
				
			if(actualUrl1.equalsIgnoreCase(expectedUrl1)) {
					System.out.println("MySettings page is not Lunched");
			}
				else {
					System.out.println("User is on MySettings page");
				}	
			}
		}
		driver.close();
		System.out.println("Tc_7_SelectMySettings is completed");
		
		
		
	}
	

	

}
