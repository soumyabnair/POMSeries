package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {

	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(Properties prop) {
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver=new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	
		driver.get(prop.getProperty("url"));
		 return driver;
		
	}
	
	/**
	 * this method is used to initialize the properties from config .properties file
	 * @return prop
	 */
	public Properties init_properies() {
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\soumy\\eclipse-workspace\\POMSeries\\src\\main\\java\\com\\qa\\hubspot\\config");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
}
