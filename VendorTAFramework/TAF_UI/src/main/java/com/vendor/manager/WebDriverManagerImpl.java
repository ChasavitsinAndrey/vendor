package com.vendor.manager;

import com.vendor.WebDriverHolder;
import com.vendor.factory.WebDriverFactory;
import com.vendor.factory.WebDriverFactoryImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebDriverManagerImpl implements WebDriverManager {

    public void setupWebDriver(String driverType) {
        if (null == WebDriverHolder.getWebDriver()) {
            WebDriverFactory factory = new WebDriverFactoryImpl();
            WebDriverHolder.setWebDriver(factory.getDriver(driverType));
        }
    }

    public void closeWebDriver() {
        WebDriverHolder.removeDriver();
    }
}

