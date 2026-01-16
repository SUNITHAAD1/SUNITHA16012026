package com.crm.ListnerImplementation;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DummyListener implements ISuiteListener, ITestListener {

	@Override
	public void onFinish(ISuite suite) {
	System.out.println("-----------------------------ISuite----Finish");		
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("-----------------------------ISuite-Start");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("-----------------------------ITestContext- Finish");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("-----------------------------ITestContext- Start");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("-----------------------------ITEstResult-onTestFailedWithininSuccessPercentage ");
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("-----------------------------ITestResult- onTestFailedWithTimeout ");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("-----------------------------ITestResult-onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("-----------------------------ITestResult-onTestSkipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("-----------------------------ITestResult-onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("-----------------------------ITestResult-onTestSuccess");
	}
	

}
