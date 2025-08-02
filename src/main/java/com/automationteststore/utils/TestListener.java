package com.automationteststore.utils;
import com.automationteststore.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Test started: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test passed: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Test FAILED: " + iTestResult.getName());
        saveScreenshot();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("--- Test Suite STARTED: " + iTestContext.getName() + " ---");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        int passed = iTestContext.getPassedTests().size();
        int failed = iTestContext.getFailedTests().size();
        int skipped = iTestContext.getSkippedTests().size();

        log.info("--- Test Suite FINISHED: " + iTestContext.getName() + " ---");
        log.info("Passed: " + passed + ", Failed: " + failed + ", Skipped: " + skipped);
    }

    private void saveScreenshot(){
        File screenshotDir = new File("./target/screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        String screenshotPath = "./target/screenshots/" + getCurrentTimeAsString() + ".png";
        File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(screenshotPath));
            log.info("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
}
