package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
       features={"./src/test/java/features/ACTITimeLoginPage.feature:28"},		
		glue= {"stepDefinitons","taskStepDef","hook"},
				plugin= {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"html:target/cucumberReport.html",
						"json:target/cucumberReport.json"
						},
		dryRun=false,
		monochrome=true,
		tags= "not @SmokeTest" // for group execution 
		
       
		)

public class Runner extends AbstractTestNGCucumberTests{
	
}
