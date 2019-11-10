package com.vendor.factory;

import com.vendor.driver.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WebDriverFactoryImpl implements WebDriverFactory {

    private WebDriver webDriver;
    private static DriverType definedDriverType;
    private static final DriverType DEFAULT_DRIVER_TYPE;

    static {
        DEFAULT_DRIVER_TYPE = new DriverTypeChrome();
    }

    @Override
    public void initWebDriver() {
        webDriver = definedDriverType.getWebDriverObject();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @Override
    public WebDriver getDriver(String driverType) {
        if (null == webDriver) {
            definedDriverType = defineDriverType(driverType);
            initWebDriver();
        }
        return webDriver;
    }

    @Override
    public DriverType defineDriverType(String driverTypeString) {
        DriverType driverType = DEFAULT_DRIVER_TYPE;
        BrowserType browserType = BrowserType.parse(driverTypeString);
        if (null != browserType) {
            switch (browserType) {
                case FIREFOX:
                    driverType = new DriverTypeFirefox();
                    break;
                case CHROME:
                    driverType = new DriverTypeChrome();
                    break;
                case EDGE:
                    driverType = new DriverTypeEdge();
                    break;
                default:
                    break;
            }
        } else {
            log.info("There is no allowable browser.");
        }
        return driverType;
    }
}
