package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BasePage;

public class ObjectLoginRepository extends BasePage {
	
	WebDriver driver;
	
	/*public ObjectLoginRepository(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    this.driver = driver;
	}*/

	@FindBy(xpath = "//p[@class='login-box-msg']")
	public WebElement loginMsg;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement button;

	@FindBy(xpath = "//b[text()='Java By Kiran']")
	public WebElement tagName;

	@FindBy(xpath = "//img[@src='pages/images/jbk.png']")
	public WebElement imageLogo;

	@FindBy(xpath = "//div[text()='Please enter password.']")
	public WebElement passwordFieldErrorMasg;

	@FindBy(xpath = "//div[text()='Please enter valid email.']")
	public WebElement email_errorMasg;

	@FindBy(xpath = "//div[text()='Please enter email as kiran@gmail.com']")
	public WebElement email_ValidErrorMasg;

	@FindBy(xpath="//a[@class='text-center']")
	public WebElement registrationLink;
	
	
}
