package tests;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.*;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.AdminTab;
import pages.LoginPage;

@Epic("HRM")
@Feature("Add users")
public class AddUser extends BaseTest {
	

	private LoginPage loginPage;
	private AdminTab admintab;

	
	@BeforeMethod
	public void initPages() {
	
	loginPage = new LoginPage(DriverFactory.getDriver());
	admintab = new AdminTab(DriverFactory.getDriver());
	
	}

	@Test
	@Description("Verify Admin can add a user without issues")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Abhishek")
	@Step("Add a user as admin")

	public void AddAdminUser(Method method) {

		Map<String, String> data = ExcelUtils.getTestData(method.getName());
		
		
		Allure.step("Login as Admin");
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		
		
		Allure.step("Navigate to Dashboard screen as expected");
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

		// admintab.navigateToAdmin();
		// System.out.printf(data.get("EmployeeName"),data.get("New_UserName"),data.get("SetPassword"));

		Allure.step("Add a user as admin");
		admintab.addUser(data.get("EmployeeName"), data.get("New_UserName"), data.get("SetPassword"));

	}

	@Test
	@Step("Failing the testcase")
	public void validateScreenshotCapture() {

		Allure.step("Starting screenshot validation test");

		Assert.fail("Intentional Failure");

	}
}