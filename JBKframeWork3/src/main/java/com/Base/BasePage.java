package com.Base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BasePage {

	public Logger loginPageLogs() {

		Logger Log = Logger.getLogger(this.getClass());
		String path = (System.getProperty("user.dir") + "/src/main/resources/log4jloginpage.properties");
		PropertyConfigurator.configure(path);
		return Log;

	}
	
	
	public Logger DashPageLogs() {

		Logger Log = Logger.getLogger(this.getClass());
		String path = (System.getProperty("user.dir") + "/src/main/resources/log4jDashPage.properties");
		PropertyConfigurator.configure(path);
		return Log;

	}
	
	
	
	
	
	
	
	
}
