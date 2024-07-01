package assignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent {

	WebDriver driver;
	private String  homePageUrl = "https://magento.softwaretestingboard.com/";
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='panel header']/ul/li[2]/a")
	WebElement signIn;

	@FindBy(xpath = "//div[@class='panel header']/ul/li[3]/a")
	WebElement createAccount;
	
	@FindBy(css = "div[class='panel header'] span[class='logged-in']")
	WebElement welcomeTag;

	public void goTo() {
		driver.get(homePageUrl);
	}

	public SignInPage clickSignIn() {
		signIn.click();
		SignInPage signInpage = new SignInPage(driver);
		return signInpage;
	}

	public CreateAccountPage clickCreateAccount() {
		createAccount.click();
		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		return createAccountPage;
	}

	public String getUrl() {
		return homePageUrl;
	}
	
	public String getWelcomeTag() {
		return welcomeTag.getText() != null ? welcomeTag.getText() : "";
	}
}
