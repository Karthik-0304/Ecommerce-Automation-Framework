package testComponents;

import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import utils.ExtentReporterNG;

import java.io.IOException;

public class Listeners implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        extentTest.get().info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");

        try {
            WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
            String filePath = ((BaseTest) result.getInstance())
                    .getScreenshot(result.getMethod().getMethodName() + "_PASS", driver);

            extentTest.get().addScreenCaptureFromPath(filePath, "Pass Screenshot");
        } catch (Exception e) {
            extentTest.get().warning("Could not attach pass screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        try {
            WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
            String filePath = ((BaseTest) result.getInstance())
                    .getScreenshot(result.getMethod().getMethodName() + "_FAIL", driver);

            extentTest.get().addScreenCaptureFromPath(filePath, "Failure Screenshot");
        } catch (IOException e) {
            extentTest.get().warning("Could not attach failure screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped");
        if (result.getThrowable() != null) {
            extentTest.get().skip(result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}