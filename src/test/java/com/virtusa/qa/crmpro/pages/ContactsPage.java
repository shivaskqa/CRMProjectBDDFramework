package com.virtusa.qa.crmpro.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;


public class ContactsPage{

	public WebDriver driver;
	
	
	@FindBy(xpath="//select[@name='title']")
	@CacheLookup
	WebElement selectTitle;
	
	@FindBy(css="input#first_name")
	@CacheLookup
	WebElement setFirstName;
	
	@FindBy(css="input#surname")
	@CacheLookup
	WebElement setLastName;
	
	@FindBy(xpath="//form[@id='contactForm']//*[@type='submit']")
	@CacheLookup
	WebElement btn_Save;
	
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}

	public void setTitle(String title)
	{
		Select select=new Select(selectTitle);
		select.selectByVisibleText(title);
	}
	
	public void setFirstName(String fname)
	{
		setFirstName.sendKeys(fname);
	}
	public void setSurname(String sname)
	{
		setLastName.sendKeys(sname);
	}
	
	public void setDataInContactsPage(DataTable data)
	{
		List<String> dataset=data.asList(String.class);
		
		setTitle(dataset.get(0));
		setFirstName(dataset.get(1));
		setSurname(dataset.get(2));
	}
	
	public void clickSave()
	{
		btn_Save.submit();
	}
	
}
