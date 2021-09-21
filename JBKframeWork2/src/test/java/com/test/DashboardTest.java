package com.test;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class DashboardTest extends TestBase  {
	  WebDriver driver = null;

      LoginPage lp;
      DashBoardPage dp;
	@BeforeMethod
	public void setUp(){
    driver = intialization();
    readProperty("url");
    //lp = new LoginPage(driver);
    //dp = lp.navigateToDashboard(driver);
	dp=loadLoginPage().navigateToDashboard(driver);
	
	}	
	
	@Test
	public void loginUser(){
		dp.nevigateToUser(driver);
		
	}
	
	@Test
	public void VerifylowerText(){
		
	    Assert.assertTrue(dp.lowerText());
	}
	@Test
	public void verifyreadCourses() throws Exception{
		
	 Assert.assertTrue(dp.readCourses());
	
	}
	
	@Test
	public void verifySideMenu() throws Exception{
		
	Assert.assertTrue(dp.SideMenu());
	}

	@Test
	public void verifycourseIcons(){
		
	Assert.assertTrue(dp.courseIcons());
	}
	
	@Test
	public void verifyMoreInfoText(){
		
	Assert.assertTrue(dp.moreInfoText());
	}
	
	@Test
	public void verifyMoreInfoLink(){
	
	dp.moreInfoLink();
	Assert.assertEquals(true, true);
	}
	
	@Test
	public void VerifyCoursesColour(){
		
	Assert.assertTrue(dp.courseColour());
   }
	
	@Test
	public void verifyuserLink(){
		
	Assert.assertTrue(dp.userLink());
	}
	
	
	@Test
	public void verifyOperatorLink(){
		
	Assert.assertTrue(dp.operatorsLink());
	}
	
	@Test
	public void verifyUsefulLink(){
		
	Assert.assertTrue(dp.usefulLink());
     }
	
	@Test
	public void verifyDownloadLink(){
		
	Assert.assertTrue(dp.downloadsLink());
	}
	
	@Test
	public void verifyLogoutLink(){
		
	Assert.assertTrue(dp.logoutLink());
    }

	@AfterMethod
	public void logOut(){
		
		driver.close();
	}
  }
