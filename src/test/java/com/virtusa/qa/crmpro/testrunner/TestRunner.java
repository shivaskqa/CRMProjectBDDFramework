package com.virtusa.qa.crmpro.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features= {"src\\test\\java\\com\\virtusa\\qa\\crmpro\\features"},
                  glue= {"com.virtusa.qa.crmpro.stepdefinitions"},
                  monochrome=true,
                  tags= "@contactstest,@logintest",
                  plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
                  dryRun=false)

@RunWith(Cucumber.class)
public class TestRunner {

	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\virtusa\\qa\\crmpro\\config\\extent-config.xml"));
	 }
	}
