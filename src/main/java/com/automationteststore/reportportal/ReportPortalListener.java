package com.automationteststore.reportportal;

import com.automationteststore.driver.DriverSingleton;
import com.epam.reportportal.service.ReportPortal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Date;
import java.io.File;
import com.epam.reportportal.listeners.LogLevel;

public class ReportPortalListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshotFile = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);

        ReportPortal.emitLog("Screenshot on failure: " + result.getName(), LogLevel.ERROR.name(), new Date(), screenshotFile);
    }
}
