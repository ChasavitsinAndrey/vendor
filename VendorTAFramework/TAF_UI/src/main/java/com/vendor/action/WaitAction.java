package com.vendor.action;

import com.vendor.WebDriverHolder;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitAction {

    public static WebDriverWait webDriverWait = new WebDriverWait(WebDriverHolder.getWebDriver(), 10);

    public static void turnOnImplicitWaits() {
        turnOnImplicitWaits(10, TimeUnit.SECONDS);
    }

    public static void turnOnImplicitWaits(long timeOut, TimeUnit timeUnit) {
        WebDriverHolder.getWebDriver().manage().timeouts().implicitlyWait(timeOut, timeUnit);
    }

    public static void turnOffImplicitWaits() {
        turnOnImplicitWaits(0, TimeUnit.SECONDS);
    }

    public static boolean waitElementClickable(WebElement webElement) {
        try {
            waitClickable(webElement);
            return StateAction.isElementDisplayed(webElement);
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitClickable(WebElement webElement) {
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilInvisible(WebElement webElement) {
        try {
            webDriverWait
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.invisibilityOf(webElement));
        } catch (Exception e) {
        }
    }
}
