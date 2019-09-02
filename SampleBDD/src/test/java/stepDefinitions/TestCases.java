package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;

public class TestCases {
	
	
	@Given("^Test Scenarios One$")
	public void test_Scenarios_One() {
	    
	    System.out.println("Hello One");
	}

	@Given("^Test Scenarios Two$")
	public void test_Scenarios_Two() {
	    
		System.out.println("Hello Two");
	}

	@Given("^Test Scenarios Three$")
	public void test_Scenarios_Three() {
	    
		System.out.println("Hello Three");
	}

	@Given("^Test Scenarios Four$")
	public void test_Scenarios_Four() {
	    
	    Assert.assertEquals("Suresh", "Sure");
	}

	
	
}
