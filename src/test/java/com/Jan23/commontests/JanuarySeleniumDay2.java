package com.Jan23.commontests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JanuarySeleniumDay2 {

		static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://qa-tekarch.firebaseapp.com/");
			driver.manage().window().maximize();
			String title =  driver.getTitle();
			System.out.println("Title of page is " +title);
			
					
			WebElement email = driver.findElement(By.id("email_field"));
			email.sendKeys("admin123@gmail.com");
			
			WebElement password = driver.findElement(By.cssSelector("#password_field"));
		    password.sendKeys("admin123");
			
		    Thread.sleep(2000);
		    WebElement login  = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		    login.click();
		    
		   // Navigate to  next page
		  
			Thread.sleep(5000);
			
			WebElement name = driver.findElement(By.id("name"));
			name.sendKeys("Jyothi");
			
		    WebElement fname = driver.findElement(By.cssSelector("#lname"));
			fname.sendKeys("Anantha Raman");
			
			WebElement postaladdress = driver.findElement(By.cssSelector("#postaladdress"));
		    postaladdress.sendKeys("1234 First street, San Francisco CA 91019");
			
		    WebElement personaladdress = driver.findElement(By.cssSelector("#personaladdress"));
			personaladdress.sendKeys("123 XYZ Street ,NewYork 95125");
	
		Thread.sleep(2000);
		
		
		driver.close();
	}

}
