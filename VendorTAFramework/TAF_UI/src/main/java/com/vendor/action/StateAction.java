package com.vendor.action;

import com.vendor.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StateAction {

    public static boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(By locator) {
        return WebDriverHolder.getWebDriver().findElements(locator).size() > 0;
    }

    public static boolean isElementEnabled(WebElement webElement) {
        return isElementDisplayed(webElement) && webElement.isEnabled();
    }

}