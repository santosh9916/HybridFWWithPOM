package com.lma.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.lma.utility.TestUtil;
import com.lma.utility.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event_driver;
	public static WebEventListener webEventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/santoshbihari.m/eclipse-workspace/HybridFWWithPOM/src/main/java/com/lma"
							+ "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/data/chromedriver");
			/*
			 * DesiredCapabilities caps = DesiredCapabilities.chrome(); LoggingPreferences
			 * logPrefs = new LoggingPreferences(); logPrefs.enable(LogType.BROWSER,
			 * Level.ALL); caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			 */
			driver = new ChromeDriver();
		} /*
			 * else if (browserName.equals("safari")) {
			 * System.setProperty("webdriver.safari.driver", "/data/safariver"); driver =
			 * new SafariDriver(); } else if (browserName.equals("firefox")) {
			 * System.setProperty("webdriver.safari.driver", "/data/safariver"); driver =
			 * new SafariDriver(); }
			 */

		event_driver = new EventFiringWebDriver(driver);
		webEventListener = new WebEventListener();
		event_driver.register(webEventListener);
		driver = event_driver;

		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		TestBase.analyzeLog();
	}

	public void highLightElementDuringRunTime(WebElement ele) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px solid red;');", ele);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void analyzeLog() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			// do something useful with the data
		}
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void closeBrowser() {
		driver.close();
	}

	
}
