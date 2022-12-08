package com.Movies.pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage 
{
	WebDriver driver;
	By searchbox =By.xpath("//input[@name=\"q\"]");
	By enterbutton = By.xpath("(//input[@name=\"btnK\"])[2]");

	public GooglePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void  googleSearchBox(String value)
	{
		driver.findElement(searchbox).sendKeys(value);
	}
	public void Enterbutton()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(enterbutton).click();
		
	}
}
