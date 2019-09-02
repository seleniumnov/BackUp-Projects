package selenium.grid;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting {
	
	WebDriver driver;
	
	
	
	Platform WIN10;
	String nodeURL;
	
	public WebDriver getDriver() {
		return driver;
	}

	
	
	@BeforeMethod
	public void setup() throws Exception {
		
		nodeURL = "http://192.168.0.104:46999/wb/hub";
		System.out.println("Chrome Browser Test Environment created");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		driver = new RemoteWebDriver(new URL(nodeURL),cap);	
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test1() throws Exception {
		
		
		driver.findElement(By.name("q"))
				.sendKeys("Selenium");
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.TAB);
		driver.findElements(By.name("btnK")).get(1).click();
		// act.keyUp(Keys.ENTER);
		
	}
	
	
	@Test
	public void google1() throws Exception {
		
		driver.findElement(By.name("q"))
				.sendKeys("Selenium");
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.TAB);
		
		driver.findElements(By.name("btnK")).get(1).click();
		// act.keyUp(Keys.ENTER);
	
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
