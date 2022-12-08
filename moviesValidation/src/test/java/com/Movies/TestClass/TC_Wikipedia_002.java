package com.Movies.TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Movies.pageObject.GooglePage;
import com.Movies.pageObject.wikipediaHomeSearchBox;
import com.Movies.pageObject.wikipediaHomepage;

public class TC_Wikipedia_002 extends BaseClass
{
	public String ActualdateofWikipedia;
	public String ActualCountryWikipedia;
	
	@Test(priority=1)
	public void HomeTitle() throws InterruptedException, IOException
	{
		GooglePage page = new GooglePage(driver);
		page.googleSearchBox("Wikipedia");
		page.Enterbutton();
		wikipediaHomepage  select= new wikipediaHomepage(driver);
		select.selectLink();
		wikipediaHomeSearchBox searching = new wikipediaHomeSearchBox(driver);
		searching.SearchBoxes("Pushpa: The Rise");
		searching.ClickAction();
		ActualdateofWikipedia =searching.releasedates();
		System.out.println( ActualdateofWikipedia);
		ActualCountryWikipedia =searching.releaseCountrye();		
	}
	@Test(priority=2,dependsOnMethods= {"HomeTitle"})
	public void MoviesReleaseDateValidate()
	{
		String Expectedreleasedate ="17 December 2021";
		Assert.assertEquals(ActualdateofWikipedia, Expectedreleasedate);
	}
	@Test(priority=3,dependsOnMethods= {"MoviesReleaseDateValidate"})
	public void MoviesReleaseCountry()
	{
		String expectedCountry ="India";
		Assert.assertEquals(ActualCountryWikipedia, expectedCountry);
	}	
}
