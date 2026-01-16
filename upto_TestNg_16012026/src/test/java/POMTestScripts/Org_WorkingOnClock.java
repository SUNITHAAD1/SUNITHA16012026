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
import POM_PAGES_ORGANIZATION.Org_Page;
import POM_PAGES_ORGANIZATION.WorldClockPage;

public class Org_WorkingOnClock {
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
	op.getWorldClock().click();
	
	WorldClockPage wp=new WorldClockPage(driver);
	wlib.selectByValue(wp.getLocal_country_Dropdown(), "5.30");
	  String clocktext = wp.getDateinClock().getText();
	  clocktext.toUpperCase();
	  System.out.println(clocktext);
	  System.out.println("------");
	  Date dateObj=new Date();
	  SimpleDateFormat sim=new SimpleDateFormat("MMMM d, yyyy h:mm a");
	  String date = sim.format(dateObj);
	  date.toUpperCase();
	 System.out.println(date);
	 
	if(date.equalsIgnoreCase(clocktext))
	{	System.out.println("Date is matching =PASS test case");	}
		else
	{	System.out.println("Date is not matching =FAIL test case");	}
	
System.out.println("------------------------Other Working-----");	
SimpleDateFormat sim1=new SimpleDateFormat("MM/dd/yyyy'T'HH:mm:ss.SSS'Z'");
String date1 = sim1.format(dateObj);
System.out.println(date1);
	

wlib.selectByValue(wp.getLocal_country_Dropdown(), "-5");
String USATime = wp.getDateinClock().getText();
System.out.println("USA timing: "+USATime);




	
	Thread.sleep(2000);
	//driver.quit();
}
}
