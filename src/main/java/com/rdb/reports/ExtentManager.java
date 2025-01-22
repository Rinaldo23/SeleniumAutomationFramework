package com.rdb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private static final ThreadLocal<ExtentTest> extText = new ThreadLocal<>();

    private ExtentManager() {

    }

    public static ExtentTest getExtentTest() {
        return extText.get();
    }

    public static void setExtentText(ExtentTest test) {
        extText.set(test);
    }

    public static void unload() {
        extText.remove();
    }

}
