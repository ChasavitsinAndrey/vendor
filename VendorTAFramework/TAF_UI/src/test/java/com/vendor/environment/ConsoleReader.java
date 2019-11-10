package com.vendor.environment;

import org.testng.util.Strings;

public class ConsoleReader {

    public static void readAll() {
        verifyBrowserName();
        verifyBaseUrl();
    }

    private static void verifyBrowserName() {
        String property = System.getProperty("browsername");
        if (!Strings.isNullOrEmpty(property)) {
            if (!property.equals(Environment.browserName)) {
                Environment.browserName = property;
            }
        }
    }

    private static void verifyBaseUrl() {
        String property = System.getProperty("baseurl");
        if (!Strings.isNullOrEmpty(property)) {
            if (!property.equals(Environment.baseUrl)) {
                Environment.baseUrl = property;
            }
        }
    }
}
