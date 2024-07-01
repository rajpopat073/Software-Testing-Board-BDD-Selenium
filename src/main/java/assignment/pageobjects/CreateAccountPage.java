package assignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.AbstractComponents.AbstractComponent;

public class CreateAccountPage extends AbstractComponent {

	WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstname")
	WebElement firstName;

	@FindBy(id = "lastname")
	WebElement lastName;

	@FindBy(id = "email_address")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "password-confirmation")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement createAccountButton;
	
	@FindBy(id = "password-error")
	WebElement passError;
	
	@FindBy(id = "firstname-error")
	WebElement firstNameError;
	
	@FindBy(id = "lastname-error")
	WebElement lastNameError;
	
	@FindBy(id = "email_address-error")
	WebElement emailError;
	
	@FindBy(id = "password-confirmation-error")
	WebElement cnfPassError;
	
	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement alreadyPresent;

	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}

	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}

	public void enterEmail(String emailAddress) {
		email.sendKeys(emailAddress);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void enterConfirmPassword(String confirmPwd) {
		confirmPassword.sendKeys(confirmPwd);
	}

	public AccountPage clickCreateAccount() {
		createAccountButton.click();
		AccountPage accountPage = new AccountPage(driver);
		return accountPage;
	}
	
	public String getEmailError() {
		return emailError.getText();
	}
	
	public String getLastNameError() {
		return lastNameError.getText();
	}
	
	public String getFirstNameError() {
		return firstNameError.getText();
	}
	
	public String getPassError() {
		return passError.getText();
	}
	
	public String getCnfPassError() {
		return cnfPassError.getText();
	}
	
	public String getPresentText() {
		return alreadyPresent.getText();
	}

}
