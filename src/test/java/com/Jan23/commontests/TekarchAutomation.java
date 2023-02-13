package com.Jan23.commontests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TekarchAutomation extends BaseTest{
	
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
		
		WebElement textElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1"));
		String actaul = getTextFromWebElement(textElement, "student registartion form");
		if (actaul.equalsIgnoreCase(expected)) {
			System.out.println("testcase passed");
		} else {
			System.out.println("testcase failed");
		}

		
		// closethebrowser();
		//driver.close();

	}

	public static void Error_login_salesforece() {
		String expected = "Please enter your password.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
	//	driver.get("https://login.salesforce.com/");
		
		driver.get("https://qa-tekarch.firebaseapp.com/");
		WebElement username = driver.findElement(By.id("username"));
		String attriValue = username.getAttribute("class");
		System.out.println("attribute of the class =" + attriValue);
		String name = username.getTagName();
		System.out.println("tag name fopr the username field" + name);

		username.sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("");
		
		 driver.findElement(By.id("Login")).click();
		String actual = driver.findElement(By.id("error")).getText();
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("Error_login_salesforece script passed");
		} else {
			System.out.println("Error_login_salesforece script failed");
		}

	}
	
	
	
	
public static void tabInfirebase() throws InterruptedException {
		
		GetDriverInstance("chrome");
		goToUrl("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		By idLoc = By.id("email_field");
		WebElement username = driver.findElement(idLoc);
		enterText(username, "admin123@gmail.com", "usernameEle");

		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password, "admin123", "passwordEle");

		driver.findElement(By.tagName("button")).click();
		Thread.sleep(5000);// static
		
		WebElement widject=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/button"));
		
		Actions action=new Actions(driver);
		action.moveToElement(widject).build().perform();
		action.contextClick(widject).build().perform();
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/a[1]")).click();
		Thread.sleep(4000);
		
		//driver.close();
	//	print all the options in the city drop down in  console
		///html/body/div[2]/div[1]/div[3]/div/a[1]
	}

	public static void NewTabTest() {
		GetDriverInstance("chrome");
		driver.get("https://www.google.com/");
		By ob3=By.partialLinkText("works");
		WebElement howWorksLink=driver.findElement(ob3);
		Actions action=new Actions(driver);
		//perform right click with mouse on howworkslink
	    action.contextClick(howWorksLink).perform();
	    
	    
		action.keyDown(howWorksLink,Keys.SHIFT).perform();
		action.keyUp(howWorksLink,Keys.SHIFT).perform();
		
		//action.contextClick(howWorksLink).keyDown(howWorksLink,Keys.ENTER).perform();
		
		
		
		//action.keyDown(Keys.CONTROL).click(howWorksLink).keyUp(Keys.CONTROL).build().perform();
	}

	
	public static void Student_registration_Form() throws InterruptedException {
		String expected = "Student Registration Form";
		GetDriverInstance("chrome");
		goToUrl("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		By idLoc = By.id("email_field");
		WebElement username = driver.findElement(idLoc);
		enterText(username, "admin123@gmail.com", "usernameElement");

		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password, "admin123", "passwordElement");

		// driver.findElement(By.tagName("button")).click();
		
		 WebElement loginbutton = driver.findElement(By.tagName("button"));
		 String loginbuttonname = "login button";
		 clickonme(loginbutton,loginbuttonname);
		 Thread.sleep(5000);
		
		WebElement nameEle=driver.findElement(By.id("name"));
		enterText(nameEle,"divya","name field");
		WebElement femaleRadioButton=driver.findElement(By.xpath("//input[@id='radiobut' and @value='female']"));
		
	//	femaleRadioButton.click();
		
		String buttonname = "buttonElement";
		clickonme(femaleRadioButton,buttonname);
		
		WebElement cityDropdown=driver.findElement(By.id("city"));
		Select ob=new Select(cityDropdown);
		ob.selectByVisibleText("PATNA");
		
		
				
	}

	public static void main(String[] args) throws InterruptedException {
		loginToFirebase();
		//Error_login_salesforece();
		// Student_registration_Form();
		// Thread.sleep(5000);
		//tabInfirebase();
		//NewTabTest();
		// closethebrowser();
		 
		 
	}

}

	


