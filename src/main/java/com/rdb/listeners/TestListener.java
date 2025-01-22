package com.rdb.listeners;

import com.rdb.reports.ExtentLogger;
import com.rdb.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public final class TestListener implements ITestListener, ISuiteListener {
    
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "is passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "is failed!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "is skipped!");
    }
}
