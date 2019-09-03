package com.lma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.lma.testbase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	@CacheLookup
	private WebElement username;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	@CacheLookup
	private WebElement password;
	@FindBy(xpath = "(//span[text()='Login'])[2]")
	private WebElement signIn_Button;
	@FindBy(xpath = "//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	private WebElement loggedUserName;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String varifyPageTitle() {
		String pageTitle = driver.getTitle();
		//System.out.println(pageTitle);
		return pageTitle;
	}

	public String verifyLoggedUserName() {
		highLightElementDuringRunTime(loggedUserName);
		String userName = loggedUserName.getText();
		//System.out.println(" Logged user name in UI " + userName);
		return userName;
	}

	public HomePage login(String uName, String pwd) {

		//highLightElementDuringRunTime(username);
		username.sendKeys(uName);
		//highLightElementDuringRunTime(password);
		password.sendKeys(pwd);
		//highLightElementDuringRunTime(signIn_Button);
		signIn_Button.click();

		return new HomePage();
	}

}
