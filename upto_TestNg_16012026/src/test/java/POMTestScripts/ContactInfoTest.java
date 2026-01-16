package POMTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.JavaUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

import POM_PAGES.HomePage;
import POM_PAGES.LoginPage;
import POM_PAGES_CONTACTS.ContactPage;
import POM_PAGES_CONTACTS.savedContactPage;

public class ContactInfoTest {
public static void main(String[] args) throws InterruptedException, IOException {

	WebDriver driver;
	FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	
	String browser = flib.getDataFromPropertyFile("browser");
	String url = flib.getDataFromPropertyFile("url");
	String username = flib.getDataFromPropertyFile("username");
	String password = flib.getDataFromPropertyFile("password");
	String lastName = elib.getDataFromXL("ContactInfo", 1, 0)+"__"+jlib.randomNumber();
	String phoneNo = elib.getDataFromXL("ContactInfo", 1, 1);
	
	if(browser.equals("chrome")) 		{driver=new ChromeDriver();}
	else if(browser.equals("edge")) 	{driver=new EdgeDriver();}
	else if(browser.equals("safari")) 	{driver=new SafariDriver();}
	else driver=new ChromeDriver();
	driver.manage().window().maximize();
	wlib.waitForPageToLoad(driver);
	driver.get(url);
	
	LoginPage l=new LoginPage(driver);
	l.LoginToApp();
	HomePage h=new HomePage(driver);
	h.getContactsLink().click();
	ContactPage cp=new ContactPage(driver);
	
	cp.getCreate_Contact_Btn().click();
	cp.getLastName_TXT().sendKeys(lastName);
	cp.getMobile_no_TXT().sendKeys(phoneNo);

	String startDate = jlib.getSystemDateYYYYMMDD();
	String endDate = jlib.getRequiredDateYYYYMMDD(12);
	
	cp.getSupport_start_date_TXT().clear();
	cp.getSupport_start_date_TXT().sendKeys(startDate);
	cp.getSupport_end_date_TXT().clear();
	cp.getSupport_end_date_TXT().sendKeys(endDate);
	cp.getSave_Contact_Btn().click();
	
	Thread.sleep(2000);
	savedContactPage saveCont=new savedContactPage(driver);

	String actLastName = saveCont.getConfi_lastName().getText();
	String actPhoneNo = saveCont.getConfi_phoneNo().getText();
	String actStartDate = saveCont.getConfi_startDate().getText();
	String actLastDate = saveCont.getConfi_EndDate().getText();
	
			if(actLastName.contains(lastName))
				{	System.out.println(lastName+" 	 Last name in the script and confirmation message is matching-- test case pass");	}
				else
				{	System.out.println(lastName+" 	Last name in the script and confirmation message is not matching-- test case failed");	}
			
			if(actPhoneNo.equals(phoneNo))
				{	System.out.println(phoneNo+" 	 PhoneNo in the script and saved contact number is matching-- test case pass");	}
				else
				{	System.out.println(phoneNo+" 	PhoneNo in the script and saved contact number is not matching-- test case failed");	}
			
			if(actStartDate.equals(startDate))
				{	System.out.println(startDate+" 	 Start Date in the script and saved start date is matching-- test case pass");	}
				else
				{	System.out.println(startDate+" 	Start Date in the script and saved start date is not matching-- test case failed");	}

			if(actLastDate.equals(endDate))
				{	System.out.println(endDate+" 	 End Date in the script and saved End date is matching-- test case pass");	}
				else
				{	System.out.println(endDate+" 	End Date in the script and saved End date is not matching-- test case failed");	}
	Thread.sleep(5000);
	driver.quit();

}
}
