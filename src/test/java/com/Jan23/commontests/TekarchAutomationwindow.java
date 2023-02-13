package com.Jan23.commontests;

import java.awt.Window;
import java.awt.*;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Jan23.Salesforce.JavascriptExecutor;
import com.Jan23.Salesforce.Robot;
import com.Jan23.Salesforce.StringSelection;
import com.Jan23.Salesforce.WebDriverWait;

public class TekarchAutomationwindow extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     
		loginToFirebase();
		switchToTab();
		
	}
	
	
	public static void loginToFirebase() throws InterruptedException {
		String expected = "Student Registration Form";
		GetDriverInstance("chrome");
		goToUrl("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		By idLoc = By.id("email_field");
		WebElement username = driver.findElement(idLoc);
		enterText(username, "admin123@gmail.com", "usernameEle");

		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password, "admin123", "passwordEle");

		//driver.findElement(By.tagName("button")).click();
		
		 WebElement buttonclick = driver.findElement(By.tagName("button"));
		 String name = "buttonElement";
		 clickonme(buttonclick,name);
		
		Thread.sleep(5000);
	}
	
	public static void uploadthefile() {
		 
		public static void uploadFile() throws InterruptedException, AWTException {
			GetDriverInstance("chrome");
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);// maximum of 30 sec  //userfield at 15th sec 15sec execution resumes at 16th sec
			goToUrl("https://qa-tekarch.firebaseapp.com/");
			//Thread.sleep(5000);
			By idLoc = By.id("email_field");
			WebElement username = driver.findElement(idLoc);
			WebDriverWait wait=new WebDriverWait(driver,30);
			 wait.until(ExpectedConditions.visibilityOf(username));
			enterText(username, "admin123@gmail.com", "usernameEle");

			WebElement password = driver.findElement(By.id("password_field"));
			enterText(password, "admin123", "passwordEle");

			driver.findElement(By.tagName("button")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//a[text()='File Upload']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='Clear']")).click();
			WebElement browse=driver.findElement(By.xpath("//input[@id='logo']"));
			JavascriptExecutor executor=(JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();",browse);
			executor.executeScript("document.getElementById('logo').click();");
			
			StringSelection stringSelection = new StringSelection("D:\\New folder\\documents\\images\\deadlock.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			
			Robot robot=new Robot();
			 robot.keyPress(KeyEvent.VK_CONTROL);
	         robot.keyPress(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_CONTROL);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
			
			
		}

	 
	 
	
	
	public static void switchToTab() throws InterruptedException {
		
		
WebElement switchto = driver.findElement(By.xpath("//body/div[@id='user_div']/div[1]/div[1]/button[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(switchto).build().perform();
		Thread.sleep(1000);

		//a[contains(text(),'Windows')]
		WebElement windowbar = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
		action.moveToElement(windowbar).build().perform();
		windowbar.click();
		
		String baseWindowhandle  = driver.getWindowHandle();
		Thread.sleep(3000);
		
		WebElement windowbutton = driver.findElement(By.xpath("//button[contains(text(),'Window')]"));
	    windowbutton.click();
	    Thread.sleep(3000);
	    
	    Set<String> allwindowshandle = driver.getWindowHandles();
	 
	   String firstwindowtab="";
	    for(String handlewindow : allwindowshandle) {
	    	if(!baseWindowhandle.equalsIgnoreCase(handlewindow)) {
	    		driver.switchTo().window(handlewindow);
	    		 firstwindowtab = handlewindow;
	    		break;    	
	    	}
	    	    	
	    }
	    driver.findElement(By.name("q")).sendKeys("selenium");
	   	
		Thread.sleep(6000);
		System.out.println("secondtab closed");
	//	driver.close();
	    
	    driver.switchTo().window(baseWindowhandle);
	    Thread.sleep(3000);
	   
	    WebElement tabbutton = driver.findElement(By.xpath("//button[contains(text(),'Tab')]"));
		tabbutton.click();
		Thread.sleep(3000);
		 
		 for(String handlewindow1 : allwindowshandle) {
		    	if(!baseWindowhandle.equalsIgnoreCase(handlewindow1)&& (!baseWindowhandle.equalsIgnoreCase(firstwindowtab))) {
		    		driver.navigate().to(handlewindow1);
		    		 break;    	
		    	}
		    	    	
		    }
		   
		 Thread.sleep(5000);
	     
	    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
	   // Thread.sleep(6000);
		System.out.println("thirdtab closed");
		//driver.close();
	      	       	
	}
}