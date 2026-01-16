package WorkingOnTEstNG_testScript;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;

public class Opportunities extends ConfigurationAnnotations_BaseClass {
	
	@Test(enabled = true)
	public void createOpportunities_Failes_get() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String oppName = elib.getDataFromXL("Opportunity", 1, 0)+jlib.randomNumber();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(oppName);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		Thread.sleep(5000);
		String expectedURL = "module=Accounts";
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> it=allWin.iterator();
		while(it.hasNext())
		{	it.next();
			String actURL = driver.getCurrentUrl();
				if(expectedURL.contains(actURL))
					{			break;			}
		}
		System.out.println("Multiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		driver.findElement(By.xpath("//a[contains(text(),'Organization Name')]/../../..//a[contains(text(),'Tejas')]")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println(driver.switchTo().alert().getText());
	}
	@Test
	public void createOpportunity() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String oppName = elib.getDataFromXL("Opportunity", 1, 0)+jlib.randomNumber();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(oppName);
		WebElement sel = driver.findElement(By.id("related_to_type"));
		wlib.selectByIndex(sel, 1);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		Thread.sleep(5000);
		
		String expectedURL = "module=Potential";
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> it=allWin.iterator();
		while(it.hasNext())
		{	it.next();
			String actURL = driver.getCurrentUrl();
				if(expectedURL.contains(actURL))
					{			break;			}
		}
		System.out.println("Multiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		System.out.println("Title        :"+driver.getTitle());
		System.out.println("Current URL  :"+driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[contains(text(),'Organization Name')]/../../..//a[contains(text(),'Tejas')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Tejas')]")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
	}
		
	
	
}

