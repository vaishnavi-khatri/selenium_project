//W.A.J. script to use different methods to manage the windows-alerts and pop ups.
package WebDriver_Pro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alert_popup 
{
	public static void main(String[] args) 
	{
    
		System.setProperty("webdriver.chrome.driver","G:\\Software.testing\\vaishnavi_testing\\Selenium-GbPro\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Navigate to a demo site (e.g., Guru99)
        driver.get("https://demo.guru99.com/test/delete_customer.php");// Enter customer ID
        driver.findElement(By.name("cusid")).sendKeys("53920");// Submit the form
        driver.findElement(By.name("submit")).submit();// Handle the alert
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("Alert message: " + alertMessage);// Accept the alert (click OK)
        alert.accept();// Close the browser
        driver.quit();
	}
}


