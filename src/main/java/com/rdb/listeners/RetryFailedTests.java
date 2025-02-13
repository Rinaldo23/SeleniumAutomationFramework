package com.rdb.listeners;

import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public final class RetryFailedTests implements IRetryAnalyzer {


    private final int retries = 1;
    private int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes") && count < retries) {
            count++;
            return true;
        }
        return false;
    }
}
