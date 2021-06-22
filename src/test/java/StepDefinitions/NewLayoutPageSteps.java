package StepDefinitions;

import java.util.List;
import java.util.Map;

import com.pages.LeadsLandingPage;
import com.pages.LoginPage;
import com.pages.NewEditLayoutPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class NewLayoutPageSteps {
	
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private LeadsLandingPage leadsLandingPage;
	private NewEditLayoutPage newEditPage=new NewEditLayoutPage(DriverFactory.getDriver());
	
	@Given("User has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable dataTable) {
		List<Map<String, String>> credList=dataTable.asMaps();
		String username=credList.get(0).get("username");
		String password=credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://tpbnk.crmnext.com/g7/app/CRMNextObject/Home/Lead");
		leadsLandingPage=loginPage.doLogin(username, password);
	}

	@Given("user navigates to new edit page")
	public void user_navigates_to_new_edit_page() {

		leadsLandingPage.newButton();
		leadsLandingPage.select_layout("Khoản vay");
	}

	@When("^user enter the data \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_the_data_and_and_and_and_and_and_and(String cardt, String LS,String city1,String SC,String lname,String mob,String natID,String thin) throws Exception {

		newEditPage.entercardtype(cardt);
		
		newEditPage.enterleadsource(LS);
		
		newEditPage.enterBranch(city1);
		
		newEditPage.enterstatuscode(SC);
		
		newEditPage.enterlastname(lname);
		
		newEditPage.entermobile(mob);
		
		newEditPage.enternationalID(natID);
		
		newEditPage.entercity(thin);
		
		newEditPage.clicksavebutton();
		
		newEditPage.dedupepopup_ignorecreate();
		
		newEditPage.updatelead();
		
		newEditPage.getLeadID();
		
		newEditPage.newButton();
		
		newEditPage.select_layout();
	}

	@And("user clicks on save button")
	public void user_clicks_on_save_button() {
	    
	}

	@And("user clicks on New button")
	public void user_clicks_on_new_button() {
	   
	}	

}
