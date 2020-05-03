package com.autotrader.page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

	public SearchResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(@class,'results-text-container')]")
	private WebElement totalResultsText;

	@FindBy(xpath = "//div[@data-cmp='loadingIndicator']//a[contains(@href,'cars-for-sale/vehi')]")
	private List<WebElement> carNames;

	public void verifySearchResults(String brand) {
		System.out.println("Total Search Results: " + totalResultsText.getText().split(" ")[2]);
		for (WebElement carName : carNames) {
			Assert.assertTrue(brand + " car is not matched in " + carName.getText(), carName.getText().contains(brand));
		}
	}

}
