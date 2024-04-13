//W.a. TestNG program to perform test with webdriver to login process of facebook
package com.ng;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WebDriver_ng 
{
	WebDriver driver=null;
	@BeforeTest
	public void beforeLogin() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium830\\chromedriver-win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
	}
	
		@Test(priority=0)
		public void testUsername() throws InterruptedException
		{
			driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("vishak488@gmail.com");
			Thread.sleep(2000);
		}
		@Test(priority=1)
		public void testPassword() throws InterruptedException
		{
			driver.findElement(By.cssSelector("input[data-testid=\"royal_pass\"]")).sendKeys("vishk");
			Thread.sleep(2000);
		}
		@Test(priority=2)
		public void testLogin() throws InterruptedException
		{
			driver.findElement(By.cssSelector("_42ft_4jy0_6lth_4jy6_4jy1.selected_51sy")).click();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.facebook.com/login.html"))
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
