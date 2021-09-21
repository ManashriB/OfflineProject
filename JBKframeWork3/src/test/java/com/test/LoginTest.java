package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Base.TestBase;
import com.pages.LoginPage;

public class LoginTest extends TestBase {
	public LoginPage lp;
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = intialization();
		readProperty("url");
		lp = new LoginPage(driver);

	}

	@Test
	public void dashboardLogin() {
		lp.navigateToDashboard(driver);
	}

	@Test
	public void verifyValidatedMasg() {
		Assert.assertTrue(lp.loginHeading());
	}

	@Test
	public void verifyCorrectCredential() {
		Assert.assertTrue(lp.correctCredential());
	}

	@Test
	public void verifyjbkText() {

		Assert.assertTrue(lp.jbkText());
	}

	@Test
	public void verifyPasswordErrorMasg() {
		Assert.assertTrue(lp.passwordErrorMasg());
	}

	@Test
	public void verifyValidUserNameErrorMasg() {
		Assert.assertTrue(lp.validUserNameErrorMasg());
	}

	@Test
	public void verifyUserNameErrorMasg() {
		Assert.assertTrue(lp.userNameErrorMasg());

	}

	@Test
	public void VerifyNewRegistrationLinkText() {
		Assert.assertTrue(lp.newRegistrationLinkText());

	}
	@AfterMethod
	public void logOut(){
		
		driver.close();
}}
