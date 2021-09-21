package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

import PageObjectRepository.ObjectLoginRepository;

public class LoginPage extends ObjectLoginRepository{
       public WebDriver driver;
       public static Logger Log = Logger.getLogger(TestBase.class);
   public LoginPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	    this.driver = driver;
	}
   
   
   public DashBoardPage navigateToDashboard(WebDriver driver) {
		email.sendKeys(TestBase.readProperty("username"));
		password.sendKeys(TestBase.readProperty("password"));
		Log.info("manashri");
		button.click();
		return new DashBoardPage(driver);
	}
   
   public boolean correctCredential() {
	    email.sendKeys(TestBase.readProperty("username"));
		password.sendKeys(TestBase.readProperty("password"));
		button.click();
		String actTitle = driver.getTitle();
		loginPageLogs().info(actTitle+" "+"Print actList is ");
		String expTitle = "JavaByKiran | Dashboard";
		
		if (actTitle.equals(expTitle)) {
			System.out.println("right credential");
			return true;
		} else {
			System.out.println("wronge credential");
			return false;
		}
      }
		
		
    public boolean loginHeading() {
		String actHeading = loginMsg.getText();
		String expHeading = "Sign in to start your session";

		if (actHeading.equals(expHeading)) {
			System.out.println(actHeading + " " + expHeading);
			return true;
		} else {
			System.out.println("code mismatch");
			return false;
		}
	  }

	    public boolean jbkText() {
		String actHeading = tagName.getText();
		String expHeading = "Java By Kiran";

		if (actHeading.equals(expHeading)) {
			System.out.println("right tagName");
			return true;
		} else {
			System.out.println("wronge tagName");
			return false;
		}
	 }

	public void verifyLogo() {
		imageLogo.isDisplayed();
	}

	public boolean passwordErrorMasg() {
        email.sendKeys("kiran@gmail.com");
		password.sendKeys();
		button.click();
		String actErrorMasg = passwordFieldErrorMasg.getText();
		String ExpErrorMasg = "Please enter password.";
		if (actErrorMasg.equals(ExpErrorMasg)) {
			System.out.println("right masg");
			return true;
		} else {
			System.out.println("wronge masg");
			return false;
		}
	}

	public boolean validUserNameErrorMasg() {
        email.sendKeys("ddfkukkk");
		password.sendKeys("123456");
		button.click();
		String actErrorMasg = email_errorMasg.getText();
		String ExpErrorMasg = "Please enter valid email.";
		if (actErrorMasg.equals(ExpErrorMasg)) {
			System.out.println("right masg");
			return true;
		} else {
			System.out.println("wronge masg");
			return false;
		}
	  }

	public boolean userNameErrorMasg() {
		email.sendKeys("manashri@gmail.com");
		button.click();
		String actErrorMasg = email_ValidErrorMasg.getText();
		String expErrorMasg = "Please enter email as kiran@gmail.com";
		if (actErrorMasg.equals(expErrorMasg)) {
			System.out.println("right masg");
			return true;
		} else {
			System.out.println("wronge masg");
			return false;
		}
	  }
	
     public boolean newRegistrationLinkText(){
	 String actText = registrationLink.getText();
	 String expText = "Register a new membership";
	 if (actText.equals(expText)) {
			System.out.println("right masg");
			return true;
		} else {
			System.out.println("wronge masg");
			return false;
		}
	}
 }
	


	
	


	
	
	
 



