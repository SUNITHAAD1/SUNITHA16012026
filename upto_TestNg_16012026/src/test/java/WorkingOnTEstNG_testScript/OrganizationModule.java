package WorkingOnTEstNG_testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.JavaUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

@Listeners(com.crm.ListnerImplementation.ListenerUtility.class)
public class OrganizationModule extends ConfigurationAnnotations_BaseClass {
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	@Test
public void createOrganization() throws InterruptedException, EncryptedDocumentException, IOException
{
	String OrgName = elib.getDataFromXL("Organization", 1, 0)+jlib.randomNumber();
	String billing_addr = elib.getDataFromXL("Organization", 1, 8);
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
	driver.findElement(By.name("bill_street")).sendKeys(billing_addr);
	driver.findElement(By.name("ship_street")).sendKeys(billing_addr);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String savedOrgNameAndNumber = driver.findElement(By.className("dvHeaderText")).getText();
	if(savedOrgNameAndNumber.equals(OrgName))
	{		System.out.println("Organization name is matching & test case is pass");		}	 
	else	
	{		System.out.println("--Organization name is not matching & test case is failed");		}	
		
	Thread.sleep(5000);
	}
	@Test
	public void Org_WebSiteTest() throws EncryptedDocumentException, IOException
	{
		String OrgName = elib.getDataFromXL("Organization", 1, 0)+jlib.randomNumber();
		String website = elib.getDataFromXL("Organization", 1, 1);
		String billing_addr = elib.getDataFromXL("Organization", 1, 8);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.name("website")).sendKeys(website);
		driver.findElement(By.name("bill_street")).sendKeys(billing_addr);
		driver.findElement(By.name("ship_street")).sendKeys(billing_addr);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String savedWebsiteName = driver.findElement(By.xpath("//span[@id='dtlview_Website']")).getText();
		if(savedWebsiteName.contains(website))
		{		System.out.println("Organization website name  is matching & test case is pass");		}	 
		else	
		{		System.out.println("--Organization website name is not matching & test case is failed");		}	
		
	}
	@Test
	public void Org_IndustryNameTest() throws EncryptedDocumentException, IOException
	{
		String OrgName = elib.getDataFromXL("Organization", 1, 0)+jlib.randomNumber();
		String industry =elib.getDataFromXL("Organization", 1, 4);
		String billing_addr = elib.getDataFromXL("Organization", 1, 8);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		wlib.selectByValue(driver.findElement(By.name("industry")), "Education");
		driver.findElement(By.name("bill_street")).sendKeys(billing_addr);
		driver.findElement(By.name("ship_street")).sendKeys(billing_addr);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String savedIndustry = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
		if(savedIndustry.equals(industry))
		{		System.out.println("Organization Industry name  is matching & test case is pass");		}	 
		else	
		{		System.out.println("--Organization Industry name  is not matching & test case is failed");		}	
		
	}

	@Test
	public void Org_TypeTest() throws EncryptedDocumentException, IOException
	{
		String OrgName = elib.getDataFromXL("Organization", 1, 0)+jlib.randomNumber();
		String type =elib.getDataFromXL("Organization", 1, 5);
		String billing_addr = elib.getDataFromXL("Organization", 1, 8);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		wlib.selectByValue(driver.findElement(By.name("accounttype")), "Press");
		driver.findElement(By.name("bill_street")).sendKeys(billing_addr);
		driver.findElement(By.name("ship_street")).sendKeys(billing_addr);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String savedType = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
		
		if(savedType.equals(type))
		{		System.out.println("Organization Type name  is matching & test case is pass");		}	 
		else	
		{		System.out.println("--Organization Type name  is not matching & test case is failed");		}	
		
	}
	
	@Test
	public void Org_PhoneNumberTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String OrgName = elib.getDataFromXL("Organization", 1, 0)+jlib.randomNumber();
		String PhoneNo = elib.getDataFromXL("Organization", 1, 6);
		String annual_revenue = elib.getDataFromXL("Organization", 1, 7);
		String billing_addr = elib.getDataFromXL("Organization", 1, 8);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.name("bill_street")).sendKeys(billing_addr);
		driver.findElement(By.name("ship_street")).sendKeys(billing_addr);
		driver.findElement(By.id("phone")).sendKeys(PhoneNo);
		driver.findElement(By.name("annual_revenue")).sendKeys(annual_revenue);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String savedPhoneNo = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		if(savedPhoneNo.equals(PhoneNo))
		{		System.out.println("Organization phone number is matching & test case is pass");		}	 
		else	
		{		System.out.println("--Organization phone number is not matching & test case is failed");		}	
		Thread.sleep(5000);
	}
	
	@Test
	public void Org_AnnualRevenueTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String OrgName = elib.getDataFromXL("Organization", 1, 0)+jlib.randomNumber();
		String annual_revenue = elib.getDataFromXL("Organization", 1, 7);
		String billing_addr = elib.getDataFromXL("Organization", 1, 8);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.name("bill_street")).sendKeys(billing_addr);
		driver.findElement(By.name("ship_street")).sendKeys(billing_addr);
		driver.findElement(By.name("annual_revenue")).sendKeys(annual_revenue);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String savedAnnual_revenue = driver.findElement(By.xpath("//span[@id='dtlview_Annual Revenue']")).getText().replace(",", "");
				if(savedAnnual_revenue.equals(annual_revenue))
		{		System.out.println("Organization annual revenue is matching & test case is pass");		}	 
		else	
		{		System.out.println("--Organization annual revenue is not matching & test case is failed");		}	
			
			Thread.sleep(5000);
		}
}
