package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowser {

    public static WebDriver getDriver(String browser) {

        switch (browser.toLowerCase()) {

    case "chrome":
                return new ChromeDriver();

            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }
    }
}