package WorkingOnTEstNG_testScript;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

public class QuickCreateTest extends ConfigurationAnnotations_BaseClass {

	@Test
public void Create_QuickCreateTest() throws InterruptedException
{
	 WebElement option1 = driver.findElement(By.id("qccombo"));
	driver.findElement(By.name("ship_street")).sendKeys("Vega city mall,  Bannerghatta Road, Bangalore");
	driver.findElement(By.name("website")).sendKeys("www.sunitha.com");
	driver.findElement(By.id("phone")).sendKeys("987654321");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.findElement(By.linkText("More Information")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("hide_Accounts_Contacts")).click();
	driver.findElement(By.xpath("//input[@title='Add Contact']")).click();
	
	driver.findElement(By.id("mobile")).sendKeys("8867495172");
	driver.findElement(By.name("lastname")).sendKeys("yyyyy");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
System.out.println("Data saved successfully");	
}
	
}
