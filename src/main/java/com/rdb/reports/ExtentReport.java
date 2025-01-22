package com.rdb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class ExtentReport {

    public static ExtentTest test;
    private static ExtentReports extent;

    private ExtentReport() {
    }

    public static void initReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("My Extent Report");
    }

    public static void flushReports() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }

    public static void createTest(String testCaseName) {
        test = extent.createTest(testCaseName);
    }
}
