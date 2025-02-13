package com.rdb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.rdb.constants.FrameworkConstants;
import com.rdb.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() {
    }

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = null;
            try {
                spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("My Extent Report");
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
            ExtentManager.unload();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentText(extent.createTest(testCaseName));
    }

    public static void addAuthors(String[] authors) {
        for (String author : authors) {
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }
}
