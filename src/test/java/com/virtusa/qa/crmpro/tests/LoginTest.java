package com.virtusa.qa.crmpro.tests;

import org.openqa.selenium.WebDriver;
import com.virtusa.qa.crmpro.pages.HomePage;
import com.virtusa.qa.crmpro.pages.LoginPage;


public class LoginTest extends TestBase{

	LoginPage lpage;
    WebDriver driver;
	
    public LoginTest(WebDriver driver)
    {
    this.driver=driver;	
    lpage=new LoginPage(this.driver);
    	
    }
          
	public void enterValidCredentials()
	{
	 
	 lpage.setUserName(prop.getProperty("username"));
	 lpage.setPassword(prop.getProperty("password"));
		
	}
	public HomePage clickLogin()
	{
	    lpage.clickButton();
		return new HomePage(this.driver);
		
	}
	
	public void enterCredentials(String username,String password) {
		
		lpage.setUserName(username);
		lpage.setPassword(password);
		
	}
	public boolean isHomePageDisplayed()
	{
		driver.switchTo().frame("mainpanel");
		return lpage.isHomePageDisplayed();
		
	}
}
