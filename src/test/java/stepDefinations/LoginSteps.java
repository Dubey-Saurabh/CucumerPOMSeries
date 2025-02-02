package stepDefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private static String pageTitle;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://practicetestautomation.com/practice-test-login/");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		pageTitle = loginPage.getLoginPageTitle();
		System.out.println("Title of the current page is: " + pageTitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(pageTitle.contains(expectedTitle));

	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}
}
