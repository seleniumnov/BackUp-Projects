package com.Automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	
	@FindBy(how=How.XPATH,using="//input[@type='password']")
	private WebElement password;
	
	public WebElement getPassword() {
		
		return password;
	}
	
	@FindBy(how=How.CSS,using="input[value='Login']")
	private WebElement login;
	
	public WebElement getUserLogin() {
		
		return login;
	}

}
