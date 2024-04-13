package WebDriver_Pro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Software.testing\\vaishnavi_testing\\Selenium-GbPro\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		Thread.sleep(2000);
		
		driver.findElement(By.name("cusid")).sendKeys("53920");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		
		Alert a1=driver.switchTo().alert();
		System.out.println("Alert 1 message is.. "+a1.getText());
		//a1.dismiss();
		a1.accept();
		
		Thread.sleep(2000);
		
		Alert a2=driver.switchTo().alert();
		System.out.println("Alert 2 message is... "+a2.getText());
		a1.dismiss();
		//a2.accept();
		
		Thread.sleep(2000);
		driver.close();
		
	}

}
