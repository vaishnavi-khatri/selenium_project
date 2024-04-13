//W.A.J.Script To use Mouse and Keyboard event using Action class
package WebDriver_Pro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Event 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Software.testing\\vaishnavi_testing\\Selenium-GbPro\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(2000);
		
		WebElement home=driver.findElement(By.linkText("Home"));
		WebElement flights=driver.findElement(By.linkText("Flights"));
		WebElement hotels=driver.findElement(By.linkText("Hotels"));
		
		Actions actions=new Actions(driver);
		Action a1=actions.moveToElement(home).build();// to make an event
		a1.perform();//to perform the event whatever you just build
		Thread.sleep(2000);
		
		Action a2=actions.moveToElement(flights).build();// to make an event
		a2.perform();//to perform the event whatever you just build
		Thread.sleep(2000);
		Action a3=actions.moveToElement(hotels).build();// to make an event
		a3.perform();//to perform the event whatever you just build
		Thread.sleep(2000);	
		driver.close();
	}
}
