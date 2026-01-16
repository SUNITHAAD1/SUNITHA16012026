package com.Comcast.Crm.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Comcast.Crm.Generic.DatabaseUtility.DatabaseUtility;
import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.JavaUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.UtilityClassObject;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

public class ConfigurationAnnotations_BaseClass {
	public static WebDriver sdriver;
	
	public WebDriver driver;
	public DatabaseUtility dlib=new DatabaseUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	

@BeforeSuite
public void beforeSuiteMethod()
{
	System.out.println("Before Suite Configuation Annotation executed");
}

@BeforeTest
public void beforeTestMethod() throws IOException
{
	
	
	FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String url = p.getProperty("url");
		
		if(browser.equals("chrome")) {			driver = new ChromeDriver();	} 
		else if (browser.equals("edge")) {		driver = new EdgeDriver();		}
		else if (browser.equals("safari")) {	driver = new SafariDriver();	} 
		else	driver = new ChromeDriver();
	sdriver=driver;
	//driver=UtilityClassObject.setDriver(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
}

@BeforeClass
public void beforeClassMethod()
{	
	

	System.out.println("Before Class Configuation Annotation executed");
}
@BeforeMethod
public void beforeMethod()
{
	System.out.println("Before Method Configuation Annotation executed");
}


@AfterMethod
public void afterMethod()
{
	
	System.out.println("After Method Configuation Annotation executed");
}

@AfterClass
public void afterclassMethod()
{	driver.quit();
	System.out.println("After Class Configuation Annotation executed");
}
@AfterTest
public void afterTestMethod()
{	
		
	System.out.println("After Test Configuation Annotation executed");
}
@AfterSuite
public void afterSuiteMethod()
{
	System.out.println("After Suite Configuation Annotation executed");
}


	
	
}
