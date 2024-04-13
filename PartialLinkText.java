package WebDriver_Pro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLinkText  
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","G:\\Software.testing\\vaishnavi_testing\\Selenium-GbPro\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("File:///G:\\NoonSelenium\\selenium_webdriver\\src\\com\\html\\index.html");
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("Here")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/a[2]")).click();
		Thread.sleep(2000);
		driver.close();
	}
}

