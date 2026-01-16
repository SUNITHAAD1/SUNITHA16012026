package POMTestScripts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

import POM_PAGES.HomePage;
import POM_PAGES.LoginPage;
import POM_PAGES_ORGANIZATION.Org_Info_Page;
import POM_PAGES_ORGANIZATION.Org_Page;
import POM_PAGES_ORGANIZATION.Org_calendar_Page;
import POM_PAGES_ORGANIZATION.SavedOrganization_Page;

public class Org_calendar_WOrking {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver;
	FileUtility flib = new FileUtility();
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib = new WebDriverUtility();

	String browser = flib.getDataFromPropertyFile("browser");
	String url = flib.getDataFromPropertyFile("url");
	String username = flib.getDataFromPropertyFile("username");
	String password = flib.getDataFromPropertyFile("password");
	String OrgName = elib.getDataFromXL("Organization", 1, 0) + jlib.getAlphaNumString();
	String billing_addr = elib.getDataFromXL("Organization", 1, 8);
	if (browser.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (browser.equals("edge")) {
		driver = new EdgeDriver();
	} else if (browser.equals("safari")) {
		driver = new SafariDriver();
	} else
		driver = new ChromeDriver();

	wlib.waitForPageToLoad(driver);
	driver.get(url);
	LoginPage l = new LoginPage(driver);
	l.LoginToApp();
	HomePage h = new HomePage(driver);
	h.getOrganizationsLink().click();
	Org_Page op=new Org_Page(driver);
	op.getCreate_Org_Btn().click();
	Org_Info_Page info=new Org_Info_Page(driver);
	info.getOrg_name_TXT().sendKeys(OrgName);
	info.getBillindg_Addr_TXT().sendKeys(billing_addr);
	info.getShipping_addr_TXT().sendKeys(billing_addr);
	info.getSave_Org_Btn().click();
	
	SavedOrganization_Page saveOrgPage=new SavedOrganization_Page(driver);
	String savedOrgNameAndNumber = saveOrgPage.getOrg_confi_TXT().getText();
	
	if (savedOrgNameAndNumber.contains(OrgName)) {
		System.out.println("Organization Name script is matching & test case is pass");
	} else {
		System.out.println("--Organization Name script is not matching & test case is failed");
	}
	
	String createdTime = saveOrgPage.getCreatedTime().getText().trim();
	//2025-12-24 06:40:21
	System.out.println("Org created date: "+createdTime);
	
	op.getOpenCalendar_org().click();
	Org_calendar_Page cal=new Org_calendar_Page(driver);
	System.out.println(cal.getMonthAndYear().getText());
	System.out.println(cal.getDate().getText());
	
	
	
	Thread.sleep(5000);
	//driver.quit();

}
}
