package POMTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

import POM_PAGES.HomePage;
import POM_PAGES.LoginPage;
import POM_PAGES_ORGANIZATION.Org_Chats;
import POM_PAGES_ORGANIZATION.Org_Page;

public class WorkingOnChats {
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
	Org_Chats oc=new Org_Chats(driver);
	oc.getchatLink().click();
	wlib.switchToTabonURL(driver, "Org_Chats");
	oc.getAdminLink().click();
	
	oc.getChatmsg().sendKeys("hi,I like to chat with you..."+Keys.TAB.ENTER);
	
	/*
	  driver.findElement(By.xpath("//a[text()='admin']")).click();
	 
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@class='cinput'])[2]")).sendKeys("hi,I like to chat with you..."+Keys.TAB.ENTER);
	driver.findElement(By.xpath("(//input[@class='cinput'])[2]")).sendKeys("hi,I like to chat with you secon msg..."+Keys.TAB.ENTER);
	
	*/
	
	
	
	
	
	
	
	
	
	
	
}
}
