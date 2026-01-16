package WorkingOnTEstNG_testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class ProductsVtiger extends ConfigurationAnnotations_BaseClass 
{
	@Test
	public void createProduct() throws EncryptedDocumentException, IOException, InterruptedException
	{
	String ProdName = elib.getDataFromXL("Products", 1, 0)+jlib.randomNumber();
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(ProdName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String actValue = driver.findElement(By.className("lvtHeaderText")).getText();
	if(actValue.contains(ProdName))
	{	System.out.println(ProdName+"  Product name script is saved and Test case is pass");}
	else 
	{	System.out.println(ProdName+"  Product name script is not saved and Test case is FAIL");}
		Thread.sleep(5000);
	}
	@Test
	public void Product_MassEditingInList() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String ProdName = elib.getDataFromXL("Products", 1, 0)+jlib.randomNumber();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(ProdName);
		wlib.selectByIndex(driver.findElement(By.name("productcategory")), 3);
		String todayDate=jlib.getSystemDateYYYYMMDD(); 
		String nextRequiredDate =jlib.getRequiredDateYYYYMMDD(10);
		driver.findElement(By.name("sales_start_date")).clear();
		driver.findElement(By.name("sales_start_date")).sendKeys(todayDate);
		driver.findElement(By.name("sales_end_date")).clear();
		driver.findElement(By.name("sales_end_date")).sendKeys(nextRequiredDate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actValue = driver.findElement(By.className("lvtHeaderText")).getText();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.id("selectCurrentPageRec")).click();
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ProdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.id("selectCurrentPageRec")).click();
		String prodEdited = driver.findElement(By.xpath("//tr[contains(@id,'row_')]/td[1]")).getText();
		if(ProdName.contains(prodEdited))
		{		System.out.println("Mass editing data in the list is done");	}
		else
		{		System.out.println("Mass edited is not done");			}
		Thread.sleep(5000);

	}
	@Test
	public void Product_DeleteEditingInList() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String ProdName = elib.getDataFromXL("Products", 1, 0)+jlib.randomNumber();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(ProdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.id("selectCurrentPageRec")).click();
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ProdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.id("selectCurrentPageRec")).click();
		String prodEdited = driver.findElement(By.xpath("//tr[contains(@id,'row_')]/td[1]")).getText();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		System.out.println("Alert Msg-----"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		if(ProdName.contains(prodEdited))
		{		System.out.println("Mass delete script is pass");	}
		else
		{		System.out.println("Mass delete script is failed");			}
		Thread.sleep(5000);

	}
	
}
