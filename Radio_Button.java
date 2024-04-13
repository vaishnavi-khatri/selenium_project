// W.A.J. Script To perform the radio button to select one by one in loop
package WebDriver_Pro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_Button 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","G:\\Software.testing\\vaishnavi_testing\\Selenium-GbPro\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/radio.html");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[value='Option 1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Option 2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Option 3']")).click();
		Thread.sleep(2000);
		
		driver.close();
	}
}
	


