package assignment.stepDefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import assignment.TestComponents.BaseTest;
import assignment.pageobjects.AccountPage;
import assignment.pageobjects.CreateAccountPage;
import assignment.pageobjects.HomePage;
import assignment.pageobjects.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {

	private HomePage homePage;
	private CreateAccountPage createAccountPage;
	private AccountPage accountPage;
	private SignInPage signInPage;

	@Given("the user is on the Home page")
	public void theUserIsOnTheCreateAnAccountPage() throws IOException {
		try {
			homePage = launchApplication();
		} catch (Exception e) {
			System.out.print("Failed to open home page: " + e.getMessage());
		}
	}

	@When("the user click on create account button")
	public void theUserClickOnCreateAccount() {
		try {
			createAccountPage = homePage.clickCreateAccount();
		} catch (Exception e) {
			System.out.print("Create account button not clicked: " + e.getMessage());
		}
	}

	@When("the user enters {string} as first name")
	public void theUserEntersFirstName(String firstName) {
		try {
			createAccountPage.enterFirstName(firstName);
		} catch (Exception e) {
			System.out.print("Note able to enter firstname, Account creation form may not open: " + e.getMessage());
		}
	}

	@When("the user enters {string} as last name")
	public void theUserEntersLastName(String lastName) {
		try {
			createAccountPage.enterLastName(lastName);
		} catch (Exception e) {
			System.out.print("Note able to last firstname, Account creation form may not open: " + e.getMessage());
		}
	}

	@When("the user enters {string} as email")
	public void theUserEntersEmail(String email) {
		try {
			createAccountPage.enterEmail(email);
		} catch (Exception e) {
			System.out.print("Note able to enter email, Account creation form may not open: " + e.getMessage());
		}
	}

	@When("the user enters {string} as password")
	public void theUserEntersPassword(String password) {
		try {
			createAccountPage.enterPassword(password);
		} catch (Exception e) {
			System.out.print("Note able to enter password, Account creation form may not open: " + e.getMessage());
		}
	}

	@When("the user enters {string} as confirm password")
	public void theUserEntersConfirmPassword(String confirmPassword) {
		try {
			createAccountPage.enterConfirmPassword(confirmPassword);
		} catch (Exception e) {
			System.out.print(
					"Note able to enter confirm password, Account creation form may not open: " + e.getMessage());
		}
	}

	@When("the user clicks on the Create an Account button")
	public void theUserClicksOnTheCreateAnAccountButton() {
		try {
			accountPage = createAccountPage.clickCreateAccount();
		} catch (Exception e) {
			System.out.print("Button not cliecked: " + e.getMessage());
			driver.close();
		}
	}

	@When("the account should be created successfully, and the user is redirected to the Account Page")
	public void theUserInfo() throws InterruptedException {
		try {
			Assert.assertTrue(driver.getCurrentUrl().contains("customer/account/"));
		} catch (Exception e) {
			System.out.print("Not able to see my account, May issue in enter field value: " + e.getMessage());
			driver.close();
			throw e;
		}
	}

	@And("the user should able to see Account information {string} {string} {string}")
	public void userInfoCheck(String firstname, String lastName, String email) {
		try {
			List<String> substringList = Arrays.asList(firstname, lastName, email);
			Assert.assertTrue(substringList.stream().allMatch(accountPage.getAccountInfo()::contains));
		} catch (Exception e) {
			System.out.print("Not able to found account info: " + e.getMessage());
		} finally {
			driver.close();
		}
	}

	@Then("the error messages {string} are displayed for the empty mandatory fields on {string} page")
	public void mandatoryFiledError(String message, String page) {
		try {
			if(page.equals("Sign Up")) {
			Assert.assertEquals(message, createAccountPage.getFirstNameError());
			Assert.assertEquals(message, createAccountPage.getLastNameError());
			Assert.assertEquals(message, createAccountPage.getEmailError());
			Assert.assertEquals(message, createAccountPage.getPassError());
			Assert.assertEquals(message, createAccountPage.getCnfPassError());
			} else {
				Assert.assertEquals(message, signInPage.getEmptyPasswordError());
				Assert.assertEquals(message, signInPage.getEmailError());
			}
		} catch (Exception e) {
			System.out.print("Not able to found error message: " + e.getMessage());
		} finally {
			driver.close();
		}

	}

	@Then("the error messages {string} is displayed for the field {string} on {string} page")
	public void invalidField(String message, String field, String page) {
		try {
			switch (field) {
			case "email":
				Assert.assertEquals(message,
						page.equals("SignIn") ? signInPage.getEmailError() : createAccountPage.getEmailError());
				break;
			case "password":
				Assert.assertEquals(message,
						page.equals("SignIn") ? signInPage.getEmptyPasswordError() : createAccountPage.getPassError());
				break;
			case "confirm pasword":
				Assert.assertEquals(message, createAccountPage.getCnfPassError());
				break;
			case "firstname":
				Assert.assertEquals(message, createAccountPage.getFirstNameError());
				break;
			case "lastname":
				Assert.assertEquals(message, createAccountPage.getLastNameError());
				break;
			default:
				Assert.assertEquals(message, page.equals("SignIn") ? signInPage.getInvalidEmailOrPassError() : createAccountPage.getPresentText());

			}
		} catch (Exception e) {
			System.out.print("Not able to found error message: " + e.getMessage());
		} finally {
			driver.close();
		}

	}

	@When("the user should be able to LogIn and the user is redirected to the Home Page")
	public void theUserClickOnSignInButton() throws InterruptedException {
		Assert.assertEquals(homePage.getUrl(), driver.getCurrentUrl());
	}

	@When("the user click on sigin button")
	public void theUserClickOnSignIn() {
		try {
			signInPage = homePage.clickSignIn();
		} catch (Exception e) {
			System.out.print("Create account button not clicked: " + e.getMessage());
		}
	}

	@When("the user enters {string} in email")
	public void theUserEnterEmail(String email) {
		try {
			signInPage.enterEmail(email);
		} catch (Exception e) {
			System.out.print("Note able to enter email, Account creation form may not open: " + e.getMessage());
		}
	}

	@When("the user enters {string} in password")
	public void theUserEnterPassword(String password) {
		try {
			signInPage.enterPassword(password);
		} catch (Exception e) {
			System.out.print("Note able to enter password, Account creation form may not open: " + e.getMessage());
		}
	}

	@When("the user clicks on the Sign in button")
	public void theUserClicksOnTheSignInButton() {
		try {
			homePage = signInPage.clickSignIn();
		} catch (Exception e) {
			System.out.print("Button not cliecked: " + e.getMessage());
			driver.close();
		}
	}

	@And("the user should able to see {string} {string} on Home Page")
	public void userLogInCheck(String firstname, String lastName) {
		try {
			List<String> substringList = Arrays.asList(firstname, lastName);
			Assert.assertTrue(substringList.stream().allMatch(homePage.getWelcomeTag()::contains));
		} catch (Exception e) {
			System.out.print("Not able to found info may not be on homepage: " + e.getMessage());
		} finally {
			driver.close();
		}
	}

}
