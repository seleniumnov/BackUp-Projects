package com.Automation.pageObjects;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WelcomePage {

	@Test(priority = 1)
	public void show() {

		Assert.assertEquals("Test", "4");
	}

	@Test(priority = 2)
	public void login() {

		System.out.println("--------------");
	}

	
	@AfterMethod
	public void verifyTest(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {

			System.out.println("Faile");
		} else if (result.getStatus() == ITestResult.SKIP) {

			System.out.println("Guddu Poindi");
		}

	}

}
