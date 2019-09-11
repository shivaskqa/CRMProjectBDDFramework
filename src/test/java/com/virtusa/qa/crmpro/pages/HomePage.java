package com.virtusa.qa.crmpro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{

	
	WebDriver driver;
	LoginPage lpage;
	
	@FindBy(xpath="//a[@title='Home']")
	WebElement homeTab;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsTab;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactsTab;
	
	public HomePage(WebDriver driver)
	{
	  	this.driver=driver;
	  	PageFactory.initElements(this.driver, this);
	  	
	}

	public boolean isHomeTabDisplayed()
	{
		return homeTab.isDisplayed();
	  
	} 
    public boolean isContactsTabDisplayed()
    {
    	return contactsTab.isDisplayed();
    }
    
    public void hoverToContactsTab()
    {   System.out.println(driver==null); 
    	driver.switchTo().frame("mainpanel");
    	System.out.println(driver==null);
    	Actions action=new Actions(driver);
    	System.out.println(action==null);
    	System.out.println(driver.getTitle());
    	System.out.println(contactsTab==null);
    	if(contactsTab.isDisplayed())
    	action.moveToElement(contactsTab).build().perform();
    	    	
    }
    
    public boolean isNewContactsDisplayed()
    {
    	return newContactsTab.isDisplayed();
    }
    
    public ContactsPage clickNewContact()
    {
    	newContactsTab.click();
       return new ContactsPage(driver);	
    }
    
}
