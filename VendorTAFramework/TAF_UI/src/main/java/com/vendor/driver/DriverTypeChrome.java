package com.vendor.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverTypeChrome implements DriverType {

    @Override
    public WebDriver getWebDriverObject() {
        return getLocalWebDriver();
    }

    @Override
    public void setupDriverManager() {
        try {
            ChromeDriverManager.chromedriver().setup();
        } catch (WebDriverManagerException ex) {
            ChromeDriverManager.chromedriver().useMirror().setup();
        }
    }

    @Override
    public WebDriver getLocalWebDriver() {
        setupDriverManager();
        return new ChromeDriver();
    }
}
