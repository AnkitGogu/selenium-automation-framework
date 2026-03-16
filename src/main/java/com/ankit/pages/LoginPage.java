package com.ankit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private By usernameFieldLocator = By.id("username");
	private By passwordFieldLocator = By.id("password");
	private By submitButtonLocator = By.xpath("//button[text()='Submit']");
	private By errorMessageLocator = By.id("error");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String username) {
		type(usernameFieldLocator, username);
	}

	public void enterPassword(String password) {
		type(passwordFieldLocator, password);
	}

	public void clickSubmit() {
		click(submitButtonLocator);
	}

	public LoggedInPage login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickSubmit();
		return new LoggedInPage(driver);
	}

	public String getErrorMessageText() {
		return getText(errorMessageLocator);
	}

}
