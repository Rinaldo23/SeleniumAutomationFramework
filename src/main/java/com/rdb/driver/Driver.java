package com.rdb.driver;

import com.rdb.enums.ConfigProperties;
import com.rdb.exceptions.BrowserNotSpecifiedException;
import com.rdb.factories.DriverFactory;
import com.rdb.utils.PropertyUtils;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver(String browserName) {
        if (Objects.isNull(DriverManager.getDriver())) {

            if (browserName.equalsIgnoreCase("chrome")) {
                DriverManager.setDriver(DriverFactory.getDriver(browserName));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                DriverManager.setDriver(DriverFactory.getDriver(browserName));
            } else if (browserName.equalsIgnoreCase("edge")) {
                DriverManager.setDriver(DriverFactory.getDriver(browserName));
            } else {
                throw new BrowserNotSpecifiedException("Browser not specified in excel data sheet file.");
            }

            /* DriverManager.getDriver().get(JsonUtils.getValue(ConfigProperties.URL)); */
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));

            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().navigate().refresh();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
//            driver = null;
            DriverManager.unload();
        }
    }

}
