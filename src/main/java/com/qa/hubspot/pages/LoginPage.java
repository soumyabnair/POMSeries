package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.Basepage;

public class LoginPage extends Basepage {

	public WebDriver driver;
	//1. By locators ---OR
	
	By username=By.id("username");
	By password=By.id("password");
	By login=By.id("loginBtn");
	By signup=By.linkText("Sign up");
	
	//2. create constructor of page class:
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. create page Actions
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignuplink() {
		return driver.findElement(signup).isDisplayed();
	}
	
	public HomePage doLogin(String username,String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.login).click();
		
		return new HomePage(driver);
	}
	
}
