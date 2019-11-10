package com.vendor.driver;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverTypeEdge implements DriverType {

    @Override
    public WebDriver getWebDriverObject() {
        return getLocalWebDriver();
    }

    @Override
    public void setupDriverManager() {
        try {
            EdgeDriverManager.edgedriver().setup();
        } catch (WebDriverManagerException ex) {
            EdgeDriverManager.edgedriver().useMirror().setup();
        }
    }

    @Override
    public WebDriver getLocalWebDriver() {
        setupDriverManager();
        return new EdgeDriver();
    }
}
