package com.vendor.driver;

import org.openqa.selenium.WebDriver;

public interface DriverType {

    WebDriver getWebDriverObject();

    void setupDriverManager();

    WebDriver getLocalWebDriver();
}
