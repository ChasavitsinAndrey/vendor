package com.vendor.scenario;

import com.vendor.utils.PropertyReader;
import com.vendor.environment.ConsoleReader;
import com.vendor.environment.Environment;
import com.vendor.action.EventAction;
import com.vendor.manager.WebDriverManager;
import com.vendor.manager.WebDriverManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

@Slf4j
public abstract class BaseTest {

    private WebDriverManager manager;

    @BeforeClass
    public void initBrowser() {
        PropertyReader.instanceCreator("TAF_UI/src/test/java/com/vendor/config/ui_environment.properties", Environment.class);
        ConsoleReader.readAll();
        manager = new WebDriverManagerImpl();
        manager.setupWebDriver(Environment.browserName);
    }

    @AfterClass(alwaysRun = true)
    public void cleanCookieAndLocalStorage() {
        EventAction.deleteAllCookies();
        EventAction.clearLocalStorage();
    }

    @AfterSuite
    public void exitBrowser() {
        manager.closeWebDriver();
    }
}
