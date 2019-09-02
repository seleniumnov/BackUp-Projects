package com.Automation.SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Utilities.GenericMethods;

public class Registration extends GenericMethods {
	
	
	@Test(priority = 2)
	public void TempShow() {
		logger = extent.createTest("Registration");
		
		Assert.fail("Failed");
	}

}
