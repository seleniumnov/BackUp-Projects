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
		glue = { "stepDefinitions","pageObjects" }, 
		plugin = {
				"rerun:target/failed.txt" }, 
		monochrome = true, 
		tags = { "@Smoke"},
		strict = true

)

public class TestRunner {

}
