package POMTestScripts;

import java.io.IOException;

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
import POM_PAGES_ORGANIZATION.Org_Find_Duplicates;
import POM_PAGES_ORGANIZATION.Org_Page;

public class Org__FindDuplicatesTest {
public static void main(String[] args) throws IOException, InterruptedException {
	
	WebDriver driver;
	FileUtility flib = new FileUtility();
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
	op.getFind_Duplicate_Btn().click();
	
	Org_Find_Duplicates dupl=new Org_Find_Duplicates(driver);
	
	wlib.selectByValue(dupl.getListOfFields1(), "1");
	wlib.selectByValue(dupl.getListOfFields1(), "2");
	wlib.selectByValue(dupl.getListOfFields1(), "3");
	
	dupl.getFindDuplicate_Btn().click();
	dupl.getgo_back_ArrowMark().click();
	dupl.getSelect_All_Records_Page().click();
	dupl.getDelete_Btn().click();
	System.out.println("Data deleted successfully...........");
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	Thread.sleep(5000);
	//driver.quit();

}
}
