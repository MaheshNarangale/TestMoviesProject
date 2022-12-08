package com.Movies.TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Movies.pageObject.GooglePage;
import com.Movies.pageObject.ImdbHomePage;
import com.Movies.pageObject.ImdbHomeSearchBox;


public class TC_SearchBoxImbd_001 extends BaseClass
{
	public String  ActualreleasedateofIMBD;
	public String ActualreleaseCountryIMBD;
	
	@Test(priority=1)
	public void HomePageTitle()
	{
		GooglePage page = new GooglePage(driver);
		page.googleSearchBox("IMDB");
		page.Enterbutton();
		ImdbHomePage seleclink =new ImdbHomePage(driver);
		seleclink.imdblink();
		String ActualTitlepage=seleclink.getTitleofHomePage();
		String VerifyTitle ="IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
		Assert.assertEquals(ActualTitlepage,VerifyTitle);
	  }	
	@Test(priority=2,dependsOnMethods= {"HomePageTitle"})
	public void validatedCountry() throws Exception
	 {
		ImdbHomeSearchBox search = new ImdbHomeSearchBox(driver);
		search.searchingBox("Pushpa: The Rise");
		search.ClickAction();
		search.moviesselect();
		search.scrollpageDown();	
		 ActualreleasedateofIMBD=search.releasedat();
		 ActualreleaseCountryIMBD =search.releaseCountry();
		 String expectedCountry="India";
		System.out.println(ActualreleaseCountryIMBD+"  "+ActualreleasedateofIMBD);	
		Assert.assertEquals(ActualreleaseCountryIMBD,expectedCountry);
	 }
	@Test(priority=3,dependsOnMethods= {"validatedCountry"})
	public void Datevalidate()
	{
		String expecteddate ="December 17, 2021";
		Assert.assertEquals(ActualreleasedateofIMBD,expecteddate);		
	}
}
