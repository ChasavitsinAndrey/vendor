package com.vendor.driver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverTypeFirefox implements DriverType {

    @Override
    public WebDriver getWebDriverObject() {
        return getLocalWebDriver();
    }

    @Override
    public void setupDriverManager() {
        try {
            FirefoxDriverManager.firefoxdriver().setup();
        } catch (WebDriverManagerException ex) {
            FirefoxDriverManager.firefoxdriver().useMirror().setup();
        }
    }

    @Override
    public WebDriver getLocalWebDriver() {
        setupDriverManager();
        return new FirefoxDriver();
    }
}