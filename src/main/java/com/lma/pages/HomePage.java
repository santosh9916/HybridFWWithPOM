package com.lma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lma.testbase.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//span[text()='Electronics']")
	WebElement electronis;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
public String homePageTitle() {
	String homePageTitle = driver.getTitle();
	return homePageTitle;
}
	public ElectronicsPage electronics() {

		return new ElectronicsPage();
	}
}
