package TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
	(features= {"src/test/resources/AppFeature"}, 
	 glue= {"StepDefinitions","AppHooks"},
	 plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	 strict=true,//it will check if any step is not defined in step definition file
	 dryRun= false //to check if mapping proper between feature file and step definition file
	 
)
public class TestRunnerFile {

}
