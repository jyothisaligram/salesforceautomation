//TC21-leadsSelectView
package com.Jan23.Salesforce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC21 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		loginToSalesforce();	
		switchtoLead();
		viewleads();
		Thread.sleep(3000);
		driver.close();
	}
	private static void viewleads() {
		// TODO Auto-generated method stub
		//select[@id='scope']
		WebElement viewdropdown = driver.findElement(By.xpath("//select['#fcf']"));
		viewdropdown.click();
		
		Select selectview = new Select(viewdropdown);
		
		//Get all options
	    List<WebElement> vew = selectview.getOptions();

	    //Get the length
	    System.out.println(vew.size());

	    // Loop to print one by one
	    for (int j = 0; j < vew.size(); j++) {
	        System.out.println(vew.get(j).getText());
	    }
	
	   System.out.println("TC_21 leadsview dropdown completed"); 
	    
}
	private static void switchtoLead() throws InterruptedException {
		// TODO Auto-generated method stub
		//a[text()='Leads']
WebElement lead = driver.findElement(By.xpath("//a[text()='Leads']"));
lead.click();
Thread.sleep(3000);
WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
popupwindow.click();
Thread.sleep(3000);

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

}
