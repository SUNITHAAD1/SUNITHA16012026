package com.Comcast.Crm.Generic.OrgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.JavaUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

public class OrganizationTestSaveClickOnContactSearchOrgNameAndOperations {

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
		String shiiping_addr = elib.getDataFromXL("Organization", 1, 8);
		
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
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		/*
		 wlib.switchToTabonURL(driver, "action=Popup"); 
		Thread.sleep(4000);
		wlib.selectByContainsVisibleText(driver.findElement(By.xpath("//select[@class='txtBox']")), "Website");
		driver.findElement(By.xpath("(//tr[@class='lvtColData'])[1]/td/a[@id='1']")).sendKeys(Keys.ENTER);
		wlib.switchToAlertAndAccept(driver);
		*/
		driver.findElement(By.name("ship_street")).sendKeys(shiiping_addr);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		
		
		Thread.sleep(5000);
		driver.quit();
	}
}
