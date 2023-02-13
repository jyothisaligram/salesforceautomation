//Test Opportunity Pipeline Report

package com.Jan23.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC17 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginToSalesforce();	
		switchToOpportunity();
		clickonpipeline();
		Thread.sleep(3000);
		driver.close();
	}
		
	
	private static void clickonpipeline() {
		// TODO Auto-generated method stub
		//li[@class='hover']//a[text()='Opportunity Pipeline']
WebElement pipeline = driver.findElement(By.xpath("//a[text()='Opportunity Pipeline']"));
pipeline.click();	
System.out.println("TC_17 opportunity pipeline report completed");
}


	private static void loginToSalesforce() throws InterruptedException {
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


	private static void switchToOpportunity() throws InterruptedException {
		// TODO Auto-generated method stub
WebElement Opportunities = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
Opportunities.click();
Thread.sleep(3000);

WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
popupwindow.click();
Select dropdownOpp = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));


}
	
}	
