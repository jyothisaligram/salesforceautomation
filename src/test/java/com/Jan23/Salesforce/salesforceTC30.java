//Check the Error message if, the required information is not entered 
//while creating a New vIEw in Contacts
package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class salesforceTC30 extends SFBaseTest{
	
	public static void main(String[] args) throws InterruptedException{
		loginToSalesforce();
		switchTocontacts();
		createnewview();
		
	}

public static void createnewview() throws InterruptedException {
		//a[text()='Create New View']
WebElement createnew = driver.findElement(By.xpath("//a[text()='Create New View']"));
createnew.click();
//input[@id='fname']

WebElement View_UniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
View_UniqueName.clear();
View_UniqueName.sendKeys("EFGH");

WebElement save = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Save']"));
save.click();

//div[@class='errorMsg']
WebElement errMsg = driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]"));
String errorMessage = errMsg.getText();

String message = "Error: You must enter a value";
System.out.println(errorMessage);

if(errorMessage.equalsIgnoreCase(message)) {
 System.out.println("Test case is passed");	
 }
else {
	System.out.println("Test case failed");
}



Thread.sleep(5000);
driver.close();
 System.out.println("TC_30 CreatenewviewintheContactPage is Completed"); 
 	}
	
	
	
	
	
	public static void switchTocontacts() throws InterruptedException {
		//a[@title='Contacts Tab']
WebElement contactsTab = driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
contactsTab.click();
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
