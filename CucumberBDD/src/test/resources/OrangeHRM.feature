Feature: OrangeHRM Login
Scenario: Logo presence on OrangeHRM home page
	Given I launch chrome browser
	When I open OrangeHRM home page
	Then I verify that the logo present or not
	And close browser
