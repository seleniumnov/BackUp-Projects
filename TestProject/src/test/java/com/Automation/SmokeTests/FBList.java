package com.Automation.SmokeTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBList {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");
		
		driver.manage().window().maximize();

		List<WebElement> currency = new Select(
				driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"))).getOptions();
		
		for(int i=0;i<currency.size();i++) {
			
			System.out.println(i+" Position "+currency.get(i).getText());
		}
		
		driver.close();

	}

}
