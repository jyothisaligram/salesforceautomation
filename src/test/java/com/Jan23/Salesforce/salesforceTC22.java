//TC22-defaultView
package com.Jan23.Salesforce;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC22 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginToSalesforce();	
		switchtoLead();
		switchtoLeadsdropdown();
		switchtogo();
		Thread.sleep(3000);
		logout();
		Thread.sleep(2000);
		loginToSalesforce();
		switchtoLead();
		switchtogo();
		System.out.println("TC_22 default view test completed");
	
		Thread.sleep(3000);
		driver.close();	
	}

		

public static void logout() throws InterruptedException {
		// TODO Auto-generated method stub
      
WebElement switchTousername = driver.findElement(By.xpath("//span[@class ='menuButtonLabel' and text() = 'Joythi SA']"));
waitforVisibilty(100, switchTousername);
switchTousername.click();

 WebElement logoutButton =  driver.findElement(By.xpath("//a[text() = 'Logout']"));
waitforVisibilty(500, logoutButton);
moveTOElementAction(logoutButton,"logout element");
Thread.sleep(2000);
logoutButton.click();

	}



	private static void switchtoLeadsdropdown() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement leadviewdropdown = driver.findElement(By.xpath("//select['#fcf']"));
		leadviewdropdown.click();
		Select view = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		view.selectByIndex(1);
		Thread.sleep(5000);
	     
	}

	private static void switchtogo() {
		// TODO Auto-generated method stub
		//input[@title = 'Go!']
		WebElement gobutton = driver.findElement(By.xpath("//input[@title = 'Go!']"));
		gobutton.click();
		System.out.println("TC22 Go leads completed");
	}



	private static void switchtoLead() throws InterruptedException {
		// TODO Auto-generated method stub
		//a[text()='Leads']
WebElement lead = driver.findElement(By.xpath("//a[text()='Leads']"));
lead.click();
Thread.sleep(4000);
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
