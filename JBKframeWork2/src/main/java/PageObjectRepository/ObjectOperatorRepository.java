package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectOperatorRepository {
	WebDriver driver;
	
	
	@FindBy(xpath = "//td[2]")
	public List<WebElement> contactPersonsColm;

	@FindBy(xpath = "//td[4]")
	public List<WebElement> contactToWay;

	@FindBy(xpath = "//th")
	public List<WebElement> HeaderList;

	@FindBy(xpath = "//td[1]")
	public List<WebElement> IndexList;

	@FindBy(xpath = "//td[3]")
	public List<WebElement> technicalHelpColm;

	@FindBy(xpath = "//td[4]")
	public List<WebElement> wayOfContact;

	@FindBy(xpath = "//td[6]")
	public List<WebElement> contactTimingcolm;
}
