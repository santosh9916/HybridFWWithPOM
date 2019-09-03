package com.lma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lma.testbase.TestBase;

public class RegistrationPage extends TestBase{
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement closePopup;
	@FindBy(xpath = "//a[text()='Login & Signup']")
	WebElement loginandsignupButton;
	@FindBy(xpath = "//a[text()='New to Flipkart? Create an account']")
	WebElement registrationLink;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement mobileNumberTextField;
	@FindBy(xpath = "//span[text()='CONTINUE']")
	WebElement continueButton;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/input")
	WebElement otpTextField;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/input")
	WebElement setPasswordTextField;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[5]/button[1]")
	WebElement signupButton;
	
	
	public RegistrationPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void newUserRegistration(String mobTxtField, String passwrd) throws Exception {
		
			closePopup.click();
			highLightElementDuringRunTime(loginandsignupButton);
			loginandsignupButton.click();
			highLightElementDuringRunTime(registrationLink);
			registrationLink.click();
			highLightElementDuringRunTime(mobileNumberTextField);
			mobileNumberTextField.sendKeys(mobTxtField);
			highLightElementDuringRunTime(continueButton);
			continueButton.click();
			Thread.sleep(20000);
			highLightElementDuringRunTime(setPasswordTextField);
			setPasswordTextField.sendKeys(passwrd);
			highLightElementDuringRunTime(signupButton);
			signupButton.click();
	
	}

}
