package assignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.AbstractComponents.AbstractComponent;

public class SignInPage extends AbstractComponent {

	WebDriver driver;

	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".base")
	WebElement loginText;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInput;

	@FindBy(xpath = "(//input[@id='pass'])[1]")
	WebElement passInput;

	@FindBy(xpath = "(//button[@id='send2'])[1]")
	WebElement signInBtn;
	
	@FindBy(id = "email-error")
	WebElement emailError;
	
	@FindBy(id = "#pass-error")
	WebElement emptyError;
	
	@FindBy(xpath = "div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement invalidPass;

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		passInput.sendKeys(password);
	}

	public String getCustomerLoginText() {
		return loginText.getText();
	}

	public HomePage clickSignIn() {
		signInBtn.click();
		HomePage accountPage = new HomePage(driver);
		return accountPage;
	}
	
	public String getEmailError() {
		return emailError.getText();
	}
	
	public String getEmptyPasswordError() {
		return emptyError.getText();
	}
	
	public String getInvalidEmailOrPassError() {
		return invalidPass.getText();
	}
	
	


}
