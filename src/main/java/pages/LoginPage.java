package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtils;

public class LoginPage {

	private WebDriver driver;
	private SeleniumUtils utils;
	
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new SeleniumUtils(driver);
    }

	// Locators
	private By usernameTxt = By.cssSelector("input[placeholder='Username']");
	private By passwordTxt = By.cssSelector("input[placeholder='Password']");
	private By loginBtn = By.cssSelector("button[type='submit']");
	private By errorMsg = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

	
	public void login(String username, String password) {
	
		utils.enterText(usernameTxt, username, "Enter username");
		utils.enterText(passwordTxt, password, "Enter Password");
		utils.click(loginBtn, "click on Login Button");
		
	}
	
	

	public String getErrorMessage() {
		
		return utils.getText(errorMsg, "Validate error message");
		
		
	}
}