package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectUserRepository {
	WebDriver driver;
	
	
	
	
	@FindBy(tagName = "th")
	public List<WebElement> allHeader;
	
	@FindBy(xpath="//tr")
	public List<WebElement> allRows;
	
    @FindBy(xpath="//th[4]")
	public WebElement mobileColmlabel;
	
	@FindBy(xpath="//tr[2]//child::td[8]")
	public WebElement fristDeleteButton;

	@FindBy(xpath="//tr[3]//child::td[8]")
	public WebElement SecondDeleteButton;
		
	@FindBy(xpath="//td[4]")
    public List<WebElement> mobileNocols;
	
	@FindBy(xpath="//td[1]")
	 public List<WebElement> indexColss;
}
