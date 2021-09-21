package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectRepository.ObjectOperatorRepository;

public class OperatorPage extends ObjectOperatorRepository {

	WebDriver driver;

	public OperatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		 this.driver=driver;
	}  

	@Test
	public boolean headerList() throws Exception {

		ArrayList<String> actList = new ArrayList<String>();
		List<WebElement> headerList = HeaderList;

		for (WebElement header : headerList) {

			String value = header.getText();
			actList.add(value);
			//Collections.sort(actList);
		}
		System.out.print(actList);

		DataFormatter df = new DataFormatter();
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet6");
		int rows = sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				expList.add(data);
			}
		}
		System.out.println(expList);
		if (actList.equals(expList)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	@Test
	public boolean seqOfIndexList() throws Exception {

		ArrayList<String> actList = new ArrayList<String>();
		List<WebElement> tableList = IndexList;

		for (WebElement table : tableList) {

			String value = table.getText();
			actList.add(value);
			Collections.sort(actList);
		}
		System.out.print(actList);

		DataFormatter df = new DataFormatter();
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet7");
		int rows = sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				expList.add(data);
			}
		}
		System.out.println(expList);
		if (actList.equals(expList)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

	@Test
	public boolean technicalHelpPersonList() {
		ArrayList<String> actList = new ArrayList<String>();

		// List<WebElement> contactNumberList = driver.findElements(By.xpath("//td[5]"));
		List<WebElement> contactPersonsList = contactPersonsColm;
		List<WebElement> technicalHelpList = technicalHelpColm;

		   for (int i = 0; i <= 4; i++) {
			// String personNumber= contactNumberList.get(i).getText();
			String personName = contactPersonsList.get(i).getText();
			String way = technicalHelpList.get(i).getText();
			if (way.startsWith("Technical")) {
				actList.add(personName);
				// actList.add(contactNumberList);
			}
		}
		// System.out.println(actList);
		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();
		FileInputStream fis;
		Workbook wb = null;

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet("Sheet8");
		int rowNum = sh.getLastRowNum();

		for (int i = 1; i <= rowNum; i++) {
			Row row = sh.getRow(i);
			Cell cell = row.getCell(2);
			String celldata = df.formatCellValue(cell);
			if (celldata.startsWith("Technical")) {
				Cell personscell = row.getCell(1);
				expList.add(df.formatCellValue(personscell));
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

	@Test
	public boolean contactToWhatsupOnlyPersonList() {

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> contactPersonsList = contactPersonsColm;
		List<WebElement> PreferedWayToConnectList = wayOfContact;
		System.out.println(PreferedWayToConnectList);
		for (int i = 0; i <= 4; i++) {
			String way = PreferedWayToConnectList.get(i).getText();
			String personName = contactPersonsList.get(i).getText();
			// System.out.println(personName);
			if (way.equals("Whats App Only")) {
				actList.add(personName);
				// System.out.println(personName);
			}
		}
		// System.out.println(actList);

		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();
		FileInputStream fis;
		Workbook wb = null;

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet("Sheet8");
		int rowNum = sh.getLastRowNum();

		for (int i = 1; i <= rowNum; i++) {
			Row row = sh.getRow(i);
			Cell cell = row.getCell(3);
			String celldata = df.formatCellValue(cell);
			if (celldata.equals("Whats App Only")) {
				Cell personscell = row.getCell(1);
				expList.add(df.formatCellValue(personscell));
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

	@Test
	public boolean availablePersonAsPerTiming() {

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> contactPersonsList = contactPersonsColm;
		List<WebElement> ConnectTimingList = contactTimingcolm;

		for (int i = 0; i <= 4; i++) {
			String timing = ConnectTimingList.get(i).getText();

			String personName = contactPersonsList.get(i).getText();

			System.out.println(personName);
			if (timing.startsWith("08:30 AM")) {
				actList.add(personName);

			}
		}
		// System.out.println(actList);

		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();
		FileInputStream fis;
		Workbook wb = null;

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "/Dashboard.xls");
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet("Sheet8");
		int rowNum = sh.getLastRowNum();

		for (int i = 1; i <= rowNum; i++) {
			Row row = sh.getRow(i);
			Cell cell = row.getCell(5);
			String celldata = df.formatCellValue(cell);
			if (celldata.startsWith("08:30 AM")) {
				Cell personscell = row.getCell(1);
				expList.add(df.formatCellValue(personscell));
			}
		}

		// System.out.println(expList);
	    System.out.println(actList + " " + expList);
	    if (actList.equals(expList)) {
			System.out.println("ok");
			return true;
		} else {
			System.out.println("not ok");
			return false;
		}
	}

}
