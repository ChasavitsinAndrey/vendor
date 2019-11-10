package com.vendor.manager;

public interface WebDriverManager {

    void setupWebDriver(String driverType);

    void closeWebDriver();
}
