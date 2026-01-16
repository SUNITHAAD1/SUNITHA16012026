package POMTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

import POM_PAGES.HomePage;
import POM_PAGES.LoginPage;
import POM_PAGES_PRODUCT.DeleteProductPage;
import POM_PAGES_PRODUCT.NewProductPage;
import POM_PAGES_PRODUCT.Prod_Edit_page;
import POM_PAGES_PRODUCT.SavedProductPage;

public class ProductInfoTest {
public static void main(String[] args) throws IOException, InterruptedException {

	WebDriver driver;
	
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	String browser = flib.getDataFromPropertyFile("browser");
	String url = flib.getDataFromPropertyFile("url");
	String username = flib.getDataFromPropertyFile("username");
	String password = flib.getDataFromPropertyFile("password");
	String ProdName = elib.getDataFromXL("Products", 1, 0)+jlib.getAlphaNumString();
	
	
	if (browser.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (browser.equals("edge")) {
		driver = new EdgeDriver();
	} else if (browser.equals("safari")) {
		driver = new SafariDriver();
	} else
		driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	LoginPage l=new LoginPage(driver);
	l.LoginToApp();
	HomePage h=new HomePage(driver);
	h.getProductsLink().click();
	NewProductPage np=new NewProductPage(driver);
	np.getCreate_Product_Btn().click();
	np.getProduct_name_TXT().sendKeys(ProdName);
	wlib.selectByIndex(np.getProduct_category_TXT(),3);
	
	String todayDate=jlib.getSystemDateYYYYMMDD(); 
	String nextRequiredDate =jlib.getRequiredDateYYYYMMDD(10);
	np.getP_sales_start_date().clear();
	np.getP_sales_start_date().sendKeys(todayDate);
	np.getP_sales_end_date().clear();
	np.getP_sales_end_date().sendKeys(nextRequiredDate);
	np.getSave_Product_Btn().click();
	
	SavedProductPage saveProd_Page=new SavedProductPage(driver);
 System.out.println(saveProd_Page.getSavedProduct_confirm_page().getText());
 String actValue =saveProd_Page.getProducts_TXT().getText();
	
	if(actValue.contains(ProdName))
	{	System.out.println(ProdName+"  Product name script is saved and Test case is pass");}
	else 
	{	System.out.println(ProdName+"  Product name script is not saved and Test case is FAIL");}
	Thread.sleep(2000);
	saveProd_Page.getSelectCurrentPageRec_CheckBox();
	saveProd_Page.getMassEdit_Btn();
	Thread.sleep(3000);
	
	Prod_Edit_page prodEdit=new Prod_Edit_page(driver);
	
	/*
	 *driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String actValue = driver.findElement(By.className("lvtHeaderText")).getText();
	if(actValue.contains(ProdName))
	{	System.out.println(ProdName+"  Product name script is saved and Test case is pass");}
	else 
	{	System.out.println(ProdName+"  Product name script is not saved and Test case is FAIL");}
	
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.id("selectCurrentPageRec")).click();
	driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
	
	 */
	Thread.sleep(2000);
	prodEdit.getPprod_name().sendKeys(ProdName);
	prodEdit.getProd_save_page().click();
	prodEdit.getCurrentRecord().click();
	String prodEdited =prodEdit.getProd_First_Ele_sel().getText();
	
	if(ProdName.contains(prodEdited))
	{		System.out.println("Mass editing data in the list is done");	}
	else
	{		System.out.println("Mass edited is not done");			}
	
	DeleteProductPage delProd=new DeleteProductPage(driver);
	delProd.getDeleteProduct().click();
	System.out.println("Alert Msg-----"+driver.switchTo().alert().getText());
	
	driver.switchTo().alert().accept();
	if(ProdName.contains(prodEdited))
		{		System.out.println("Mass delete script is pass");	}
		else
		{		System.out.println("Mass delete script is failed");			}
	
	
	
	Thread.sleep(5000);
	driver.quit();

}
}
