package com.lma.testScriptsPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.lma.pages.HomePage;
import com.lma.pages.LogOutPage;
import com.lma.pages.LoginPage;
import com.lma.testbase.TestBase;
import com.lma.utility.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	LogOutPage logoutpage;
	String sheetName = "LoginPage";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homePage = new HomePage();
		logoutpage = new LogOutPage();
	}

	@DataProvider
	public Object[][] getLoginPageTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider="getLoginPageTestData", invocationCount=1)
	public void loginToAppTest(String username, String password) {
		homePage = loginpage.login(username, password);
		String userName = loginpage.verifyLoggedUserName();
		Assert.assertEquals(userName, "Santosh", "Logged user name not matched");
		logoutpage.signOutApp();
	}

	@Test(priority = 2, dependsOnMethods = {"loginToAppTest"})
	public void verifyPageTitleTest() {
		String pageTitle1 = loginpage.varifyPageTitle();
		Assert.assertEquals(pageTitle1,	"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!",	"Home page title not matched");
	}

	@AfterMethod
	public void teardown() {
		TestBase.quitBrowser();
	}

}
