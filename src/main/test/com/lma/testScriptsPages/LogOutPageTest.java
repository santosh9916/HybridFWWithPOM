package com.lma.testScriptsPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lma.pages.LogOutPage;
import com.lma.pages.LoginPage;
import com.lma.testbase.TestBase;

public class LogOutPageTest extends TestBase {
LogOutPage logout;
LoginPage loginpage;

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		logout = new LogOutPage();
	}

	@Test
	public void logOutAppTest() throws Exception {
		loginpage.login(prop.getProperty("UserName_leaseManager"), prop.getProperty("Password_leaseManager"));
		logout.signOutApp();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		TestBase.quitBrowser();
	}

}
