package com.Automation.RegTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class paralleldemo2 {
	
	@Test
	public void google2() throws Exception {
		BrowserFactory browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		browserFactory.getDriver().get("http://www.google.com");
		browserFactory.getDriver().findElement(By.name("q"))
				.sendKeys("Contract");
		Thread.sleep(3000);
		
		// browserFactory.getDriver().findElement(By.name("btnK")).click();
		browserFactory.getDriver().findElement(By.name("q")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		browserFactory.getDriver().findElements(By.name("btnK")).get(1).click();
		// act.keyUp(Keys.ENTER);
		Thread.sleep(8000);
		browserFactory.getDriver().quit();
	}

}
