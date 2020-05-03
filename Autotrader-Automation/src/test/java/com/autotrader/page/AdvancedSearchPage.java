package com.autotrader.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedSearchPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public AdvancedSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
	}

	@FindBy(xpath = "//*[text()='Search Cars for Sale']")
	private WebElement advancedSearchPageTitle;

	@FindBy(id = "zipundefined")
	private WebElement zipCodeField;

	@FindBy(xpath = "//*[@value='CERTIFIED']")
	private WebElement certifiedConditionCheckBox;

	@FindBy(xpath = "//*[@value='CONVERT']")
	private WebElement convertiableCheckBox;

	@FindBy(name = "startYear")
	private WebElement fromYearDropDown;

	@FindBy(name = "endYear")
	private WebElement toYearDropDown;

	@FindBy(name = "makeFilter0")
	private WebElement makeDropDown;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchResultsButton;

	public void waitForAdvancedSearchPageLoad() {
		wait.until(ExpectedConditions.stalenessOf(advancedSearchPageTitle));
	}

	public void enterZipcode(String zipCode) {
		zipCodeField.sendKeys(zipCode);
	}

	public void selectCertifiedCheckbox() {
		certifiedConditionCheckBox.click();
	}

	public void selectConvertiableCheckbox() {
		convertiableCheckBox.click();
	}

	public void selectFromYear(String fromYear) {
		Select fromDropDown = new Select(fromYearDropDown);
		fromDropDown.selectByValue(fromYear);
	}

	public void selectToYear(String toYear) {
		Select toDropDown = new Select(toYearDropDown);
		toDropDown.selectByValue(toYear);
	}

	public void selectMakeVehicle(String brand) {
		Select makeDropDownSel = new Select(makeDropDown);
		makeDropDownSel.selectByValue(brand);
	}

	public SearchResultsPage clickSearchButton() {
		searchResultsButton.click();
		return new SearchResultsPage(driver);
	}
}
