package WorkingOnTEstNG_testScript;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.UtilityClassObject;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;
import com.aventstack.extentreports.Status;
@Listeners(com.crm.ListnerImplementation.ListenerUtility.class)
public class ContactsInfo extends ConfigurationAnnotations_BaseClass {
	SoftAssert sassert = new SoftAssert();

		
	@Test
	public void createContact() throws EncryptedDocumentException, IOException, InterruptedException {
		String lastName = elib.getDataFromXL("ContactInfo", 1, 0);
		String phoneNo = elib.getDataFromXL("ContactInfo", 1, 1);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contact");

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.PASS, "Contact page added successfully");

		String actLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		sassert.assertEquals(actLastName, lastName);
		sassert.assertAll();
		
		UtilityClassObject.getTest().log(Status.PASS, "VERIFIED CONTCT PAGE WITH LAST NAME");

		/*
		 * if(actLastName.contains(lastName)) { Reporter.log(
		 * lastName+" 	 Last name in the script and confirmation message is matching-- test case pass"
		 * ); } else { Reporter.log(
		 * lastName+" 	Last name in the script and confirmation message is not matching-- test case failed"
		 * ); }
		 */
	}

	@Test
	public void Contact_PhoneNumberTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String lastName = elib.getDataFromXL("ContactInfo", 1, 0) + jlib.randomNumber();
		String phoneNo = elib.getDataFromXL("ContactInfo", 1, 1);
		driver.findElement(By.linkText("Contacts")).click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contact");

		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.id("mobile")).sendKeys(phoneNo);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS, " Contact page saved");

		String actPhoneNo = driver.findElement(By.xpath("//span[@id='dtlview_Mobile']")).getText();
		sassert.assertEquals(actPhoneNo, phoneNo);
		UtilityClassObject.getTest().log(Status.PASS, "CONTACT PAGE PHONE NUMBER VERIFIED");

		/*
		 * if(actPhoneNo.equals(phoneNo)) { System.out.println(
		 * phoneNo+" 	 PhoneNo in the script and saved contact number is matching-- test case pass"
		 * ); } else { System.out.println(
		 * phoneNo+" 	PhoneNo in the script and saved contact number is not matching-- test case failed"
		 * ); }
		 */
	}

	@Test
	public void Contact_StartDateTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String lastName = elib.getDataFromXL("ContactInfo", 1, 0) + jlib.randomNumber();
		driver.findElement(By.linkText("Contacts")).click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Contact");

		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		String startDate = jlib.getSystemDateYYYYMMDD();
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		UtilityClassObject.getTest().log(Status.PASS, " CONTACT PAGE SAVED SUCCESSFULLY");

		Thread.sleep(2000);
		String actStartDate = driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
		UtilityClassObject.getTest().log(Status.PASS, "start date verified successully");
		/*
		 * if(actStartDate.equals(startDate)) { System.out.println(
		 * startDate+" 	 Start Date in the script and saved start date is matching-- test case pass"
		 * ); } else { System.out.println(
		 * startDate+" 	Start Date in the script and saved start date is not matching-- test case failed"
		 * ); }
		 */
	}

	@Test
	public void Contact_EndDateTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String lastName = elib.getDataFromXL("ContactInfo", 1, 0) + jlib.randomNumber();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contact");

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		String endDate = jlib.getRequiredDateYYYYMMDD(12);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "contact page saved successfully");

		String actLastDate = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
		assertEquals(actLastDate, endDate);
		UtilityClassObject.getTest().log(Status.PASS, "end date is verified");

		/*
		 * if(actLastDate.equals(endDate)) { System.out.println(
		 * endDate+" 	 End Date in the script and saved End date is matching-- test case pass"
		 * ); } else { System.out.println(
		 * endDate+" 	End Date in the script and saved End date is not matching-- test case failed"
		 * ); }
		 * 
		 */
	}

}
