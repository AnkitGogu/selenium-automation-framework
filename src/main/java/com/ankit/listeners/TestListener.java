package com.ankit.listeners;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ankit.utils.ExtentManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ankit.base.BaseTest;
import com.ankit.utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	
	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	@Override
	public void onTestFailure(ITestResult result) {

	    test.get().fail(result.getThrowable());

	    String testName = result.getName();
	    Object testClass = result.getInstance();
	    WebDriver driver = ((BaseTest) testClass).getDriver();

	    String screenshotPath = ScreenshotUtil.captureScreenshot(driver, testName);

	    test.get().addScreenCaptureFromPath(screenshotPath);
	}
	
	@Override
	public void onTestStart(ITestResult result) {

	    ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
	    test.set(extentTest);

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {

	    test.get().pass("Test Passed");

	}
	
	@Override
	public void onFinish(org.testng.ITestContext context) {
	    extent.flush();
	}

}
