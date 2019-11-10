package com.vendor;

import org.openqa.selenium.WebDriver;

public class WebDriverHolder {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver driver) {
        if (null == webDriver) {
            webDriver = driver;
        }
    }

    public static void removeDriver() {
        if (null != webDriver) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
