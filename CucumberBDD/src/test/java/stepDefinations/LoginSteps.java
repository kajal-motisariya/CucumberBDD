package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass {
	public WebDriver driver = GlobalSteps.driver;


@Then("Page Title should be {string}")
public void page_title_should_be(String title) throws InterruptedException {
	if(driver.getPageSource().contains("Login was unsuccessful.")) {
		logger.info("************* Login failed *****************");
		driver.close();
		Assert.assertTrue(false);
	}else {
		logger.info("************* Login Passed *****************");
		Assert.assertEquals(title, driver.getTitle());
	}
	Thread.sleep(3000);
}




}
