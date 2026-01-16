package WorkingOnTEstNG_testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.JavaUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

public class Org_Attach_existing_Org {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
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
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	driver.findElement(By.xpath("(//*[contains(text(),'Facebook_')])[1]")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.name("bill_street")).sendKeys(billing_addr);
	driver.findElement(By.name("ship_street")).sendKeys(billing_addr);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String savedOrgNameAndNumber = driver.findElement(By.className("dvHeaderText")).getText();
	String savedOrgNumber = driver.findElement(By.className("dvtCellInfo")).getText();
	
	if(savedOrgNameAndNumber.contains(OrgName))
	{		System.out.println("Organization Name script is matching & test case is pass");		}	 
	else	
	{		System.out.println("--Organization Name script is not matching & test case is failed");		}	
	
	driver.quit();
}
}