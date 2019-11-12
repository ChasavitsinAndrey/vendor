package com.vendor.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;

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
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("safebrowsing.enabled", "true");
        chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
//        options.addArguments("--headless");
        options.addArguments("--disable-extensions"); //to disable browser extension popup
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return new ChromeDriver(getDriverService(), options);
    }

    public static ChromeDriverService getDriverService() {
        ChromeDriverService driverService = new ChromeDriverService.Builder().usingPort(8083).build();
        return driverService;
    }
}