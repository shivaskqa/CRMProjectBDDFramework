package com.virtusa.qa.crmpro.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.virtusa.qa.crmpro.pages.ContactsPage;

import cucumber.api.DataTable;

public class ContactsTest extends TestBase{

	ContactsPage cpage;
	WebDriver driver;
	
	public ContactsTest(WebDriver driver)
	{
		this.driver=driver;
		cpage=new ContactsPage(this.driver);
	}
	
	
	
	public void enterDataInConatctsPage(DataTable data)
	{
		cpage=PageFactory.initElements(driver, ContactsPage.class);
		cpage.setDataInContactsPage(data);
	}
	
	
}
