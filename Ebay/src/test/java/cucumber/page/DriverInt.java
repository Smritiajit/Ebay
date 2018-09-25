package cucumber.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class DriverInt {
	

public static WebDriver driver;

	@After (order= 0)
	public void testingClose()
	{
		driver.quit();
	}
	

}
