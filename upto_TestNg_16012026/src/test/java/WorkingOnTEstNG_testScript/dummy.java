package WorkingOnTEstNG_testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.Configuration_BaseClass;
@Listeners(com.crm.ListnerImplementation.DummyListener.class)
public class dummy extends  Configuration_BaseClass{
	WebDriver driver;

	@Test(groups = "SmokeTest")
	public void createContact() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String lastName = "sunitha1";
		String phoneNo = "123698547";

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		//UtilityClassObject.getTest().log(Status.PASS, "Contact page added successfully");

		String actLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		//sassert.assertEquals(actLastName, lastName);
		//sassert.assertAll();
		
		//UtilityClassObject.getTest().log(Status.PASS, "VERIFIED CONTCT PAGE WITH LAST NAME");


	}
}
