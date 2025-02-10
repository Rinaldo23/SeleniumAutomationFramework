package com.rdb.utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils() {
    }

    public static String getXpath(String xPath, String value) {
        return String.format(xPath, value);
    }
}
