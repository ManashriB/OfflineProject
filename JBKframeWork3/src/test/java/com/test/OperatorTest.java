package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.OperatorPage;

public class OperatorTest extends TestBase {

	WebDriver driver;
	//public LoginPage lp;
	public OperatorPage Op;
	public DashBoardPage dp;

	@BeforeMethod
	public void setUp() {
		driver = intialization();
		readProperty("url");
		//lp = new LoginPage(driver);
		//Op =lp.navigateToDashboard(driver).nevigateToOpetator();
		Op=loadLoginPage().navigateToDashboard(driver).nevigateToOpetator();
	}

	@Test
	public void verifyHeaderList() throws Exception {
		Assert.assertTrue(Op.headerList());

	}

	@Test
	public void verifySeqOfIndexList() throws Exception {
		Assert.assertTrue(Op.seqOfIndexList());

	}

	@Test
	public void verifyTechnicalHelpPersonList() {
		Assert.assertTrue(Op.technicalHelpPersonList());

	}

	@Test
	public void verifyContactToWhatsupOnlyPersonList() {
		Assert.assertTrue(Op.contactToWhatsupOnlyPersonList());

	}

	@Test
	public void verifyAvailablePersonAsPerTiming() {
	Assert.assertTrue(Op.availablePersonAsPerTiming());

	}
	@AfterMethod
	public void logOut(){
		
		driver.close();
}}
