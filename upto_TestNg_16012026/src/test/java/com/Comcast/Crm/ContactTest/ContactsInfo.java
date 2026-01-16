package com.Comcast.Crm.ContactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.JavaUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.UtilityClassObject;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;
import com.aventstack.extentreports.Status;
@Listeners(com.crm.ListnerImplementation.ListenerUtility.class)
public class ContactsInfo {
public static void main(String[] args) throws IOException, InterruptedException {

	UtilityClassObject.getTest().log(Status.INFO, "Read data from XL");
	WebDriver driver;
	FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	
	String browser = flib.getDataFromPropertyFile("browser");
	String url = flib.getDataFromPropertyFile("url");
	String username = flib.getDataFromPropertyFile("username");
	String password = flib.getDataFromPropertyFile("password");
	String lastName = elib.getDataFromXL("ContactInfo", 1, 0);
	String phoneNo = elib.getDataFromXL("ContactInfo", 1, 1);
	
	if(browser.equals("chrome")) 		{driver=new ChromeDriver();}
	else if(browser.equals("edge")) 	{driver=new EdgeDriver();}
	else if(browser.equals("safari")) 	{driver=new SafariDriver();}
	else driver=new ChromeDriver();
	driver.manage().window().maximize();
	wlib.pageToLoad(driver);
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(lastName);
	driver.findElement(By.id("mobile")).sendKeys(phoneNo);
	
	String startDate = jlib.getSystemDateYYYYMMDD();
	String endDate = jlib.getRequiredDateYYYYMMDD(12);
	
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	
			String actLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(actLastName.contains(lastName))
				{	System.out.println(lastName+" 	 Last name in the script and confirmation message is matching-- test case pass");	}
				else
				{	System.out.println(lastName+" 	Last name in the script and confirmation message is not matching-- test case failed");	}
			
	
			String actPhoneNo = driver.findElement(By.xpath("//span[@id='dtlview_Mobile']")).getText();
			if(actPhoneNo.equals(phoneNo))
				{	System.out.println(phoneNo+" 	 PhoneNo in the script and saved contact number is matching-- test case pass");	}
				else
				{	System.out.println(phoneNo+" 	PhoneNo in the script and saved contact number is not matching-- test case failed");	}

			String actStartDate = driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
			if(actStartDate.equals(startDate))
				{	System.out.println(startDate+" 	 Start Date in the script and saved start date is matching-- test case pass");	}
				else
				{	System.out.println(startDate+" 	Start Date in the script and saved start date is not matching-- test case failed");	}

			String actLastDate = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
				if(actLastDate.equals(endDate))
				{	System.out.println(endDate+" 	 End Date in the script and saved End date is matching-- test case pass");	}
				else
				{	System.out.println(endDate+" 	End Date in the script and saved End date is not matching-- test case failed");	}

			
		
			
			
			
	Thread.sleep(5000);
	driver.quit();
}
}
