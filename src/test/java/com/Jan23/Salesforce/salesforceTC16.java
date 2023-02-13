//create a new opportunity

package com.Jan23.Salesforce;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class salesforceTC16 extends SFBaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginToSalesforce();	
		switchToOpportunity();
		createnewopportunity();
		Thread.sleep(3000);
	driver.close();
	}

	private static void createnewopportunity() {
		// TODO Auto-generated method stub
	
		WebElement NewButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		NewButton.click();

		WebElement Oppname = driver.findElement(By.id("opp3"));
		Oppname.clear();
		Oppname.sendKeys("Marketing");	
		
		//input[@id='opp4']
		WebElement Oppnaccount = driver.findElement(By.id("opp4"));
		Oppnaccount.clear();
		Oppnaccount.sendKeys("Jyothi");
		
		WebElement Oppntype = driver.findElement(By.xpath("//select[@id ='opp5']"));
		Select oppselect1 = new Select(Oppntype);
		oppselect1.selectByVisibleText("New Customer");
		//select[@id='opp11']

		WebElement Oppnlead = driver.findElement(By.xpath("//select[@id ='opp6']"));
		Select oppselect3 = new Select(Oppnlead);
		oppselect3.selectByVisibleText("Web");

		WebElement Oppnclosedate = driver.findElement(By.id("opp9"));
		Oppnclosedate.click();
		
		WebElement today=driver.findElement(By.xpath("//a[@class='calToday']"));
		today.click();
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		WebElement Stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		Stage.click();

		WebElement Oppnstage = driver.findElement(By.xpath("//select[@id ='opp11']"));
		Select oppselect2= new Select(Oppnstage);
		oppselect2.selectByVisibleText("Qualification");

		WebElement probability = driver.findElement(By.id("opp12"));
		probability.clear();
		probability.sendKeys("10");


		WebElement pcampaign = driver.findElement(By.id("opp17"));
		pcampaign.clear();
		pcampaign.sendKeys("  ");

		//input[@name = 'save']
         WebElement savebutton = driver.findElement(By.xpath("//input[@name = 'save']"));
         savebutton.click();

		System.out.println("TC_15_opportunitiesdropdown is completed");
		
		
			}

	private static void switchToOpportunity() throws InterruptedException {
		// TODO Auto-generated method stub
WebElement Opportunities = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
Opportunities.click();
Thread.sleep(3000);

WebElement popupwindow = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
popupwindow.click();
Select dropdownOpp = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));





/*WebElement LookupWindow = driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
LookupWindow.click();

String parentWindow = driver.getWindowHandle();
//Switching driver control to new window.
Set<String> getAllWindows = driver.getWindowHandles();
String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
driver.switchTo().window(getWindow[1]);

Thread.sleep(3000);
//switch to first frame
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@name='go']")).click();
		
		//Switching to Lookup Window
		driver.switchTo().defaultContent();
		
		//Switching to Insideframe(result)
		
		driver.switchTo().frame("resultsFrame");
		
		Thread.sleep(5000);
driver.findElement(By.xpath("//tr[@class='dataRow even last first']/th/a")).click();
		
		driver.switchTo().window(getWindow[0]);
		
		Thread.sleep(2000);*/


		//Coming out of the window to original window.
		

	
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
