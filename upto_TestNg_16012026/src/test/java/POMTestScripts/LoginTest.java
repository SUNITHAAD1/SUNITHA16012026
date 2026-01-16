package POMTestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

import POM_IMPLEMENTATION.LoginPage;

public class LoginTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		
		FileUtility flib=new FileUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		String browser = flib.getDataFromPropertyFile("browser");
		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");
		
		if(browser.equals("chrome")) 		{driver=new ChromeDriver();}
		else if(browser.equals("edge")) 	{driver=new EdgeDriver();}
		else if(browser.equals("safari")) 	{driver=new SafariDriver();}
		else driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setUnTBX("admin");
		l.setPwdTBX("admin");
		l.setLoginBtn();
		
		Thread.sleep(5000);
		//driver.quit();
	}

}
