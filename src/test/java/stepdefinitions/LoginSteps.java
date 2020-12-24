package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	  DriverFactory.getDriver().get("https://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    title = loginPage.getPageTitle();
	    System.out.println("Login Page title is: "+ title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		    Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	   Assert.assertTrue(loginPage.isForgotPasswordLinkAvailable());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    loginPage.enterPassword(password);
	}

	@When("user clicks on the Login button")
	public void user_clicks_on_the_login_button() {
	   loginPage.clickOnLogin();
	}

}
