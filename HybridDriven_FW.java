package com.framework;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HybridDriven_FW 
{
	@DataProvider(name="vaishnavi")
	public Object[][] readExcel() throws InvalidFormatException, IOException
	{
		Object[][] data=null;
		
		File file=new File("G:\\Software testing\\vaishnavi_testing\\login.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);//to open the workbook means excel
		
		Sheet sheet=workbook.getSheet("Sheet3");//to  open the sheet 1 in the workbook
		
		int nrows=sheet.getPhysicalNumberOfRows();//to count how much row you have written
		System.out.println("Total no of rows are... "+nrows);
		
		data=new String[nrows][];//jagged array initialization
		
		for(int i=0;i<nrows;i++)//for row
		{
			Row row=sheet.getRow(i);//to select physical row
			
			int ncols=row.getPhysicalNumberOfCells();//to count how much cols upon particular row
			System.out.println("no of cols are..."+ncols);
			
			data[i]=new String[ncols];
			
			for(int j=0;j<ncols;j++)//for cols
			{
				Cell cols=row.getCell(j);//to select particular cell/column
				cols.setCellType(CellType.STRING);
				data[i][j]=cols.getStringCellValue();
			}
		}	
		return data;
	}
	WebDriver driver=null;
	@Test(dataProvider ="rahul")
	public void test() throws InterruptedException, InvalidFormatException, IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium830\\chromedriver-win32\\chromedriver.exe");
		if(keyword.equalsIgnoreCase("open browser"))
		{
			driver=new ChromeDriver();
		}
		else if(keyword.equalsIgnoreCase("enter url"))
		{
			driver.get("https://automationpractice.com/index.php");
			Thread.sleep(2000);
		}
		else if(keyword.equalsIgnoreCase("enter username"))
		{
			driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys(data);
			Thread.sleep(2000);
		}
		else if(keyword.equalsIgnoreCase("enter password"))
		{
			driver.findElement(By.cssSelector("input[data-test=\"password\"]")).sendKeys(data);
			Thread.sleep(2000);
		}
		else if(keyword.equalsIgnoreCase("click login"))
		{
			driver.findElement(By.cssSelector("input.submit-button.btn_action")).click();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://automationpractice.com/inventory.html"))
			{
				System.out.println("Your login Test has been passed...");
			}
			else 
			{
				System.out.println("Your login Test has been failed...");
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//screenshot taken
				File dest=new File("G:\\Software testing\\vaishnavi_testing\\Selenium SS\\failed.png");
				FileUtils.copyFile(src, dest);
				fail("invalid Username or Password");
			}
		}
		else if(keyword.equalsIgnoreCase("close browser"))
		{
		
			Thread.sleep(2000);
			System.out.println("Bye Bye...");
			driver.close();		
		}
	}	

}
