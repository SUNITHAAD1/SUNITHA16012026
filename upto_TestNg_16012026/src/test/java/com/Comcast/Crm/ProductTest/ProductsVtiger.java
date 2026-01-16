package com.Comcast.Crm.ProductTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.JavaUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

public class ProductsVtiger {
public static void main(String[] args) throws IOException, InterruptedException {
	
	WebDriver driver;
	
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	String browser = flib.getDataFromPropertyFile("browser");
	String url = flib.getDataFromPropertyFile("url");
	String username = flib.getDataFromPropertyFile("username");
	String password = flib.getDataFromPropertyFile("password");
	String ProdName = elib.getDataFromXL("Products", 1, 0)+jlib.randomNumber();
	
	
	if (browser.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (browser.equals("edge")) {
		driver = new EdgeDriver();
	} else if (browser.equals("safari")) {
		driver = new SafariDriver();
	} else
		driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(ProdName);
	wlib.selectByIndex(driver.findElement(By.name("productcategory")), 3);
	
	String todayDate=jlib.getSystemDateYYYYMMDD(); 
	String nextRequiredDate =jlib.getRequiredDateYYYYMMDD(10);
			
	driver.findElement(By.name("sales_start_date")).clear();
	driver.findElement(By.name("sales_start_date")).sendKeys(todayDate);
	driver.findElement(By.name("sales_end_date")).clear();
	driver.findElement(By.name("sales_end_date")).sendKeys(nextRequiredDate);
	
	//driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img")).click();
	//driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(ProdName+Keys.ENTER);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String actValue = driver.findElement(By.className("lvtHeaderText")).getText();
	if(actValue.contains(ProdName))
	{	System.out.println(ProdName+"  Product name script is saved and Test case is pass");}
	else 
	{	System.out.println(ProdName+"  Product name script is not saved and Test case is FAIL");}
	
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.id("selectCurrentPageRec")).click();
	driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ProdName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	driver.findElement(By.id("selectCurrentPageRec")).click();
	String prodEdited = driver.findElement(By.xpath("//tr[contains(@id,'row_')]/td[1]")).getText();
	if(ProdName.contains(prodEdited))
	{		System.out.println("Mass editing data in the list is done");	}
	else
	{		System.out.println("Mass edited is not done");			}
	
	driver.findElement(By.xpath("//input[@value='Delete']")).click();
	System.out.println("Alert Msg-----"+driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	if(ProdName.contains(prodEdited))
	{		System.out.println("Mass delete script is pass");	}
	else
	{		System.out.println("Mass delete script is failed");			}
	
	
	
	Thread.sleep(5000);
	driver.quit();
	
}
}
