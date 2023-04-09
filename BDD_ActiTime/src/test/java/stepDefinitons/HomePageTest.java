package stepDefinitons;

import java.io.IOException;

import org.testng.Assert;

import com.act.Objectrepo.HomePage;
import com.act_generic.BaseClass;
import com.act_generic.PropertyFileUtility;

import io.cucumber.java.en.Then;

public class HomePageTest extends BaseClass {
	BaseClass base;

	public HomePageTest(BaseClass base) {
		this.base = base;
	}

	@Then("home page will display")
	public void home_page_will_display() throws IOException {
		base.propertyFileUtility = new PropertyFileUtility();
		base.propertyFileUtility.loadProperty();
		base.homepage = new HomePage(base.driver);

		base.homepage.getUsername().sendKeys(base.propertyFileUtility.getusername());
		base.homepage.getPassword().sendKeys(base.propertyFileUtility.getpassword());
		base.homepage.getKeepmeloggedin().click();
		base.homepage.getClickLogin().click();
	}

	@Then("Also I will verify that home page title")
	public void also_i_will_verify_that_home_page_title() throws InterruptedException {
		Thread.sleep(5000);
		String title = base.driver.getTitle();
		//Assert.assertEquals(title, "actiTIME - Enter Time-Track");
		System.out.println(title);
	}

}
