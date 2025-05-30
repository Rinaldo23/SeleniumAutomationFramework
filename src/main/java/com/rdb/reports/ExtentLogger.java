package com.rdb.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;
import com.rdb.utils.ScreenshotUtils;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void pass(String message, boolean isScreenshotRequired) {
        try {
            if (PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                    && isScreenshotRequired) {
                ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            } else {
                pass(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void fail(String message, boolean isScreenshotRequired) {
        try {
            if (PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                    && isScreenshotRequired) {
                ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            } else {
                fail(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void skip(String message, boolean isScreenshotRequired) {
        try {
            if (PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                    && isScreenshotRequired) {
                ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            } else {
                skip(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
