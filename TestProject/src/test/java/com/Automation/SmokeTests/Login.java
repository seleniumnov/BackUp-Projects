package com.Automation.SmokeTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Automation.Utilities.GenericMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends GenericMethods {

	WebDriver driver = null;

	

	@Test
	public void loginChallan() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Select select=new Select(driver.findElement(By.id("day")));

		//Validating drop-down option without For Loop
		
		select.getOptions().stream().anyMatch(item->item.getText().equals("21"));
		
		
		
		

	}

}
