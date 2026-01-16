import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class dummy {
public static void main(String[] args) {
	ExtentSparkReporter spark =new ExtentSparkReporter("c:/path.html");
	spark.config().setDocumentTitle("VTIGER SUITE RESULTS");
	spark.config().setReportName("MODULES REPORTSSSS.....");
	spark.config().setTheme(Theme.DARK);
	
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "WIN-10");
	report.setSystemInfo("BROWSER", "CHROME-100");
	System.out.println("***********************");
	ExtentTest test = null;
	//test.log(Status.INFO);

}
}
