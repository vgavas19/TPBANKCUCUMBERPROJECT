package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginPageSteps_1 {
	
	private static String title;
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {

			DriverFactory.getDriver().get("https://tpbnk.crmnext.com/g7/app/CRMNextObject/Home/Lead");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title=loginPage.getLoginPageTitle();
		System.out.println("login page title is:" + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		
		
		Assert.assertTrue(title.contains(expectedTitleName));	
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {

		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {

		loginPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);

	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {

		loginPage.clicklogin();
	}

	@Then("user should be navigated to landing page")
	public void user_should_be_navigated_to_landing_page() {

		loginPage.verifyLandingPage();
	}

	@Then("text on landing page should be {string}")
	public void text_on_landing_page_should_be(String string) {

		loginPage.leadsText();
	}
}
