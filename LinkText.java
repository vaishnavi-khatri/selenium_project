//W.A.J.Script for Locating links by linkText() and partialLinkText()
package WebDriver_Pro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","G:\\Software.testing\\vaishnavi_testing\\Selenium-GbPro\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Forgotten password")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
