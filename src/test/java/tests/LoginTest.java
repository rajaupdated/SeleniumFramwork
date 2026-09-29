package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.AdminTab;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginTest extends BaseTest {
	
	private LoginPage loginPage;

	
	@BeforeMethod
	public void initPages() {
	
	loginPage = new LoginPage(DriverFactory.getDriver());
	
	}
	

    @Test
    @Description("Verify Admin can LOGIN without issues")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Abhishek")
    @Step("Login into Admin account")
    public void AdminLogin() {
    	
    	Allure.step("Login using admin creds");
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        
        Assert.assertTrue(
        		DriverFactory.getDriver().getCurrentUrl().contains("dashboard"));
    }
    
  
    @Description("Validating login using invalid creds")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Abhishek")
    @Step("Validate invalid error in login page	")
    @Test
    public void ValidateFaildLogin() {
    	
		
    	Allure.step("Login using invalid creds");
        loginPage.login("Testing", "Testing");
        
        String msg = loginPage.getErrorMessage();
        
    	Allure.step("Validate error message for invalid creds");
        Assert.assertTrue(msg.equalsIgnoreCase("Invalid credentials"));
    }
}