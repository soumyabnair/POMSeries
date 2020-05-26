package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.ConstantsUtils;

public class LoginPageTest {
	Basepage basepage;
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	
	@BeforeTest
	public void setup() {
		basepage=new Basepage();
	   prop=basepage.init_properies();
		driver=basepage.init_driver(prop);
		loginpage=new LoginPage(driver);
		
	}
	
	@Test(priority=2)
	public void doVerifyLoginPageTitletest() {
		String title=loginpage.getLoginPageTitle();
		System.out.println("Login page title is:"+title);
		Assert.assertEquals(title,ConstantsUtils.Login_Page_title,"LoginPage title is not matched.....");
	}
	
	@Test(priority=1)
	public void doVerifySignupLinkTest(){
		boolean flag=loginpage.verifySignuplink();
		Assert.assertTrue(flag,"Sign up link is npt displayed....");
		
	}
	
	@Test(priority=3)
	public void doVerifyLoginTest() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	@AfterTest
	public void doClose() {
		driver.quit();
	}
	
	

}
