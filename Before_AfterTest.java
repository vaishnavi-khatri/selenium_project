//W.a. TestNG program to check gmail login using with @beforetest,@aftertest,@Test
package com.ng;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Before_AfterTest 
{
	WebDriver driver=null;
	@BeforeTest
	public void beforeLogin() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium830\\chromedriver-win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://accounts.google.com/");
		Thread.sleep(2000);
	}
	@Test(priority=0)
	public void testUsername() throws InterruptedException
	{
		driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys("vishakhatri4999@gmail.com");
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void testNext() throws InterruptedException
	{
		driver.findElement(By.cssSelector("VfPpkd-vQzf8d")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void testPassword() throws InterruptedException
	{
		driver.findElement(By.cssSelector("input[data-test=\"password\"]")).sendKeys("vaishnavi23");
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void testLogin() throws InterruptedException
	{
		driver.findElement(By.cssSelector("rFrNMe.i79UJc.YKooDc.zKHdkd.sdJrJc.k0tWj.IYewr")).click();
		Thread.sleep(2000);
	
	
		if(driver.getCurrentUrl().equals("https://accounts.google.com.html"))
		{
			System.out.println("Your login Test has been passed...");
		}
		else 
		{
			System.out.println("Your login Test has been failed...");
			fail("invalid Username or Password");
		}
	}
	@AfterTest
	public void afterlogin() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("Bye Bye...");
		driver.close();		
	}

}
