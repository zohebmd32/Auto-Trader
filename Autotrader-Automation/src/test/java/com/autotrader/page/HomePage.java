package com.autotrader.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private static String PAGE_TITLE="New Cars, Used Cars - Find Cars for Sale and Reviews at Autotrader";
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver =driver; 
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//*[text()='Continue to Autotrader']")
	private List<WebElement> continueToAutoTraderBtn;
	
	@FindBy(xpath = "//img[@class='display-inline-block display-lg-none ae-img']/ancestor::a")
	private WebElement homePageTitle;

	@FindBy(xpath = "//span[@title='Browse by Make']")
	private WebElement browseByMakeLink;

	@FindBy(xpath = "//span[@title='Browse by Style']")
	private WebElement browseByStyleLink;

	@FindBy(xpath = "//a[text()='Advanced Search']")
	private WebElement advancedSearchLink;

	@FindBy(xpath = "//button[@id='search']")
	private WebElement searchButton;

	@FindBy(xpath = "//select[@name='makeCodeListPlaceHolder']")
	private WebElement autotraderMakeDropDown;

	@FindBy(xpath = "//select[@name='modelCodeListPlaceHolder']")
	private WebElement modelDropDown;
	
	public void verifyUserIsOnHomepage() {
		Assert.assertEquals("Home Page is not displayed", PAGE_TITLE, driver.getTitle());
	}

	public void verifyBrowseByMakeIsPresent() {
		Assert.assertTrue("Browse By Make link is not present on Home Page", browseByMakeLink.isDisplayed());
	}
	
	public void verifyBrowseByStyleIsPresent() {
		Assert.assertTrue("Browse By Style link is not present on Home Page", browseByStyleLink.isDisplayed());
	}
	
	public void verifyAdvanceSearchIsPresent() {
		Assert.assertTrue("Advanced Search link is not present on Home Page", advancedSearchLink.isDisplayed());
	}
	
	public void verifySearchButtonIsPresent() {
		Assert.assertTrue("Search Button is not present on Home Page", searchButton.isDisplayed());
	}
	
	public AdvancedSearchPage clickOnAdvancedSearchLink() {
		advancedSearchLink.click();
		return new AdvancedSearchPage(driver);
	}
	
	public void verifyMakeDropdownIsPresent() {
		Assert.assertTrue("Make Drop down is not present on Home Page", autotraderMakeDropDown.isDisplayed());
	}
	
	public void verifyModelDropdownIsPresent() {
		Assert.assertTrue("Model Drop down is not present on Home Page", modelDropDown.isDisplayed());
	}
	
	public void clickContinueToAutoTrader() {
		if(continueToAutoTraderBtn.size()>0)
		continueToAutoTraderBtn.get(0).click();
	}
}
