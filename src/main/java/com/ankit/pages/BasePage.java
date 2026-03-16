package com.ankit.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ankit.base.BaseTest;
import com.ankit.config.ConfigReader;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	//private static ConfigReader configReader = new ConfigReader();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(BaseTest.configReader.getTimeout()));
	}
	
	
	protected void type(By locator, String text) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
	}

	protected void click(By locator) {
	    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	protected String getText(By locator) {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}
	
	protected boolean isDisplayed(By locator) {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}

}
