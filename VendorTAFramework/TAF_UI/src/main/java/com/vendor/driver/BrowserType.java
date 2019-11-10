package com.vendor.driver;

import org.testng.util.Strings;

public enum BrowserType {

    CHROME("CHROME", "chr"),
    FIREFOX("FIREFOX", "ff"),
    EDGE("EDGE", "ee");

    private final Object[] values;

    BrowserType(Object... v) {
        values = v;
    }

    public static BrowserType parse(String string) {
        if (Strings.isNotNullAndNotEmpty(string)) {
            for (BrowserType value : BrowserType.values()) {
                if (string.equalsIgnoreCase((String) value.values[0])
                        || string.equalsIgnoreCase((String) value.values[1])){
                    return value;
                }
            }
        }
        return null;
    }
}
