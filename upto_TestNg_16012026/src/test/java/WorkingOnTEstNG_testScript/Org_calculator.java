package WorkingOnTEstNG_testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

public class Org_calculator extends ConfigurationAnnotations_BaseClass {
public static void main(String[] args) throws IOException {
	
	WebDriver driver;
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	String browser = flib.getDataFromPropertyFile("browser");
	String url = flib.getDataFromPropertyFile("url");
	String username = flib.getDataFromPropertyFile("username");
	String password = flib.getDataFromPropertyFile("password");
	String zero = elib.getDataFromXL("Org_Calculator", 1, 0);
	String one = elib.getDataFromXL("Org_Calculator", 2, 0 );
	String two = elib.getDataFromXL("Org_Calculator", 3, 0);
	String three = elib.getDataFromXL("Org_Calculator", 4, 0);
	String four = elib.getDataFromXL("Org_Calculator", 5, 0);
	String five = elib.getDataFromXL("Org_Calculator", 6, 0);
	String six = elib.getDataFromXL("Org_Calculator", 7, 0);
	String seven = elib.getDataFromXL("Org_Calculator", 8, 0);
	String eight = elib.getDataFromXL("Org_Calculator", 9, 0);
	String nine = elib.getDataFromXL("Org_Calculator", 10, 0);
	String ten = elib.getDataFromXL("Org_Calculator", 11, 0);
	
	
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
	
}
}
