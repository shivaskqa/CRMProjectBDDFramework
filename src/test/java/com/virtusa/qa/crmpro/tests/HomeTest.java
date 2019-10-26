package com.virtusa.qa.crmpro.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.virtusa.qa.crmpro.pages.ContactsPage;
import com.virtusa.qa.crmpro.pages.HomePage;

public class HomeTest extends TestBase{

	HomePage hpage;
	ContactsPage cpage;
	WebDriver driver;
	
	public HomeTest(WebDriver driver)
	{
		hpage=new HomePage(driver);
		
	}
	
	public void verifyTabsinHomepage()
	{   hpage=PageFactory.initElements(driver, HomePage.class);
		hpage.isHomeTabDisplayed();
		hpage.isContactsTabDisplayed();
	}
   
	public ContactsPage clickNewContact()
	{
		cpage=hpage.clickNewContact();
		return cpage; 
	}
	

}



