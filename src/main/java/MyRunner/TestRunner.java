package MyRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/punath/Documents/Eclipse Workspace/NaveenJun/JavaPrac/FreeCRMBDDFramework/src/main/java/Features/dealsMap.feature",
		glue = {"stepDefinitions"},
		format= {"pretty", "html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
		monochrome = true,
		strict=true,
		dryRun = false
//		tags = {"@SmokeTest, @RegressionTest"}		//ORed condition - Execute all tests tagged as @SmokeTest or @RegressionTest
//		tags = {"@SmokeTest"}						//Execute all tests tagged as @SmokeTest
//		tags = {"@SmokeTest", "@RegressionTest"}	//ANDed condition - Execute all test cases that are tagged as @SmokeTest and @RegressionTest
//		tags = {"~@SmokeTest", "@RegressionTest"}	//Negation condition - "~" this char is used to skip the marked TAG and that tag will not be executed
		
		)


public class TestRunner 
{
	
}
