package com.rdb.tests;

import com.rdb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    protected BaseTest() {
    }

    @SuppressWarnings("unchecked")
    @BeforeMethod
    public void setUp(Object[] data) {
        Map<String, String> m = (Map<String, String>) data[0];
        Driver.initDriver(m.get("browser"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    /*
     * Tried to eliminate the use of DP for every test
     *
     * @SuppressWarnings("unchecked")
     * @BeforeMethod public void setUp(Method method, Object[] data) {
     * // Fetch browser from Excel for all tests, not just DataDriven
     * // This will cover both @DataDriven and regular tests
     * if (data.length > 0 && data[0] instanceof Map) {
     * Map<String, String> map = (Map<String, String>) data[0];
     * browser = map.getOrDefault("browser", "chrome"); // default to chrome if not specified
     * }
     * <p>
     * // Initialize driver (based on the browser fetched from Excel)
     * Driver.initDriver(browser);
     * }
     * @SuppressWarnings("unchecked")
     * @BeforeMethod public void setUp(ITestResult result) {
     * Map<String, String> testdata = null;
     * Object[] parameters = result.getParameters();
     * if (parameters != null && parameters.length > 0) {
     * testdata = (Map<String, String>) parameters[0];
     * }
     * System.out.println(testdata);
     * <p>
     * Driver.initDriver(testdata.get("browser"));
     * }
     */

}
