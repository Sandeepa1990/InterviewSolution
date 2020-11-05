package jpmcInterviewSolution.CucumberBDD;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(features = "src/test/resources/TheGaurdianNews",
				glue = "jpmcInterviewSolution.StepDefinitions", 
				plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber/cucumber.json" },
				monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
