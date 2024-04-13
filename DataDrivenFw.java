//W.a.framework program for data driven framework
package com.framework;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenFw 
{
	@Test
	public static String[][] readExcel() throws InvalidFormatException, IOException
	{
		String[][] data=null;
		
		File file=new File("G:\\Software testing\\vaishnavi_testing\\login.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);//to open the workbook means excel
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");//to  open the sheet 1 in the workbook
		
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
	@Test
	public void test() throws InterruptedException, InvalidFormatException, IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium830\\chromedriver-win32\\chromedriver.exe");
		String[][] data=readExcel();
		for(int i=0;i<data.length;i++)
		{
			driver=new ChromeDriver();
			driver.get("https://accounts.google.com/");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys(data[i][0]);
			Thread.sleep(2000);
		
			driver.findElement(By.cssSelector("input[data-test=\"password\"]")).sendKeys(data[i][1]);
			Thread.sleep(2000);
		
			driver.findElement(By.cssSelector("rFrNMe.i79UJc.YKooDc.zKHdkd.sdJrJc.k0tWj.IYewr")).click();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://accounts.google.com.html"))
			{
				System.out.println("Your login Test has been passed...");
			}
			else 
			{
				System.out.println("Your login Test has been failed...");
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//screenshot taken


File dest=new File("G:\\Software testing\\vaishnavi_testing\\Selenium SS\\failed"+i+".png");
				FileUtils.copyFile(src, dest);
				fail("invalid Username or Password");
			}
		
			Thread.sleep(2000);
			System.out.println("Bye Bye...");
			driver.close();		
		}
	}	

}
