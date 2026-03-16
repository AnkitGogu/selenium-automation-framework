package com.ankit.base;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ankit.config.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	public static ConfigReader configReader = new ConfigReader();
	protected static final Logger logger = Logger.getLogger(BaseTest.class.getName());


	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(@Optional String browser) {

		if (browser == null || browser.isEmpty()) {
		    browser = configReader.getBrowser();
		}
		logger.info("Starting test setup. Browser: " + browser);

		switch (browser.toLowerCase()) {

		case "chrome":
			logger.info("Launching Chrome browser");
			driver = new ChromeDriver();
			break;

		case "firefox":
			logger.info("Launching Firefox browser");
			driver = new FirefoxDriver();
			break;

		default:
			logger.warning("Invalid browser provided. Launching Chrome by default.");
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		logger.info("Browser maximized");
		// driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.get(configReader.getBaseUrl());
		logger.info("Navigated to login page");

	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		logger.info("Closing browser");
		driver.quit();
	}
	
	public WebDriver getDriver() {
	    return driver;
	}

}
