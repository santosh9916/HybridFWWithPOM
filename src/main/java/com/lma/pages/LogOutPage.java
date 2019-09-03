package com.lma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lma.testbase.TestBase;
import com.lma.utility.TestUtil;

public class LogOutPage extends TestBase{
	
	
	@FindBy(xpath = "//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	WebElement usericon;
	@FindBy(xpath = "//div[text()='Logout']")
	WebElement signOut_button;
	
	
	public LogOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LogOutPage signOutApp()  {
		
		highLightElementDuringRunTime(usericon);
		TestUtil.mouseHoverAction(usericon);
		highLightElementDuringRunTime(signOut_button);
		signOut_button.click();
		return new LogOutPage();
	}
		
	
}
