package com.project.stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

import com.project.utilities.Base;
import com.project.utilities.ReadExcel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HMSLogin extends Base {
	
	public static List<HashMap<String, String>> testData = ReadExcel.readExcel();
	
	
	@Given("^I Entered UserName \"([^\"]*)\"$")
	public void i_Entered_UserName(String arg1) throws Throwable {
		
		int num = Integer.parseInt(arg1)-1;
		
		System.out.println(num);
	    
		driver.findElement(By.name("username")).sendKeys(testData.get(num).get("UserName"));   
		
		System.out.println(testData.get(num).get("UserName"));
	}

	@When("^I Entered Password  \"([^\"]*)\"$")
	public void i_Entered_Password(String arg1) throws Throwable {
		
		int num = Integer.parseInt(arg1)-1;
		
		System.out.println(num);
	   
		driver.findElement(By.name("password")).sendKeys(testData.get(num).get("Password"));
		
		System.out.println(testData.get(num).get("Password"));   
	}
	
	@When("^I Entered UserName$")
	public void i_Entered_UserName() throws Throwable {
	    System.out.println("UserName");
	}

	@Then("^I Entered Password$")
	public void i_Entered_Password() throws Throwable {
		System.out.println("Password");
	}
	
	@Given("^I Navigate to Application$")
	public void navigateToApp() {
		
		driver.get("http://selenium4testing.com/hms/");
	}

}
