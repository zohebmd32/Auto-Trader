package com.autotrader.common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseDriver {
	private WebDriver driver;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String CHROME_DRIVER_PATH = "/src/test/resources/Drivers/chromedriver";
	private static final String FIREFOX_DRIVER_PATH = "/src/test/resources/Drivers/geckodriver.exe";
	private ConfigFileReader configFileReader;
	String driverType;

	public BaseDriver() {
		configFileReader = new ConfigFileReader();
		driverType = configFileReader.getBrowser();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (driverType.toUpperCase()) {
		case "FIREFOX":
			System.setProperty(FIREFOX_DRIVER_PROPERTY, System.getProperty("user.dir") +FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		case "CHROME":
			System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir") + CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "INTERNETEXPLORER":
			driver = new InternetExplorerDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		if (driver != null) {
			//driver.close();
			driver.quit();
			
			try {
				Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}