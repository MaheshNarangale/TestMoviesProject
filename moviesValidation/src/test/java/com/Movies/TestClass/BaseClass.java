package com.Movies.TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Movies.pageObject.GooglePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    
	    driver.get("https://www.google.com");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.quit();
	}

}
