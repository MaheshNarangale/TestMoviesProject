package com.Movies.pageObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class wikipediaHomeSearchBox 
{
	 WebDriver driver;
     By serachbox =By.xpath("//input[@id='searchInput']");
     By submit = By.xpath("//button[@type='submit']");
     By releasedate =By.xpath("//body[1]/div[3]/div[3]/div[5]/div[1]/table[1]/tbody[1]/tr[12]/td[1]/div[1]/ul[1]/li[1]");
     By releaseCountry =By.xpath("//td[contains(text(),'India')]");
     
     public wikipediaHomeSearchBox( WebDriver driver)
     {
    	 this.driver=driver;  	 
     }  
     public void SearchBoxes(String value)
     {
    	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	 driver.findElement(serachbox).sendKeys(value);
     }
     public void ClickAction()
     {
    	 driver.findElement(submit).click();
     }
     
     public String  releasedates() throws InterruptedException
     {
    	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	JavascriptExecutor js=(JavascriptExecutor)driver;
     	Thread.sleep(2000); 
    	WebElement element= driver.findElement(releasedate);
    	js.executeScript("arguments[0].scrollIntoView();",element);
    	js.executeScript("arguments[0].style.border='3px solid red'",element);
    	String getext=element.getText();
		return getext;    	
     }
     public String releaseCountrye() throws IOException
     {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 WebElement element1= driver.findElement(releaseCountry);
    	 js.executeScript("arguments[0].style.border='3px solid red'",element1);
    	 
    	TakesScreenshot ts = (TakesScreenshot)driver;
     	File src = ts.getScreenshotAs(OutputType.FILE);
     	
     	File trg = new File("C:\\Users\\admin\\eclipse-workspace2\\moviesValidation\\ScreenShot\\\\date.png");
     	FileHandler.copy(src, trg);		
     	
    	 String getextCountry =element1.getText();
    	 return getextCountry;        
    	
     }
}
