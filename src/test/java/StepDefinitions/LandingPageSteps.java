package StepDefinitions;

import java.util.List;
import java.util.Map;

import com.pages.LeadsLandingPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageSteps {
	
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private LeadsLandingPage leadsLandingPage;
	
	@Given("User has laready logged in to the application")
	public void user_has_laready_logged_in_to_the_application(DataTable dataTable) {
	
		List<Map<String, String>> credList=dataTable.asMaps();
		String username=credList.get(0).get("username");
		String password=credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://tpbnk.crmnext.com/g7/app/CRMNextObject/Home/Lead");
		leadsLandingPage=loginPage.doLogin(username, password);
	}

	@Given("user is on Leads landing page")
	public void user_is_on_leads_landing_page() {

		leadsLandingPage.getLandingPageTitle();
		
	}

	@When("user clicks on new button")
	public void user_clicks_on_new_button() {
		leadsLandingPage.newButton();

	}

	@When("user clicks on {string}")
	public void user_clicks_on(String layoutName) {

		leadsLandingPage.select_layout(layoutName);
	}

}
