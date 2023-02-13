package com.Jan23.Salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class salesforceTC06 extends SFBaseTest {

	public static void main(String[] args) throws InterruptedException, AWTException, FileNotFoundException {
		// TODO Auto-generated method stub
		loginToSalesforce();
		waitforMe(5000);
		checkforUsermenu();
		myProfileTab();
	    Thread.sleep(3000);
		editmyProfilebutton();
	    
		editprofileWindow();
	    
		postthemessage();
		waitforMe(5000);
		
	    uploadthefile();
	
		uploadmyphoto();
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
    
	public static void checkforUsermenu() {
		WebElement switchTousername = driver.findElement(By.xpath("//span[@class ='menuButtonLabel' and text() = 'Joythi SA']"));
			
			waitforVisibilty(100, switchTousername);
			Actions action = new Actions(driver);
			action.moveToElement(switchTousername).build().perform();
			switchTousername.click();
			 waitforMe(5000);
			
			
		}
	
	
	
  public static void myProfileTab() throws InterruptedException {
        	   
     WebElement profileTab = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
     waitforVisibilty(100, profileTab);
   	Actions action = new Actions(driver);
   	action.moveToElement(profileTab).build().perform();
    Thread.sleep(5000);
   	profileTab.click();
   
    }
        
    
 public static void  editmyProfilebutton() throws InterruptedException {
  WebElement editprofilebutton = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]")); 
  editprofilebutton.click(); 
  Thread.sleep(8000);
        	       	  
 }
          
 public static void editprofileWindow() throws InterruptedException {
        	//iframe[@id='contactInfoContentId']
	
WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
	System.out.println("I am inside frame");
	driver.switchTo().frame(frame1);
	 
	//Thread.sleep(5000); 
 WebElement aboutTab = driver.findElement(By.cssSelector("#aboutTab"));
 aboutTab.click();
 WebElement newLastname = driver.findElement(By.xpath("//input[@id='lastName']"));
 newLastname.clear();
 newLastname.sendKeys("Saligram");
 System.out.println("LastName is Entered");
 
        	
WebElement savebutton = driver.findElement(By.xpath("//input[@value='Save All']"));
   Thread.sleep(4000);

  savebutton.click();
 }
 
 
 
 public static void postthemessage() throws InterruptedException {
	WebElement postele = driver.findElement(By.xpath("//span[text()='Post']"));
	postele.click();
	//iframe[contains(@title ,'Rich Text Editor, publisherRichTextEditor')]
	
WebElement postframe = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
	driver.switchTo().frame(postframe);
    
    WebElement framebody = driver.findElement(By.xpath("//html[1]/body[1]"));
    framebody.click();
    framebody.sendKeys("Hello This is new message");
     
     driver.switchTo().parentFrame();
     
     Thread.sleep(5000);
    WebElement shareButton = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
    shareButton.click();
    System.out.println("Message is posted");
   
    }
 
 public static void uploadthefile() throws InterruptedException, AWTException, FileNotFoundException {
	 
	
 WebElement fileTab = driver.findElement(By.xpath("//a[@id = 'publisherAttachContentPost']"));
 fileTab.click();
 Thread.sleep(3000);
		
 WebElement uploadFilefromcomputer = driver.findElement(By.xpath("//a[@id ='chatterUploadFileAction']"));
 uploadFilefromcomputer.click();

 WebElement chooseFilebutton = driver.findElement(By.xpath("//input[@id = 'chatterFile']"));

    System.out.println("clicked on uploadfile button on computer");
	Thread.sleep(3000);
 
	String curdir = System.getProperty("user.dir");
	 String filepath = curdir+"\\src\\test\\resources\\MasalaDose.jpg";
	 System.out.println(filepath);
 
	 WebElement choosefile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
	enterText(choosefile, filepath, "choosefile");
	System.out.println("choosefile option is selected");
	
	Thread.sleep(4000);
	WebElement Share = driver.findElement(By.id("publishersharebutton"));
	Share.click();
		
	//	clickObj(Share, "ShareButton");

 
 }
 
 public static void uploadmyphoto() throws InterruptedException, AWTException {
	
	//span[@id='displayBadge']
WebElement moderator = driver.findElement(By.xpath("//span[@id='displayBadge']"));
Thread.sleep(3000);
moderator.click(); 
Thread.sleep(5000);	
// mouseOver(driver, photoBox);

WebElement photoFrame= driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));	 
driver.switchTo().frame(photoFrame);	 
Thread.sleep(3000);	 
//input[@id='j_id0:uploadFileForm:uploadInputFile']	 

WebElement fileuploadButton = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));

String curdir = System.getProperty("user.dir");
fileuploadButton.sendKeys(curdir+"/src/test/resources/jyothi2018.jpg");
 System.out.println("upload profile page opened");
 
WebElement saveButton = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn")); 
saveButton.click();
Thread.sleep(3000);

//input[@id='j_id0:j_id7:save']
WebElement save = driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
save.click();
Thread.sleep(2000);
System.out.println("My profile completed successfully");
 }
	
		 
		
}

	 
	 
 
 
 

