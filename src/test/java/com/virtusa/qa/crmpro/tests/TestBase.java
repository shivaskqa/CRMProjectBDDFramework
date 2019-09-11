package com.virtusa.qa.crmpro.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	
	public static WebDriver getDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    
		return driver;
	}	
	
	public static Properties getProperties()
	{
		try
		   {
			   
		   	prop=new Properties();
			fis=new FileInputStream("src\\test\\java\\com\\virtusa\\qa\\crmpro\\config\\config.properties");
			prop.load(fis);
			
		   }
		   catch(FileNotFoundException fe)
		   { System.out.println("File is not found in the given path");}
		   catch(IOException ie)
		   {System.out.println("Unable to load the properties file");}
		
		
		return prop;
	}
	
	
	public static void setUp(String url)
	{  
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}
	


	}
