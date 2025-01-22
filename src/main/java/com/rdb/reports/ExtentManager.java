package com.rdb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private static final ThreadLocal<ExtentTest> extText = new ThreadLocal<>();

    private ExtentManager() {

    }

    static ExtentTest getExtentTest() {
        return extText.get();
    }

    static void setExtentText(ExtentTest test) {
        extText.set(test);
    }

    static void unload() {
        extText.remove();
    }

}
