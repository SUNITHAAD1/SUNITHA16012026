package POMTestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Comcast.Crm.Generic.FileUtility.ExcelUtility;
import com.Comcast.Crm.Generic.FileUtility.FileUtility;
import com.Comcast.Crm.Generic.JavaUtility.JavaUtility;
import com.Comcast.Crm.Generic.WebDriverUtility.WebDriverUtility;

import POM_PAGES.HomePage;
import POM_PAGES.LoginPage;
import POM_PAGES_ORGANIZATION.Org_Info_Page;
import POM_PAGES_ORGANIZATION.Org_Page;
import POM_PAGES_ORGANIZATION.SavedOrganization_Page;


public class createNewOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String browser = flib.getDataFromPropertyFile("browser");
		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");
		String OrgName = elib.getDataFromXL("Organization", 1, 0) + jlib.randomNumber();
		String website = elib.getDataFromXL("Organization", 1, 1);
		String employee = elib.getDataFromXL("Organization", 1, 2);
		String email = elib.getDataFromXL("Organization", 1, 3);
		String industry = elib.getDataFromXL("Organization", 1, 4);
		String type = elib.getDataFromXL("Organization", 1, 5);
		String PhoneNo = elib.getDataFromXL("Organization", 1, 6);
		String annual_revenue = elib.getDataFromXL("Organization", 1, 7);
		String billing_addr = elib.getDataFromXL("Organization", 1, 8);

		
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else
			driver = new ChromeDriver();

		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		driver.get(url);
		LoginPage l = new LoginPage(driver);
		l.LoginToApp();
		HomePage h = new HomePage(driver);
		h.getOrganizationsLink().click();
		Org_Page op=new Org_Page(driver);
		op.getCreate_Org_Btn().click();
		Org_Info_Page info=new Org_Info_Page(driver);
		info.getOrg_name_TXT().sendKeys(OrgName);
		info.getWebsite_name_TXT().sendKeys(website);
		wlib.selectByValue(info.getIndustry_Dropdown(), "Education");
		Thread.sleep(2000);
		wlib.selectByValue(info.getType_Dropdown(), "Press");
		info.getBillindg_Addr_TXT().sendKeys(billing_addr);
		info.getShipping_addr_TXT().sendKeys(billing_addr);
		info.getPhone_TXT().sendKeys(PhoneNo);
		info.getAnnual_revenue_TXT().sendKeys(annual_revenue);
		info.getSave_Org_Btn().click();
		
		SavedOrganization_Page saveOrgPage=new SavedOrganization_Page(driver);
		String savedOrgNameAndNumber = saveOrgPage.getOrg_confi_TXT().getText();
		String savedAnnual_revenue = saveOrgPage.getSaved_annual_revenue().getText().replaceAll(",", "");
		String saved_industry_name_dropdown = saveOrgPage.getSaved_industry_name_dropdown().getText();
		String savedPhoneNo = saveOrgPage.getSaved_phone_number().getText();
		String saved_type_dropdown = saveOrgPage.getSaved_type_dropdown().getText();
		String savedWebsiteName1 = saveOrgPage.getSaved_website_name().getText();
		
		if (savedOrgNameAndNumber.contains(OrgName)) {
			System.out.println("Organization Name script is matching & test case is pass");
		} else {
			System.out.println("--Organization Name script is not matching & test case is failed");
		}

		if (savedWebsiteName1.contains(website)) {
			System.out.println("Organization website name  is matching & test case is pass");
		} else {
			System.out.println("--Organization website name is not matching & test case is failed");
		}

		if (saved_industry_name_dropdown.equals(industry)) {
			System.out.println("Organization Industry name  is matching & test case is pass");
		} else {
			System.out.println("--Organization Industry name  is not matching & test case is failed");
		}

		if (saved_type_dropdown.equals(type)) {
			System.out.println("Organization Type name  is matching & test case is pass");
		} else {
			System.out.println("--Organization Type name  is not matching & test case is failed");
		}

		if (savedPhoneNo.equals(PhoneNo)) {
			System.out.println("Organization phone number is matching & test case is pass");
		} else {
			System.out.println("--Organization phone number is not matching & test case is failed");
		}

		if (savedAnnual_revenue.equals(annual_revenue)) {
			System.out.println("Organization annual revenue is matching & test case is pass");
		} else {
			System.out.println("--Organization annual revenue is not matching & test case is failed");
		}

		Thread.sleep(5000);
		driver.quit();
	}
}
