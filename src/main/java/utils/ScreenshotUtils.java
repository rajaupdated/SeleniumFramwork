package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class ScreenshotUtils {

	@Attachment(value = "Screenshot", type = "image/png")
    public static byte[] captureScreenshot(String screenshotName,
                                           WebDriver driver) {


    	byte[] screenshot =
    			
    			((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    		
    			System.out.println(  "Screenshot size = " + screenshot.length);
    			return screenshot;
    }
}