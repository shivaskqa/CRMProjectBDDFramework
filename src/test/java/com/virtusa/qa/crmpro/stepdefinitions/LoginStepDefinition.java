package com.virtusa.qa.crmpro.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.virtusa.qa.crmpro.pages.LoginPage;
import com.virtusa.qa.crmpro.tests.LoginTest;
import com.virtusa.qa.crmpro.tests.TestBase;
import com.virtusa.qa.crmpro.utils.Hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition {

	
	LoginTest test;
	LoginPage lpage;
	WebDriver driver;
	Hooks hooks;
		
	
	@Given("^that user launches the application$")
	public void that_user_launches_the_application() throws Throwable {
		driver=TestBase.getDriver();;
		Properties prop=TestBase.getProperties();
		TestBase.setUp(prop.getProperty("url"));
	}

	@When("^user enters valid username,password and click on Login button$")
	public void user_enters_valid_username_password_and_click_on_Login_button() throws Throwable {
	    test=new LoginTest(driver);
		test.enterValidCredentials();
		test.clickLogin();
		
			
		
	}

	@Then("^Home Page should be displayed$")
	public boolean home_Page_should_be_displayed() throws Throwable {
	   return test.isHomePageDisplayed();
	   }

	@When("^user enters \"([^\"]*)\",\"([^\"]*)\" and click on Login button$")
	public void user_enters_and_click_on_Login_button(String username, String password) throws Throwable {
		test=new LoginTest(driver);
		test.enterCredentials(username, password);
		test.clickLogin();
		
		
	}

	@Then("^Login Page should be displayed successfully$")
	public void Login_Page_should_be_displayed_successfully() throws Throwable {
		
		boolean flag=test.isSignUpDisplayed();
		Assert.assertEquals(true,flag);
				
		
		}

	@After("@logintest")
	public void getScreenshot(Scenario scenario) throws IOException, InterruptedException 
	{
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		Calendar c=Calendar.getInstance();
		
			 
			 File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 
			 //Building up the destination path for the screenshot to save
			 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
			 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/"+ screenshotName +c.getTimeInMillis()+".png");
			 
			 //Copy taken screenshot from source location to destination location
			 Files.copy(sourcePath, destinationPath);   
			 
			 
			 //This attach the specified screenshot to the test
			 Reporter.addScreenCaptureFromPath(destinationPath.toString());
			
				Thread.sleep(10000);
					 
		driver.quit();
	}
	
	}
	

