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
import com.virtusa.qa.crmpro.pages.ContactsPage;
import com.virtusa.qa.crmpro.pages.HomePage;
import com.virtusa.qa.crmpro.tests.LoginTest;
import com.virtusa.qa.crmpro.tests.TestBase;
import com.virtusa.qa.crmpro.utils.Hooks;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactsStepDefinition {

	LoginTest ltest;
	HomePage hpage;
	ContactsPage cpage;
	Hooks hooks;
	WebDriver driver;
	Properties prop;
	
	
	
	

@Given("^that user is in Home Page and hover on Contacts Tab and click on New Contact Link$")
public void that_user_is_in_Home_Page_and_hover_on_Contacts_Tab_and_click_on_New_Contact_Link() throws Throwable {
    
	driver=TestBase.getDriver();
	prop=TestBase.getProperties();
	
	TestBase.setUp(prop.getProperty("url"));
	
	ltest=new LoginTest(driver);
	ltest.enterValidCredentials();
    hpage=ltest.clickLogin();
    System.out.println("We are second Given Method");
    hpage.hoverToContactsTab();
    cpage=hpage.clickNewContact();
    
}


@When("^user enters following details in New Contct Page$")
public void user_enters_following_details_in_New_Contct_Page(DataTable contactData) throws Throwable {
    System.out.println(cpage==null);
	cpage.setDataInContactsPage(contactData);
	
	
}

@Then("^details should be Saved successfully$")
public void details_should_be_Saved_successfully() throws Throwable {
    
	cpage.clickSave();
	System.out.println("Data Saved Succesfully");
	
}

@After("@contactstest")
final public void getScreenshot(Scenario scenario) throws Throwable 
{
	String screenshotName = scenario.getName().replaceAll(" ", "_");
	Calendar c=Calendar.getInstance();
	    Thread.sleep(5000);
		System.out.println("This is from Contacts Step Drinigtion");
		System.out.println(driver==null);
		 //This takes a screenshot from the driver at save it to the specified location
		 File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 //Building up the destination path for the screenshot to save
		 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" +screenshotName+c.getTimeInMillis()+".png");
		 
		 //Copy taken screenshot from source location to destination location
		 Files.copy(sourcePath, destinationPath);   
		 
		 //This attach the specified screenshot to the test
		 Reporter.addScreenCaptureFromPath(destinationPath.toString());
		 
		Thread.sleep(10000);
	
	driver.quit();
}


}
