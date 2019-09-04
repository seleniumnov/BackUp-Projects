package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(
						jsonReport = "target/cucumber.json",
						retryCount = 3,
						includeCoverageTags = {"@test"}
						)*/

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/FeatureFiles" }, 
		glue = { "com.project.stepDefinitions","com.project.utilities"}, 
		plugin = { 
				"pretty", 
				"html:target/cucumber-html-report",
				"json:target/cucumber.json",
				"rerun:target/FailedScenarios/failed.txt" 
				}, 
		monochrome = true,
		tags = {"@Hello"}
		

)

public class TestRunner {

}
