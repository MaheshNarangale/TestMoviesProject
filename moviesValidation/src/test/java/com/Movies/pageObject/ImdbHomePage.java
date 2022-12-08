package com.Movies.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbHomePage 
{
    WebDriver driver;
    By selectimdbLink =By.xpath("//h3[contains(text(),'IMDb: Ratings, Reviews, and Where to Watch the Bes')]");
      
   public  ImdbHomePage(WebDriver driver)
   {
	   this.driver = driver;
   }
   public void imdblink()
   {
	   driver.findElement(selectimdbLink).click();
   }
   
   public String getTitleofHomePage()
   {
	  String title= driver.getTitle();
	  return title;
   }
 
   
}
