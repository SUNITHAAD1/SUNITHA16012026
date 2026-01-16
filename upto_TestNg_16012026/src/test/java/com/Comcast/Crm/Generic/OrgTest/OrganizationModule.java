package com.Comcast.Crm.Generic.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
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

public class OrganizationModule {
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
	String OrgName = elib.getDataFromXL("Organization", 1, 0)+jlib.randomNumber();
	String website = elib.getDataFromXL("Organization", 1, 1);
	String employee = elib.getDataFromXL("Organization", 1, 2);
	String email = elib.getDataFromXL("Organization", 1, 3);
	String industry =elib.getDataFromXL("Organization", 1, 4);
	String type =elib.getDataFromXL("Organization", 1, 5);
	String PhoneNo = elib.getDataFromXL("Organization", 1, 6);
	String annual_revenue = elib.getDataFromXL("Organization", 1, 7);
	String billing_addr = elib.getDataFromXL("Organization", 1, 8);
	
	if(browser.equals("chrome")) 		{driver=new ChromeDriver();}
	else if(browser.equals("edge")) 	{driver=new EdgeDriver();}
	else if(browser.equals("safari")) 	{driver=new SafariDriver();}
	else driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	wlib.waitForPageToLoad(driver);
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
		//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	//driver.findElement(By.xpath("//a[@id='1']")).sendKeys(Keys.ENTER);
	//wlib.switchToAlertAndAccept(driver);
	//driver.findElement(By.id("email2")).sendKeys(email);
	driver.findElement(By.name("website")).sendKeys(website);
	wlib.selectByValue(driver.findElement(By.name("industry")), "Education");
	wlib.selectByValue(driver.findElement(By.name("accounttype")), "Press");
	driver.findElement(By.name("bill_street")).sendKeys(billing_addr);
	driver.findElement(By.name("ship_street")).sendKeys(billing_addr);
	driver.findElement(By.id("phone")).sendKeys(PhoneNo);
	driver.findElement(By.name("annual_revenue")).sendKeys(annual_revenue);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String savedOrgNameAndNumber = driver.findElement(By.className("dvHeaderText")).getText();
	String savedOrgNumber = driver.findElement(By.className("dvtCellInfo")).getText();
	String savedWebsiteName = driver.findElement(By.xpath("//span[@id='dtlview_Website']")).getText();
	String savedIndustry = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
	String savedType = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
	String savedPhoneNo = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
	String savedAnnual_revenue = driver.findElement(By.xpath("//span[@id='dtlview_Annual Revenue']")).getText().replace(",", "");
	
	if(savedOrgNameAndNumber.contains(OrgName))
	{		System.out.println("Organization Name script is matching & test case is pass");		}	 
	else	
	{		System.out.println("--Organization Name script is not matching & test case is failed");		}	
	
	
	if(savedWebsiteName.contains(website))
	{		System.out.println("Organization website name  is matching & test case is pass");		}	 
	else	
	{		System.out.println("--Organization website name is not matching & test case is failed");		}	
	
	if(savedIndustry.equals(industry))
	{		System.out.println("Organization Industry name  is matching & test case is pass");		}	 
	else	
	{		System.out.println("--Organization Industry name  is not matching & test case is failed");		}	
	
	if(savedType.equals(type))
	{		System.out.println("Organization Type name  is matching & test case is pass");		}	 
	else	
	{		System.out.println("--Organization Type name  is not matching & test case is failed");		}	
	
	if(savedPhoneNo.equals(PhoneNo))
	{		System.out.println("Organization phone number is matching & test case is pass");		}	 
	else	
	{		System.out.println("--Organization phone number is not matching & test case is failed");		}	

	if(savedAnnual_revenue.equals(annual_revenue))
	{		System.out.println("Organization annual revenue is matching & test case is pass");		}	 
	else	
	{		System.out.println("--Organization annual revenue is not matching & test case is failed");		}	
		



Thread.sleep(5000);
driver.quit();
}
}
