package com.lma.testScriptsPages;

import org.testng.annotations.Test;

import com.lma.pages.HomePage;
import com.lma.pages.LogOutPage;
import com.lma.pages.LoginPage;
import com.lma.pages.RegistrationPage;
import com.lma.testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;

public class RegistrationPageTest extends TestBase{
	
	RegistrationPage registrationPage;
	public RegistrationPageTest() {
		super();
	}
 
  @BeforeMethod
  public void setup() {
		initialization();
		registrationPage = new RegistrationPage();
	}
  
  @Test
  public void newUserRegistrationTest() throws Exception {
	  registrationPage.newUserRegistration("9439688185", "Sant@2136");
  }
  
  @AfterMethod
  public void afterMethod() {
	  quitBrowser();
  }

}
