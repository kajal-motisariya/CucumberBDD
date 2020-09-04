package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.SearchCustomerPage;

public class CustomerSteps extends BaseClass {
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		addCust=new AddCustomerPage(driver);
		logger.info("********* Verifying Dashboad page title after login successful **************");
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());

	   
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("********* Clicking on customer main menu **************");
		addCust.clickOnCustomersMenu();


	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("********* Clicking on customer sub menu **************");
		addCust.clickOnCustomersMenuItem();

	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		  addCust.clickOnAddnew();
		  Thread.sleep(2000);

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		 Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());

		
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomestring() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer roles
		// Add the customer to 'Guests' or 'Registered' customer role
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Pavan");
		addCust.setLastName("Kumar");
		addCust.setDob("7/05/1985"); // Format: D/MM/YYY
		addCust.setCompanyName("busyQA");
		addCust.setAdminContent("This is for testing.........");

	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("********* Saving customer details **************");   
		addCust.clickOnSave();
		   Thread.sleep(2000);

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));

	}
	
	//search customer by email id

@When("Enter customer EMail")
public void enter_customer_e_mail() {
  
	searchCust=new SearchCustomerPage(driver);
	logger.info("********* Searching customer details by Email **************");
	searchCust.setEmail("victoria_victoria@nopCommerce.com");

}

@When("Click on search button")
public void click_on_search_button() throws InterruptedException {
	searchCust.clickSearch();
	Thread.sleep(3000);

}

@Then("User should found Email in the Search table")
public void user_should_found_email_in_the_search_table() {
	boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	Assert.assertEquals(true, status);

   
}

//steps for searching a customer by Name................
@When("Enter customer FirstName")
public void enter_customer_FirstName() {
	logger.info("********* Searching customer details by Name **************");
	searchCust=new SearchCustomerPage(driver);
	searchCust.setFirstName("Victoria");
}

@When("Enter customer LastName")
public void enter_customer_LastName() {
	searchCust.setLastName("Terces");
}

@Then("User should found Name in the Search table")
public void user_should_found_Name_in_the_Search_table() {
	boolean status=searchCust.searchCustomerByName("Victoria Terces");
	Assert.assertEquals(true, status);
}





}
