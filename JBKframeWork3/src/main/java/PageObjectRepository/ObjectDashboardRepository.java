package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BasePage;

public class ObjectDashboardRepository extends BasePage {
	WebDriver driver;
	
	
	@FindBy(xpath = "//strong[text()='Copyright © 2005-2019 ']")
	public WebElement lowerText;

	@FindBy(tagName = "h3")
	public List<WebElement> courses1;

	@FindBy(xpath = "//ul[@class='sidebar-menu']//li")
	public List<WebElement> SideMenu;

	@FindBy(xpath = "//div[(@class='icon')]/i")
	public List<WebElement> coursesIcons;

	@FindBy(partialLinkText = "info")
	public List<WebElement> moreInfo;

	@FindBy(xpath = "//div//parent::div[contains(@class,'small-box ')]")
	public List<WebElement> textColour;

	@FindBy(xpath = "//span[text()='Users']")
	public WebElement userLink;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	public WebElement dashboardLink;
	
	@FindBy(xpath = "//span[text()='Operators']")
	public WebElement operatorsLink;
	
	@FindBy(xpath = "//span[text()='     Useful Links']")
	public WebElement usefulLink;
	
	@FindBy(xpath = "//span[text()='Downloads']")
	public WebElement downloadLink;
	
	@FindBy(xpath="//span[text()='Logout']")
	public WebElement logoutLink;
} 
