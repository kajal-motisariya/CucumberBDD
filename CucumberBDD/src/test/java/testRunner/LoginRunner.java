package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:login.feature",
				 glue = "classpath:stepDefinations",
				 dryRun = true,
				 monochrome = true,
				 stepNotifications = true,
				 plugin = {"pretty","html:test-output"})

public class LoginRunner {

}
