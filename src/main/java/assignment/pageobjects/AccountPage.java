package assignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import assignment.AbstractComponents.AbstractComponent;

public class AccountPage extends AbstractComponent {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='box-content'] p")
	WebElement accountInfo;

	@FindBy(css = "div[class='panel header'] button[type='button']")
	WebElement menu;

	public String getAccountInfo() {
		return accountInfo.getText() == null ? "" : accountInfo.getText();
	}

	public void logOut() {
		Select dropDown = new Select(menu);
		dropDown.selectByIndex(2);
	}

}
