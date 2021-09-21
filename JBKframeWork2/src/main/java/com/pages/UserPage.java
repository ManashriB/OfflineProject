package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import PageObjectRepository.ObjectUserRepository;

public class UserPage extends ObjectUserRepository {
	WebDriver driver;

	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		 this.driver=driver;
	}

	public boolean countOfLabel() throws Exception {
		DataFormatter df = new DataFormatter();
		ArrayList<String> expListCount = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
		int rows = sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				expListCount.add(data);
			}
		}
		List<WebElement> courses = allHeader;
		ArrayList<String> actCountOfLabel = new ArrayList<String>();
		for (WebElement course : courses) {
			String text = course.getText();
			actCountOfLabel.add(text);
		}

		System.out.println(expListCount.size() + " " + actCountOfLabel.size());
		if (actCountOfLabel.equals(expListCount)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}

	}

	public boolean listOfLabel() throws Exception {
		DataFormatter df = new DataFormatter();
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
		int rows = sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				expList.add(data);
			}
		}
		List<WebElement> headers = allHeader;
		ArrayList<String> actList = new ArrayList<String>();
		for (WebElement headerList : headers) {
			String text = headerList.getText();
			actList.add(text);
		}

		System.out.println(expList + "  " + actList);
		if (actList.equals(expList)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	public boolean IndexCols() throws Exception {
		ArrayList<String> actlist = new ArrayList<String>();
		List<WebElement> indexList = indexColss;
		for (WebElement index : indexList) {
			String value = index.getText();
			actlist.add(value);
		}
		// System.out.println(actlist);

		DataFormatter df = new DataFormatter();
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet4");
		int rows = sh.getLastRowNum();// 6
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();// row=0..cols-3/row-1..cols-4
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				expList.add(data);
			}
		}
		// System.out.println(expList);
		System.out.println(actlist + " " + expList);

		if (actlist.equals(expList)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	public boolean mobileNoCol() throws Exception {
		ArrayList<String> actlist = new ArrayList<String>();
		List<WebElement> actList = driver.findElements(By.xpath("//td[4]"));
		for (WebElement mobileNo : actList) {
			String value = mobileNo.getText();
			actlist.add(value);
		}
		// System.out.println(actlist);

		DataFormatter df = new DataFormatter();
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet5");

		int rows = sh.getLastRowNum();// 6
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				expList.add(data);
			}
		}
		// System.out.println(expList);
		System.out.println(actlist + " " + expList);
		if (actlist.equals(expList)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	public void simpleAlert(WebDriver driver) throws Exception {

		fristDeleteButton.click(); // xpath-->parent and child relationship
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();
	}

	public void promtAlert() throws Exception {
		SecondDeleteButton.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();;

	}

}
