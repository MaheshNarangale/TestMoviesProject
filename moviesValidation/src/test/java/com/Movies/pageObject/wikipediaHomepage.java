package com.Movies.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wikipediaHomepage 
{
     WebDriver driver;
     By selectlinkpage = By.xpath("//h3[normalize-space()='Wikipedia']");
     public wikipediaHomepage( WebDriver driver)
     {
    	 this.driver=driver;  	 
     }   
     
	public void selectLink() 
     {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	WebElement element= driver.findElement(selectlinkpage);
    	element.click();
     }
	
}
