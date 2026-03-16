package com.ankit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage extends BasePage {

	private By successHeadingLocator = By.xpath("//h1[@class='post-title']");
	private By logoutButtonLocator = By.linkText("Log out");

	public LoggedInPage(WebDriver driver) {
		super(driver);
	}

	public String getSuccessHeadingText() {
		return getText(successHeadingLocator);
	}

	public boolean isLogoutButtonDisplayed() {
		return isDisplayed(logoutButtonLocator);
	}

}
