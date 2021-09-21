package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class UserTest extends TestBase {
	 WebDriver driver;  
	 public DashBoardPage dp;
	 public LoginPage lp;
	 public UserPage up;
	

	@BeforeMethod
	  
    public void setUp(){
	driver = intialization();
	    readProperty("url");
	  // lp = new LoginPage(driver); 
	 //up = lp.navigateToDashboard(driver).nevigateToUser(driver);
      up=loadLoginPage().navigateToDashboard(driver).nevigateToUser(driver);
}
	
	@Test
	public void VerifyLabelCount() throws Exception{
	Assert.assertTrue(up.countOfLabel());
		
	}
	
	@Test
	public void verifyListOfLabel() throws Exception{
	Assert.assertTrue(up.listOfLabel());
	}

	@Test
	public void verifyIndexCols() throws Exception{
	Assert.assertTrue(up.IndexCols());
	}
	
	@Test
	public void verifyMobileNoCol() throws Exception{
		Assert.assertTrue(up.mobileNoCol());
	}
	
	@Test
	public void verifySimpleAlert() throws Exception{
		
	up.simpleAlert(driver);
	Assert.assertEquals(true, true);
		
	}
	
	@Test
	public void verifyAcceptPromtAlert() throws Exception{

	up.promtAlert();
	Assert.assertEquals(true, true);
		
	}
	/*@AfterMethod
	public void logOut(){
		
		driver.close();	
}	*/
	}
	
	
	
	
	
	
	
	
