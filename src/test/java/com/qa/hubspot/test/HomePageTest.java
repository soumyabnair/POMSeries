package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.ConstantsUtils;

public class HomePageTest  {
	
	Basepage basepage;
	LoginPage loginpage;
	HomePage homepage;
	WebDriver driver;
	Properties prop;
	
	@BeforeTest
	public void setup() {
		basepage=new Basepage();
		 prop=basepage.init_properies();
		 
		basepage.init_driver(prop);
		 loginpage=new LoginPage(driver);
		 homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void verifyHomePageTitleTest() {
		String title=homepage.getHomePageTitle();
		System.out.println("HomePage title is: "+title);
		Assert.assertEquals(title,ConstantsUtils.Home_Page_title,"HomePage title is not matched....");
	}
	
	@Test(priority=1)
	public void verifyHomePageHeaderTest() {
		String headertext=homepage.getHomePageHeaderText();
		System.out.println("HomePage header is: "+headertext);
		Assert.assertEquals(headertext, ConstantsUtils.Home_Page_header,"Home page header is not matched....");
		
	}
	
	@Test(priority=2)
	public void verifyLoggedInUserTest() {
		String loggedinuser=homepage.getLoggedInUser();
		System.out.println("Logged In User is: "+loggedinuser);
		Assert.assertEquals(loggedinuser,prop.getProperty("accountname"),"Logged In User is not matched...");
	}
	
	
	
	
	
	
	
	
	@AfterTest
	public void doclose() {
		driver.quit();
	}
	

}
