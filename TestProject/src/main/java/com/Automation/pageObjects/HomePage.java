package com.Automation.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Automation.Utilities.GenericMethods;



public class HomePage extends GenericMethods {
	
	
	// WebElement ele = driver.findElement(By.id("email"))
	
	// fjdskteuiufieufiw43842754
	
	// Unable to locate or no such element /// stale element ref
	
	// Advantages
	// Write syntax for one element
	// write syntax for init locators in POM
	
	@FindBy(how=How.NAME,using="username")
	private WebElement username;
	
	public WebElement getUserName() {
		
		return username;
	}

	
	@FindBy(how=How.NAME,using="username")
	private List<WebElement> username1;
	
	public List<WebElement> getUserName1() {
		
		return username1;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
