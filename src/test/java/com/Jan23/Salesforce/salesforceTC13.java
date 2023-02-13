//Merge accounts

package com.Jan23.Salesforce;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class salesforceTC13 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginToSalesforce();
		SwitchtoaccountsTab();
		SwitchToMergeAccounts();
		
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
	
	//opening Accounts page
	public static void SwitchtoaccountsTab() throws InterruptedException {
		//a[text()='Accounts']
  WebElement accountsTab = driver.findElement(By.xpath("//a[text()='Accounts']"));
  Actions action = new Actions(driver);
  action.build().perform();
  waitforVisibilty(500, accountsTab);
  accountsTab.click();
  Thread.sleep(4000);
  WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
  popupwindow.click();
		
	}
	
	
	public static void SwitchToMergeAccounts() throws InterruptedException {
		
	WebElement Mergeacc = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
	Mergeacc.click();
	Thread.sleep(4000);
	
	
	WebElement fb = driver.findElement(By.id("srch"));
	fb.clear();
	fb.sendKeys("Jy");
	
	WebElement FindAccount = driver.findElement(By.xpath("//input[@value ='Find Accounts']"));
	waitforVisibilty(500, FindAccount);
	FindAccount.click();
	Thread.sleep(4000);
	
//	 WebElement Button1 = driver.findElement(By.xpath("//input[@id='cid0']"));
//	 Button1.click();
			
//	 WebElement Button2 = driver.findElement(By.xpath("//input[@id='cid1']"));
//	 Button2.click();
    
//	 WebElement Button3 = driver.findElement(By.xpath("//input[@id='cid2']"));
  //   Button3.click();
  
   //  Thread.sleep(4000);
  
// WebElement nextButton = driver.findElement(By.xpath("//div[@class='pbWizardHeader'] //input[@title='Next']"));	
 System.out.println("I am here");
 WebElement nextbut = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]"));
 if(nextbut.isDisplayed()){
 nextbut.click(); 
 System.out.println("next clicked");
 }
 else
 {
	System.out.println("Next button not clicked"); 
 }
  
 
 WebElement Merge = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[2]"));

 
 if(Merge.isDisplayed())
{
	System.out.println("merge displayed");
	 Thread.sleep(5000);
}
 Merge.click();	    
 driver.switchTo().alert().accept();
 System.out.println("Pass: alert is present and accept");	
 driver.close();
	    System.out.println("TC13_MergeAccounts is completed");
	
	}
}

