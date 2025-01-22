package com.rdb.tests;

import com.rdb.driver.Driver;
import com.rdb.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.initReports();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReport.flushReports();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
