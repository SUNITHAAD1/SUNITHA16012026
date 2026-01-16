package WorkingOnTEstNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;

public class WorkingOnDataProviderwithAmazonApplTest {

	ExcelUtility elib = new ExcelUtility();

	@Test(dataProvider = "geDataforIPhone")
	public void getProductInfoTest(String BrandName, String ProductName) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("-incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName + Keys.ENTER);
		WebElement res = driver.findElement(By.xpath("//span[contains(text(),'" + ProductName
				+ "')]/../../../../../div/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]"));
		System.out.println("Product Name:   " + "Apple iPhone 14 Pro Max");
		System.out.println(" Price  		:" + res.getText());
		System.out.println("*********************");
	}

	@DataProvider
	
	public Object[][] geDataforIPhone() throws EncryptedDocumentException, IOException {
		int rowCount = elib.getRowCount("Product");

		Object[][] objArry = new Object[rowCount][2];
		System.out.println("rc:" + rowCount);
		for (int i = 0; i < rowCount; i++) {
			objArry[i][0] = elib.getDataFromXL("Product", i+1, 0);
			objArry[i][1] = elib.getDataFromXL("Product", i+1, 1);
		}
		return objArry;
	}

}
