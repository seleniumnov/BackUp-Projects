package com.project.utilities;

import org.openqa.selenium.WebDriver;

public class Base {

	/*
	 * private static Base instance = new Base();
	 * 
	 * public static Base getInstance() { return instance; }
	 * 
	 * private static ThreadLocal<WebDriver> driver1 = new ThreadLocal<WebDriver>();
	 */

	public static WebDriver driver = null;
	
	//Base.getInstance().getDriver();

	/*
	 * public WebDriver getDriver() {
	 * 
	 * return driver1.get(); }
	 * 
	 * public void removeDriver() // Quits the driver and closes the browser {
	 * 
	 * driver1.remove(); }
	 */
}
