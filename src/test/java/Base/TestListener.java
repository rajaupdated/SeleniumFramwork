package Base;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest test = (BaseTest) result.getInstance();

        byte[] screenshot = ((TakesScreenshot) test.getDriver()).getScreenshotAs(OutputType.BYTES);

        
        Allure.addAttachment( "Failure Screenshot", "image/png", new ByteArrayInputStream(screenshot),".png");

        System.out.println("Failure screenshot attached");
    }
}