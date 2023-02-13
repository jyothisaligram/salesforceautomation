package com.Jan23.commontests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static WebDriver driver=null;
	public static void enterText(WebElement element,String text,String name){
		if(element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		}
		else {
			System.out.println( name+ "web element is not displayed");
		}
		driver.getTitle();
	}
	//Method for click
	
	public static void clickonme(WebElement element, String name) {
		if(element.isDisplayed()) {
			element.click();
		}
		else
		{
			System.out.println("Unable to click because web element is not displayed"+name);
		}
	}
	
	
	public static void closethebrowser() {
		driver.close();
	}
	public static void goToUrl(String url) {
		driver.get(url);
	}
	
	public static void GetDriverInstance(String browserName) {
		
		switch(browserName) {
		case "firefox":		WebDriverManager.firefoxdriver().setup();
							driver=new FirefoxDriver();
							driver.manage().window().maximize();
							break;
							
		case "chrome":  WebDriverManager.chromedriver().setup();
						driver=new ChromeDriver();
						driver.manage().window().maximize();
						break;
						
		default: System.out.println("not entered proper browsername");
		}
		
	}
	
	public static String  getTextFromWebElement(WebElement element,String name) {
		if(element.isDisplayed()) {
			return element.getText();
		}
		else {
			System.out.println(name+ " web element is not displayed");
			return null;
		}
		
	}


}
