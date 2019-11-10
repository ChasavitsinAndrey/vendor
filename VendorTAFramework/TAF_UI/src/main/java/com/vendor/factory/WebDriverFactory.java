package com.vendor.factory;

import com.vendor.driver.DriverType;
import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {

    void initWebDriver();

    WebDriver getDriver(String driverType);

    DriverType defineDriverType(String driverType);
}
