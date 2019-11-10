package com.vendor.listener;

import com.vendor.WebDriverHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Slf4j
public class WebDriverListener extends Listener {

    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        takeScreenshot(iTestResult);
        printITestResult(iTestResult);
    }

    @Override
    public void onConfigurationFailure(ITestResult iTestResult) {
        takeScreenshot(iTestResult);
        printITestResult(iTestResult);
    }

    public void takeScreenshot(ITestResult result) {
        String methodName = result.getName();
        if (!result.isSuccess()) {
            File screenshotFile = ((TakesScreenshot) WebDriverHolder.getWebDriver()).getScreenshotAs(OutputType.FILE);
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/screenshots";
            String screenshotName = String.format("%s/screenshots/%s_%s.png", reportDirectory, methodName, formatter.format(calendar.getTime()));
            File destFile = new File(screenshotName);
            try {
                FileUtils.copyFile(screenshotFile, destFile);
            } catch (IOException e) {
                log.error("Can not save screenshot: " + e);
            }
            log.info("SCREENSHOT SAVED  : {}", getClassAndMethodName(screenshotName, "\\/"));
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100%' width='100%'/> </a>");
        }
    }
}
