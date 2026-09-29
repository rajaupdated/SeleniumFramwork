package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.AdminTab;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import io.qameta.allure.Step;

public class BaseTest {

	protected WebDriver driver;

	public WebDriver getDriver() {

			return DriverFactory.getDriver();
			
			

	}

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeMethod
	@Step("User login into HRMS")
	public void setup(@Optional("edge") String browser) {

		
			
		  DriverFactory.initDriver(browser);
		  
		  driver = DriverFactory.getDriver();
		  
          driver.manage() .window() .maximize();
		  
		  driver.get(ConfigReader.getProperty("url"));
		 
		  System.out.println(
				    "Thread ID: " +
				    Thread.currentThread().getId() +
				    " Browser: " + browser
				);
	}

	
	@AfterMethod
	@Step("Quit the browser and close the driver")
	public void tearDown() {

		DriverFactory.quitDriver();
		System.out.println("Browser closed successfully");
	}
}