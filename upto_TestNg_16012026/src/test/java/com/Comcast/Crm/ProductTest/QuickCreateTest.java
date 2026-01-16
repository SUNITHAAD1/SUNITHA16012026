package com.Comcast.Crm.ProductTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class QuickCreateTest {
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
	
	
	if (browser.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (browser.equals("edge")) {
		driver = new EdgeDriver();
	} else if (browser.equals("safari")) {
		driver = new SafariDriver();
	} else
		driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	 WebElement option1 = driver.findElement(By.id("qccombo"));
	
	Select s=new Select(option1);
	s.selectByValue("Accounts");
	/*
	wlib.selectByContainsVisibleText(driver.findElement(By.id("qccombo")), "New Organization");
	
	*/driver.findElement(By.name("accountname")).sendKeys(OrgName);
	driver.findElement(By.name("ship_street")).sendKeys("Vega city mall,  Bannerghatta Road, Bangalore");
	driver.findElement(By.name("website")).sendKeys("www.sunitha.com");
	driver.findElement(By.id("phone")).sendKeys("987654321");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.findElement(By.linkText("More Information")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("hide_Accounts_Contacts")).click();
	driver.findElement(By.xpath("//input[@title='Add Contact']")).click();
	
	driver.findElement(By.id("mobile")).sendKeys("8867495172");
	driver.findElement(By.name("lastname")).sendKeys("yyyyy");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	
	
	
	
	
	
	
	
	
	
	
	
	Thread.sleep(5000);
	driver.quit();
	
	
	
	
	
}
}
