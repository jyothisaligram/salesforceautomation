package com.Jan23.Salesforce;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.Jan23.utility.PropertiesUtility;


public class salesforceTC1 extends SFBaseTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
     loginToSalesforce();
    //  Error_login_salesforce();
      closethebrowser();
	}


public static void loginToSalesforce() throws InterruptedException, IOException {

	String curdir = System.getProperty("user.dir");
	FileInputStream fis = new FileInputStream(curdir+"/src/test/resources/testData.properties");
	Properties ob = new Properties();
	ob.load(fis);
	String url = ob.getProperty("url");
	String username=ob.getProperty("login.valid.userid");
	System.out.println("username= :" +username);
	
	
	
	GetDriverInstance("chrome");
	
	goToUrl(url);
	Thread.sleep(5000);
	
	By idLoc = By.id("username");
	WebElement userName = driver.findElement(idLoc);
	
	enterText(userName, username , "usernameEle");
    Thread.sleep(2000); 
	
    WebElement password = driver.findElement(By.id("password"));
	password.clear();
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

public static void Error_login_salesforce() throws InterruptedException {
	String expected = "Please enter your password.";
	
	GetDriverInstance("chrome");
	goToUrl("https://login.salesforce.com/");
	Thread.sleep(5000);
	
	WebElement username = driver.findElement(By.id("username"));
	String attriValue = username.getAttribute("class");
	System.out.println("attribute of the class = " + attriValue);
	String name = username.getTagName();
	System.out.println("tag name for the username field " + name);

	username.sendKeys("username@ta.com");
	driver.findElement(By.id("password")).sendKeys("");
	Thread.sleep(2000);
	 driver.findElement(By.id("Login")).click();
	 String actual = driver.findElement(By.id("error")).getText();
	if (actual.equalsIgnoreCase(expected)) {
		System.out.println("Error_login_salesforece script passed");
	} else {
		System.out.println("Error_login_salesforece script failed");
	}
  }
}

