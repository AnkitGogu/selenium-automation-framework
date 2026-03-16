package com.ankit.tests.login;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ankit.base.BaseTest;
import com.ankit.pages.LoggedInPage;
import com.ankit.pages.LoginPage;
import com.ankit.utils.DataProviders;

public class LoginTests extends BaseTest {

	// @Parameters({ "username", "password" })

	@Test(groups = { "positive", "smoke",
			"regression" }, dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void userShouldLoginWithValidCredentials(String username, String password, String expectedResult, String expectedMessage) {
		LoginPage loginPage = new LoginPage(driver);

		logger.info("Executing positive login test");

		logger.info("Performing login");

		LoggedInPage loggedInPage = loginPage.login(username, password);

		logger.info("Verifying successful login");

		if (expectedResult.equalsIgnoreCase("success")) {

			Assert.assertEquals(loggedInPage.getSuccessHeadingText(), expectedMessage);

			Assert.assertTrue(loggedInPage.isLogoutButtonDisplayed());

			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
			Assert.assertEquals(actualUrl, expectedUrl);

		}

		else if (expectedResult.equalsIgnoreCase("error")) {

			Assert.assertEquals(loginPage.getErrorMessageText(), "hi");

		}

	}

//	@Parameters({ "username", "password", "expectedErrorMessage" })
//	@Test(groups = { "negative", "regression" })
//	public void validateErrorForInvalidLogin(String username, String password, String expectedErrorMessage) {
//		LoginPage loginPage = new LoginPage(driver);
//
//
//		logger.info("Executing negative login test");
//
//		logger.info("Performing login");
//
//	    loginPage.login(username, password);
//
//	
//	    logger.info("Waiting for error message");
//
//		Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
//	    logger.info("Error message validation successful: " + expectedErrorMessage);
//
//
//	}

}
