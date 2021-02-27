package com.qa.test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class DemoTest {

public static WebDriver driver;
public static String browser;


	

@BeforeClass
	public static void YahooTest() throws InterruptedException{
		SetBrowser();
		SetBrowserConfig();
		SetConnection();
	}
	public static void SetBrowser() {
		browser="Chrome";
		
	}
	public static void SetBrowserConfig() {
		if(browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		
	}
	public static void SetConnection() {
		driver.get("https://www.apex4u.com/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		
	}


//@Test(priority=0)
public static void Register() throws InterruptedException {
	
	driver.findElement(By.xpath("//a[@id='login']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("raisa@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Register']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Anika");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Tahsin");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("tahsin01@gmail.com");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("01711122234");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='reg-pass']")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@id='reg-con-pass']")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@id='accept-consent']")).click();
	driver.findElement(By.xpath("//input[@id='Newsletter']")).click();
	driver.findElement(By.xpath("//input[@id='register-button']")).click();
	
	Thread.sleep(5000);
	
	
}
//@Test(priority=1)
public static void validateRegistration() throws InterruptedException{
	WebElement e1 = driver.findElement(By.xpath("//div[@class='result']"));
	String s1 = e1.getText();
	
	if(s1.equalsIgnoreCase("Your registration completed")) {
		
		AssertJUnit.assertTrue(true);
	System.out.println(s1);
	}
	else {
		AssertJUnit.assertTrue(false);
	}
	
	

	
	driver.findElement(By.xpath("//input[@name='register-continue']")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//span[normalize-space()='Log Out']")).click();
}



public static void validateRegister() throws InterruptedException{
	WebElement element1=driver.findElement(By.xpath("//div[normalize-space()='Your registration has been successful.']"));
	String expectedText = element1.getText();
	if(expectedText.contains("Your registration has been successful.")) {
		AssertJUnit.assertTrue(true);
	}else {
		AssertJUnit.fail();
	}
}
@Test(priority=2)
public static void login() throws InterruptedException{
	driver.findElement(By.xpath("//a[@id='login']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("tahsin@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	Thread.sleep(3000);
}
@Test(priority=3)	
public static void validateLogin() throws InterruptedException{
	WebElement element2 = driver.findElement(By.xpath("//p[normalize-space()='You have been logged in successfully.']"));
	String user = element2.getText();
	if(user.equalsIgnoreCase("You have been logged in successfully.")) {
		AssertJUnit.assertTrue(true);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
	}else {
		AssertJUnit.fail();
		Thread.sleep(2000);
	}
}
@Test(priority=4)
public static void purchase() throws InterruptedException{
	driver.findElement(By.xpath("//ul[@class='mega-menu']//a[@class='with-subcategories']//span[contains(text(),'WOMEN')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@title='Show products in category SPORTS'][normalize-space()='SPORTS']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@title='Show products in category SNEAKERS & SPORTS SHOES'][normalize-space()='SNEAKERS & SPORTS SHOES']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@id='quickviewprd_2909']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@title='Pink']//span[@class='attribute-square']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[normalize-space()='39']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='addtocart_2909_EnteredQuantity']")).clear();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='addtocart_2909_EnteredQuantity']")).sendKeys("1");
	Thread.sleep(5000);
	driver.findElement(By.id("add-to-cart-button-2909")).click();
	Thread.sleep(3000);
	

}
@Test(priority=5)

public static void viewCart() throws InterruptedException{
	driver.findElement(By.xpath("//button[normalize-space()='View Cart']")).click();
	Thread.sleep(3000);
	
	WebElement e2= driver.findElement(By.xpath("//a[contains(@class,'product-name')][contains(.,\"SPRINT Women's Flyknit Mesh Shoe\")]"));
    String s2 = e2.getText();
    
    if(s2.equalsIgnoreCase("SPRINT Women's Flyknit Mesh Shoe")) {
    	
    AssertJUnit.assertTrue(true);
    System.out.println(s2+" added in the cart successfully!");
    Thread.sleep(5000);
    }
    else {
    	AssertJUnit.assertTrue(false);
    	System.out.println(s2+" is not the product you added.");
    }

}

@Test(priority=6)

public static void removeCart() throws InterruptedException{
	driver.findElement(By.xpath("//td[@class='remove-from-cart']//span[contains(text(),'Remove')]")).click();
	Thread.sleep(1500);
	WebElement e1 = driver.findElement(By.xpath("//div[@class='no-data']"));
	Thread.sleep(1000);
	String s1 = e1.getText();
	if(s1.equalsIgnoreCase("Your Shopping Cart is empty!")) {
		AssertJUnit.assertTrue(true);
		System.out.println("Your cart has been emptied");
		
	}
	else {
		AssertJUnit.assertTrue(false);
		System.out.println("Your cart has not been emptied! Try again!");
	}
 
	
	

}

@Test(priority=7)
public static void searchProduct() throws InterruptedException{
	driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("sprint");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//input[@value='Search']")).click();
	
	
	
	driver.findElement(By.xpath("//a[@id='quickviewprd_3918']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@title='GREY']//span[@class='attribute-square']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[normalize-space()='30']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='addtocart_3918_EnteredQuantity']")).clear();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='addtocart_3918_EnteredQuantity']")).sendKeys("1");
	Thread.sleep(5000);
	driver.findElement(By.id("add-to-cart-button-3918")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//button[normalize-space()='View Cart']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//td[@class='remove-from-cart']//span[contains(text(),'Remove')]")).click();
	Thread.sleep(1500);
	
}

@AfterClass
public static void closeBrowser() {
	driver.close();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
