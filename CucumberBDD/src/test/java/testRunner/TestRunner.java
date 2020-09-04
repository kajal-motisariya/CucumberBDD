package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//src/test/resources/",
				 glue = "classpath:stepDefinations",
				 dryRun = false,
				 monochrome = true,
				 stepNotifications = true,
				 plugin = {"pretty","html:test-output"})
public class TestRunner {
  
}
