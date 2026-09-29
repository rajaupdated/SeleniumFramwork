package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.SeleniumUtils;

public class AdminTab {

	private WebDriver driver;
	private SeleniumUtils utils;
	
	public AdminTab(WebDriver driver) {
        this.driver = driver;
        this.utils = new SeleniumUtils(driver);
    }

	// Locators
	    private By adminTab = By.xpath("//span[text()='Admin']");

	    private By addEmpButton = By.xpath("//button[normalize-space()='Add']");

	    private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");

	    private By username = By.xpath("(//input[contains(@class,'oxd-input')])[2]");

	    private By password = By.xpath("(//input[@type='password'])[1]");

	    private By confirmPassword = By.xpath("(//input[@type='password'])[2]");

	    private By saveButton =	By.xpath("//button[normalize-space()='Save']");
	    
	    
	
	public void navigateToAdmin() {

	    utils.click(adminTab, "Admin Tab");

	    Assert.assertTrue(utils.isElementDisplayed(addEmpButton, "Add Employee Button")); 
	    
	}


    public void addUser(String empName, String userName, String pwd) {
    	
    	navigateToAdmin();
    	
    	utils.click(addEmpButton, "click Add button");
    	
    	utils.selectDropdownValue( "User Role", "Admin");
    	
    	utils.selectAutoSuggestion(employeeName,empName,empName);
    	
    	utils.selectDropdownValue("Status", "Enabled");
    	
    	utils.enterText(username, userName+utils.generateRandomText(3), "Username");
   
    	utils.enterText(password, pwd, "Password");
    
    	utils.enterText(confirmPassword,    pwd,    "Confirm Password");

    	utils.click(saveButton,    "Save Button");
    	
}
}
	
	