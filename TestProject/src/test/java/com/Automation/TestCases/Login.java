package com.Automation.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	
	
	@Test(priority = 1)
	public void show() {
		
		Assert.fail("Dummy Fail");
	}
	
	@Test(priority = 2,dependsOnMethods = "show")
	public void show1() {
		
		Assert.fail("Dummy Fail");
	}
}
