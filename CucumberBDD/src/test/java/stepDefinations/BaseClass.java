package stepDefinations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.GlobalPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public static WebDriver driver;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public GlobalPage gp;
	public LoginPage lp;
	public static Logger logger;
	public Properties configProp;
	
	//Created for generating random string for Unique email
	public static String randomestring(){
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	

}
