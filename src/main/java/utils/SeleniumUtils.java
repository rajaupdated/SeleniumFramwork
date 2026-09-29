package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	private WebDriver driver;
	private WebDriverWait wait;

	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void navigateToUrl(String url, String pageName) {

		driver.get(url);

		wait.until(ExpectedConditions.titleContains(pageName));

		System.out.println("Successfully navigated to : " + pageName);
	}

	public void click(By locator, String elementName) {

		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		System.out.println("Clicked on: " + elementName);
	}

	public void enterText(By locator, String text, String elementName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);

		System.out.println("Entered '" + text + "' into " + elementName);
	}

	public String getText(By locator, String elementName) {

		String value = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();

		System.out.println("Captured text from " + elementName + ": " + value);

		return value;
	}

	public boolean isElementDisplayed(By locator, String elementName) {

		try {

			boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();

			System.out.println(elementName + " is displayed");

			return isDisplayed;

		} catch (Exception e) {

			System.out.println(elementName + " is NOT displayed");

			return false;
		}
	}

	public void selectByVisibleText(By locator, String value, String elementName) {

		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));

		dropdown.selectByVisibleText(value);

		System.out.println("Selected '" + value + "' from " + elementName);
	}

	public void selectDropdownValue(String labelName, String optionToSelect) {

		By dropdown = By.xpath("//label[text()='" + labelName
				+ "']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]");

		By option = By.xpath("//div[@role='listbox']//span[text()='" + optionToSelect + "']");

		click(dropdown, labelName + " Dropdown");
		System.out.println("Clicked on dropdown");
		click(option, optionToSelect + " Option");

		System.out.println("Selected '" + optionToSelect + "' from '" + labelName + "'");
	}

	public void selectAutoSuggestion(By inputField, String value, String fieldName) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputField));

		element.clear();
		element.sendKeys(value);

		By option = By.xpath("//div[@role='listbox']//span[normalize-space()='" + value + "']");

		wait.until(ExpectedConditions.visibilityOfElementLocated(option));

		wait.until(ExpectedConditions.elementToBeClickable(option)).click();

		System.out.println("Selected '" + value + "' from " + fieldName);
	}

	public void waitForSeconds(int seconds) {

		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String generateRandomText(int length) {

	    String characters =
	            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    StringBuilder randomText = new StringBuilder();

	    for (int i = 0; i < length; i++) {

	        int index = (int) (Math.random() * characters.length());

	        randomText.append(characters.charAt(index));
	    }

	    return "_"+randomText.toString();
	}

}
