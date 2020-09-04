
package stepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GlobalPage;

public class GlobalSteps extends BaseClass {
	//public static WebDriver driver;
	//public GlobalPage lp;
	@Before
	public void setup() throws IOException
	{
			
	}
	

@Given("User Launch Chrome browser")
public void user_launch_chrome_browser() throws IOException {
	
	//Logging
			logger=Logger.getLogger("CucumberBDD");
			PropertyConfigurator.configure("Log4j.properties");
			logger.setLevel(Level.DEBUG);
			

			//Load properties file
			configProp= new Properties();
			FileInputStream configPropfile = new FileInputStream("config.properties");
			configProp.load(configPropfile);
			
			String br=configProp.getProperty("browser"); //getting the browser name from config.properties file
			System.out.println(br);

			System.out.println(configProp.getProperty("firefoxpath"));

			//Launching browser
			if (br.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
				driver = new FirefoxDriver();
			}

			else if (br.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
				driver = new ChromeDriver();
			}
			
			else if (br.equals("ie")) {
				System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
				driver = new InternetExplorerDriver();
			}

	logger.info("************* Launching Browser *****************");
	gp = new GlobalPage(driver);
	  
   
}

@When("User opens URL {string}")
public void user_opens_url(String url) {
	logger.info("************* Opening URL  *****************");
	driver.get(url);
    
}
@When("User enters Email as {string} and Password as {string}")
public void user_enters_email_as_and_password_as(String email, String password) {
	logger.info("************* Prvding user and password *****************");
   gp.setUserName(email);
   gp.setPassword(password);
}

@When("Click on Login")
public void click_on_login() throws InterruptedException {
	logger.info("************* click on login *****************");
    gp.clickLogin();
    Thread.sleep(3000);
}






@When("User click on Log out link")
public void user_click_on_log_out_link() throws InterruptedException {
	logger.info("************* clciking on logout *****************");
   gp.clickLogout();
   Thread.sleep(3000);
}
@Then("close the browser")
public void close_browser() {
	logger.info("************* cloding browser *****************");
	  driver.close();
	}


}
