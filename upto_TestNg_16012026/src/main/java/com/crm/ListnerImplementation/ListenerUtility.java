package com.crm.ListnerImplementation;

import java.sql.ResultSet;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.Generic.WebDriverUtility.UtilityClassObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerUtility extends ConfigurationAnnotations_BaseClass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public ExtentTest test;
	@Override
	
	public void onFinish(ISuite suite) {
		System.out.println("------------------------------------------***********************-Listener ISuite onFinish");
		
		System.out.println(suite.getSuiteState());
		
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("------------------------------------------***********************-Listener ISuite onStart");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		ExtentSparkReporter spark =new ExtentSparkReporter("./AdvanceReport/"+suite.getName()+"___"+time+".html");
		spark.config().setDocumentTitle("VTIGER SUITE RESULTS");
		spark.config().setReportName("*************VTIGER APPLICATIONS***************");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WIN-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
			}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("------------------------------------------***********************-Listener ITestContext onFinish");
		System.out.println("=============>"+context.getName()+"     <=====FINISH========");
		test.log(Status.PASS,context.getName());
			report.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("------------------------------------------***********************-Listener ITestContext onStart");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("------------------------------------------***********************-Listener ITestResult onTestFailedButWithinSuccessPercentage");

		System.out.println("=============>"+result.getMethod().getMethodName()+"<=====FAIL WITH SUCCESS PERCENTAGE========");
		test.log(Status.FAIL, result.getMethod().getMethodName());
			}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("------------------------------------------***********************-Listener ITestResult onTestFailedWithTimeout");
		
		System.out.println("=============>"+result.getMethod().getMethodName()+"<=====FAILED WITH TIMEOUTS========");
		test.log(Status.FAIL, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("------------------------------------------***********************-Listener ITestResult onTestFailure");
		
		String name = result.getName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot)ConfigurationAnnotations_BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath, name+"_"+time);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("------------------------------------------***********************-Listener ITestResult onTestSkipped");
		
		System.out.println("=============>"+result.getMethod().getMethodName()+"     <=====SKIPPED========");
		test.log(Status.SKIP, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("------------------------------------------***********************-Listener ITestResult onTestStart");
		
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"       =========>STARTED<=============");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("------------------------------------------***********************-Listener ITestResult onTestSuccess");
		System.out.println("=============>"+result.getMethod().getMethodName()+"      <=====SUCCESS========");
		test.log(Status.PASS, result.getMethod().getMethodName());
			}
	

	
	
}
