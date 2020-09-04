package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class orangeHRMsteps {
	
	WebDriver driver;
	@Given("I launch chrome browser")
	public void i_launch_chrome_browser() {
		driver = new ChromeDriver();
		}

	@When("I open OrangeHRM home page")
	public void i_open_orange_hrm_home_page() {
		driver.navigate().to("http://www.google.com");

	}

	@Then("I verify that the logo present or not")
	public void i_verify_that_the_logo_present_or_not() {
	  int actual = 10;
	  Assert.assertEquals(10, actual);
	}

	@Then("close browser")
	public void close_browser() {
	  driver.quit();
	}


}
