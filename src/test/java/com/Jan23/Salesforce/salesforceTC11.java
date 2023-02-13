//TC11 Createnewview

package com.Jan23.Salesforce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC11 extends SFBaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginToSalesforce();
		SwitchtoaccountsTab();
		createnewview();
		driver.close();
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
	public static void createnewview() throws InterruptedException {
	Thread.sleep(3000);	
//	WebElement createview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	WebElement createview1 = driver.findElement(By.xpath("//*[@id=\'filter_element\']/div/span/span[2]/a[2]"));
	createview1.click();
	System.out.println("Clicked on Create New View..");
	
		//input[@id='fname']	
	WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
	viewname.clear();
	viewname.sendKeys("Krishna");
	
	String value = driver.findElement(By.xpath("//*[@id=\"fname\"]")).getAttribute("value");
	System.out.println(value);
	//input[@id='devname']
	WebElement viewuniqname = driver.findElement(By.xpath("//input[@id='devname']"));
	viewuniqname.clear();
	viewuniqname.sendKeys("sa");
	//input[@name='save']
	Thread.sleep(5000);
	WebElement saveButton = driver.findElement(By.xpath("//input[@name='save']"));
	saveButton.click();
	System.out.println("clicked on save button");
	
	WebElement dropdown = driver.findElement(By.className("title"));
	dropdown.click();
	Select dropdown_options = new Select(dropdown);
	List<WebElement> options = dropdown_options.getOptions();
	Thread.sleep(5000);
	for(int i=0; i<options.size(); i++) {
		if(options.get(i).getText().equals(value)) {
			System.out.println("Account name is displayed in the dropdown");
		}
	}
	System.out.println("TC_11 Create new view completed....");
		
	}
	
}	
	
	
	