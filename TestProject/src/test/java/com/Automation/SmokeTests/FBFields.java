package com.Automation.SmokeTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Automation.Utilities.GenericMethods;
import com.Automation.pageObjects.HomePage;
import com.Automation.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBFields extends GenericMethods {

	

	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void HMSLogin() throws Exception {

		logger = extent.createTest("HMS User Login");

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		driver.get("http://selenium4testing.com/hms/");
		Thread.sleep(5000);
		input(home.getUserName(), "admin", "UserName");
		input(login.getPassword(), "admin", "Password");
		click(login.getUserLogin());

	}
	
	
	  @Test(priority = 2) public void show() { logger =
	  extent.createTest("Dummy Test"); }
	  
	  @Test(priority = 2) public void TempShow() { logger =
	  extent.createTest("Registration");
	  
	  Assert.fail("Failed"); }
	 

	
	
	

	@AfterClass
	public void tearDown() {

		driver.close();
	}

}
