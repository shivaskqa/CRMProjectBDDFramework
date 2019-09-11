package com.virtusa.qa.crmpro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage{

	WebDriver driver;
	
	/* Login Page Web Elements */
	@FindBy(xpath="//input[@name='username']")
	WebElement txt_Username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_Login;
	
		
	@FindBy(xpath="//a[@title='Home']")
	WebElement homeTab;
	
	public LoginPage(WebDriver driver)
	{
	    this.driver=driver;
	    PageFactory.initElements(this.driver,this);

	}
	
	public void setUserName(String username)
	{
		txt_Username.sendKeys(username);
		
	}
	
	public void setPassword(String password)
	{
		txt_Password.sendKeys(password);
	}
	
	public void clickButton()
	{
		btn_Login.submit();
	}
		
	
	
	public boolean isHomePageDisplayed()
	{
		return homeTab.isDisplayed();
		
	}
}
