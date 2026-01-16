package POMTestScripts;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
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
import POM_PAGES_ORGANIZATION.Org_CalculatorPage;
import POM_PAGES_ORGANIZATION.Org_Page;

public class Org_CalculatorTest {

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
		op.getOpenCalculator().click();
		Org_CalculatorPage oc=new Org_CalculatorPage(driver);
		 oc.getFive().click();
		 oc.getAdd().click();
		 oc.getSeven().click();
		 oc.getEqual().click();
			 
		   
		String res = oc.getCalculatorResult().getAttribute("value");
		
		System.out.println("operation Result :"+res);// it is in multiple places unable to locate
		Thread.sleep(5000);
		
	Thread.sleep(3000);
	driver.quit();
	}
	
}
