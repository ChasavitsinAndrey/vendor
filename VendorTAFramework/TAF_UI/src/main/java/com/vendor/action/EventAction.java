package com.vendor.action;

import com.vendor.WebDriverHolder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class EventAction {

    public static void clickByJS(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverHolder.getWebDriver();
        executor.executeScript("arguments[0].click();", webElement);
    }

    public static void clearLocalStorage() {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverHolder.getWebDriver();
        executor.executeScript(String.format("window.localStorage.clear();"));
    }

    public static void deleteAllCookies() {
        WebDriverHolder.getWebDriver().manage().deleteAllCookies();
    }
}

