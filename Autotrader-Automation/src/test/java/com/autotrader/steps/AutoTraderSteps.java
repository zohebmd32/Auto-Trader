package com.autotrader.steps;

import org.openqa.selenium.WebDriver;

import com.autotrader.common.BaseDriver;
import com.autotrader.common.ConfigFileReader;
import com.autotrader.page.AdvancedSearchPage;
import com.autotrader.page.HomePage;
import com.autotrader.page.SearchResultsPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutoTraderSteps {
	WebDriver driver;
	BaseDriver baseDriver;
	ConfigFileReader configFileReader;
	HomePage homePage;
	AdvancedSearchPage advancedSearchPage;
	SearchResultsPage searchResultsPage;

	@Before
	public void before() {
		baseDriver = new BaseDriver();
		configFileReader = new ConfigFileReader();
		driver = baseDriver.getDriver();
		homePage = new HomePage(driver);
	}

	@After
	public void after() {
		baseDriver.closeDriver();
	}

	@Given("^Launch AutoTrader Application$")
	public void launch_AutoTrader_Application() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		homePage.clickContinueToAutoTrader();
	}

	@Then("^Validate AutoTrader HomePage is displayed$")
	public void validate_AutoTrader_HomePage_is_displayed() throws Throwable {
		homePage.verifyUserIsOnHomepage();
	}

	@Then("^Validate Browse by Make, Browse by Style, Advanced Search are present$")
	public void validate_Browse_by_Make_Browse_by_Style_Advanced_Search_are_present() throws Throwable {
		homePage.verifyBrowseByMakeIsPresent();
		homePage.verifyBrowseByStyleIsPresent();
		homePage.verifyAdvanceSearchIsPresent();
	}

	@Then("^Validate Search button is present$")
	public void validate_Search_button_is_present() throws Throwable {
		homePage.verifySearchButtonIsPresent();
	}

	@Then("^Validate Make and Model dropdowns are present$")
	public void validate_Make_and_Model_dropdowns_are_present() throws Throwable {
		homePage.verifyMakeDropdownIsPresent();
		homePage.verifyModelDropdownIsPresent();
	}

	@When("^Click on advanced search link$")
	public void click_on_advanced_search_link() throws Throwable {
		advancedSearchPage = homePage.clickOnAdvancedSearchLink();
		advancedSearchPage.waitForAdvancedSearchPageLoad();
	}

	@When("^Enter \"([^\"]*)\" in the zip code field$")
	public void enter_in_the_zip_code_field(String zipCode) throws Throwable {
		advancedSearchPage.enterZipcode(zipCode);
	}

	@When("^Select the Certified check box under Condition$")
	public void select_the_Certified_check_box_under_Condition() throws Throwable {
		advancedSearchPage.selectCertifiedCheckbox();
	}

	@When("^Select the Convertible check box under Style$")
	public void select_the_Convertible_check_box_under_Style() throws Throwable {
		advancedSearchPage.selectConvertiableCheckbox();
	}

	@When("^Select \"([^\"]*)\" from From Year drop down$")
	public void select_date_from_drop_down(String fromYear) throws Throwable {
		advancedSearchPage.selectFromYear(fromYear);
	}

	@When("^Select \"([^\"]*)\" from To Year drop down$")
	public void select_date_to_drop_down(String toYear) throws Throwable {
		advancedSearchPage.selectToYear(toYear);
	}

	@When("^Select Make as \"([^\"]*)\" under Make, Model & Trim section$")
	public void select_Make_under_Make_Model_Trim_section(String brand) throws Throwable {
		advancedSearchPage.selectMakeVehicle(brand);
	}

	@When("^Click the button Search at the bottom of the page$")
	public void click_the_button_Search_at_the_bottom_of_the_page() throws Throwable {
		searchResultsPage = advancedSearchPage.clickSearchButton();
	}

	@Then("^Validate that only \"([^\"]*)\" cars are displayed in the results page$")
	public void validate_that_only_brand_cars_are_displayed_in_the_results_page(String brand) throws Throwable {
		searchResultsPage.verifySearchResults(brand);
	}

}
