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
    public void setUp(Object[] data) throws Exception {
        Map<String, String> m = (Map<String, String>) data[0];
        Driver.initDriver(m.get("browser"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
