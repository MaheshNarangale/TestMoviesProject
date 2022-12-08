package com.Movies.pageObject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ImdbHomeSearchBox 
{
	WebDriver driver;
	By imdbsearchbox = By.xpath("//input[@id='suggestion-search']");
	By clickButton = By.xpath("//button[@id='suggestion-search-button']//*[name()='svg']");
	By selectmovies =By.xpath("//body/div[@id='__next']/main[@role='main']/div[@role='presentation']/div[@role='presentation']/section[@class='ipc-page-background ipc-page-background--base sc-1486e37e-0 coJplq']/div[@class='ipc-page-grid ipc-page-grid--bias-left']/div[@class='ipc-page-grid__item ipc-page-grid__item--span-2']/section[2]/div[2]/ul[1]/li[1]/div[2]");
	By releasedate =By.xpath("(//a[@class=\"ipc-metadata-list-item__icon-link\"])[14]");
	By releasedate1 =By.xpath(" //a[normalize-space()='December 17, 2021 (United States)']");
	By Country =By.xpath("//li[@data-testid='title-details-origin']");
	By Country1=By.xpath("//a[normalize-space()='India']");
	public ImdbHomeSearchBox(WebDriver driver)
	{
		this.driver= driver;
	}
	public void searchingBox(String moviesname)
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(imdbsearchbox).sendKeys(moviesname);
	}
	public void ClickAction()
	{
		driver.findElement(clickButton).click();
	}
	public void moviesselect()
	{
		
		driver.findElement(selectmovies).click();
	}

	public void scrollpageDown() throws Exception 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
    	Thread.sleep(4000);
    	WebElement elementPoint=driver.findElement(releasedate);
    	js.executeScript("arguments[0].scrollIntoView();",elementPoint);
    	js.executeScript("arguments[0].style.border='3px solid red'",elementPoint);
    	WebElement elementPoint2 =driver.findElement(Country);
    	js.executeScript("arguments[0].style.border='3px solid red'",elementPoint2);
    	
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	
    	File trg = new File("C:\\Users\\admin\\eclipse-workspace2\\moviesValidation\\ScreenShot\\\\demo.png");
    	FileHandler.copy(src, trg);		  	
	}
	public String releasedat()
	{
		WebElement dat=driver.findElement(releasedate1);
		String data= dat.getText();
		return data;	
	}
	public String releaseCountry()
	{
		WebElement cuntry =driver.findElement(Country1);
		String country =cuntry.getText();
		return country;
	}
	
}
