package com.rdb.listeners;

import com.rdb.annotations.FrameworkAnnotation;
import com.rdb.reports.ExtentLogger;
import com.rdb.reports.ExtentReport;
import com.rdb.utils.ELKUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.Objects;

public final class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ELKUtils.deleteAllPreviousLogsFromIndex();
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());

        if (Objects.nonNull(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class))) {
            ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).authors());
        }

        if (Objects.nonNull(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class))) {
            ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).categories());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed!", true);
        ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed!", true);
        ExtentLogger.fail(result.getThrowable().toString()); // Only TOP line failed message
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped!", true);
        ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "SKIP");
    }
}
