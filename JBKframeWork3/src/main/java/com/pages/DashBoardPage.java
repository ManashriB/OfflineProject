package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageObjectRepository.ObjectDashboardRepository;

public class DashBoardPage extends ObjectDashboardRepository {
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
    }
		
	
	
     public UserPage nevigateToUser(WebDriver driver) {
		 userLink.click();
		return new UserPage(driver) ;
	}
	
	 public OperatorPage nevigateToOpetator() {
		 operatorsLink .click();
		return new OperatorPage(driver) ;
	}
	 
	 public UsefulLinkPage nevigateToUsefulLink() {
		 usefulLink.click();
		return new UsefulLinkPage(driver) ;
	}
	 
	 public DownloadPage nevigateToDownload() {
		 downloadLink.click();
		return new DownloadPage(driver) ;
	}
	 
	public boolean courseColour() {
		ArrayList<String> actColour = new ArrayList<String>();
		List<WebElement> course = textColour;
		for (WebElement text : course) {
			String colourText = text.getCssValue("class");
			// System.out.println(colourText);
			String colour = colourText.substring(colourText.lastIndexOf('-') + 1);
			actColour.add(colour);
			
		}
		DashPageLogs().info("Print all colors");
		
		ArrayList<String> expColour = new ArrayList<String>();
		expColour.add("aqua");
		expColour.add("green");
		expColour.add("yellow");
		expColour.add("red");
		Assert.assertEquals(actColour, expColour);
		System.out.println(actColour + " " + expColour);

		if (expColour.equals(actColour)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	public boolean lowerText() {
		String acttext = lowerText.getText();
		String exptext = "Copyright © 2005-2019 JavaByKiran.";
		if (acttext.equals(exptext)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}

	}

	public boolean readCourses() throws Exception {

		DataFormatter df = new DataFormatter();
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rows = sh.getLastRowNum();// 6
		for (int i = 1; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();// row=0..cols-3/row-1..cols-4
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				expList.add(data);
			}
		}
		List<WebElement> courses = courses1;
		ArrayList<String> actList = new ArrayList<String>();
		for (WebElement course : courses) {
			String text = course.getText();
			actList.add(text);
		}
		// System.out.println(actList+" "+ expList);
		if (actList.equals(expList)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	public boolean SideMenu() throws Exception {
		ArrayList<String> actList = new ArrayList<String>();
		List<WebElement> sidemenu = SideMenu;
		for (WebElement menu : sidemenu) {
			// System.out.println("1");
			String text = menu.getText();
			actList.add(text);
		}
		// System.out.println(actList);

		DataFormatter df = new DataFormatter();
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int rows = sh.getLastRowNum();// 6
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();// row=0..cols-3/row-1..cols-4
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				expList.add(data);
			}
		}
		System.out.println(actList + " " + expList);

		if (actList.equals(expList)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	public boolean courseIcons() {
		ArrayList<String> actIcons = new ArrayList<String>();
		List<WebElement> icons = coursesIcons;
		for (WebElement text : icons) {
			String iconText = text.getAttribute("class");
			String symbolIcon = iconText.substring(iconText.lastIndexOf('-') + 1);
			actIcons.add(symbolIcon);
		}
		System.out.println(actIcons);

		ArrayList<String> expIcons = new ArrayList<String>();
		expIcons.add("bag");
		expIcons.add("bars");
		expIcons.add("add");
		expIcons.add("graph");
		System.out.println(expIcons);

		if (actIcons.equals(expIcons)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	public boolean moreInfoText() {
		ArrayList<String> actMoreInfoText = new ArrayList<String>();
		List<WebElement> list = moreInfo;
		for (WebElement moreInfo : list) {

			String value = moreInfo.getText();
			actMoreInfoText.add(value);
		}
		System.out.println(actMoreInfoText);

		ArrayList<String> expMoreInfoText = new ArrayList<String>();
		expMoreInfoText.add("More info");
		expMoreInfoText.add("More info");
		expMoreInfoText.add("More info");
		expMoreInfoText.add("More info");
		if (actMoreInfoText.equals(expMoreInfoText)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	public void moreInfoLink() {
		List<WebElement> links = moreInfo;
		String mainwindow = driver.getWindowHandle();

		for (WebElement link : links)
			link.click();
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			System.out.println(win);
			if (!win.equalsIgnoreCase(mainwindow)) {
				driver.switchTo().window(win);
				System.out.println(driver.getCurrentUrl().contains("python"));
				// driver.close();
			}
		}
	}

	public boolean userLink() {
		userLink.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | User";
		System.out.println(actTitle);
		if (actTitle.equals(expTitle)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	 } 
	    
		
	public boolean operatorsLink() {
		operatorsLink.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Operators";
		System.out.println(actTitle);
		if (actTitle.equals(expTitle)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	  }
	
	public boolean usefulLink() {
		usefulLink.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Useful Links";
		System.out.println(actTitle);
		if (actTitle.equals(expTitle)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
      }
	
	
      public boolean downloadsLink() {
		downloadLink.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Downloads";
		System.out.println(actTitle);
		if (actTitle.equals(expTitle)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		   }
		}
	
	
	
public boolean logoutLink() {
		logoutLink.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Log in";
		System.out.println(actTitle);
		if (actTitle.equals(expTitle)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	  }
    }
