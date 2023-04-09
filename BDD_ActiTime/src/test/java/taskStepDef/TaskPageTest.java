package taskStepDef;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;

import com.act.Objectrepo.HomePage;
import com.act.Objectrepo.TaskPage;
import com.act_generic.BaseClass;
import com.act_generic.PropertyFileUtility;

import io.cucumber.java.en.Then;

public class TaskPageTest extends BaseClass {

	BaseClass base;

	public TaskPageTest(BaseClass base) {
		this.base = base;
	}
	
	Random random = new Random();
	String name = "sravan" + random.nextInt(10);

	@Then("Click on Tasks Module")
	public void click_on_tasks_module() throws IOException {
		base.homepage = new HomePage(base.driver);
		base.propertyFileUtility = new PropertyFileUtility();
		base.propertyFileUtility.loadProperty();
		base.homepage.getUsername().sendKeys(base.propertyFileUtility.getusername());
		base.homepage.getPassword().sendKeys(base.propertyFileUtility.getpassword());
		base.homepage.getKeepmeloggedin().click();
		base.homepage.getClickLogin().click();
		base.homepage.getClickTasksModule().click();
	}

	@Then("click on add new button")
	public void click_on_add_new_button() {
		base.taskpage = new TaskPage(base.driver);
		base.taskpage.getClickDropDownAddNew().click();
	}

	@Then("create new customer page will display")
	public void create_new_customer_page_will_display() {
		base.taskpage.getClickNewCus().click();
	}

	@Then("enter all details and click on createcustomer button")
	public void enter_all_details_and_click_on_createcustomer_button() throws InterruptedException {
		Thread.sleep(3000);
		base.taskpage.TaskPageName(base.driver,name);
	}

	@Then("Also i will verify that created name")
	public void also_i_will_verify_that_created_name() throws InterruptedException {
		Thread.sleep(3000);
		int actName = base.taskpage.getFinalName().size();
		
		Assert.assertEquals(actName,1);
	}

}
